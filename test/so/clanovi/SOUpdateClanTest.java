/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.clanovi;

import domain.Bibliotekar;
import domain.Clan;
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
public class SOUpdateClanTest {
    SOUpdateClan so;
    
    public SOUpdateClanTest() {
    }
    
    @Before
    public void setUp() {
        so = new SOUpdateClan();
    }
    
    @After
    public void tearDown() {
        so = null;
    }

    @Test
    public void testValidate(){
        try {
        Clan clan = new Clan(2, "Zika", "Mikic", new java.sql.Date(System.currentTimeMillis()), 
                new Bibliotekar(1, "Aleksandra", "Pantelic", "aleksandra", "aleksandra123", null, null));
        so.validate(clan);
        System.out.println("No exception");
        } catch (Exception ex) {
        Logger.getLogger(SOUpdateClanTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
        Clan clan = new Clan(2, "Zika", "Zikic", new java.sql.Date(System.currentTimeMillis()), 
                new Bibliotekar(1, "Aleksandra", "Pantelic", "aleksandra", "aleksandra123", null, null));
        so.validate(clan);
        System.out.println("No exception");
        } catch (Exception ex) {
        Logger.getLogger(SOUpdateClanTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testExecute(){
        try {
            Clan clan = new Clan(-1, "Zika", "Mikic", new java.sql.Date(System.currentTimeMillis()), 
                    new Bibliotekar(1, "Aleksandra", "Pantelic", "aleksandra", "aleksandra123", null, null));
            so.execute(clan);
            System.out.println("No exception");
        } catch (Exception ex) {
            Logger.getLogger(SOUpdateClanTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
