package models.veiculos;

import java.io.Serializable;

/**
 * Classe que Representa um Veiculo do tipo moto
 * extends Veiculo
 */
public class Moto extends Veiculo implements Serializable{

    private boolean possuiBau;
    private boolean partidaEletrica;
    private boolean travaParaCapacete;


    public Boolean getTravaParaCapacete() {
        return travaParaCapacete;
    }

    public void setTravaParaCapacete(Boolean travaParaCapacete) {
        this.travaParaCapacete = travaParaCapacete;
    }

    public Boolean getPartidaEletrica() {
        return partidaEletrica;
    }

    public void setPartidaEletrica(Boolean partidaEletrica) {
        this.partidaEletrica = partidaEletrica;
    }

    public Boolean getPossuiBau() {
        return possuiBau;
    }

    public void setPossuiBau(Boolean possuiBau) {
        this.possuiBau = possuiBau;
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
                "\npossui bau: "+(this.getPossuiBau() == null ? "sim":"não") +
                "\npossui trava para capacetes: "+(this.getTravaParaCapacete() ? "sim":"não") +
                "\npossui partida eletrica: "+(this.getPartidaEletrica() ? "sim":"não");
    }

}
