/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import controller.ClientController;
import domain.Knjiga;
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
public class ModelTabeleKnjige extends AbstractTableModel implements Runnable{
    
    String[] kolone = {"KnjigaID", "Naziv", "Prosecna ocena"};
    ArrayList<Knjiga> lista;
    String parametar = "";

    public ArrayList<Knjiga> getLista() {
        return lista;
    }

    public ModelTabeleKnjige() {
        try {
            lista = ClientController.getInstance().getAllKnjige();
        } catch (Exception ex) {
            Logger.getLogger(ModelTabeleKnjige.class.getName()).log(Level.SEVERE, null, ex);
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
        Knjiga k = lista.get(rowIndex);
        switch(columnIndex){
            case 0: return k.getKnjigaID();
            case 1: return k.getNaziv();
            case 2: return k.getProsecnaOcena();
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
            lista = ClientController.getInstance().getAllKnjige();
            if (!parametar.equals("")) {
                ArrayList<Knjiga> novaLista = new ArrayList<>();
                for (Knjiga knjiga : lista) {
                    long id = 0;
                    double ocena = -1;
                    try {
                        ocena = Double.parseDouble(parametar);
                    }catch (Exception e) {
                    }
                    try {
                        id = Integer.parseInt(parametar);
                    }catch (Exception e) {
                    }
                    if (knjiga.getNaziv().toLowerCase().contains(parametar.toLowerCase()) || (knjiga.getProsecnaOcena() == ocena)
                            || (knjiga.getKnjigaID() == id)) {
                        novaLista.add(knjiga);
                    }
                }
                lista = novaLista;
            }
        fireTableDataChanged();

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void dodajKnjigu(Knjiga knjiga) {
        lista.add(knjiga);
        fireTableDataChanged();
        
    }

    public Knjiga vratiKnjigu(int row) {
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
            Logger.getLogger(ModelTabeleKnjige.class.getName()).log(Level.SEVERE, null, interruptedException);

        }
    }

    public void obrisiKnjigu(int row) {
        lista.remove(row);
        fireTableDataChanged();
    }
    
}
