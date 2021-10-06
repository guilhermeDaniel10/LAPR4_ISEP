/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eapli.base.pedidomanagement.domain;

import eapli.framework.domain.model.ValueObject;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Embeddable;

/**
 *
 * @author Guilherme
 */
@Embeddable
public class DataLimite implements ValueObject{
    
    private Date dataLimite;
    
    protected DataLimite(){
        
    }
    
    public DataLimite(Date dataLimite){
        Date currentDate = new Date();
        if(dataLimite == null){
            throw new IllegalArgumentException("Data Limite nao pode ser null ou vazio");
        }
        if(dataLimite.before(currentDate)){
            throw new IllegalArgumentException("Data Limite ja ultrapassada.");
        }
        this.dataLimite = dataLimite;   
    }
    
    public boolean isSameDate(String sDate) throws ParseException{
        Date date;
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        date = format.parse(sDate);
        
        return this.dataLimite.equals(date);
    }
    
    public boolean isSameDate(Date date){
        return this.dataLimite.equals(date);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.dataLimite);
        return hash;
    }
    
    public boolean equals(Object other){
        if (!(other instanceof DataLimite)) {
            return false;
        }

        final DataLimite that = (DataLimite) other;
        if (this == that) {
            return true;
        }
        
        return this.dataLimite.equals(that.dataLimite);
    }
    
    @Override
    public String toString() {
        return "Data Limite: " + dataLimite.toString();
    }
    
    public Date dataLimiteAsData(){
        return this.dataLimite;
    }
    
    
}
