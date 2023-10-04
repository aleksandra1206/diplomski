/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.knjige;

import domain.Autor;
import domain.AutorKnjige;
import domain.Knjiga;
import domain.Zanr;
import domain.ZanrKnjige;
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
public class SOAddKnjigaTest {
    SOAddKnjiga so;
    
    public SOAddKnjigaTest() {
    }
    
    @Before
    public void setUp() {
        so = new SOAddKnjiga();
    }
    
    @After
    public void tearDown() {
        so = null;
    }

    @Test
    public void testValidate(){
        /*Autor au = new Autor(1, "Fjodor", "Dostojevski", null);
        AutorKnjige ak = new AutorKnjige(true, new Knjiga(), au);
        Zanr z = new Zanr(10, "Egzistencijalizam", null);
        ZanrKnjige zk = new ZanrKnjige(true, z, new Knjiga());
        ArrayList<AutorKnjige> autoriKnjige = new ArrayList<>();
        ArrayList<ZanrKnjige> zanroviKnjige = new ArrayList<>();
        
        autoriKnjige.add(ak);
        zanroviKnjige.add(zk);
        //1
        try {
        Knjiga k = new Knjiga(-1, "Nova knjiga", 0, autoriKnjige, zanroviKnjige, null);
        so.validate(k);
        System.out.println("No exception");
        } catch (Exception ex) {
        Logger.getLogger(SOAddKnjigaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        //2
        try {
        Knjiga k = new Knjiga(-1, "Sidarta", 0, null, null, null);
        so.validate(k);
        System.out.println("No exception");
        } catch (Exception ex) {
        Logger.getLogger(SOAddKnjigaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        //3
        try {
        Knjiga k = new Knjiga(-1, "", 0, null, null, null);
        so.validate(k);
        System.out.println("No exception");
        } catch (Exception ex) {
        Logger.getLogger(SOAddKnjigaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        //4
        try {
        Autor a = new Autor();
        so.validate(a);
        System.out.println("No exception");
        } catch (Exception ex) {
        Logger.getLogger(SOAddKnjigaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        //5
        try {
        so.validate(new Knjiga(-1, "Nova", 0, new ArrayList<AutorKnjige>(), new ArrayList<ZanrKnjige>(), null));
        System.out.println("No exception");
        } catch (Exception ex) {
        Logger.getLogger(SOAddKnjigaTest.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }

    @Test
    public void testExecute(){
        Autor au = new Autor(1, "Fjodor", "Dostojevski", null);
        AutorKnjige ak = new AutorKnjige(true, new Knjiga(), au);
        Zanr z = new Zanr(10, "Egzistencijalizam", null);
        ZanrKnjige zk = new ZanrKnjige(true, z, new Knjiga());
        ArrayList<AutorKnjige> autoriKnjige = new ArrayList<>();
        ArrayList<ZanrKnjige> zanroviKnjige = new ArrayList<>();
        
        autoriKnjige.add(ak);
        zanroviKnjige.add(zk);
        
        Knjiga k = new Knjiga(-1, "Nova knjiga", 0, autoriKnjige, zanroviKnjige, null);
        try {
        so.execute(k);
        System.out.println("No exception");
        } catch (Exception ex) {
        Logger.getLogger(SOAddKnjigaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
