/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author nailton viana gloria
 */
@Entity
public class Reclamacoesbr2014 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String regiao;
    private String uf;
    private String cidade;
    private String nome_fantasia;
    private String respondidas;

    public Reclamacoesbr2014() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNome_fantasia() {
        return nome_fantasia;
    }

    public void setNome_fantasia(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }

    public String getRespondidas() {
        return respondidas;
    }

    public void setRespondidas(String respondidas) {
        this.respondidas = respondidas;
    }

   

    @Override
    public String toString() {
        return "Reclamacoesbr2014{" + "id=" + id + ", regiao=" + regiao + ", uf=" + uf + ", cidade=" + cidade + ", nome_fantasia=" + nome_fantasia + ", respondidas=" + respondidas + '}';
    }

}
