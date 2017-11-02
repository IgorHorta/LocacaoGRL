package models.veiculos;

/**
 * Classe que Representa um Veiculo do tipo carro
 * extends Veiculo
 */
public class Carro extends Veiculo {

    private Integer numeroDePortas = 4;
    private Integer numeroMaxPassageiros = 5;
    private Boolean arCondicionado;
    private Boolean vidroEletricoDianteiro;
    private Boolean vidroEletricoTraseiro;

    public Integer getNumeroMaxPassageiros() {
        return numeroMaxPassageiros;
    }

    public void setNumeroMaxPassageiros(Integer numeroMaxPassageiros) {
        this.numeroMaxPassageiros = numeroMaxPassageiros;
    }

    public Boolean getArCondicionado() {
        return arCondicionado;
    }

    public void setArCondicionado(Boolean arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    public Integer getNumeroDePortas() {
        return numeroDePortas;
    }

    public void setNumeroDePortas(Integer numeroDePortas) {
        this.numeroDePortas = numeroDePortas;
    }

    public Boolean getVidroEletricoDianteiro() {
        return vidroEletricoDianteiro;
    }

    public void setVidroEletricoDianteiro(Boolean vidroEletricoDianteiro) {
        this.vidroEletricoDianteiro = vidroEletricoDianteiro;
    }

    public Boolean getVidroEletricoTraseiro() {
        return vidroEletricoTraseiro;
    }

    public void setVidroEletricoTraseiro(Boolean vidroEletricoTraseiro) {
        this.vidroEletricoTraseiro = vidroEletricoTraseiro;
    }
}
