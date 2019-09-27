/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.thiagohc.dao;

import br.com.thiagohc.contracts.ICriteria;
import java.util.ArrayList;

/**
 *
 * @author thiag
 */
public interface DaoInterface {
    public ArrayList<Object>GetByCriterios(ICriteria c);
    
        /**
        * Salva um Objeto qualquer
        * @param o Objeto
        * @author thiag
        */

        public void salvar(Object o);
        
        /**
        * Remove um Objeto qualquer
        * @param o Objeto
        * @author thiag
        */
        public void remover(Object o);
        
        /**
        * Retorna um Objeto qualquer
        * @param id id do objeto
        * @author thiag
        * @return 
        */
        
        public Object getbyId(long id);
        
}
