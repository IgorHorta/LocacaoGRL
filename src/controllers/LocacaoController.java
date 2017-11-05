package controllers;

import Dao.LojaDao;
import models.Locacao;

import java.util.List;

public class LocacaoController implements BaseController<Locacao> {

    private LojaDao lojaDao;

    public LocacaoController() {
        lojaDao = LojaDao.getInstance();
    }

    @Override
    public Locacao salvar(Locacao locacao) {
        lojaDao.getLocacoes().add(locacao);
        return locacao;
    }

    @Override
    public Locacao editar(Locacao locacao) {
        return null;
    }

    @Override
    public Locacao buscar(String cpf, String... args) {

        for (Locacao locacao : lojaDao.getLocacoes()) {

            if(locacao.getVeiculo().getPlaca().equals(args[0]) && locacao.getCliente().getCpf().equals(cpf)){
                return locacao;
            }
        }

        return null;

    }

    @Override
    public void deletar(Locacao locacao) {
        lojaDao.getLocacoes().remove(locacao);
    }

    @Override
    public List<Locacao> listar() {
        return lojaDao.getLocacoes();
    }

    /**
     *
     * Calcula a receita total ao dia de todas as Locações
     * da lista.
     * @return Float total da receita ao dia;
     */
    public Float calcularReceitaTotalDeLocacoes() {

        Float total = 0F;

        for (Locacao locacao : lojaDao.getLocacoes()) {
            total += locacao.getVeiculo().getPrecoAoDia();
        }

        return total;
    }
}
