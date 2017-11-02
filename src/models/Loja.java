package models;

import models.veiculos.Veiculo;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe singleton(única instância) que representa o estado da Loja de locação de veiculos
 * contém todos os clientes, veiculos e locacoes
 */
public class Loja {

    private static Loja instancia = new Loja();

    /**
     * @return Uma Instacia da classe Loja
     */
    public static Loja getInstance() {
        return instancia;
    }

    private List<Cliente> clientes;
    private List<Locacao> locacoes;
    private List<Veiculo> veiculos;

    private Loja() {
        this.clientes = new ArrayList<>();
        this.locacoes = new ArrayList<>();
        this.veiculos = new ArrayList<>();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Locacao> getLocacoes() {
        return locacoes;
    }

    public void setLocacoes(List<Locacao> locacoes) {
        this.locacoes = locacoes;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }
}
