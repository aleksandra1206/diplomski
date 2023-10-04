/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.autor;

import so.clanovi.*;
import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Autor;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Korisnik
 */
public class SOGetAllAutori extends AbstractSO{
    
    private ArrayList<Autor> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Autor) ){
            throw new Exception("Prosledjeni objekat nije instanca klase Autor!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> autori = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Autor>) (ArrayList<?>) autori;
    }

    public ArrayList<Autor> getLista() {
        return lista;
    }
    
    
    
}
