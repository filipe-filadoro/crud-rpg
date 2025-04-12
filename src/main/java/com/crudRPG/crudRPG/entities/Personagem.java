package com.crudRPG.crudRPG.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "personagem")
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String nomeAventureiro;

    @Enumerated(EnumType.STRING)
    private ClassePersonagem classe;

    private int level;
    private int forca;
    private int defesa;

    @OneToMany(mappedBy = "personagem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItensMagicos> itensMagicos = new ArrayList<>();

    public enum ClassePersonagem {
        GUERREIRO, MAGO, ARQUEIRO, LADINO, BARDO
    }

    public Personagem() {}

    public Personagem(Long id, String nome, String nomeAventureiro, ClassePersonagem classe, int level, int forca, int defesa) {
        this.id = id;
        this.nome = nome;
        this.nomeAventureiro = nomeAventureiro;
        this.classe = classe;
        this.level = level;
        this.forca = forca;
        this.defesa = defesa;
    }

    @PrePersist
    @PreUpdate
    public void validarDistribuicaoDeAtributos() {
        if (forca < 0 || defesa < 0) {
            throw new IllegalArgumentException("Força e Defesa não podem ser valores negativos.");
        }

        if (forca + defesa > 10) {
            throw new IllegalArgumentException("A soma de Força e Defesa deve ser no máximo 10.");
        }
    }

    public int calcularForcaTotal() {
        return forca + itensMagicos.stream().mapToInt(ItensMagicos::getForca).sum();
    }

    public int calcularDefesaTotal() {
        return defesa + itensMagicos.stream().mapToInt(ItensMagicos::getDefesa).sum();
    }

    public void equiparItemMagico(ItensMagicos novoItem) {
        if (novoItem.getTipo() == ItensMagicos.TipoItem.AMULETO && possuiAmuletoEquipado()) {
            throw new IllegalArgumentException("Este personagem já possui um amuleto equipado.");
        }

    }

    public void removerItemMagicoPorId(Long itemId) {
        itensMagicos.removeIf(item -> item.getId().equals(itemId));
    }

    public ItensMagicos buscarAmuletoEquipado() {
        return itensMagicos.stream()
                .filter(item -> item.getTipo() == ItensMagicos.TipoItem.AMULETO)
                .findFirst()
                .orElse(null);
    }

    private boolean possuiAmuletoEquipado() {
        return itensMagicos.stream()
                .anyMatch(item -> item.getTipo() == ItensMagicos.TipoItem.AMULETO);
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getNomeAventureiro() { return nomeAventureiro; }
    public void setNomeAventureiro(String nomeAventureiro) { this.nomeAventureiro = nomeAventureiro; }

    public ClassePersonagem getClasse() { return classe; }
    public void setClasse(ClassePersonagem classe) { this.classe = classe; }

    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }

    public int getForca() { return forca; }
    public void setForca(int forca) { this.forca = forca; }

    public int getDefesa() { return defesa; }
    public void setDefesa(int defesa) { this.defesa = defesa; }

    public List<ItensMagicos> getItensMagicos() { return itensMagicos; }
    public void setItensMagicos(List<ItensMagicos> itensMagicos) { this.itensMagicos = itensMagicos; }
}
