/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.ocena;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Knjiga;
import domain.OcenaKnjige;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Korisnik
 */
public class SOGetAllOcena extends AbstractSO{
    private ArrayList<OcenaKnjige> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof OcenaKnjige) ){
            throw new Exception("Objekat nije instanca klase OcenaKnjige!");
            
        }
        
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        System.out.println("Execute\n");
        ArrayList<AbstractDomainObject> oceneKnjige = DBBroker.getInstance().select(ado);
        lista = (ArrayList<OcenaKnjige>) (ArrayList<?>) oceneKnjige;
    }

    public ArrayList<OcenaKnjige> getLista() {
        return lista;
    }
    
}
