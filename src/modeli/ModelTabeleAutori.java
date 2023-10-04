/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import controller.ClientController;
import domain.Autor;
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
public class ModelTabeleAutori extends AbstractTableModel implements Runnable{
    
    String[] kolone = {"AutorID", "Ime", "Prezime"};
    ArrayList<Autor> lista;
    String parametar = "";

    public ArrayList<Autor> getLista() {
        return lista;
    }

    public ModelTabeleAutori() {
        try {
            lista = ClientController.getInstance().getAllAutori();
        } catch (Exception ex) {
            Logger.getLogger(ModelTabeleAutori.class.getName()).log(Level.SEVERE, null, ex);
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
        Autor a = lista.get(rowIndex);
        switch(columnIndex){
            case 0: return a.getAutorID();
            case 1: return a.getIme();
            case 2: return a.getPrezime();
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
            lista = ClientController.getInstance().getAllAutori();
            if (!parametar.equals("")) {
                ArrayList<Autor> novaLista = new ArrayList<>();
                for (Autor autor : lista) {
                    long id = 0;
                    try {
                        id = Integer.parseInt(parametar);
                    }catch (Exception e) {
                    }
                    if (autor.getIme().toLowerCase().contains(parametar.toLowerCase()) 
                            || autor.getPrezime().toLowerCase().contains(parametar.toLowerCase()) 
                            || (autor.getAutorID() == id)) {
                        novaLista.add(autor);
                    }
                }
                lista = novaLista;
            }
        fireTableDataChanged();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void dodajAutora(Autor autor) {
        lista.add(autor);
        fireTableDataChanged();
        
    }

    public Autor vratiAutora(int row) {
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
            Logger.getLogger(ModelTabeleAutori.class.getName()).log(Level.SEVERE, null, interruptedException);

        }
    }

    public void obrisiAutora(int row) {
        lista.remove(row);
        fireTableDataChanged();
    }
    
}
