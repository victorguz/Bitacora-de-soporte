/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Usuario;
import Model.Usuario;
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
public class UsuariosDAO implements CRUD<Usuario, Integer> {

    Connection conex;

    final String INSERT = "INSERT INTO USUARIOS (usuario, "
            + "contrasena, nombre, area, empresa, rol, estado, usedate, usetime)"
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    final String ALL = "SELECT usuariokey,usuario,contrasena, nombre, "
            + "area, empresa, rol, estado FROM USUARIOS order by usetime desc, usedate desc";
    final String LIKE = "SELECT usuariokey,usuario,contrasena, nombre,"
            + " area, empresa, rol FROM USUARIOS order by nombre like %?%";
    final String ONE = "SELECT usuariokey,usuario,contrasena, nombre, "
            + "area, empresa FROM USUARIOS where usuariokey=?";
    final String UPDATE = "UPDATE USUARIOS SET usuario = ?,"
            + " contrasena = ?, nombre = ?, area = ?, "
            + "empresa = ?, rol=?, usedate=?, usetime=? WHERE usuariokey = ?";
    final String DESACTIVATE = "update usuarios set estado = ? where usuariokey = ?";

    public UsuariosDAO(Connection conex) {
        this.conex = conex;
    }
    
    @Override
    public void insert(Usuario a) {
        PreparedStatement s = null;
        try {
            s = conex.prepareStatement(INSERT);
            s.setString(1, a.getUsername());
            s.setString(2, a.getPassword());
            s.setString(3, a.getNombre());
            s.setString(4, a.getArea());
            s.setString(5, a.getEmpresa());
            s.setString(6, a.getRol());
            s.setString(7, a.getEstado());
            s.setDate(8, Date.valueOf(LocalDate.now()));
            s.setTime(9, Time.valueOf(LocalTime.now()));
            if (s.executeUpdate() == 0) {
                throw new SQLException("Error al insertar usuario");
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
    public void update(Usuario a) {
        PreparedStatement s = null;
        try {
            s = conex.prepareStatement(UPDATE);
            s.setString(1, a.getUsername());
            s.setString(2, a.getPassword());
            s.setString(3, a.getNombre());
            s.setString(4, a.getArea());
            s.setString(5, a.getEmpresa());
            s.setString(6, a.getRol());
            s.setDate(7, Date.valueOf(LocalDate.now()));
            s.setTime(8, Time.valueOf(LocalTime.now()));
            s.setInt(9, a.getUsuariokey());
            if (s.executeUpdate() == 0) {
                throw new SQLException("Error al insertar usuario");
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
    public void desactivate(Usuario a) {
        PreparedStatement s = null;
        try {
            s = conex.prepareStatement(DESACTIVATE);
            s.setString(1, "inactivo");
            s.setInt(2, a.getUsuariokey());
            if (s.executeUpdate() == 0) {
                throw new SQLException("Error al insertar usuario");
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
    public Usuario select(Integer dato) {
        PreparedStatement s = null;
        ResultSet rs = null;
        Usuario c = null;
        try {
            s = conex.prepareStatement(ONE);
            s.setInt(1, dato);
            rs = s.executeQuery();
            if (rs.next()) {
                c = convertir(rs);
            } else {
                throw new SQLException("Usuario no encontrado");
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
    public ObservableList<Usuario> all() {
        PreparedStatement s = null;
        ResultSet rs = null;
        ObservableList<Usuario> Usuarios = FXCollections.observableArrayList();
        try {
            s = conex.prepareStatement(ALL);
            rs = s.executeQuery();
            while (rs.next()) {
                Usuarios.add(convertir(rs));
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
        return Usuarios;
    }

    @Override
    public ObservableList<Usuario> like(String dato) {
        PreparedStatement s = null;
        ResultSet rs = null;
        ObservableList<Usuario> l = FXCollections.observableArrayList();
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
    public Usuario convertir(ResultSet rs) {
        try {
            Usuario c = new Usuario();
            c.setUsuariokey(rs.getInt("usuariokey"));
            c.setUsername(rs.getString("usuario"));
            c.setPassword(rs.getString("contrasena"));
            c.setNombre(rs.getString("nombre"));
            c.setArea(rs.getString("area"));
            c.setEmpresa(rs.getString("empresa"));
            c.setEstado(rs.getString("estado"));
            c.setRol(rs.getString("rol"));
            return c;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
