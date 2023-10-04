/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import controller.ClientController;
import domain.Zanr;
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
public class ModelTabeleZanrovi extends AbstractTableModel implements Runnable{
    
    String[] kolone = {"ZanrID", "Naziv zanra"};
    ArrayList<Zanr> lista;
    String parametar = "";

    public ArrayList<Zanr> getLista() {
        return lista;
    }

    public ModelTabeleZanrovi() {
        try {
            lista = ClientController.getInstance().getAllZanrovi();
        } catch (Exception ex) {
            Logger.getLogger(ModelTabeleZanrovi.class.getName()).log(Level.SEVERE, null, ex);
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
        Zanr z = lista.get(rowIndex);
        switch(columnIndex){
            case 0: return z.getZanrID();
            case 1: return z.getNaziv();
            default: return "Greska u ucitavanju!";
        }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
    }

    public String getParametar() {
        return parametar;
    }

    public void refreshTable() {
        try {
            lista = ClientController.getInstance().getAllZanrovi();
            if (!parametar.equals("")) {
                ArrayList<Zanr> novaLista = new ArrayList<>();
                for (Zanr zanr : lista) {
                    long id = 0;
                    try {
                        id = Integer.parseInt(parametar);
                    }catch (Exception e) {
                    }
                    if (zanr.getNaziv().toLowerCase().contains(parametar.toLowerCase())
                            || (zanr.getZanrID() == id)) {
                        novaLista.add(zanr);
                    }
                }
                lista = novaLista;
            }
        fireTableDataChanged();
        
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void dodajZanr(Zanr zanr) {
        lista.add(zanr);
        fireTableDataChanged();
        
    }

    public Zanr vratiZanr(int row) {
        return lista.get(row);
    }

    @Override
    public void run() {
        try {
            while (true) {                
                Thread.sleep(5000);
                //refreshTable();
            }    
        } catch (InterruptedException interruptedException) {
            Logger.getLogger(ModelTabeleZanrovi.class.getName()).log(Level.SEVERE, null, interruptedException);

        }
    }

    public void obrisiAutora(int row) {
        lista.remove(row);
        fireTableDataChanged();
    }
    
}
