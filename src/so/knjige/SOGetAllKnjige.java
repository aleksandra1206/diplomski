/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.knjige;

import so.clanovi.*;
import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Autor;
import domain.AutorKnjige;
import domain.Clan;
import domain.Knjiga;
import domain.Zanr;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Korisnik
 */
public class SOGetAllKnjige extends AbstractSO{
    
    private ArrayList<Knjiga> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Knjiga) ){
            throw new Exception("Prosledjeni objekat nije instanca klase Knjiga!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<Knjiga> knjige = (ArrayList<Knjiga>) (ArrayList<?>) DBBroker.getInstance().select(ado);
        lista = knjige;
    }

    public ArrayList<Knjiga> getLista() {
        return lista;
    }
    
    
    
}
