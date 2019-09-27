/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.thiagohc.controller;

import br.com.thiagohc.dao.TableModelInterface;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author thiag
 */
public class TelaDePesquisaController implements Initializable {

    @FXML
    private BorderPane pnpesquisa;
    @FXML
    private TextField txtpesquisa;
    @FXML
    private Button btnpesquisar;
    @FXML
    private TableView<Object> tbldados;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    private TableModelInterface tm;
    
    public void configure(TableModelInterface tm) {
        this.tm = tm;
        this.start();
        
    }

    private void start() {
        this.tbldados.getItems().clear();
        this.tbldados.getColumns().clear();
        this.tbldados.getColumns().addAll(this.tm.getCols());
        
    }

    @FXML
    private void pesquisarCliked(ActionEvent event) {
        this.tbldados.getItems().clear();   
        this.tbldados.getItems().addAll(FXCollections.observableArrayList(this.tm.pesquisar(txtpesquisa.getText())));
        
        
    }
}
