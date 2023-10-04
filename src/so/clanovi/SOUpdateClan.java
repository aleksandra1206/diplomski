/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.clanovi;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Clan;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author PC
 */
public class SOUpdateClan extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Clan)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Clan!");
        }
        
        ArrayList<Clan> lista =(ArrayList<Clan>) (ArrayList<?>) DBBroker.getInstance().select(ado);
        
        Clan c = (Clan) ado;
        
        for (Clan clan : lista) {
            if (clan.getIme().equals(c.getIme()) && clan.getPrezime().equals(c.getPrezime())) {
                throw new Exception("Sistem ne moze da zapamti clana! Uneti podaci su isti kao i do sad! Nije doslo do izmene!");
            }
        }

    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().update(ado);
    }

}
