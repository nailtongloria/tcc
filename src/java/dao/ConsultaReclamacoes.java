/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import modelo.Nome_Lojas;
import modelo.Sindec2016;

/**
 *
 * @author nailton viana gloria
 */
@Stateless
public class ConsultaReclamacoes {

    @PersistenceContext(name = "TccPU")
    EntityManager em;

    public Long getReclamacoesbr2014(String uf, String cidade, String nome, String resposta) {
        String jpql = "select count(r) from Reclamacoesbr2014 r where r.uf like :buscarsigla and r.cidade like :buscarcidade and r.nome_fantasia like :buscarnome and r.respondidas like :buscaresposta";
        Query query = em.createQuery(jpql);
        query.setParameter("buscarsigla", "%" + uf + "%");
        query.setParameter("buscarcidade", "%" + cidade + "%");
        query.setParameter("buscarnome", "%" + nome + "%");
        query.setParameter("buscaresposta", "%" + resposta + "%");
        return (Long) query.getSingleResult();
    }

    public Long getReclamacoesbr2015(String uf, String cidade, String nome, String resposta) {
        String jpql = "select count(r) from Reclamacoesbr2015 r where r.uf like :buscarsigla and r.cidade like :buscarcidade and r.nome_fantasia like :buscarnome and r.respondidas like :buscaresposta";
        Query query = em.createQuery(jpql);
        query.setParameter("buscarsigla", "%" + uf + "%");
        query.setParameter("buscarcidade", "%" + cidade + "%");
        query.setParameter("buscarnome", "%" + nome + "%");
        query.setParameter("buscaresposta", "%" + resposta + "%");
        return (Long) query.getSingleResult();
    }

    public Long getReclamacoesbr2016(String uf, String cidade, String nome, String resposta) {
        String jpql = "select count(r) from Reclamacoesbr2016 r where r.uf like :buscarsigla and r.cidade like :buscarcidade and r.nome_fantasia like :buscarnome  and r.respondidas like :buscaresposta";
        Query query = em.createQuery(jpql);
        query.setParameter("buscarsigla", "%" + uf + "%");
        query.setParameter("buscarcidade", "%" + cidade + "%");
        query.setParameter("buscarnome", "%" + nome + "%");
        query.setParameter("buscaresposta", "%" + resposta + "%");
        return (Long) query.getSingleResult();
    }

    public Long getReclamacoesbr2017(String uf, String cidade, String nome, String resposta) {
        String jpql = "select count(r) from Reclamacoesbr2017 r where r.uf like :buscarsigla and r.cidade like :buscarcidade and r.nome_fantasia like :buscarnome and r.respondidas like :buscaresposta";
        Query query = em.createQuery(jpql);
        query.setParameter("buscarsigla", "%" + uf + "%");
        query.setParameter("buscarcidade", "%" + cidade + "%");
        query.setParameter("buscarnome", "%" + nome + "%");
        query.setParameter("buscaresposta", "%" + resposta + "%");
        return (Long) query.getSingleResult();
    }

    public Long getSindec2010(String uf, String cidade, String nome, String resposta) {
        String jpql = "select count(s) from Sindec2010 s where s.uf like :buscarsigla and s.cidade like :buscarcidade and s.nome_fantasia like :buscarnome and s.respondidas like :buscaresposta";
        Query query = em.createQuery(jpql);
        query.setParameter("buscarsigla", "%" + uf + "%");
        query.setParameter("buscarcidade", "%" + cidade + "%");
        query.setParameter("buscarnome", "%" + nome + "%");
        query.setParameter("buscaresposta", "%" + resposta + "%");
        return (Long) query.getSingleResult();
    }

    public Long getSindec2011(String uf, String cidade, String nome, String resposta) {
        String jpql = "select count(s) from Sindec2011 s where s.uf like :buscarsigla and s.cidade like :buscarcidade and s.nome_fantasia like :buscarnome and s.respondidas like :buscaresposta";
        Query query = em.createQuery(jpql);
        query.setParameter("buscarsigla", "%" + uf + "%");
        query.setParameter("buscarcidade", "%" + cidade + "%");
        query.setParameter("buscarnome", "%" + nome + "%");
        query.setParameter("buscaresposta", "%" + resposta + "%");
        return (Long) query.getSingleResult();
    }

    public Long getSindec2012(String uf, String cidade, String nome, String resposta) {
        String jpql = "select count(s) from Sindec2012 s where s.uf like :buscarsigla and s.cidade like :buscarcidade and s.nome_fantasia like :buscarnome and s.respondidas like :buscaresposta";
        Query query = em.createQuery(jpql);
        query.setParameter("buscarsigla", "%" + uf + "%");
        query.setParameter("buscarcidade", "%" + cidade + "%");
        query.setParameter("buscarnome", "%" + nome + "%");
        query.setParameter("buscaresposta", "%" + resposta + "%");
        return (Long) query.getSingleResult();
    }

    public Long getSindec2013(String uf, String cidade, String nome, String resposta) {
        String jpql = "select count(s) from Sindec2013 s where s.uf like :buscarsigla and s.cidade like :buscarcidade and s.nome_fantasia like :buscarnome  and s.respondidas like :buscaresposta";
        Query query = em.createQuery(jpql);
        query.setParameter("buscarsigla", "%" + uf + "%");
        query.setParameter("buscarcidade", "%" + cidade + "%");
        query.setParameter("buscarnome", "%" + nome + "%");
        query.setParameter("buscaresposta", "%" + resposta + "%");
        return (Long) query.getSingleResult();
    }

    public Long getSindec2014(String uf, String cidade, String nome, String resposta) {
        String jpql = "select count(s) from Sindec2014 s where s.uf like :buscarsigla and s.cidade like :buscarcidade and s.nome_fantasia like :buscarnome and s.respondidas like :buscaresposta";
        Query query = em.createQuery(jpql);
        query.setParameter("buscarsigla", "%" + uf + "%");
        query.setParameter("buscarcidade", "%" + cidade + "%");
        query.setParameter("buscarnome", "%" + nome + "%");
        query.setParameter("buscaresposta", "%" + resposta + "%");
        return (Long) query.getSingleResult();
    }

    public Long getSindec2015(String uf, String cidade, String nome, String resposta) {
        String jpql = "select count(s) from Sindec2015 s where s.uf like :buscarsigla and s.cidade like :buscarcidade and s.nome_fantasia like :buscarnome and s.respondidas like :buscaresposta";
        Query query = em.createQuery(jpql);
        query.setParameter("buscarsigla", "%" + uf + "%");
        query.setParameter("buscarcidade", "%" + cidade + "%");
        query.setParameter("buscarnome", "%" + nome + "%");
        query.setParameter("buscaresposta", "%" + resposta + "%");
        return (Long) query.getSingleResult();
    }

    public Long getSindec2016(String uf, String cidade
            , String nome, String resposta) {
        String jpql = "select count(s) from Sindec2016 s "
                + "where s.uf like :buscarsigla "
                + "and s.cidade like :buscarcidade "
                + "and s.nome_fantasia like :buscarnome  "
                + "and s.respondidas like :buscaresposta";
        Query query = em.createQuery(jpql);
        query.setParameter("buscarsigla", "%" + uf + "%");
        query.setParameter("buscarcidade", "%" + cidade + "%");
        query.setParameter("buscarnome", "%" + nome + "%");
        query.setParameter("buscaresposta", "%" + resposta 
                + "%");
        return (Long) query.getSingleResult();
    }

    private List<Nome_Lojas> removeElementosRepetidos(List<Nome_Lojas> filtroProdutividadeList) {
        List<Nome_Lojas> novaLista = new ArrayList<Nome_Lojas>();
        for (int i = 0; i < filtroProdutividadeList.size(); i++) {
            if (novaLista.isEmpty()) {
                novaLista.add(filtroProdutividadeList.get(i));
            } else {
                int count = 0;
                for (Nome_Lojas f : novaLista) {
                    if (filtroProdutividadeList.get(i).getNome().equalsIgnoreCase(f.getNome())) {
                        count++;
                    }
                }
                if (count == 0) {
                    novaLista.add(filtroProdutividadeList.get(i));
                }
            }
        }
        return novaLista;
    }

    public List<Nome_Lojas> getnome_lojas(String uf, String cidade, String nome) {
        String jpql = "select n from Nome_Lojas n where n.uf like :buscarsigla and n.cidade like :buscarcidade and n.nome like :buscarnome";
        Query query = em.createQuery(jpql);
        query.setParameter("buscarsigla", "%" + uf + "%");
        query.setParameter("buscarcidade", "%" + cidade + "%");
        query.setParameter("buscarnome", "%" + nome + "%");
        return removeElementosRepetidos(query.getResultList());
    }

}
