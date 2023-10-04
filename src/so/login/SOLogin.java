/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.login;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Bibliotekar;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Korisnik
 */
public class SOLogin extends AbstractSO {

    Bibliotekar ulogovani;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Bibliotekar)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Prodavac!");
        }
        
        Bibliotekar b = (Bibliotekar) ado;
        
        if (b.getUsername().isEmpty()) {
            throw new Exception("Niste popunili polje za korisnicko ime!");
        }
        
        if (b.getPassword().isEmpty()) {
            throw new Exception("Niste popunili polje za lozinku!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {

        Bibliotekar b = (Bibliotekar) ado;

        ArrayList<Bibliotekar> bibliotekari
                = (ArrayList<Bibliotekar>) (ArrayList<?>) DBBroker.getInstance().select(ado);

        for (Bibliotekar bibliotekar : bibliotekari) {
            if (bibliotekar.getUsername().equals(b.getUsername())
                    && bibliotekar.getPassword().equals(b.getPassword())) {
                ulogovani = bibliotekar;
                return;
            }
        }

        throw new Exception("Sistem ne moze da pronadje bibliotekara.");

    }

    public Bibliotekar getUlogovani() {
        return ulogovani;
    }

}
