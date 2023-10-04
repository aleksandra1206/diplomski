/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import controller.ClientController;
import domain.Autor;
import domain.Clan;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class ModelTabeleIzabraniAutori extends AbstractTableModel{
    
    String[] kolone = {"AutorID", "Ime", "Prezime"};
    private ArrayList<Autor> lista;

    public ModelTabeleIzabraniAutori() {
        lista = new ArrayList<>();
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


    public void refreshTable() {
        
    }

    public void dodajAutora(Autor autor) {
        if (!daLiPostoji(autor)) {
            lista.add(autor);
            fireTableDataChanged();
        }
    }

    public Autor vratiAutora(int row) {
        return lista.get(row);
    }

    public void obrisiAutora(int row) {
        lista.remove(row);
        fireTableDataChanged();
    }

    private boolean daLiPostoji(Autor autor) {
        for (Autor autor1 : lista) {
            if (autor.getAutorID() == autor1.getAutorID()) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Autor> getLista() {
        return lista;
    }
    
}
