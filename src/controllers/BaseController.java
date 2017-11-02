package controllers;

/**
 * Interface que representa um controller
 * Base com todas operações que um controller simples deve
 * implementar
 * @param <T>
 */
public interface BaseController <T> {

    T salvar(T t);

    T editar(T t);

    void deletar(Integer id);

}
