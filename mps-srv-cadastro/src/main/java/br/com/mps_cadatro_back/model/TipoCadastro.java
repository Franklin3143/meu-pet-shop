package br.com.mps_cadatro_back.model;

import javax.persistence.*;

@Entity
public class TipoCadastro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descTipoCadastro;
    private boolean isAtivo;

    public TipoCadastro() {

    }

    public TipoCadastro(Long id, String descTipoCadastro, boolean isAtivo) {
        this.id = id;
        this.descTipoCadastro = descTipoCadastro;
        this.isAtivo = isAtivo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescTipoCadastro() {
        return descTipoCadastro;
    }

    public void setDescTipoCadastro(String descTipoCadastro) {
        this.descTipoCadastro = descTipoCadastro;
    }

    public boolean isAtivo() {
        return isAtivo;
    }

    public void setAtivo(boolean ativo) {
        isAtivo = ativo;
    }

    @Override
    public String toString() {
        return "TipoCadastro{" +
                "id=" + id +
                ", descTipoCadastro='" + descTipoCadastro + '\'' +
                ", isAtivo=" + isAtivo +
                '}';
    }
}
