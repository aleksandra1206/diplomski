/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.clanovi;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Autor;
import domain.Bibliotekar;
import domain.Clan;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Korisnik
 */
public class SOAddClanTest {
    SOAddClan so;
    
    public SOAddClanTest() {
    }
    
    @Before
    public void setUp() {
        so = new SOAddClan();
    }
    
    @After
    public void tearDown() {
        so = null;
    }

    @Test(expected = Exception.class)
    public void testValidate()throws Exception{
        so.validate(new Clan());
        System.out.println("Uspesno validiran Clan");
        so.validate((AbstractDomainObject) new Object());
        System.out.println("Uspesno validiran Object");
    }
    
    

    @Test
    public void testExecute()throws Exception{
        ArrayList<Clan> clanoviPre = (ArrayList<Clan>)(ArrayList<?>)DBBroker.getInstance().select(new Clan());
        int sizePre = clanoviPre.size();
        
        Bibliotekar b = new Bibliotekar(1, "Aleksandra", "Pantelic", "aleksandra", "aleksandra123", null, null);
        Clan clan = new Clan(-1, "Novak", "Novakovic", new java.sql.Date(System.currentTimeMillis()), b);
        so.execute(clan);
        
        ArrayList<Clan> clanoviPosle = (ArrayList<Clan>)(ArrayList<?>)DBBroker.getInstance().select(new Clan());
        int sizePosle = clanoviPosle.size();
        
        assertEquals(sizePre, sizePosle - 1);

    }
    
}
