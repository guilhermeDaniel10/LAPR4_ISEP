/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.backoffice.console.presentation.servicos;

import eapli.base.app.backoffice.console.presentation.SLA.NivelCriticidadePrinter;
import eapli.base.formulariomanagement.application.CreateFormularioController;
import eapli.base.formulariomanagement.domain.Atributo;
import eapli.base.formulariomanagement.domain.DadosBase;
import eapli.base.formulariomanagement.domain.TiposFormulario;
import eapli.base.slamanagement.domain.NivelCriticidade;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.SelectWidget;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 *
 * @author lucas
 */
public class AtributosEmFormularioSettings {

    private CreateFormularioController createAtributo = new CreateFormularioController();
    private final Set<Atributo> allAtributosSet = new HashSet<>();
    private final List<String> list;
    private int option = -1;
    private final DadosBase[] dadosBase = {DadosBase.NUMERICO, DadosBase.DATA, DadosBase.TEXTO, DadosBase.BOOLEANO, DadosBase.FICHEIRO};
    private int positionForContext = 1;

    public AtributosEmFormularioSettings() {
        list = makeList();
    }

    private List<String> makeList() {
        final List<String> result = new ArrayList<>();

        result.add("Adicionar atributo ao formulario");

        return result;
    }

    private void showOpcoes() {
        int cont = 0;
        System.out.println(" Escolha o dado que quer introduzir");
        System.out.println("0.  Sem mais dados em falta");
        for (final String dados : list) {
            cont++;
            System.out.println(cont + ".  " + dados);
        }
    }

    public Set<Atributo> criarAtributosEmFormulario(TiposFormulario tipoFormulario, Set<Atributo> atributosOtherForm) throws ParseException {
        List<DadosBase> dadosAsList = Arrays.asList(dadosBase);
        

        if (tipoFormulario == TiposFormulario.APROVACAO) {
            int op = -1;
            do {
                
                Set<Atributo> copyList = atributosOtherForm;
                Iterable<Atributo> lister = copyList;
                final SelectWidget<Atributo> selectorAtributoAprov = new SelectWidget<>("Verificar aprovacao do atributo:", lister, new AtributoPrinter());
                selectorAtributoAprov.show();
                Atributo atributoParaAprovar = null;
                boolean successoAtributo = false;
                Atributo selecionado = selectorAtributoAprov.selectedElement();
 
                if (selecionado != null) {
                    try {
                        atributoParaAprovar = createAtributo.createAtributo(positionForContext, "NF", 0, selecionado.nomeVariavel().toStringNome(), selecionado.etiquetaAtributo().etiqueta(), "Aprovar atributo", DadosBase.BOOLEANO, DadosBase.BOOLEANO.getExpRegular(), null);
                        successoAtributo = true;
                        //copyList.remove(selecionado);
                        positionForContext++;
                        
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Erro na construcao de atributo");
                        successoAtributo = false;
                    }
                    if (successoAtributo) {
                        this.allAtributosSet.add(atributoParaAprovar);
                        positionForContext++;
                    }
                }
                op = selectorAtributoAprov.selectedOption();
            } while (op != 0);
        }

        while (option != 0) {
            showOpcoes();
            option = Console.readOption(1, list.size(), 0);
            if (option != 0) {

                String strNomeVariavel;
                do {
                    strNomeVariavel = Console.readLine("Nome da variavel do atributo:");
                    if (strNomeVariavel.isEmpty()) {
                        System.out.println("Campos de introducao obrigatorios!");
                    }
                } while (strNomeVariavel.isEmpty());
                boolean obrigatoriedade = Console.readBoolean("Obrigatorio (y/n):");

                String obrigatoriedadeAsString = "";
                if (obrigatoriedade == true) {
                    obrigatoriedadeAsString = "NF";
                } else {
                    obrigatoriedadeAsString = "F";
                }

                int dependencia = Console.readInteger("Dependencia de algum campo (posicao na qual inseriu o campo, 0 caso nao tenha):");
                String resposta = null;
                if (dependencia != 0) {
                    resposta = Console.readLine("Expressao Regular da Resposta Esperada:");
                }

                String strEtiquetaAtributo;
                do {
                    strEtiquetaAtributo = Console.readLine("Etiqueta do atributo:");
                    if (strEtiquetaAtributo.isEmpty()) {
                        System.out.println("Campos de introducao obrigatorios!");
                    }
                } while (strEtiquetaAtributo.isEmpty());

                String strDescricaoAjuda;
                do {
                    strDescricaoAjuda = Console.readLine("Descricao de ajuda do atributo:");
                    if (strDescricaoAjuda.isEmpty()) {
                        System.out.println("Campos de introducao obrigatorios!");
                    }
                } while (strDescricaoAjuda.isEmpty());

                final SelectWidget<DadosBase> selectorDadosBase = new SelectWidget<>("Dados Base Disponiveis:", dadosAsList, new DadosBasePrinter());
                selectorDadosBase.show();
                DadosBase dados = selectorDadosBase.selectedElement();

                String strExpressaoRegular = "";

                for (DadosBase tipoAtributo : dadosAsList) {
                    if (tipoAtributo.equals(dados)) {
                        strExpressaoRegular = tipoAtributo.getExpRegular();
                    }
                }
                String expExtra = null;
                boolean wantExtra = Console.readBoolean("Deseja uma expressao regular diferente a predefinida (y/n):");
                if (wantExtra) {
                    boolean isRegex = false;
                    do {
                        expExtra = Console.readLine("Expressao Regular:");

                        try {
                            Pattern.compile(expExtra);
                            isRegex = true;
                            strExpressaoRegular = expExtra;

                        } catch (PatternSyntaxException e) {
                            isRegex = false;
                        }
                    } while (!isRegex);
                }

                Atributo atributoFormulario = null;
                boolean sucesso = true;

                try {
                    atributoFormulario = createAtributo.createAtributo(positionForContext, obrigatoriedadeAsString, dependencia, strNomeVariavel, strEtiquetaAtributo, strDescricaoAjuda, dados, strExpressaoRegular, resposta);
                } catch (IllegalArgumentException e) {
                    System.out.println("Erro na construcao de atributo");
                    sucesso = false;
                }
                if (sucesso) {
                    this.allAtributosSet.add(atributoFormulario);
                    positionForContext++;
                }
            }
        }
        return this.allAtributosSet;
    }

}
