package models.veiculos;

/**
 * Classe que Representa um Veiculo do tipo moto
 * extends Veiculo
 */
public class Moto extends Veiculo {

    private Boolean possuiBau;
    private Boolean partidaEletrica;
    private Boolean travaParaCapacete;


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
}
