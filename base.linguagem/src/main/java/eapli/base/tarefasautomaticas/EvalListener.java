/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.tarefasautomaticas;

import eapli.base.utils.EmailSender;
import eapli.base.utils.ReadXMLFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 *
 * @author Guilherme
 */
public class EvalListener extends TarefasAutomaticasBaseListener {

    private List<String> stack = new ArrayList<>();
    private int quantidadeIDs = 0;

    public List<String> getStack() {
        return this.stack;
    }

    // private final Stack<String> stack = new Stack();
    private Integer posicao = 0;
    private ReadXMLFile readerXML = new ReadXMLFile();
    private Integer quantidade;
    private Double preco;
    private Integer quantidadeMinima;
    private Double desconto = 0.0;
    private Integer numeroAnos = 0;
    private String currentEmail = "";
    private String produto = "";
    private String nome = "";
    private boolean hasEmail = false;
    private boolean fazCalculos = false;
    private boolean prodNotNull = false, qtdNotNull = false;
    private String categoria;
    private Double precoAPagar = 0.0;
    double descontoTotal = 0;
    String emailEnviar;
    String tipoDesconto;
    String pctDesconto;
    String valorDesconto;
    String iban = "";

    @Override
    public void exitPlano_pagamento(TarefasAutomaticasParser.Plano_pagamentoContext ctx) {

        String plano = ctx.getText();
        switch (plano) {
            case "PRONTO PAGAMENTO":
            case "pronto pagamento":
                descontoTotal += 0.05;
                break;
            case "PAGAMENTO A 30 DIAS":
            case "pagamento a 30 dias":
                descontoTotal += 0.02;
                break;
            case "PAGAMENTO ANUAL":
            case "pagamento anual":
                descontoTotal += 0.00;
                break;
        }
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.</p>
     */
    @Override
    public void enterInicio(TarefasAutomaticasParser.InicioContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.</p>
     */
    @Override
    public void exitInicio(TarefasAutomaticasParser.InicioContext ctx) {
        if (qtdNotNull && prodNotNull) {
            fazCalculos = true;
            precoAPagar = precoPorQuantidade(preco, quantidadeMinima);
        }
        
        if (hasEmail) {

            if (precoAPagar == 0.0) {
                EmailSender.sendEmail(emailEnviar, gerarMensagemEmailSemPreco());
            } else {

                if (!currentEmail.equals("")) {
                    EmailSender.sendEmail(currentEmail, gerarMensagemEmailCliente());
                }
                EmailSender.sendEmail(emailEnviar, gerarMensagemEmailComPreco());
            }
        }
       
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.</p>
     */
    @Override
    public void enterComandos(TarefasAutomaticasParser.ComandosContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.</p>
     */
    @Override
    public void exitComandos(TarefasAutomaticasParser.ComandosContext ctx) {
        stack.add(ctx.getText());
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.</p>
     */
    @Override
    public void enterEmail(TarefasAutomaticasParser.EmailContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.</p>
     */
    @Override
    public void exitEmail(TarefasAutomaticasParser.EmailContext ctx) {
        hasEmail = true;
        emailEnviar = ctx.getText();
       
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.</p>
     */
    @Override
    public void enterIdentificador(TarefasAutomaticasParser.IdentificadorContext ctx) {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.</p>
     */
    @Override
    public void exitIdentificador(TarefasAutomaticasParser.IdentificadorContext ctx) {
        if (ctx.getText().contains("Cli")) {
            String arr[] = readerXML.xmlElementsFromFieldClientes(ctx.getText());
            numeroAnos = Integer.parseInt(arr[2]);
            currentEmail = arr[3];
            nome = arr[1];

        } else {
            String arr[] = readerXML.xmlElementsFromFieldProdutos(ctx.getText());
            preco = Double.parseDouble(arr[3]);
            quantidadeMinima = Integer.parseInt(arr[2]);
            produto = arr[1];
            categoria = arr[4];

            prodNotNull = true;
        }
        //System.out.println("IDENTIFICADOR " + ctx.getText());
        //stack.add(ctx.getText());
    }

    public double precoPorQuantidade(Double preco, Integer quantidadeMinima) {
        double total = 0;

        if (quantidade >= quantidadeMinima) {
            total = preco * quantidade;
        } else {
            total = preco * quantidadeMinima;
        }

        descontoTotal += descontoAAplicar(total) + descontoPorCategoria();
        return total * (1 - descontoTotal);

    }

    public double descontoAAplicar(Double total) {
        if (total > 1248) {
            return 0.03;
        }
        return 0.01;
    }

    public double descontoPorCategoria() {
        if (categoria.equals("Processador")) {
            return 0.05;
        } else if (categoria.equals("GPU")) {
            return 0.03;
        }
        return 0;
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.</p>
     */
    @Override
    public void enterQuantidade(TarefasAutomaticasParser.QuantidadeContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.</p>
     */
    @Override
    public void exitQuantidade(TarefasAutomaticasParser.QuantidadeContext ctx) {
        qtdNotNull = true;
        quantidade = Integer.parseInt(ctx.getText());
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.</p>
     */
    @Override
    public void enterMetodo_pagamento(TarefasAutomaticasParser.Metodo_pagamentoContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.</p>
     */
    @Override
    public void exitMetodo_pagamento(TarefasAutomaticasParser.Metodo_pagamentoContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.</p>
     */
    @Override
    public void enterPlano_pagamento(TarefasAutomaticasParser.Plano_pagamentoContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.</p>
     */
    @Override
    public void enterNome(TarefasAutomaticasParser.NomeContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.</p>
     */
    @Override
    public void exitNome(TarefasAutomaticasParser.NomeContext ctx) {
        nome = ctx.getText();
   
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.</p>
     */
    @Override
    public void enterTipo_desconto(TarefasAutomaticasParser.Tipo_descontoContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.</p>
     */
    @Override
    public void exitTipo_desconto(TarefasAutomaticasParser.Tipo_descontoContext ctx) {
        tipoDesconto = ctx.getText();

   
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.</p>
     */
    @Override
    public void enterRecorrencia(TarefasAutomaticasParser.RecorrenciaContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.</p>
     */
    @Override
    public void exitRecorrencia(TarefasAutomaticasParser.RecorrenciaContext ctx) {
  
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.</p>
     */
    @Override
    public void enterPercentagem_desconto(TarefasAutomaticasParser.Percentagem_descontoContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.</p>
     */
    @Override
    public void exitPercentagem_desconto(TarefasAutomaticasParser.Percentagem_descontoContext ctx) {

        pctDesconto = ctx.getText();

;
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.</p>
     */
    @Override
    public void enterFatura(TarefasAutomaticasParser.FaturaContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.</p>
     */
    @Override
    public void exitFatura(TarefasAutomaticasParser.FaturaContext ctx) {

        iban = ctx.getText();
       
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.</p>
     */
    @Override
    public void enterValor_desconto(TarefasAutomaticasParser.Valor_descontoContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.</p>
     */
    @Override
    public void exitValor_desconto(TarefasAutomaticasParser.Valor_descontoContext ctx) {

        valorDesconto = ctx.getText();

    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.</p>
     */
    @Override
    public void enterTipo_cliente(TarefasAutomaticasParser.Tipo_clienteContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.</p>
     */
    @Override
    public void exitTipo_cliente(TarefasAutomaticasParser.Tipo_clienteContext ctx) {
        String plano = ctx.getText();
        switch (plano) {
            case "NACIONAL":
            case "nacional":
                descontoTotal += 0.02;
                break;
            case "europeu":
            case "EUROPEU":
                descontoTotal += 0.01;
                break;
            case "resto do mundo":
            case "RESTO DO MUNDO":
                descontoTotal += 0.00;
                break;
        }
  
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.</p>
     */
    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.</p>
     */
    @Override
    public void exitEveryRule(ParserRuleContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.</p>
     */
    @Override
    public void visitTerminal(TerminalNode node) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The default implementation does nothing.</p>
     */
    @Override
    public void visitErrorNode(ErrorNode node) {
    }

    public String gerarMensagemEmailSemPreco() {

        if(iban.equals("")){
            return "Foi aprovado um pedido de desconto de " + this.pctDesconto + " para o cliente " + nome + ".\nCumprimentos,\nLAPR4 2DMG02";
        }
        return "Foi aprovado um pedido de desconto de " + this.pctDesconto + " para o cliente " + nome + ". Irá ser gerada uma fatura para o IBAN " + iban + ".\nCumprimentos,\nLAPR4 2DMG02";

    }

    public String gerarMensagemEmailComPreco() {
        return "O orcamento calculado sera de " + precoAPagar + "€ pelo produto " + produto + " , com quantidade de " + this.quantidade + " da categoria " + categoria + ", tendo sido aplicado um desconto total de " + (descontoTotal * 100) + "%.\nCumprimentos,\nLAPR4 2DMG02";
    }

    public String gerarMensagemEmailCliente() {
        return "O orcamento calculado para o Sr/Sra " + nome + " sera de " + precoAPagar + "€ pelo produto " + produto + " , com quantidade de " + this.quantidade + ", tendo sido aplicado um desconto total de " + (descontoTotal * 100) + "%.\nCumprimentos,\nLAPR4 2DMG02";
    }

}

