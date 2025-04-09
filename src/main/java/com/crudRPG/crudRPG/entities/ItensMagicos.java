package com.crudRPG.crudRPG.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "itens")
public class ItensMagicos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String tipoDoItem;
    private String forca;
    private String defesa;

    public ItensMagicos(int id, String nome, String tipoDoItem, String forca, String defesa) {
        this.id = id;
        this.nome = nome;
        this.tipoDoItem = tipoDoItem;
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

    public String getTipoDoItem() {
        return tipoDoItem;
    }

    public void setTipoDoItem(String tipoDoItem) {
        this.tipoDoItem = tipoDoItem;
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
