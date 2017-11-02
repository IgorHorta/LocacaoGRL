package models.veiculos;

import enums.Categoria;

/**
 * Classe Pai responsavél por armazenar informações básicas dos veículos
 */
public class Veiculo {

    private Integer id;
    private String nome;
    private String marca;
    private String anoFabricacao;
    private String modelo;
    private Categoria categoria;
    private Float kmPorLitro;
    private Integer cavalos;
    private Integer cilindradas;
    private Integer precoAoDia;

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

    public String getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(String anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Float getKmPorLitro() {
        return kmPorLitro;
    }

    public void setKmPorLitro(Float kmPorLitro) {
        this.kmPorLitro = kmPorLitro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Integer getCavalos() {
        return cavalos;
    }

    public void setCavalos(Integer cavalos) {
        this.cavalos = cavalos;
    }

    public Integer getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(Integer cilindradas) {
        this.cilindradas = cilindradas;
    }

    public Integer getPrecoAoDia() {
        return precoAoDia;
    }

    public void setPrecoAoDia(Integer precoAoDia) {
        this.precoAoDia = precoAoDia;
    }
}
