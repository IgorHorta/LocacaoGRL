package models.veiculos;

import java.io.Serializable;

/**
 * Classe que Representa um Veiculo do tipo carro
 * extends Veiculo
 */
public class Carro extends Veiculo implements Serializable {

    private Integer numeroDePortas = 4;
    private Integer numeroMaxPassageiros = 5;
    private boolean arCondicionado = false;
    private boolean vidroEletricos = false;

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

    public boolean isVidroEletricos() {
        return vidroEletricos;
    }

    public void setVidroEletricos(boolean vidroEletricos) {
        this.vidroEletricos = vidroEletricos;
    }

    @Override
    public String toString(){

        return " -------- " +
                "\nnome: "+(this.getNome() == null ? "" : this.getNome()) +
                "\nplaca: "+(this.getPlaca() == null ? "" : this.getPlaca()) +
                "\nmarca: "+(this.getMarca() == null ? "" : this.getMarca()) +
                "\nano de fabricação: "+(this.getAnoFabricacao() == null ? "" : this.getAnoFabricacao().toString()) +
                "\ncategoria: "+(this.getCategoria() == null ? "" : this.getCategoria().ordinal()) +
                "\nkmPorLitro: "+(this.getKmPorLitro() == null ? "" : this.getKmPorLitro().toString()) +
                "\ncilindradas: "+(this.getCilindradas() == null ? "": this.getCilindradas().toString()) +
                "\npreco ao Dia: "+(this.getPrecoAoDia() == null ? "": this.getPrecoAoDia().toString()) +
                "\nnumero de portas: "+(this.getNumeroDePortas() == null ? "": this.getNumeroDePortas().toString()) +
                "\nnumero max de passageiros: "+(this.getNumeroDePortas() == null ? "": this.getNumeroDePortas().toString()) +
                "\npossui ar condicionado: "+(this.getArCondicionado() == true ? "sim":"não");

    }
}
