/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.knjige;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Bibliotekar;
import domain.Knjiga;
import domain.OcenaKnjige;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Korisnik
 */
public class SOUpdateKnjigaTest {
    SOUpdateKnjiga so;
    
    public SOUpdateKnjigaTest() {
    }
    
    @Before
    public void setUp() {
        so = new SOUpdateKnjiga();
    }
    
    @After
    public void tearDown() {
        so = null;
    }
    
    @Test
    public void testValidateNotChanged() throws Exception {
        System.out.println("********************************");
        Knjiga knjiga = new Knjiga(1, "Ponizeni i uvredjeni", 8.9975, null, null, null);
        try {
            so.validate(knjiga);
        } catch (Exception exception) {
            assertEquals("Uneti naziv je isti kao i do sad! Nije doslo do izmene!", exception.getMessage());
            System.out.println(exception.getMessage());
        }
    }
    
    @Test
    public void testValidateAlreadyExists() throws Exception {
        System.out.println("********************************");
        Knjiga knjiga = new Knjiga(1, "Sidarta", 8.9975, null, null, null);
        try {
            so.validate(knjiga);
        } catch (Exception exception) {
            assertEquals("Druga knjiga sa istim nazivom vec postoji!", exception.getMessage());
            System.out.println(exception.getMessage());
        }
    }
    
    @Test
    public void testValidateAlreadyRated() throws Exception {
        System.out.println("********************************");
        ArrayList<OcenaKnjige> ocene = (ArrayList<OcenaKnjige>)(ArrayList<?>)DBBroker.getInstance().select(new OcenaKnjige());
        assertNotNull(ocene);//proverava da li lista nije null
        
        ArrayList<OcenaKnjige> oceneKnjige = new ArrayList<>();
        Bibliotekar b = new Bibliotekar(1, "Aleksandra", "Pantelic", "aleksandra", "aleksandra123", null, null);
        Knjiga knjiga = new Knjiga(1, "Test knjiga", 8.9975, null, null, null);
        
        for (OcenaKnjige ocenaIzBaze : ocene) {
            if (ocenaIzBaze.getKnjiga().getKnjigaID() == knjiga.getKnjigaID()) {
                oceneKnjige.add(ocenaIzBaze);
            }
        }
        
        OcenaKnjige oc = new OcenaKnjige(10, b, knjiga);
        oceneKnjige.add(oc);
        knjiga.setOceneBibliotekara(oceneKnjige);
        
        try {
            so.validate(knjiga);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            assertEquals("Vec ste uneli ocenu za ovu knjigu!", exception.getMessage());
        }
    }

    @Test(expected = Exception.class)
    public void testValidateInstanceOf() throws Exception {
        System.out.println("********************************");
        so.validate(new Knjiga());
        System.out.println("Uspesno validirana Knjiga");//treba da se ispise
        so.validate((AbstractDomainObject) new Object());//treba da baci izuzetak
        System.out.println("Uspesno validiran Object");//ne treba da se desi   
    }

    @Test
    public void testExecute() throws Exception {
        System.out.println("********************************");
        ArrayList<OcenaKnjige> ocene = (ArrayList<OcenaKnjige>)(ArrayList<?>)DBBroker.getInstance().select(new OcenaKnjige());
        assertNotNull(ocene);//proverava da li lista nije null
        int sizePre = ocene.size();
        
        ArrayList<OcenaKnjige> oceneKnjige = new ArrayList<>();
        Bibliotekar b = new Bibliotekar(1, "Aleksandra", "Pantelic", "aleksandra", "aleksandra123", null, null);
        Knjiga knjiga = new Knjiga(10, "Test knjiga", 7, null, null, null);
        
        for (OcenaKnjige ocenaIzBaze : ocene) {
            if (ocenaIzBaze.getKnjiga().getKnjigaID() == knjiga.getKnjigaID()) {
                oceneKnjige.add(ocenaIzBaze);
            }
        }
        
        OcenaKnjige oc = new OcenaKnjige(10, b, knjiga);
        oceneKnjige.add(oc);
        knjiga.setOceneBibliotekara(oceneKnjige);
        
        so.execute(knjiga);
        
        ArrayList<OcenaKnjige> ocenePosle = (ArrayList<OcenaKnjige>)(ArrayList<?>)DBBroker.getInstance().select(new OcenaKnjige());
        int sizePosle = ocenePosle.size();
        System.out.println(ocene.size());
        System.out.println(ocenePosle.size());
        
        assertEquals(sizePre, sizePosle - 1);
        System.out.println("Uspesno dodata knjiga!");
    }
    
}
