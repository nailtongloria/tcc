/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author nailton viana gloria
 */
@Entity
public class Cidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue

    private Long id;

    @ManyToOne(cascade = CascadeType.DETACH)
    private Estado estado_id;
    private String nome;
    private String uf;
    private Integer Codigo_IBGE;
    private Integer Capital;

    public Cidade() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Estado getEstado_id() {
        return estado_id;
    }

    public void setEstado_id(Estado estado_id) {
        this.estado_id = estado_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Integer getCodigo_IBGE() {
        return Codigo_IBGE;
    }

    public void setCodigo_IBGE(Integer Codigo_IBGE) {
        this.Codigo_IBGE = Codigo_IBGE;
    }

    public Integer getCapital() {
        return Capital;
    }

    public void setCapital(Integer Capital) {
        this.Capital = Capital;
    }

    @Override
    public String toString() {
        return nome;
    }

}
