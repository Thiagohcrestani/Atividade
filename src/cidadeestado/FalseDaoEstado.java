/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cidadeestado;

import br.com.thiagohc.dao.TableModelInterface;
import br.com.thiagohc.model.Estado;
import java.util.ArrayList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author thiag
 */
public class FalseDaoEstado implements TableModelInterface {

    @Override
    public ArrayList<TableColumn<Object, Object>> getCols() {
        ArrayList<TableColumn<Object, Object>> cols = new ArrayList<>();
        
        TableColumn<Object, Object> nome = new
        TableColumn<>("Nome Estado");
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        cols.add(nome);
        
        TableColumn<Object, Object> uf = new
        TableColumn<>("Sigla");
        uf.setCellValueFactory(new PropertyValueFactory<>("uf"));
        cols.add(uf);
        return cols;
        
            
        
    }

    @Override
    public ArrayList<Object> pesquisar(String param) {
        ArrayList<Object> lista = new ArrayList<>();
        Estado pr = new Estado();
        pr.setId(1);
        pr.setNome("Paraná");
        pr.setUf("PR");
        lista.add(pr);
        
        
        Estado mt = new Estado();
        mt.setId(2);
        mt.setNome("Mato Grosso do Sul");
        mt.setUf("MS");
        lista.add(mt);
        return lista;
    }
    
}
