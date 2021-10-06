/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.app.user.console.presentation.colaborador;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.repositories.CatalogoRepository;
import eapli.base.catalogomanagemente.application.ListCatalogoController;
import eapli.base.catalogomanagemente.application.ListCatalogoService;
import eapli.base.colaboradormanagement.domain.CodigoAlfanumerico;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.domain.Contacto;
import eapli.base.colaboradormanagement.domain.DesignacaoFuncao;
import eapli.base.colaboradormanagement.domain.EmailInstitucional;
import eapli.base.colaboradormanagement.domain.Funcao;
import eapli.base.colaboradormanagement.domain.LocalResidencia;
import eapli.base.colaboradormanagement.domain.NomeCompleto;
import eapli.base.colaboradormanagement.domain.NomeCurto;
import eapli.base.colaboradormanagement.domain.NumeroMecanografico;
import eapli.base.cor.domain.CodigoCor;
import eapli.base.cor.domain.Cor;
import eapli.base.equipamanagement.application.ListEquipaService;
import eapli.base.equipamanagement.domain.AcronimoEquipa;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.servicomanagement.application.ListServicoController;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.tipoequipamanagement.domain.DescricaoTipoEquipa;
import eapli.base.tipoequipamanagement.domain.TipoEquipa;
import eapli.framework.infrastructure.authz.application.AuthenticationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

/**
 *
 * @author Guilherme
 */
public class ConsultarCatalogoUI extends AbstractUI {

    private ListCatalogoController listCatalogoController = new ListCatalogoController();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final AuthenticationService authenticationService = AuthzRegistry.authenticationService();
    private ListCatalogoService serv = new ListCatalogoService();
    private ListEquipaService serv2 = new ListEquipaService();
    private ListServicoController servicController = new ListServicoController();
    private ListCatalogoController listCatalogo = new ListCatalogoController();

    @Override
    protected boolean doShow() {

        for (Catalogo c : serv.findCatalogosDeColaborador()) {
            if (c.isActive()) {
                System.out.println(c.toString());
                System.out.println("\n   -> Serviços disponíveis do catálogo: ");
                for (Servico servi : servicController.allServicosFromCatalogo(c)) {
                    if (servi.isActive()) {
                        System.out.println(servi.toStringWithCatalogo());
                    } else {
                        System.out.println("\n      Titulo Servico:" + servi.name().toString() + "\n      Serviço brevemente disponível...");
                    }
                }
            }
        }

        return true;
    }

    @Override
    public String headline() {
        return "Consultar Catalogo";
    }

}
