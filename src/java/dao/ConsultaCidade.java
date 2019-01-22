/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.Cidade;

/**
 *
 * @author nailton viana gloria
 */
@Stateless
public class ConsultaCidade {

    @PersistenceContext(name = "TccPU")
    EntityManager em;

    public List<Cidade> getCidades(String cidade) {

        String jpql = "select c from Cidade c where c.uf like :buscarcidade";
        Query query = em.createQuery(jpql);
        query.setParameter("buscarcidade", "%" + cidade + "%");

        return query.getResultList();
    }

    public Cidade visualizar(long id) {
        return em.find(Cidade.class, id);
    }

}
