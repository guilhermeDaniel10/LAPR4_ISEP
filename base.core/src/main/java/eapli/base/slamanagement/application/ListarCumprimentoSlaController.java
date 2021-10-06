/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.slamanagement.application;

import eapli.base.pedidomanagement.application.ListPedidoService;
import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.servicomanagement.domain.Servico;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author rui3m
 */
@Component
@UseCaseController
public class ListarCumprimentoSlaController {

    @Autowired
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    @Autowired
    private final ListPedidoService listServico = new ListPedidoService();

    public Map<String, List<Pedido>> listarInfomacaoCumprimentoSLA(Date limiteInferior, Date limiteSuperior) {
        return listServico.listarInfomacaoCumprimentoSLA(limiteInferior, limiteSuperior);
        //infoServicos = 

    }

    public Map<String, List<Servico>> listarInformacaoCumprimentosMediasSLA(Date limiteInferior, Date limiteSuperior) {
        return listServico.listarInformacaoCumprimentosMediasSLA(limiteInferior, limiteSuperior);

    }

}
