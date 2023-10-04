/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Korisnik
 */
public class Knjiga extends AbstractDomainObject{
    
    private long knjigaID;
    private String naziv;
    private double prosecnaOcena;
    private ArrayList<AutorKnjige> autori;
    private ArrayList<ZanrKnjige> zanrovi;
    private ArrayList<OcenaKnjige> oceneBibliotekara;

    public Knjiga() {
    }

    public Knjiga(long knjigaID, String naziv, double prosecnaOcena, ArrayList<AutorKnjige> autori, ArrayList<ZanrKnjige> zanrovi, ArrayList<OcenaKnjige> oceneBibliotekara) {
        this.knjigaID = knjigaID;
        this.naziv = naziv;
        this.prosecnaOcena = prosecnaOcena;
        this.autori = autori;
        this.zanrovi = zanrovi;
        this.oceneBibliotekara = oceneBibliotekara;
    }

    @Override
    public String nazivTabele() {
        return " knjiga ";
    }

    @Override
    public String alijas() {
        return " k ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        while (rs.next()) {
            Knjiga k = new Knjiga(rs.getLong(1), rs.getString(2), rs.getDouble(3), null, null, null);
            lista.add(k);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (naziv, prosecnaOcena) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " knjigaID = " + knjigaID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + naziv + "', " + prosecnaOcena + " ";
    }

    @Override
    public String vrednostiZaUpdate() {
        return " naziv = '" + naziv + "', prosecnaOcena = " + prosecnaOcena;
    }

    @Override
    public String uslov() {
        return "";
    }

    public long getKnjigaID() {
        return knjigaID;
    }

    public void setKnjigaID(long knjigaID) {
        this.knjigaID = knjigaID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getProsecnaOcena() {
        return prosecnaOcena;
    }

    public void setProsecnaOcena(double prosecnaOcena) {
        this.prosecnaOcena = prosecnaOcena;
    }

    public ArrayList<AutorKnjige> getAutori() {
        return autori;
    }

    public void setAutori(ArrayList<AutorKnjige> autori) {
        this.autori = autori;
    }

    public ArrayList<ZanrKnjige> getZanrovi() {
        return zanrovi;
    }

    public void setZanrovi(ArrayList<ZanrKnjige> zanrovi) {
        this.zanrovi = zanrovi;
    }

    public ArrayList<OcenaKnjige> getOceneBibliotekara() {
        return oceneBibliotekara;
    }

    public void setOceneBibliotekara(ArrayList<OcenaKnjige> oceneBibliotekara) {
        this.oceneBibliotekara = oceneBibliotekara;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Knjiga other = (Knjiga) obj;
        if (this.knjigaID != other.knjigaID) {
            return false;
        }
        if (Double.doubleToLongBits(this.prosecnaOcena) != Double.doubleToLongBits(other.prosecnaOcena)) {
            return false;
        }
        if (!Objects.equals(this.naziv, other.naziv)) {
            return false;
        }
        if (!Objects.equals(this.autori, other.autori)) {
            return false;
        }
        if (!Objects.equals(this.zanrovi, other.zanrovi)) {
            return false;
        }
        if (!Objects.equals(this.oceneBibliotekara, other.oceneBibliotekara)) {
            return false;
        }
        return true;
    }
    
}
