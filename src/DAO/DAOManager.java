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
    private UsuariosDAO usuarios;
    private TicketsDAO tickets;
    private EventosDAO eventos;
    private DatosDAO datos;

    public DAOManager() {
        try {
            DriverManager.registerDriver(new JDBC());
            setConex(DriverManager.getConnection("jdbc:sqlite:src/bd/bitacora.db"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private Connection getConex() {
        return conex;
    }

    public void setConex(Connection conex) {
        this.conex = conex;
    }

    public UsuariosDAO getUsuarios() {
        if (usuarios == null) {
            usuarios = new UsuariosDAO(conex);
        }
        return usuarios;
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
