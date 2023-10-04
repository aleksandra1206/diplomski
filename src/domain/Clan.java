/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Korisnik
 */
public class Clan extends AbstractDomainObject{
    
    private long clanID;
    private String ime;
    private String prezime;
    private Date datumUclanjenja;
    private Bibliotekar bibliotekar;

    public Clan() {
    }

    public Clan(long clanID, String ime, String prezime, Date datumUclanjenja, Bibliotekar bibliotekar) {
        this.clanID = clanID;
        this.ime = ime;
        this.prezime = prezime;
        this.datumUclanjenja = datumUclanjenja;
        this.bibliotekar = bibliotekar;
    }

    @Override
    public String nazivTabele() {
        return " clan ";
    }

    @Override
    public String alijas() {
        return " c ";
    }

    @Override
    public String join() {
        return " join bibliotekar b on (c.bibliotekarid = b.bibliotekarid) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        while (rs.next()) {
            Bibliotekar b = new Bibliotekar(rs.getLong("BibliotekarID"), rs.getString("Ime"), rs.getString("Prezime"),
            rs.getString("KorisnickoIme"), rs.getString("Lozinka"), null, null);
            Clan c = new Clan(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getDate(4), b);
            lista.add(c);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (ime, prezime, datumUclanjenja, bibliotekarID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " clanID = " + clanID;
    }

    @Override
    public String vrednostiZaInsert() {
        long millis = System.currentTimeMillis();
        java.sql.Date datum = new java.sql.Date(millis);
        return "'" + ime + "', '" + prezime + "', '" + datum + "', " + bibliotekar.getBibliotekarID();
    }

    @Override
    public String vrednostiZaUpdate() {
        return " ime = '" + ime + "', prezime = '" + prezime + "' ";
    }

    @Override
    public String uslov() {
        return " ORDER BY clanid ASC ";
    }

    public long getClanID() {
        return clanID;
    }

    public void setClanID(long clanID) {
        this.clanID = clanID;
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

    public Date getDatumUclanjenja() {
        return datumUclanjenja;
    }

    public void setDatumUclanjenja(Date datumUclanjenja) {
        this.datumUclanjenja = datumUclanjenja;
    }

    public Bibliotekar getBibliotekar() {
        return bibliotekar;
    }

    public void setBibliotekar(Bibliotekar bibliotekar) {
        this.bibliotekar = bibliotekar;
    }
    
}
