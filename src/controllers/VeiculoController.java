package controllers;

import Dao.LojaDao;
import exceptions.ValidacaoException;
import models.veiculos.Veiculo;

import java.util.List;

public class VeiculoController implements BaseController<Veiculo> {

    private LojaDao lojaDao;

    public VeiculoController() {
        lojaDao = LojaDao.getInstance();
    }

    @Override
    public Veiculo salvar(Veiculo novoVeiculo) throws ValidacaoException {

        if(buscar(novoVeiculo.getPlaca()) != null){
            throw new ValidacaoException("Já existe veiculo com a placa informada");
        }

        lojaDao.getVeiculos().add(novoVeiculo);
        return novoVeiculo;
    }

    @Override
    public Veiculo editar(Veiculo veiculo) {
        return null;
    }

    @Override
    public Veiculo buscar(String placa, String... args) {

        for (Veiculo veiculoExistente : lojaDao.getVeiculos()) {
            if(veiculoExistente.getPlaca().equals(placa)){
                return veiculoExistente;
            }
        }
        return null;
    }

    @Override
    public void deletar(Veiculo veiculo) {
        lojaDao.getVeiculos().remove(veiculo);
    }

    @Override
    public List<Veiculo> listar() {
        return lojaDao.getVeiculos();
    }
}
