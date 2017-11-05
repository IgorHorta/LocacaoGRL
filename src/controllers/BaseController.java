package controllers;

import exceptions.ValidacaoException;

import java.util.List;

/**
 * Interface que representa um controller
 * Base com todas operações que um controller simples deve
 * implementar
 * @param <T>
 */
public interface BaseController <T> {

    /**
     * Salva uma entidade na lojaDao
     *
     * @param t entidade a ser salva na lojaDao
     * @return a entida salva
     * @throws ValidacaoException
     */
    T salvar(T t) throws ValidacaoException;

    /**
     * @param t edita a entidade e a atuliaza na lojaDao
     * @return entidad eeditada
     * @throws ValidacaoException
     */
    T editar(T t) throws ValidacaoException;


    /**
     * Busca uma entidade com os parametros informados
     * @param s parametro para a busca
     * @param args array de parametros extras opcionais
     * @return a entidae encotrada que atende aos parametros especificados
     */
    T buscar(String s, String... args);

    /**
     * Deleta a entidade informada da Lojadao
     * @param t a entidade a ser deletada
     */
    void deletar(T t);

    /**
     * Lista todas as entidades da lojaDao
     *
     * @return uma lista de objetos da lojaDao
     */
    List<T> listar();
}
