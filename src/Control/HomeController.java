/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Victorguz
 */
public class HomeController extends Controller implements Initializable {

    @FXML
    VBox holderPane;
    VBox Login;
    VBox Admin;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            Login = FXMLLoader.load(new File("src/View/Login.fxml").toURL());
            Admin = FXMLLoader.load(new File("src/View/Administrar.fxml").toURL());
        } catch (MalformedURLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        } /*finally {
            Login = new VBox(new Label("Algo ocurrió, contacte al programador."));
            Admin = new VBox(new Label("Algo ocurrió, contacte al programador."));
        }*/
        switchLogin();
    }

    public void switchLogin() {
        set(Login);
    }

    public void switchConfig() {
        set(Admin);
    }

    protected void set(VBox node) {
        holderPane.getChildren().clear();
        holderPane.getChildren().add(node);
        fadeTransition(node, 700);
    }
}
