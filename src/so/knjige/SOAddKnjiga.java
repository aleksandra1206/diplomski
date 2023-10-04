/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.knjige;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.AutorKnjige;
import domain.Clan;
import domain.Knjiga;
import domain.ZanrKnjige;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Korisnik
 */
public class SOAddKnjiga extends AbstractSO{

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Knjiga)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Knjiga!");
        }
        
        Knjiga knjiga = (Knjiga) ado;
        
        ArrayList<Knjiga> knjigeIzBaze = (ArrayList<Knjiga>) (ArrayList<?>)DBBroker.getInstance().select(new Knjiga());
        
        for (Knjiga knjigaIzBaze : knjigeIzBaze) {
            if (knjigaIzBaze.getNaziv().equals(knjiga.getNaziv())) {
                throw new Exception("Knjiga sa datim nazivom vec postoji u bazi!");
            }
        }
        //
        if (knjiga.getNaziv().isEmpty()) {
            throw new Exception("Morate uneti naziv knjige!");
        }
        
        if (knjiga.getAutori().isEmpty()) {
            throw new Exception("Morate uneti bar jednog autora!");
        }
        
        if (knjiga.getZanrovi().isEmpty()) {
            throw new Exception("Morate uneti bar jedan zanr!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        PreparedStatement ps = DBBroker.getInstance().insert(ado);

        ResultSet tableKeys = ps.getGeneratedKeys();
        tableKeys.next();
        long knjigaID = tableKeys.getLong(1);
        System.out.println(knjigaID);

        Knjiga knjiga = (Knjiga) ado;
        knjiga.setKnjigaID(knjigaID);

        for (AutorKnjige autorKnjige : knjiga.getAutori()) {
            autorKnjige.setKnjiga(knjiga);
            DBBroker.getInstance().insert(autorKnjige);
        }
        
        for (ZanrKnjige zanrKnjige : knjiga.getZanrovi()) {
            zanrKnjige.setKnjiga(knjiga);
            DBBroker.getInstance().insert(zanrKnjige);
        }
        
    }
    
}
