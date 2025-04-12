package com.crudRPG.crudRPG.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "itens_magicos")
public class ItensMagicos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoItem tipo;

    private int forca;
    private int defesa;

    @ManyToOne
    @JoinColumn(name = "personagem_id")
    private Personagem personagem;

    public enum TipoItem {
        ARMA,
        ARMADURA,
        AMULETO
    }

    public ItensMagicos() {}

    public ItensMagicos(Long id, String nome, TipoItem tipo, int forca, int defesa, Personagem personagem) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.forca = forca;
        this.defesa = defesa;
        this.personagem = personagem;
    }

    @PrePersist
    @PreUpdate
    public void validarItem() {
        if (forca < 0 || defesa < 0 || forca > 10 || defesa > 10) {
            throw new IllegalArgumentException("Força e Defesa devem estar entre 0 e 10.");
        }

        if (forca == 0 && defesa == 0) {
            throw new IllegalArgumentException("O item deve possuir pelo menos Força ou Defesa.");
        }

        switch (tipo) {
            case ARMA:
                if (defesa != 0) {
                    throw new IllegalArgumentException("Itens do tipo ARMA devem ter Defesa igual a 0.");
                }
                break;
            case ARMADURA:
                if (forca != 0) {
                    throw new IllegalArgumentException("Itens do tipo ARMADURA devem ter Força igual a 0.");
                }
                break;
            case AMULETO:
                // Amuletos podem ter força e defesa
                break;
        }
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public TipoItem getTipo() { return tipo; }
    public void setTipo(TipoItem tipo) { this.tipo = tipo; }

    public int getForca() { return forca; }
    public void setForca(int forca) { this.forca = forca; }

    public int getDefesa() { return defesa; }
    public void setDefesa(int defesa) { this.defesa = defesa; }

    public Personagem getPersonagem() { return personagem; }
    public void setPersonagem(Personagem personagem) { this.personagem = personagem; }
}

