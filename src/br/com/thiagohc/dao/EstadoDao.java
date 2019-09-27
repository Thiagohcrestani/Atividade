/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.thiagohc.dao;

import br.com.thiagohc.contracts.ICriteria;
import br.com.thiagohc.contracts.IFilter;
import br.com.thiagohc.contracts.ISqlInsert;
import br.com.thiagohc.contracts.ISqlInstruction;
import br.com.thiagohc.contracts.ISqlUpdate;
import br.com.thiagohc.model.Estado;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author thiag
 */
public class EstadoDao extends AbstractDao{

    public EstadoDao(Connection conn) {
        this.conn = conn;
    }
    
    
    

    @Override
    protected String getTableName() {
        return "estado";
    }

    @Override
    public ArrayList<Object> GetByCriterios(ICriteria c) {
        ISqlInstruction sql = this.newInstruction(ISqlInstruction.QueryType.SELECT);
        sql.setCriterio(c);
        try{
            ArrayList<HashMap<String,Object>> dados = this.executeSql(sql);
            if (!dados.isEmpty()){
                ArrayList<Estado> ests = new ArrayList<>();
                for (HashMap<String, Object> row: dados){
                    Estado est = new Estado();
                    est.setId((long) row.get("id"));
                    est.setNome((String) row.get("nome"));
                    est.setUf((String) row.get("sigla"));
                    ests.add(est);
                }
                return(ArrayList) ests;
            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void salvar(Object o) {
       Estado estado = (Estado) o;
       ISqlInstruction sql = this.newInstruction(ISqlInstruction.QueryType.INSERT);
       if (estado.getId()>0){
           sql = this.newInstruction(ISqlInstruction.QueryType.UPDATE);
       }
           ((ISqlUpdate) sql).addRowData("nome", estado.getNome());
           ((ISqlUpdate) sql).addRowData("sigla", estado.getUf());
       if (sql instanceof ISqlUpdate){
           //updatecol
           ICriteria criterio = new ICriteria();
           criterio.addExpressions(
                   new IFilter("id", 
                                                "=", 
                                                Long.toString(estado.getId())
                   )
           );
           sql.setCriterio(criterio);
           
       }else if(sql instanceof ISqlInsert){
           //insert
           ((ISqlUpdate) sql).getRowData().put("id", null);
           
       }
       try{
          Object ret = this.executeSql(sql);
          if (sql instanceof ISqlInsert && ret instanceof Long);
            estado.setId((long)ret);
       } catch(SQLException ex){
           System.out.println(ex.getMessage());
       }
    }

    @Override
    public void remover(Object o) {
        Estado estado = (Estado) o;
        if (estado.getId()>0){
            ISqlInstruction del = this.newInstruction(ISqlInstruction.QueryType.DELETE);
            ICriteria criterio = new ICriteria();
            criterio.addExpressions(
            new IFilter("id", "=", String.valueOf(estado.getId())));
            del.setCriterio(criterio);
            
            try {
                executeSql(del);
            } catch (SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }

    @Override
    public Object getbyId(long id) {
        ICriteria criterio = new ICriteria();
        criterio.addExpressions(new IFilter("id", "=", String.valueOf(id)));
        return this.GetByCriterios(criterio);
    }
    
}
