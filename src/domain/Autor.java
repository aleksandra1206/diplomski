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
public class Autor extends AbstractDomainObject{
    
    private long autorID;
    private String ime;
    private String prezime;
    private ArrayList<AutorKnjige> knjige;

    public Autor() {
    }

    public Autor(long autorID, String ime, String prezime, ArrayList<AutorKnjige> knjige) {
        this.autorID = autorID;
        this.ime = ime;
        this.prezime = prezime;
        this.knjige = knjige;
    }
    
    

    @Override
    public String nazivTabele() {
        return " autor ";
    }

    @Override
    public String alijas() {
        return " a ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        while (rs.next()) {
            Autor a = new Autor(rs.getLong("AutorID"), rs.getString("Ime"), rs.getString("Prezime"), null);
            lista.add(a);
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
        return " autorID = " + autorID;
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

    public long getAutorID() {
        return autorID;
    }

    public void setAutorID(long autorID) {
        this.autorID = autorID;
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

    public ArrayList<AutorKnjige> getKnjige() {
        return knjige;
    }

    public void setKnjige(ArrayList<AutorKnjige> knjige) {
        this.knjige = knjige;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }
    
    
    
}
