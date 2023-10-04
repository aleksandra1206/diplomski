/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.autor;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Autor;
import domain.Knjiga;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.rules.ErrorCollector;
import org.junit.rules.Verifier;
import org.junit.runner.Description;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import sun.invoke.util.VerifyAccess;

/**
 *
 * @author Korisnik
 */
public class SOGetAllAutoriTest {
    SOGetAllAutori so;
    
    public SOGetAllAutoriTest() {
    }
    
    @Before
    public void setUp() {
        so = new SOGetAllAutori();
    }
    
    @After
    public void tearDown() {
        so = null;
    }

    @Test(expected = Exception.class)
    public void testValidate() throws Exception{
        so.validate(new Autor());
        System.out.println("Uspesno validiran Autor");
        so.validate((AbstractDomainObject) new Object());
        System.out.println("Uspesno validiran Object");
    }

    @Test
    public void testExecute() throws Exception{
        so.execute(new Autor());
        ArrayList<Autor> lista = so.getLista();
        
        assertEquals(true, lista.size() > 0);
    }
    
}


