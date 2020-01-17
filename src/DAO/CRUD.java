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
public interface CRUD<T, K>  {

    public void insert(T registro)throws DAOException;

    public void update(T registro)throws DAOException;

    public void desactivate(T registro)throws DAOException;

    public T select(K dato)throws DAOException;
    public ObservableList<T> all()throws DAOException;

    public ObservableList<T> like(String dato)throws DAOException;

    public T convertir(ResultSet rs)throws DAOException;

}
