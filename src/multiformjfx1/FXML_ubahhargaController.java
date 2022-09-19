/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiformjfx1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class FXML_ubahhargaController implements Initializable {

    @FXML
    private AnchorPane btnreset;
    @FXML
    private TextField txthrsederhana;
    @FXML
    private TextField txthrmenengah;
    @FXML
    private TextField txthrmewah;
    @FXML
    private TextField txthtsederhana;
    @FXML
    private TextField txthtmenengah;
    @FXML
    private TextField txthtmewah;
    @FXML
    private Button btnok;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void okklik(ActionEvent event) {
        FXMLDocumentController.dtharga.setHrsederhana(Integer.parseInt(txthrsederhana.getText()));
        FXMLDocumentController.dtharga.setHrmenengah(Integer.parseInt(txthrmenengah.getText()));
        FXMLDocumentController.dtharga.setHrmewah(Integer.parseInt(txthrmewah.getText()));
        FXMLDocumentController.dtharga.setHtsederhana(Integer.parseInt(txthtsederhana.getText()));
        FXMLDocumentController.dtharga.setHtmenengah(Integer.parseInt(txthtmenengah.getText()));
        FXMLDocumentController.dtharga.setHtmewah(Integer.parseInt(txthtmewah.getText()));
        btnok.getScene().getWindow().hide();
    }

    @FXML
    private void resetklik(ActionEvent event) {
        txthrsederhana.setText("50000000");
        txthrmenengah.setText("100000000");
        txthrmewah.setText("500000000");
        txthtsederhana.setText("500000");
        txthtmenengah.setText("800000");
        txthtmewah.setText("2000000");            
    }
    
}
