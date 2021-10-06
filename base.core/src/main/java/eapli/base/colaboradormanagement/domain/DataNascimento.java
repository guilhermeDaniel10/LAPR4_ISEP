/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.colaboradormanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Embeddable;


/**
 *
 * @author Guilherme
 */
@Embeddable
public class DataNascimento implements ValueObject{
    
    private Date dataNascimento;

    protected DataNascimento() {
    }
    
    public DataNascimento(Date dataN) throws ParseException{
        if(dataN == null){
            throw new IllegalArgumentException("Data de nascimento nao pode ser null ou vazio");
        }

        this.dataNascimento = dataN;
    }
    
    public boolean isSameDate(String sDate) throws ParseException{
        Date date;
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        date = format.parse(sDate);
        
        return this.dataNascimento.equals(date);
    }
    
    public boolean isSameDate(Date date){
        return this.dataNascimento.equals(date);
    }

    @Override
    public String toString() {
        return "DataNascimento: " + dataNascimento.toString();
    }
    
    
    
}
