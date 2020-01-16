/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Licmora
 */
public interface CRUD<T, K> {

    public void insert(T registro);

    public void update(T registro);

    public void delete(T registro);

    public T select(K dato);

}
