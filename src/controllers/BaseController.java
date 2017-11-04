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

    T salvar(T t) throws ValidacaoException;

    T editar(T t) throws ValidacaoException;

    T buscar(String s, String... args);

    void deletar(T t);

    List<T> listar();

}
