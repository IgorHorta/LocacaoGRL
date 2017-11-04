package models.veiculos;

import enums.Categoria;

import java.io.Serializable;

/**
 * Classe Pai responsavél por armazenar informações básicas dos veículos
 */
public class Veiculo implements Serializable{

    private String placa;
    private String nome;
    private String marca;
    private Integer anoFabricacao;
    private Categoria categoria;
    private Integer kmPorLitro;
    private Integer cilindradas;
    private Float precoAoDia;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Integer getKmPorLitro() {
        return kmPorLitro;
    }

    public void setKmPorLitro(Integer kmPorLitro) {
        this.kmPorLitro = kmPorLitro;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Integer getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(Integer cilindradas) {
        this.cilindradas = cilindradas;
    }

    public Float getPrecoAoDia() {
        return precoAoDia;
    }

    public void setPrecoAoDia(Float precoAoDia) {
        this.precoAoDia = precoAoDia;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

}
