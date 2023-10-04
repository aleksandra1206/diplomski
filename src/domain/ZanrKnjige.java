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
public class ZanrKnjige extends AbstractDomainObject{
    
    private boolean osnovniZanr;
    private Zanr zanr;
    private Knjiga knjiga;

    public ZanrKnjige() {
    }

    public ZanrKnjige(boolean osnovniZanr, Zanr zanr, Knjiga knjiga) {
        this.osnovniZanr = osnovniZanr;
        this.zanr = zanr;
        this.knjiga = knjiga;
    }
    
    

    @Override
    public String nazivTabele() {
        return " zanrknjige ";
    }

    @Override
    public String alijas() {
        return " zk ";
    }

    @Override
    public String join() {
        return "JOIN ZANR Z ON (ZK.ZANRID = Z.ZANRID) "
                + "JOIN KNJIGA K ON (ZK.KNJIGAID = K.KNJIGAID) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        while (rs.next()) {
            Zanr zanr = new Zanr(rs.getLong("ZanrID"), rs.getString("NazivZanra"), null);
            Knjiga k = new Knjiga(rs.getLong("KnjigaID"), rs.getString("Naziv"), rs.getDouble("ProsecnaOcena"), null, null, null);
            ZanrKnjige zk = new ZanrKnjige(rs.getBoolean("OsnovniZanr"), zanr, k);
            lista.add(zk);
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (osnovniZanr, knjigaID, zanrID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " (zanrID, knjigaID) = (" + knjiga.getKnjigaID() + ", " + zanr.getZanrID() + ") ";
    }

    @Override
    public String vrednostiZaInsert() {
        return " " + osnovniZanr + ", " + knjiga.getKnjigaID() + ", " + zanr.getZanrID() + " ";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String uslov() {
        return "";
    }

    public boolean isOsnovniZanr() {
        return osnovniZanr;
    }

    public void setOsnovniZanr(boolean osnovniZanr) {
        this.osnovniZanr = osnovniZanr;
    }

    public Zanr getZanr() {
        return zanr;
    }

    public void setZanr(Zanr zanr) {
        this.zanr = zanr;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }
    
}
