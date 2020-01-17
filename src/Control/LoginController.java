/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Usuario;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;

/**
 * FXML Controller class
 *
 * @author 57300
 */
public class LoginController extends Controller implements Initializable {

    @FXML
    private TextField textUsername;

    @FXML
    private PasswordField textPassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void iniciar() {
        String user = "";
        String pass = "";
        if (!textUsername.getText().isEmpty()) {
            user = textUsername.getText();
            if (textPassword.getText().isEmpty()) {
                mensaje("Digite una contraseña", "Aviso");
            } else {
                user = textPassword.getText();
                Usuario u = getUsuarios().iniciar(user, pass);
                u.setSesion(true);
                getUsuarios().update(u);
            }
        } else {
            mensaje("Digite su nombre de usuario", "Aviso");
        }

        System.out.println("Sesion iniciada");
    }

    public void link() {

    }

}
