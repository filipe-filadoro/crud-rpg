package com.crudRPG.crudRPG.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "/personagem")
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String nomeAventireiro; //nome fantasia
    private String classe;
    private String level;
    private String listaItenMagico;
    private String forca;
    private String defesa;

    public Personagem(int id, String nome, String nomeAventireiro, String classe, String level, String listaItenMagico, String forca, String defesa) {
        this.id = id;
        this.nome = nome;
        this.nomeAventireiro = nomeAventireiro;
        this.classe = classe;
        this.level = level;
        this.listaItenMagico = listaItenMagico;
        this.forca = forca;
        this.defesa = defesa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeAventireiro() {
        return nomeAventireiro;
    }

    public void setNomeAventireiro(String nomeAventireiro) {
        this.nomeAventireiro = nomeAventireiro;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getListaItenMagico() {
        return listaItenMagico;
    }

    public void setListaItenMagico(String listaItenMagico) {
        this.listaItenMagico = listaItenMagico;
    }

    public String getForca() {
        return forca;
    }

    public void setForca(String forca) {
        this.forca = forca;
    }

    public String getDefesa() {
        return defesa;
    }

    public void setDefesa(String defesa) {
        this.defesa = defesa;
    }
}
