/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.thiagohc.dao;

import java.util.ArrayList;
import javafx.scene.control.TableColumn;

/**
 *
 * @author thiag
 */
public interface TableModelInterface {
    public ArrayList<TableColumn<Object, Object>> getCols();
    public ArrayList<Object> pesquisar(String param);
}
