/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.AbstractDomainObject;
import domain.Autor;
import domain.Bibliotekar;
import domain.Clan;
import domain.Knjiga;
import domain.OcenaKnjige;
import domain.Zanr;
import java.util.ArrayList;
import so.autor.SOGetAllAutori;
import so.clanovi.SOAddClan;
import so.clanovi.SODeleteClan;
import so.clanovi.SOGetAllClanovi;
import so.clanovi.SOUpdateClan;
import so.knjige.SOAddKnjiga;
import so.knjige.SOGetAllKnjige;
import so.knjige.SOUpdateKnjiga;
import so.login.SOLogin;
import so.ocena.SOGetAllOcena;
import so.zanr.SOGetAllZanrovi;

/**
 *
 * @author Korisnik
 */
public class ServerController {
    
    private static ServerController instance;

    private ServerController() {
    }

    public static ServerController getInstance() {
        if (instance == null) {
            instance = new ServerController();
        }
        return instance;
    }
    
    public Bibliotekar login(Bibliotekar bibliotekar) throws Exception {
        SOLogin so = new SOLogin();
        so.templateExecute(bibliotekar);
        return so.getUlogovani();
    }

    public void addClan(Clan clan) throws Exception {
        new SOAddClan().templateExecute(clan);
    }

    public ArrayList<Clan> getAllClanovi() throws Exception {
        SOGetAllClanovi so = new SOGetAllClanovi();
        so.templateExecute(new Clan());
        return so.getLista();
    }

    public void updateClan(Clan clan) throws Exception {
        new SOUpdateClan().templateExecute(clan);
    }

    public void deleteClan(Clan clan) throws Exception {
        new SODeleteClan().templateExecute(clan);
    }

    public void addKnjiga(Knjiga knjiga) throws Exception {
        new SOAddKnjiga().templateExecute(knjiga);
        
    }
    
    public Object getAllKnjige() throws Exception {
        SOGetAllKnjige so = new SOGetAllKnjige();
        so.templateExecute(new Knjiga());
        return so.getLista();
    }

    public void updateKnjiga(Knjiga knjiga) throws Exception {
        new SOUpdateKnjiga().templateExecute(knjiga);
    }

    public Object getAllAutori() throws Exception {
        SOGetAllAutori so = new SOGetAllAutori();
        so.templateExecute(new Autor());
        return so.getLista();
    }

    public Object getAllZanrovi() throws Exception {
        SOGetAllZanrovi so = new SOGetAllZanrovi();
        so.templateExecute(new Zanr());
        return so.getLista();
    }

    public Object getAllOcene(Object data) throws Exception {    
        SOGetAllOcena so = new SOGetAllOcena();
        so.templateExecute((AbstractDomainObject) data);
        return so.getLista();
    }


    
}
