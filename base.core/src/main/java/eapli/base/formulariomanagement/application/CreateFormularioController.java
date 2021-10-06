/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.formulariomanagement.application;

import eapli.base.formulariomanagement.domain.Atributo;
import eapli.base.formulariomanagement.domain.DadosBase;
import eapli.base.formulariomanagement.domain.DescricaoAjuda;
import eapli.base.formulariomanagement.domain.EtiquetaAtributo;
import eapli.base.formulariomanagement.domain.ExpressaoRegular;
import eapli.base.formulariomanagement.domain.Formulario;
import eapli.base.formulariomanagement.domain.NomeFormulario;
import eapli.base.formulariomanagement.domain.NomeVariavel;
import eapli.base.formulariomanagement.repositories.AtributoRepository;
import eapli.base.formulariomanagement.repositories.FormularioRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import java.text.ParseException;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lucas
 */
public class CreateFormularioController {

    @Autowired
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    @Autowired
    private final FormularioRepository formularioRepository = PersistenceContext.repositories().formulario();
    @Autowired
    private final AtributoRepository atributoRepository = PersistenceContext.repositories().atributo();

    @Transactional
    public Atributo createAtributo(int posicao, String obrigatoriedade, int dependencia,
            String strNomeVariavel, String strEtiquetaAtributo, String strDescricaoAjuda, DadosBase dadosBase, String strExpressaoRegular, String expResposta) throws ParseException {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.GESTOR_SERVICO_HELP_DESK, BaseRoles.POWER_USER, BaseRoles.COLABORADOR);

        final NomeVariavel nomeVariavel = new NomeVariavel(strNomeVariavel);
        final EtiquetaAtributo etiqueta = new EtiquetaAtributo(strEtiquetaAtributo);
        final DescricaoAjuda descricaoAjuda = new DescricaoAjuda(strDescricaoAjuda);
        final DadosBase dadosbase = dadosBase;
        final ExpressaoRegular expressaoRegular = new ExpressaoRegular(strExpressaoRegular);

        Atributo newAtributo = new Atributo(posicao, obrigatoriedade, dependencia, nomeVariavel, etiqueta, descricaoAjuda, dadosbase, expressaoRegular);
        if (expResposta != null) {
            newAtributo.fillRespostaEsperadaDependencia(new ExpressaoRegular(expResposta));
        }
        return atributoRepository.save(newAtributo);
    }

    @Transactional
    public Formulario createFormulario(String strFomularioServico, Set<Atributo> atributosFormulario) throws ParseException {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.GESTOR_SERVICO_HELP_DESK, BaseRoles.POWER_USER, BaseRoles.COLABORADOR);

        NomeFormulario nomeFormulario = new NomeFormulario(strFomularioServico);
        Formulario newformularioServico = new Formulario(nomeFormulario);

        if (!atributosFormulario.isEmpty()) {
            newformularioServico.copyAtributo(atributosFormulario);
        }

        return formularioRepository.save(newformularioServico);
    }

}
