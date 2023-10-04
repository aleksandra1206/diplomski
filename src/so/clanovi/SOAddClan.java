/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.clanovi;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Clan;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import so.AbstractSO;

/**
 *
 * @author Korisnik
 */
public class SOAddClan extends AbstractSO{

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Clan)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Clan!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        Clan clan = (Clan) ado;
        PreparedStatement ps = DBBroker.getInstance().insert(clan);
        
        ResultSet tableKeys = ps.getGeneratedKeys();
        tableKeys.next();
        long clanID = tableKeys.getLong(1);
        
        clan.setClanID(clanID);
    }
    
}
