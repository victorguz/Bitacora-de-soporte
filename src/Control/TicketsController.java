/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.DAOException;
import Model.Dato;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

/**
 * FXML Controller class
 *
 * @author Licmora
 */
public class TicketsController extends Controller implements Initializable {

    @FXML
    private TextField textSolicitante;

    @FXML
    private TextField textEmpresa;

    @FXML
    private TextField textArea;

    @FXML
    private TextField textIncidencia;

    @FXML
    private TextArea textDetalle;

    @FXML
    private TextField textResponsable;

    @FXML
    private TextField textEstado;

    @FXML
    private TextField textMedio;

    @FXML
    private TextField textBuscar;

    ObservableList<String> solicitantes = FXCollections.observableArrayList();
    AutoCompletionBinding<String> autoSolicitantes;

    ObservableList<String> empresas = FXCollections.observableArrayList();
    AutoCompletionBinding<String> autoEmpresas;

    ObservableList<String> incidencias = FXCollections.observableArrayList();
    AutoCompletionBinding<String> autoIncidencias;

    ObservableList<String> areas = FXCollections.observableArrayList();
    AutoCompletionBinding<String> autoAreas;

    ObservableList<String> medios = FXCollections.observableArrayList();
    AutoCompletionBinding<String> autoMedios;

    ObservableList<String> responsables = FXCollections.observableArrayList();
    AutoCompletionBinding<String> autoResponsables;

    ObservableList<String> estados = FXCollections.observableArrayList();
    AutoCompletionBinding<String> autoEstados;

    ObservableList<String> buscar = FXCollections.observableArrayList();
    AutoCompletionBinding<String> autoBuscar;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        setDatos();
    }

    public void addSolicitante() {
        if (!textSolicitante.getText().isEmpty()) {
            if (!solicitantes.contains(textSolicitante.getText())) {
                try {
                    addBuscar(textSolicitante.getText());
                    solicitantes.add(textSolicitante.getText());
                    getDatos().insert(new Dato("solicitante", textSolicitante.getText().toUpperCase()));
                    if (autoSolicitantes != null) {
                        autoSolicitantes.dispose();
                    }
                    autoSolicitantes = TextFields.bindAutoCompletion(textSolicitante, solicitantes);
                } catch (DAOException ex) {
                    excepcion(ex);
                }
            }
        }
    }

    public void addEmpresa() {
        if (!textEmpresa.getText().isEmpty()) {
            if (!empresas.contains(textEmpresa.getText())) {
                try {
                    addBuscar(textEmpresa.getText());
                    empresas.add(textEmpresa.getText());
                    getDatos().insert(new Dato("empresa", textEmpresa.getText().toUpperCase()));
                    if (autoEmpresas != null) {
                        autoEmpresas.dispose();
                    }
                    autoEmpresas = TextFields.bindAutoCompletion(textEmpresa, empresas);
                } catch (DAOException ex) {
                    excepcion(ex);
                }
            }
        }
    }

    public void addArea() {
        if (!textArea.getText().isEmpty()) {
            if (!areas.contains(textArea.getText())) {
                try {
                    addBuscar(textArea.getText());
                    areas.add(textArea.getText());
                    getDatos().insert(new Dato("area", textArea.getText().toUpperCase()));
                    if (autoAreas != null) {
                        autoAreas.dispose();
                    }
                    autoAreas = TextFields.bindAutoCompletion(textArea, areas);
                } catch (DAOException ex) {
                    excepcion(ex);
                }
            }
        }
    }

    public void addIncidencia() {
        if (!textIncidencia.getText().isEmpty()) {
            if (!incidencias.contains(textIncidencia.getText())) {
                try {
                    addBuscar(textIncidencia.getText());
                    incidencias.add(textIncidencia.getText());
                    getDatos().insert(new Dato("incidencia", textIncidencia.getText().toUpperCase()));
                    if (autoIncidencias != null) {
                        autoIncidencias.dispose();
                    }
                    autoIncidencias = TextFields.bindAutoCompletion(textIncidencia, incidencias);
                } catch (DAOException ex) {
                    excepcion(ex);
                }
            }
        }
    }

    public void addMedio() {
        if (!textMedio.getText().isEmpty()) {
            if (!medios.contains(textMedio.getText())) {
                try {
                    addBuscar(textMedio.getText());
                    medios.add(textMedio.getText());
                    getDatos().insert(new Dato("medio", textMedio.getText().toUpperCase()));
                    if (autoMedios != null) {
                        autoMedios.dispose();
                    }
                    autoMedios = TextFields.bindAutoCompletion(textMedio, medios);
                } catch (DAOException ex) {
                    excepcion(ex);
                }
            }
        }
    }

    public void addResponsable() {
        if (!textResponsable.getText().isEmpty()) {
            if (!responsables.contains(textResponsable.getText())) {
                try {
                    addBuscar(textResponsable.getText());
                    responsables.add(textResponsable.getText());
                    getDatos().insert(new Dato("responsable", textResponsable.getText().toUpperCase()));
                    if (autoResponsables != null) {
                        autoResponsables.dispose();
                    }
                    autoResponsables = TextFields.bindAutoCompletion(textResponsable, responsables);
                } catch (DAOException ex) {
                    excepcion(ex);
                }
            }
        }
    }

    public void addEstado() {
        if (!textEstado.getText().isEmpty()) {
            if (!estados.contains(textEstado.getText())) {
                try {
                    addBuscar(textEstado.getText());
                    estados.add(textEstado.getText());
                    getDatos().insert(new Dato("estado", textEstado.getText().toUpperCase()));
                    if (autoEstados != null) {
                        autoEstados.dispose();
                    }
                    autoEstados = TextFields.bindAutoCompletion(textEstado, estados);
                } catch (DAOException ex) {
                    excepcion(ex);
                }
            }
        }
    }

    public void addBuscar(String text) {
        if (!buscar.contains(text)) {
            buscar.add(text);
            autoBuscar = TextFields.bindAutoCompletion(textBuscar, buscar);
        }
    }

    public void setDatos() {
        try {
            ObservableList<Dato> datos = getDatos().all();
            setBuscar(datos);
            for (Dato dato : datos) {
                if (dato.getNombre().equalsIgnoreCase("medio")) {
                    medios.add(dato.getDato());
                }
                if (dato.getNombre().equalsIgnoreCase("incidencia")) {
                    incidencias.add(dato.getDato());
                }
                if (dato.getNombre().equalsIgnoreCase("area")) {
                    areas.add(dato.getDato());
                }
                if (dato.getNombre().equalsIgnoreCase("empresa")) {
                    empresas.add(dato.getDato());
                }
                if (dato.getNombre().equalsIgnoreCase("solicitante")) {
                    solicitantes.add(dato.getDato());
                }
                if (dato.getNombre().equalsIgnoreCase("responsable")) {
                    responsables.add(dato.getDato());
                }
            }
            autoSolicitantes = TextFields.bindAutoCompletion(textSolicitante, solicitantes);
            autoEmpresas = TextFields.bindAutoCompletion(textEmpresa, empresas);
            autoAreas = TextFields.bindAutoCompletion(textArea, areas);
            autoIncidencias = TextFields.bindAutoCompletion(textIncidencia, incidencias);
            autoMedios = TextFields.bindAutoCompletion(textMedio, medios);
            autoResponsables = TextFields.bindAutoCompletion(textResponsable, responsables);
        } catch (DAOException ex) {
            excepcion(ex);
        }

    }

    public void setBuscar(ObservableList<Dato> datos) {
        for (Dato dato : datos) {
            buscar.add(dato.getDato());
        }
        autoBuscar = TextFields.bindAutoCompletion(textBuscar, buscar);
    }

    public void buscar() {
        System.out.println(autoBuscar.getCompletionTarget());
    }

}
