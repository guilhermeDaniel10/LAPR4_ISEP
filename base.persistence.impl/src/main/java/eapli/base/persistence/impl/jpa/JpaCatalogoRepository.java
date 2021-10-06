/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.jpa;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.domain.DescBreveCatalogo;
import eapli.base.catalogomanagement.domain.DescCompletaCatalogo;
import eapli.base.catalogomanagement.domain.EquipasComAcessoCatalogo;
import eapli.base.catalogomanagement.domain.IdentificadorCatalogo;
import eapli.base.catalogomanagement.domain.TituloCatalogo;
import eapli.base.catalogomanagement.repositories.CatalogoRepository;
import eapli.base.equipamanagement.domain.Equipa;
import java.util.LinkedHashSet;
import javax.persistence.TypedQuery;

/**
 *
 * @author lucas
 */
public class JpaCatalogoRepository extends BasepaRepositoryBase<Catalogo, Long, Long> implements CatalogoRepository {

    JpaCatalogoRepository() {
        super("identificadorUnico");
    }

    @Override
    public Iterable<Catalogo> findCatalogosByTeam(Equipa equipa) {
        EquipasComAcessoCatalogo comAcesso = new EquipasComAcessoCatalogo(equipa);
        final TypedQuery<Catalogo> q = createQuery("SELECT e FROM Catalogo e WHERE :equipas member of e.equipasComAcessoCatalogo",
                Catalogo.class);
        q.setParameter("equipas", comAcesso);
        return q.getResultList();
    }

    @Override
    public Iterable<Catalogo> findCatalogoByFields(String field, Equipa equipa) {
        EquipasComAcessoCatalogo comAcesso = new EquipasComAcessoCatalogo(equipa);
        LinkedHashSet<Catalogo> list = new LinkedHashSet<>();
        try {
            final TypedQuery<Catalogo> q = createQuery("SELECT e FROM Catalogo e WHERE :equipas member of e.equipasComAcessoCatalogo AND e.descBreveCatalogo = :descBreve",
                    Catalogo.class);
            q.setParameter("descBreve", new DescBreveCatalogo(field));
            q.setParameter("equipas", comAcesso);
            list.addAll(q.getResultList());
        } catch (Exception e) {

        }
        try {
            final TypedQuery<Catalogo> q = createQuery("SELECT e FROM Catalogo e WHERE :equipas member of e.equipasComAcessoCatalogo AND e.descCompletaCatalogo = :descCompleta",
                    Catalogo.class);
            q.setParameter("descCompleta", new DescCompletaCatalogo(field));
            q.setParameter("equipas", comAcesso);
            list.addAll(q.getResultList());
        } catch (Exception e) {

        }
        try {
            final TypedQuery<Catalogo> q = createQuery("SELECT e FROM Catalogo e WHERE :equipas member of e.equipasComAcessoCatalogo AND e.identificadorCatalogo = :idCatalogo",
                    Catalogo.class);
            q.setParameter("idCatalogo", new IdentificadorCatalogo(field));
            q.setParameter("equipas", comAcesso);
            list.addAll(q.getResultList());
        } catch (Exception e) {

        }
        try {
            final TypedQuery<Catalogo> q = createQuery("SELECT e FROM Catalogo e WHERE :equipas member of e.equipasComAcessoCatalogo AND e.tituloCatalogo = :titulo",
                    Catalogo.class);
            q.setParameter("titulo", new TituloCatalogo(field));
            q.setParameter("equipas", comAcesso);
            list.addAll(q.getResultList());
        } catch (Exception e) {

        }
        return list;
    }

    @Override
    public Catalogo findCatalogoById(IdentificadorCatalogo id) {

        final TypedQuery<Catalogo> q = createQuery("SELECT e FROM Catalogo e WHERE e.identificadorCatalogo = :idCat",
                Catalogo.class);
        q.setParameter("idCat", id);
        return q.getSingleResult();
    }

}
