/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import session.Session;
import transfer.Request;
import transfer.Response;
import transfer.status.ResponseStatus;
import constants.Operation;
import domain.Autor;
import domain.Bibliotekar;
import domain.Clan;
import domain.Knjiga;
import domain.OcenaKnjige;
import domain.Zanr;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class ClientController {

    private static ClientController instance;

    private ClientController() {
    }

    public static ClientController getInstance() {
        if (instance == null) {
            instance = new ClientController();
        }
        return instance;
    }

    private Object sendRequest(int operation, Object data) throws Exception {
        Request request = new Request(operation, data);

        ObjectOutputStream out = new ObjectOutputStream(Session.getInstance().getSocket().getOutputStream());
        out.writeObject(request);

        ObjectInputStream in = new ObjectInputStream(Session.getInstance().getSocket().getInputStream());
        Response response = (Response) in.readObject();

        if (response.getResponseStatus().equals(ResponseStatus.Error)) {
            throw response.getException();
        } else {
            return response.getData();
        }

    }
    
    
    public Bibliotekar login(Bibliotekar bibliotekar) throws Exception {
        return (Bibliotekar) sendRequest(Operation.LOGIN, bibliotekar);
    }

    public void addClan(Clan clan) throws Exception {
        sendRequest(Operation.ADD_CLAN, clan);
    }

    public ArrayList<Clan> getAllClanovi() throws Exception {
        return (ArrayList<Clan>) sendRequest(Operation.GET_ALL_CLANOVI, null);
    }

    public void updateClan(Clan clan) throws Exception {
        sendRequest(Operation.UPDATE_CLAN, clan);
    }

    public void deleteClan(Clan clan) throws Exception {
        sendRequest(Operation.DELETE_CLAN, clan);
    }

    public ArrayList<Autor> getAllAutori() throws Exception {
        return (ArrayList<Autor>) sendRequest(Operation.GET_ALL_AUTORI, null);
    }

    public ArrayList<Zanr> getAllZanrovi() throws Exception {
        return (ArrayList<Zanr>) sendRequest(Operation.GET_ALL_ZANROVI, null);
    }

    public ArrayList<Knjiga> getAllKnjige() throws Exception {
        return (ArrayList<Knjiga>) sendRequest(Operation.GET_ALL_KNJIGE, null);
    }

    public void updateKnjiga(Knjiga knjiga) throws Exception {
        sendRequest(Operation.UPDATE_KNJIGA, knjiga);
    }

    public void addKnjiga(Knjiga knjiga) throws Exception {
        sendRequest(Operation.ADD_KNJIGA, knjiga);
    }

    public ArrayList<OcenaKnjige> getAllOcenaKnjige(OcenaKnjige ocena) throws Exception {
        return (ArrayList<OcenaKnjige>) sendRequest(Operation.GET_ALL_OCENE, ocena);
    }

}
