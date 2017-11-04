package models;

import models.veiculos.Veiculo;

import java.io.Serializable;

/**
 * Classe que representa a ação de um Cliente
 * alugar um veiculo por determinado tempo
 */
public class Locacao implements Serializable{

    private Cliente cliente;
    private Veiculo veiculo;
    private String dataInicio;
    private String dataFim;

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString(){
        return "\n --------\n"+
                "\ncliente cpf: " +(cliente == null ? "" : cliente.getCpf())+
                "\nveículo placa: "+(veiculo == null ? "" : veiculo.getPlaca())+
                "\ndata inicio: "+(dataInicio == null ? "": dataInicio)+
                "\ndata fim: "+(dataFim == null ? "": dataFim);
    }


}
