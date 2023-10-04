/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.knjige;


import controller.ServerController;
import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Clan;
import domain.Knjiga;
import domain.OcenaKnjige;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author PC
 */
public class SOUpdateKnjiga extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Knjiga)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Knjiga!");
        }
        
        ArrayList<Knjiga> knjigeIzBaze = (ArrayList<Knjiga>) (ArrayList<?>) DBBroker.getInstance().select(ado);
        
        Knjiga knjiga = (Knjiga) ado;
        
        if (knjiga.getOceneBibliotekara() == null) {
            for (Knjiga knjigaIzBaze : knjigeIzBaze) {
                if (knjigaIzBaze.getNaziv().equals(knjiga.getNaziv()) && (knjigaIzBaze.getKnjigaID() == knjiga.getKnjigaID()) ) {
                    throw new Exception("Uneti naziv je isti kao i do sad! Nije doslo do izmene!");
                }
                
                
                if (knjigaIzBaze.getNaziv().equals(knjiga.getNaziv()) && (knjigaIzBaze.getKnjigaID() != knjiga.getKnjigaID()) ) {
                    throw new Exception("Druga knjiga sa istim nazivom vec postoji!");
                }
            
            }
            
        }else{
            OcenaKnjige oc = knjiga.getOceneBibliotekara().get(knjiga.getOceneBibliotekara().size() - 1);
            ArrayList<OcenaKnjige> ocene = (ArrayList<OcenaKnjige>) (ArrayList<?>) DBBroker.getInstance().select(new OcenaKnjige());
            if (ocene != null) {
                for (OcenaKnjige ocenaIzBaze : ocene) {
                    if (ocenaIzBaze.getBibliotekar().getBibliotekarID() == oc.getBibliotekar().getBibliotekarID()
                            && ocenaIzBaze.getKnjiga().getKnjigaID() == oc.getKnjiga().getKnjigaID()) {
                        throw new Exception("Vec ste uneli ocenu za ovu knjigu!");
                    }
                }
            }
        }
        
        

    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().update(ado);
        //
        Knjiga knjiga = (Knjiga) ado;
        
        if (knjiga.getOceneBibliotekara() != null) {
            OcenaKnjige oc = knjiga.getOceneBibliotekara().get(knjiga.getOceneBibliotekara().size() - 1);
            oc.setKnjiga(knjiga);
            DBBroker.getInstance().insert(oc);
        }

        
    }

}
