/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cidadeestado;

import br.com.thiagohc.contracts.ICriteria;
import br.com.thiagohc.dao.DaoInterface;
import br.com.thiagohc.dao.TableModelInterface;
import br.com.thiagohc.model.Cidade;
import java.util.ArrayList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author thiag
 */
public class FalseDaoCidade implements TableModelInterface, DaoInterface    {

    @Override
    public ArrayList<TableColumn<Object, Object>> getCols() {
       ArrayList<TableColumn<Object,Object>> cols = new ArrayList<>();
       
       TableColumn<Object, Object> cnome = new TableColumn<>("Nome Cidade");
       
       cnome.setCellValueFactory(new PropertyValueFactory<>("nome"));
       cols.add(cnome);
       return cols;
    }

    @Override
    public ArrayList<Object> pesquisar(String param) {
        ArrayList<Object> Lista = new ArrayList<Object>();
        Cidade palotina = new Cidade();
        palotina.setId(1);
        palotina.setNome("Palotina");
        Lista.add(palotina);
       
        Cidade maripa = new Cidade();
        maripa.setId(2);
        maripa.setNome("Maripá");
        Lista.add(maripa);
        
        return Lista;
    }

    @Override
    public ArrayList<Object> GetByCriterios(ICriteria c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void salvar(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getbyId(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
