package school.sptech.democonexaoapiexterna.dto;

public class SomaDiasResponse {
    private int somaDiasVencimento;

    public SomaDiasResponse(int somaDiasVencimento) {
        this.somaDiasVencimento = somaDiasVencimento;
    }

    public int getSomaDiasVencimento() {
        return somaDiasVencimento;
    }

    public void setSomaDiasVencimento(int somaDiasVencimento) {
        this.somaDiasVencimento = somaDiasVencimento;
    }
}
