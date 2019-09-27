/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.thiagohc.atividade;

import br.com.thiagohc.contracts.ICriteria;
import br.com.thiagohc.contracts.IFilter;
import br.com.thiagohc.contracts.ISqlSelect;

/**
 *
 * @author thiag
 */
public class Atividade4 {
    public static void main(String[] args) {
        ISqlSelect select = new ISqlSelect("produto");
        select.getCols().add("nome");
        select.getCols().add("valor");

        ICriteria criterio = new ICriteria();
        criterio.addExpressions(new IFilter("situacao", "=", "A"));
        criterio.getProperties().put("limit", 3);
        criterio.getProperties().put("order", "valor desc");
        select.setCriterio(criterio);
        System.out.println(select.getSql());
    }
}
