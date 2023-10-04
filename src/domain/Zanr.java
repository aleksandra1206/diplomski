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
public class Zanr extends AbstractDomainObject{
    
    private long zanrID;
    private String naziv;
    private ArrayList<ZanrKnjige> knjige;

    public Zanr() {
    }

    public Zanr(long zanrID, String naziv, ArrayList<ZanrKnjige> knjige) {
        this.zanrID = zanrID;
        this.naziv = naziv;
        this.knjige = knjige;
    }
    
    

    @Override
    public String nazivTabele() {
        return " zanr ";
    }

    @Override
    public String alijas() {
        return " z ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        while (rs.next()) {
            Zanr zanr = new Zanr(rs.getLong("ZanrID"), rs.getString("NazivZanra"), null);
            lista.add(zanr);
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " zanrID = " + zanrID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String uslov() {
        return "";
    }

    public long getZanrID() {
        return zanrID;
    }

    public void setZanrID(long zanrID) {
        this.zanrID = zanrID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public ArrayList<ZanrKnjige> getKnjige() {
        return knjige;
    }

    public void setKnjige(ArrayList<ZanrKnjige> knjige) {
        this.knjige = knjige;
    }

    @Override
    public String toString() {
        return naziv;
    }
    
    
    
}
