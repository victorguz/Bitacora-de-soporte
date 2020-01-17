/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import javafx.collections.ObservableList;

/**
 *
 * @author Victorguz
 */
public interface CRUD<T, K> {

    public void insert(T registro);

    public void update(T registro);

    public void desactivate(T registro);

    public T select(K dato);
    public ObservableList<T> all();

    public ObservableList<T> like(String dato);

    public T convertir(ResultSet rs);

}
