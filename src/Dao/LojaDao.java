package Dao;

import models.Cliente;
import models.Locacao;
import models.veiculos.Veiculo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe singleton(única instância) que representa o estado da Dao.LojaDao de locação de veiculos
 * contém todos os clientes, veiculos e locacoes
 */
public class LojaDao implements Serializable {

    private static LojaDao instancia = new LojaDao();
    private static final String CAMINHO_ARQUIVO = "../dados.bin";

    /**
     * @return Uma Instacia da classe Dao.LojaDao
     */
    public static LojaDao getInstance() {
        return instancia;
    }

    private List<Cliente> clientes;
    private List<Locacao> locacoes;
    private List<Veiculo> veiculos;

    private LojaDao() {
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

    /**
     * Preenche as listas de veiculos, clientes e locações com dados
     * de um arquivo
     */
    public void initialize() throws IOException, ClassNotFoundException {

        File dadosExistente = new File(CAMINHO_ARQUIVO);
        if(!dadosExistente.exists()) {
            dadosExistente.createNewFile();
        } else {

            FileInputStream fis = new FileInputStream(CAMINHO_ARQUIVO);
            ObjectInputStream oos = new ObjectInputStream(fis);

            LojaDao lojaDao = (LojaDao) oos.readObject();

            this.clientes = lojaDao.getClientes();
            this.locacoes = lojaDao.getLocacoes();
            this.veiculos = lojaDao.getVeiculos();
            oos.close();

        }

    }

    /**
     * Salva os registros cadastrados em
     * arquivo
     */
    public void salvarDados() throws IOException {
        File dadosExistente = new File(CAMINHO_ARQUIVO);
        FileOutputStream fos = new FileOutputStream(dadosExistente);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(this);
        oos.close();
    }
}
