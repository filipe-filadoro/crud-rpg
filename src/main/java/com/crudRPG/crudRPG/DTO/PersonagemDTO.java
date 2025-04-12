package com.crudRPG.crudRPG.DTO;

import java.util.List;

public class PersonagemDTO {

    private String nome;
    private String nomeAventureiro;
    private String classe;
    private int level;
    private int forca;
    private int defesa;
    private int forcaTotal;
    private int defesaTotal;

    public PersonagemDTO(String nome, String nomeAventureiro, String classe, int level, int forca, int defesa, int forcaTotal, int defesaTotal, List<ItensDTO> itensMagicos) {
        this.nome = nome;
        this.nomeAventureiro = nomeAventureiro;
        this.classe = classe;
        this.level = level;
        this.forca = forca;
        this.defesa = defesa;
        this.forcaTotal = forcaTotal;
        this.defesaTotal = defesaTotal;
        this.itensMagicos = itensMagicos;
    }

    private List<ItensDTO> itensMagicos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeAventureiro() {
        return nomeAventureiro;
    }

    public void setNomeAventureiro(String nomeAventureiro) {
        this.nomeAventureiro = nomeAventureiro;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getForcaTotal() {
        return forcaTotal;
    }

    public void setForcaTotal(int forcaTotal) {
        this.forcaTotal = forcaTotal;
    }

    public int getDefesaTotal() {
        return defesaTotal;
    }

    public void setDefesaTotal(int defesaTotal) {
        this.defesaTotal = defesaTotal;
    }

    public List<ItensDTO> getItensMagicos() {
        return itensMagicos;
    }

    public void setItensMagicos(List<ItensDTO> itensMagicos) {
        this.itensMagicos = itensMagicos;
    }
}
