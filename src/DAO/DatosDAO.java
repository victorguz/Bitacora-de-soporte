/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Dato;
import Model.Dato;
import Model.Dato;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Victorguz
 */
public class DatosDAO implements CRUD<Dato, Integer> {

    Connection conex;

    final String INSERT = "INSERT INTO DatoS (nombre, dato, usedate, usetime)"
            + "VALUES (?, ?, ?, ?, ?)";
    final String ALL = "SELECT Datokey,nombre, dato "
            +" FROM DatoS order by usetime desc, usedate desc";
    final String LIKE = "SELECT Datokey,nombre, dato "
            +" FROM DatoS order by dato like %?%";
    final String ONE = "SELECT Datokey,nombre, dato "
            +" FROM DatoS  where Datokey=?";
    final String UPDATE = "UPDATE DatoS SET nombre = ?, dato = ?, usedate=?, usetime=? WHERE Datokey = ?";
    final String DESACTIVATE = "update Datos set estado = ? where Datokey = ?";

    public DatosDAO(Connection conex) {
        this.conex = conex;
    }
    
    @Override
    public void insert(Dato a) {
        PreparedStatement s = null;
        try {
            s = conex.prepareStatement(INSERT);
            s.setString(1, a.getNombre());
            s.setString(2, a.getDato());
            s.setDate(3, Date.valueOf(LocalDate.now()));
            s.setTime(4, Time.valueOf(LocalTime.now()));
            if (s.executeUpdate() == 0) {
                throw new SQLException("Error al insertar Dato");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (s != null) {
                try {
                    s.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public void update(Dato a) {
        PreparedStatement s = null;
        try {
            s = conex.prepareStatement(UPDATE);
            s.setString(1, a.getNombre());
            s.setString(2, a.getDato());
            s.setDate(3, Date.valueOf(LocalDate.now()));
            s.setTime(4, Time.valueOf(LocalTime.now()));
            s.setInt(5, a.getDatokey());
            if (s.executeUpdate() == 0) {
                throw new SQLException("Error al insertar Dato");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (s != null) {
                try {
                    s.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public void desactivate(Dato a) {
        PreparedStatement s = null;
        try {
            s = conex.prepareStatement(DESACTIVATE);
            s.setString(1, "inactivo");
            s.setInt(2, a.getDatokey());
            if (s.executeUpdate() == 0) {
                throw new SQLException("Error al insertar Dato");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (s != null) {
                try {
                    s.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public Dato select(Integer dato) {
        PreparedStatement s = null;
        ResultSet rs = null;
        Dato c = null;
        try {
            s = conex.prepareStatement(ONE);
            s.setInt(1, dato);
            rs = s.executeQuery();
            if (rs.next()) {
                c = convertir(rs);
            } else {
                throw new SQLException("Dato no encontrado");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (s != null) {
                try {
                    s.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return c;
    }

    @Override
    public ObservableList<Dato> all() {
        PreparedStatement s = null;
        ResultSet rs = null;
        ObservableList<Dato> Datos = FXCollections.observableArrayList();
        try {
            s = conex.prepareStatement(ALL);
            rs = s.executeQuery();
            while (rs.next()) {
                Datos.add(convertir(rs));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (s != null) {
                try {
                    s.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return Datos;
    }

    @Override
    public ObservableList<Dato> like(String dato) {
        PreparedStatement s = null;
        ResultSet rs = null;
        ObservableList<Dato> l = FXCollections.observableArrayList();
        try {
            s = conex.prepareStatement(LIKE);
            s.setString(1, dato.toLowerCase());
            rs = s.executeQuery();
            while (rs.next()) {
                l.add(convertir(rs));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (s != null) {
                try {
                    s.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return l;
    }

    @Override
    public Dato convertir(ResultSet rs) {
        try {
            Dato c = new Dato();
            c.setDatokey(rs.getInt("Datokey"));
            c.setNombre(rs.getString("nombre"));
            c.setDato(rs.getString("dato"));
            return c;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
