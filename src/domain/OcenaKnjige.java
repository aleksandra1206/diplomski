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
public class OcenaKnjige extends AbstractDomainObject{
    
    private int iznosOcene;
    private Bibliotekar bibliotekar;
    private Knjiga knjiga;

    public OcenaKnjige() {
    }

    public OcenaKnjige(int iznosOcene, Bibliotekar bibliotekar, Knjiga knjiga) {
        this.iznosOcene = iznosOcene;
        this.bibliotekar = bibliotekar;
        this.knjiga = knjiga;
    }
    
    

    @Override
    public String nazivTabele() {
        return " ocenaknjige ";
    }

    @Override
    public String alijas() {
        return " ok ";
    }

    @Override
    public String join() {
        return " JOIN KNJIGA K ON (OK.KNJIGAID = K.KNJIGAID) JOIN BIBLIOTEKAR B ON (OK.BIBLIOTEKARID = B.BIBLIOTEKARID) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        //System.out.println("vratiListu\n");
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        while (rs.next()) {
            Bibliotekar b = new Bibliotekar(rs.getLong("BibliotekarID"), rs.getString("Ime"), 
                    rs.getString("Prezime"), rs.getString("KorisnickoIme"), rs.getString("Lozinka"), null, null);
            Knjiga k = new Knjiga(rs.getLong("KnjigaID"), rs.getString("Naziv"), rs.getDouble("ProsecnaOcena"), null, null, null);
            OcenaKnjige ok = new OcenaKnjige(rs.getInt("IznosOcene"), b, k);
            lista.add(ok);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (iznosOcene, bibliotekarID, knjigaID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " (bibliotekarID, knjigaID) = (" + bibliotekar.getBibliotekarID() + ", " + knjiga.getKnjigaID() + ") ";
    }

    @Override
    public String vrednostiZaInsert() {
        return " " + iznosOcene + ", " + bibliotekar.getBibliotekarID() + ", " + knjiga.getKnjigaID() + " ";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String uslov() {
        return "";
    }

    public int getIznosOcene() {
        return iznosOcene;
    }

    public void setIznosOcene(int iznosOcene) {
        this.iznosOcene = iznosOcene;
    }

    public Bibliotekar getBibliotekar() {
        return bibliotekar;
    }

    public void setBibliotekar(Bibliotekar bibliotekar) {
        this.bibliotekar = bibliotekar;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
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
        final OcenaKnjige other = (OcenaKnjige) obj;
        if (this.iznosOcene != other.iznosOcene) {
            return false;
        }
        if (!Objects.equals(this.bibliotekar, other.bibliotekar)) {
            return false;
        }
        if (!Objects.equals(this.knjiga, other.knjiga)) {
            return false;
        }
        return true;
    }
    
}
