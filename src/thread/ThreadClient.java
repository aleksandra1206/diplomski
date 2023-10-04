/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;


import constants.Operation;
import controller.ServerController;
import domain.Bibliotekar;
import domain.Clan;
import domain.Knjiga;
import domain.OcenaKnjige;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import transfer.Request;
import transfer.Response;
import transfer.status.ResponseStatus;


/**
 *
 * @author PC
 */
public class ThreadClient extends Thread {

    private Socket socket;

    ThreadClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (!socket.isClosed()) {
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                Request request = (Request) in.readObject();
                Response response = handleRequest(request);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Response handleRequest(Request request) {
        Response response = new Response(null, null, ResponseStatus.Success);
        try {
            switch (request.getOperation()) {
                case Operation.LOGIN:
                    Bibliotekar bibliotekar = (Bibliotekar) request.getData();
                    Bibliotekar ulogovani = ServerController.getInstance().login(bibliotekar);
                    response.setData(ulogovani);
                    break;
                case Operation.ADD_CLAN:
                    ServerController.getInstance().addClan((Clan) request.getData());
                    break;
                case Operation.ADD_KNJIGA:
                    ServerController.getInstance().addKnjiga((Knjiga) request.getData());
                    break;
                case Operation.DELETE_CLAN:
                    ServerController.getInstance().deleteClan((Clan) request.getData());
                    break;
                case Operation.UPDATE_CLAN:
                    ServerController.getInstance().updateClan((Clan) request.getData());
                    break;
                case Operation.UPDATE_KNJIGA:
                    ServerController.getInstance().updateKnjiga((Knjiga) request.getData());
                    break;
                case Operation.GET_ALL_CLANOVI:
                    response.setData(ServerController.getInstance().getAllClanovi());
                    break;
                case Operation.GET_ALL_OCENE:
                    response.setData(ServerController.getInstance().getAllOcene(request.getData()));
                    break;
                case Operation.GET_ALL_AUTORI:
                    response.setData(ServerController.getInstance().getAllAutori());
                    break;
                case Operation.GET_ALL_ZANROVI:
                    response.setData(ServerController.getInstance().getAllZanrovi());
                    break;
                case Operation.GET_ALL_KNJIGE:
                    response.setData(ServerController.getInstance().getAllKnjige());
                    break;
                default:
                    return null;
            }
        } catch (Exception e) {
            response.setResponseStatus(ResponseStatus.Error);
            response.setException(e);
        }
        return response;
    }

}
