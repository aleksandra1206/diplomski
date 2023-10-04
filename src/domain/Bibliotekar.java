/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Korisnik
 */
public class Bibliotekar extends AbstractDomainObject{
    
    private long bibliotekarID;
    private String ime;
    private String prezime;
    private String username;
    private String password;
    private ArrayList<OcenaKnjige> oceneKnjiga;
    private ArrayList<Clan> dodatiClanovi;

    public Bibliotekar() {
    }

    public Bibliotekar(long bibliotekarID, String ime, String prezime, String username, String password, 
            ArrayList<OcenaKnjige> oceneKnjiga, ArrayList<Clan> dodatiClanovi) {
        this.bibliotekarID = bibliotekarID;
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
        this.oceneKnjiga = oceneKnjiga;
        this.dodatiClanovi = dodatiClanovi;
    }

    @Override
    public String nazivTabele() {
        return " bibliotekar ";
    }

    @Override
    public String alijas() {
        return "";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Bibliotekar b = new Bibliotekar(rs.getLong(1), rs.getString(2), 
                    rs.getString(3), rs.getString(4), rs.getString(5), null, null);

            lista.add(b);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vrednostiZaInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vrednostiZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String uslov() {
        return "";
    }

    public long getBibliotekarID() {
        return bibliotekarID;
    }

    public void setBibliotekarID(long bibliotekarID) {
        this.bibliotekarID = bibliotekarID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<OcenaKnjige> getOceneKnjiga() {
        return oceneKnjiga;
    }

    public void setOceneKnjiga(ArrayList<OcenaKnjige> oceneKnjiga) {
        this.oceneKnjiga = oceneKnjiga;
    }

    public ArrayList<Clan> getDodatiClanovi() {
        return dodatiClanovi;
    }

    public void setDodatiClanovi(ArrayList<Clan> dodatiClanovi) {
        this.dodatiClanovi = dodatiClanovi;
    }
    
    
    
}
