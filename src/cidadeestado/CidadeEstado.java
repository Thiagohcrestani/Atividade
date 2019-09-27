/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cidadeestado;

import br.com.thiagohc.controller.TelaDePesquisaController;
import br.com.thiagohc.dao.TableModelInterface;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author thiag
 */
public class CidadeEstado extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
         
        FXMLLoader loaderPrincipal = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root = loaderPrincipal.load();
        FXMLDocumentController pc = loaderPrincipal.getController();
        
        
        
        FXMLLoader loaderPesquisa = new FXMLLoader(getClass().getResource("/br/com/thiagohc/view/TelaDePesquisa.fxml"));
        Parent bp = loaderPesquisa.load();
        TelaDePesquisaController tpc = loaderPesquisa.getController();
      
        
        pc.getBtnCidade().addEventHandler(ActionEvent.ACTION,(event) -> {
            pc.getStackPane().getChildren().clear();
            pc.getStackPane().getChildren().add(bp);
            TableModelInterface tm = new FalseDaoCidade();
            tpc.configure(tm);
            stage.setTitle("Pesquida de Cidade");
        } );
        
        pc.getBtnEstado().addEventHandler(ActionEvent.ACTION,(event) -> {
            pc.getStackPane().getChildren().clear();
            pc.getStackPane().getChildren().add(bp);
            TableModelInterface tm = new FalseDaoEstado();
            tpc.configure(tm);
            stage.setTitle("Pesquida de Estado");
        } );
       
        
        TableModelInterface tm = new FalseDaoCidade();
        tpc.configure(tm);
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        //Estado e = new Estado();
        //e.setId(1);
        //e.setNome("Paraná");
        //e.setUf("PR");
        
       // Cidade c = new Cidade();
      //  c.setId(1);
       // c.setNome("Palotina");
       // c.setEstado(e);
        
       // System.out.println(c.getEstado().getNome());
        //System.out.println(c.getEstado().getNome().replace("a", "i"));
    }
    
}
