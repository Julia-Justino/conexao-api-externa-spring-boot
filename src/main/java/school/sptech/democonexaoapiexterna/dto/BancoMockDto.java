package school.sptech.democonexaoapiexterna.dto;

import java.util.Collection;

public class BancoMockDto {
    private int id;
    private String nomeCategoria;
    private int conversaoPadrao;
    private String nome;
    private boolean perecivel;
    private int unidadeMedida;
    private int diasVencimento;

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public int getConversaoPadrao() {
        return conversaoPadrao;
    }

    public void setConversaoPadrao(int conversaoPadrao) {
        this.conversaoPadrao = conversaoPadrao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isPerecivel() {
        return perecivel;
    }

    public void setPerecivel(boolean perecivel) {
        this.perecivel = perecivel;
    }

    public int getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(int unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public int getDiasVencimento() {
        return diasVencimento;
    }

    public void setDiasVencimento(int diasVencimento) {
        this.diasVencimento = diasVencimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
