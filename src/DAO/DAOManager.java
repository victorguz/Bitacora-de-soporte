/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.sqlite.JDBC;

/**
 *
 * @author 57300
 */
public class DAOManager {

    private Connection conex;
    private TicketsDAO tickets;
    private EventosDAO eventos;
    private DatosDAO datos;

    public DAOManager() throws SQLException {
            DriverManager.registerDriver(new JDBC());
            //setConex(DriverManager.getConnection("jdbc:sqlite:src/bd/bitacora.db"));
            setConex(DriverManager.getConnection("jdbc:sqlite:bd/bitacora.db"));
    }

    private Connection getConex() {
        return conex;
    }

    public void setConex(Connection conex) {
        this.conex = conex;
    }

    public TicketsDAO getTickets() {
        if (tickets == null) {
            tickets = new TicketsDAO(conex);
        }
        return tickets;
    }

    public EventosDAO getEventos() {
        if (eventos == null) {
            eventos = new EventosDAO(conex);
        }
        return eventos;
    }

    public DatosDAO getDatos() {
        if (datos == null) {
            datos = new DatosDAO(conex);
        }
        return datos;
    }

}
