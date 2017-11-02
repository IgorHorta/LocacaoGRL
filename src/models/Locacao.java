package models;

import models.veiculos.Veiculo;

import java.util.Date;

/**
 * Classe que representa a ação de um Cliente
 * alugar um veiculo por determinado tempo
 */
public class Locacao {

    private Cliente cliente;
    private Veiculo veiculo;
    private Date dataInicio;
    private Date dataFim;

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
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
}
