/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import controller.ClientController;
import domain.Clan;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class ModelTabeleClanovi extends AbstractTableModel implements Runnable{
    
    String[] kolone = {"ClanID", "Ime", "Prezime", "Datum uclanjenja"};
    ArrayList<Clan> lista;
    String parametar = "";

    public ArrayList<Clan> getLista() {
        return lista;
    }

    public ModelTabeleClanovi() {
        try {
            lista = ClientController.getInstance().getAllClanovi();
            fireTableDataChanged();
        } catch (Exception ex) {
            Logger.getLogger(ModelTabeleClanovi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Clan clan = lista.get(rowIndex);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        switch(columnIndex){
            case 0: return clan.getClanID();
            case 1: return clan.getIme();
            case 2: return clan.getPrezime();
            case 3: return sdf.format(clan.getDatumUclanjenja());
            default: return "Greska u ucitavanju!";
        }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
    }

    public String getParametar() {
        return parametar;
    }

    public void refreshTable(){
        try {
            lista = ClientController.getInstance().getAllClanovi();
            if (!parametar.equals("")) {
                ArrayList<Clan> novaLista = new ArrayList<>();
                for (Clan clan : lista) {
                    long id = 0;
                    try {
                        id = Integer.parseInt(parametar);
                    }catch (Exception e) {
                    }
                    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                    String datum = "";
                    try {
                        datum = sdf.format(clan.getDatumUclanjenja());
                    } catch (Exception e) {
                    }
                    if (clan.getIme().toLowerCase().contains(parametar.toLowerCase()) 
                            || clan.getPrezime().toLowerCase().contains(parametar.toLowerCase()) 
                            || (clan.getClanID() == id) || datum.contains(parametar)) {
                        novaLista.add(clan);
                    }
                }
                lista = novaLista;
            }
        fireTableDataChanged();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void dodajClana(Clan clan) {
        lista.add(clan);
        fireTableDataChanged();
        
    }

    public Clan vratiClana(int row) {
        return lista.get(row);
    }

    @Override
    public void run() {
        try {
            while (true) {                
                Thread.sleep(8000);
                refreshTable();
            }
        } catch (InterruptedException interruptedException) {
            Logger.getLogger(ModelTabeleClanovi.class.getName()).log(Level.SEVERE, null, interruptedException);

        }
    }
    
}
