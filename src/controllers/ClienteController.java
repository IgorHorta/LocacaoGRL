package controllers;

import Dao.LojaDao;
import models.Cliente;

import java.util.List;

public class ClienteController implements BaseController<Cliente> {

    private LojaDao lojaDao;

    public ClienteController() {
        lojaDao = LojaDao.getInstance();
    }

    @Override
    public Cliente salvar(Cliente cliente) {

        lojaDao.getClientes().add(cliente);
        return cliente;
    }

    @Override
    public Cliente editar(Cliente cliente) {
        return null;
    }

    @Override
    public Cliente buscar(String cpf,String... args) {
        for (Cliente cliente : lojaDao.getClientes()) {
            if(cpf.equals(cliente.getCpf())) {
                return cliente;
            }
        }
        return null;
    }

    @Override
    public void deletar(Cliente cliente) {
        lojaDao.getClientes().remove(cliente);
    }

    @Override
    public List<Cliente> listar() {
        return lojaDao.getClientes();
    }
}
