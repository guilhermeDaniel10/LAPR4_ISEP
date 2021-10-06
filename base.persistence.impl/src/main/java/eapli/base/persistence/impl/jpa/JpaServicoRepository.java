/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.jpa;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.servicomanagement.domain.DescBreveServico;
import eapli.base.servicomanagement.domain.DescCompServico;
import eapli.base.servicomanagement.domain.IdentificadorServico;
import eapli.base.servicomanagement.domain.Keyword;
import eapli.base.servicomanagement.domain.KeywordsEmServico;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.domain.TituloServico;
import eapli.base.servicomanagement.repositories.ServicoRepository;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author lucas
 */
public class JpaServicoRepository extends BasepaRepositoryBase<Servico, Long, Long> implements ServicoRepository {

    JpaServicoRepository() {
        super("idServico");
    }

    @Override
    public Iterable<Servico> allServicosFromCatalogo(Catalogo catalogo) {
        final TypedQuery<Servico> q = createQuery("SELECT e FROM Servico e WHERE e.catalogoDisponiblizaServico = :catalogos",
                Servico.class);
        q.setParameter("catalogos", catalogo);
        return q.getResultList();
    }

    @Override
    public Iterable<Servico> findServicoByFields(String obj, Catalogo catalogo) {

        LinkedHashSet<Servico> list = new LinkedHashSet<>();
        try {
            final TypedQuery<Servico> q = createQuery("SELECT e FROM Servico e WHERE e.catalogoDisponiblizaServico = :catal AND e.descBreveServico = :descBreve",
                    Servico.class);
            q.setParameter("descBreve", new DescBreveServico(obj));
            q.setParameter("catal", catalogo);
            list.addAll(q.getResultList());
        } catch (Exception e) {

        }

        try {
            final TypedQuery<Servico> q = createQuery("SELECT e FROM Servico e WHERE e.catalogoDisponiblizaServico = :catal AND e.descCompletaServico = :descComp",
                    Servico.class);
            q.setParameter("descComp", new DescCompServico(obj));
            q.setParameter("catal", catalogo);
            list.addAll(q.getResultList());
        } catch (Exception e) {

        }

        try {

            final TypedQuery<Servico> q = createQuery("SELECT e FROM Servico e WHERE e.catalogoDisponiblizaServico = :catal AND e.tituloServico = :titulo",
                    Servico.class);
            q.setParameter("titulo", new TituloServico(obj));
            q.setParameter("catal", catalogo);
            list.addAll(q.getResultList());

        } catch (Exception e) {

        }

        //Elevada complexidade- descobrir uma melhor query para pesquisa!
        try {
            Keyword keyS = new Keyword(obj);
            final TypedQuery<Servico> q2 = createQuery("SELECT e FROM Servico e WHERE e.catalogoDisponiblizaServico = :catal", Servico.class);
            q2.setParameter("catal", catalogo);
            List<Servico> list2 = new ArrayList<>();
            list2.addAll(q2.getResultList());

            for (Servico s : list2) {
                for (KeywordsEmServico kk : s.keyword()) {
                    if (kk.keyword().toString().equals(keyS.toString())) {
                        list.add(s);
                    }
                }

            }
        } catch (Exception e) {

        }

        return list;
    }

    @Override
    public int allServicos() {
        try {

            final TypedQuery<Servico> q = createQuery("SELECT e FROM Servico e",
                    Servico.class);
            return q.getResultList().size();

        } catch (Exception e) {
            return 0;
        }
    }

    public Servico findServicoByIdentificador(String idSer) {
        IdentificadorServico titl = new IdentificadorServico(idSer);

        try {

            final TypedQuery<Servico> q = createQuery("SELECT e FROM Servico e WHERE e.identificadorServico = :idSer",
                    Servico.class);
            q.setParameter("idSer", titl);
            return q.getSingleResult();

        } catch (Exception e) {
            return null;
        }
    }

}
