/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.thiagohc.atividade;

import br.com.thiagohc.contracts.ICriteria;
import br.com.thiagohc.contracts.IFilter;
import br.com.thiagohc.contracts.ISqlUpdate;

/**
 *
 * @author thiag
 */
public class Atividade5 {
     public static void main(String[] args) {
        ISqlUpdate update = new ISqlUpdate("usuario");
        
        update.addRowData("nome", "Pedro");
        
        ICriteria criterio = new ICriteria();
        criterio.addExpressions(new IFilter("nome", "=", "João"));

        update.setCriterio(criterio);
        System.out.println(update.getSql());
    }
}
