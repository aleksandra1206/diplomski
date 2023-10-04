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
public class AutorKnjige extends AbstractDomainObject{
    
    private boolean imaViseAutora;
    private Knjiga knjiga;
    private Autor autor;

    public AutorKnjige() {
    }

    public AutorKnjige(boolean imaViseAutora, Knjiga knjiga, Autor autor) {
        this.imaViseAutora = imaViseAutora;
        this.knjiga = knjiga;
        this.autor = autor;
    }
    
    

    @Override
    public String nazivTabele() {
        return " autorknjige ";
    }

    @Override
    public String alijas() {
        return " ak ";
    }

    @Override
    public String join() {
        return "JOIN AUTOR A ON (AK.AUTORID = A.AUTORID) "
                + "JOIN KNJIGA K ON (AK.KNJIGAID = K.KNJIGAID) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        while (rs.next()) {
            Knjiga k = new Knjiga(rs.getLong("KnjigaID"), rs.getString("Naziv"), rs.getDouble("ProsecnaOcena"), null, null, null);
            Autor a = new Autor(rs.getLong("AutorID"), rs.getString("Ime"), rs.getString("Prezime"), null);
            AutorKnjige ak = new AutorKnjige(rs.getBoolean("ImaViseKoautora"), k, a);
            lista.add(ak);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (imaViseKoautora, autorID, knjigaID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " (autorID, knjigaID) = (" + autor.getAutorID() + ", " + knjiga.getKnjigaID() + ") ";
    }

    @Override
    public String vrednostiZaInsert() {
        return " " + imaViseAutora + ", " + autor.getAutorID() + ", " + knjiga.getKnjigaID() + " ";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String uslov() {
        return "";
    }

    public boolean isImaViseAutora() {
        return imaViseAutora;
    }

    public void setImaViseAutora(boolean imaViseAutora) {
        this.imaViseAutora = imaViseAutora;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    
}
