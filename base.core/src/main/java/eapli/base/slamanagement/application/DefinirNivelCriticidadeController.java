/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.slamanagement.application;

import eapli.base.slamanagement.domain.Designacao;
import eapli.base.slamanagement.domain.EtiquetaCriticidade;
import eapli.base.slamanagement.domain.NivelCriticidade;
import eapli.base.objetivosmanagement.domain.Objetivos;
import eapli.base.slamanagement.domain.ValorCriticidade;
import eapli.base.slamanagement.repositories.SLARepository;
import eapli.base.cor.application.ListCorService;
import eapli.base.cor.domain.Cor;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.objetivosmanagement.repositories.ObjetivosRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author rui3m
 */
public class DefinirNivelCriticidadeController {
    @Autowired
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    
    private final SLARepository slaRepository = PersistenceContext.repositories().SLA();
    
    private final ObjetivosRepository objetivosRepository = PersistenceContext.repositories().objetivos();

    private final ListCorService listarCoresService = new ListCorService();
    
    NivelCriticidade nivelCriticidade;
    
    Objetivos objetivos;
    
    public DefinirNivelCriticidadeController(){
    }
    
    public Iterable<Cor> create(){
        ArrayList<Cor> list = (ArrayList)listarCoresService.allCores();
        if(list.isEmpty()){
            return null;
        }
        return list;
    }

    public boolean createObjetivos(int tempoMedioAprovacao, int tempoMaxAprovacao, int tempoMedioResolucao, int tempoMaxResolucao){
        this.objetivos = new Objetivos(tempoMaxAprovacao,tempoMaxResolucao,tempoMedioAprovacao,tempoMedioResolucao);
        return true;
    }
    public String createNivelCriticidade(String etiqueta,String designacao,int valorCriticidade, Cor cor){
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.GESTOR_SERVICO_HELP_DESK, BaseRoles.POWER_USER);
        nivelCriticidade = new NivelCriticidade(objetivos,new Designacao(designacao),new EtiquetaCriticidade(etiqueta), new ValorCriticidade(valorCriticidade),cor);
        return nivelCriticidade.toString();
    
    }
    
    public NivelCriticidade findCriticidadeByEtiqueta(String etiqueta) {
        return slaRepository.findCriticidadeByEtiqueta(etiqueta);
    }
    
    
    public boolean save(){
        
        slaRepository.save(nivelCriticidade);
        return true;
    }
}
