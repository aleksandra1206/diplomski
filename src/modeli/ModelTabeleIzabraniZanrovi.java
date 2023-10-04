/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import controller.ClientController;
import domain.Autor;
import domain.Clan;
import domain.Zanr;
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
public class ModelTabeleIzabraniZanrovi extends AbstractTableModel{
    
    String[] kolone = {"ZanrID", "Naziv zanra"};
    private ArrayList<Zanr> lista;

    public ModelTabeleIzabraniZanrovi() {
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
        Zanr z = lista.get(rowIndex);
        switch(columnIndex){
            case 0: return z.getZanrID();
            case 1: return z.getNaziv();
            default: return "Greska u ucitavanju!";
        }
    }


    public void refreshTable() {
        
    }

    public void dodajZanr(Zanr zanr) {
        if (!daLiPostoji(zanr)) {
            lista.add(zanr);
            fireTableDataChanged();
        }
    }

    public Zanr vratiZanr(int row) {
        return lista.get(row);
    }

    public void obrisiZanr(int row) {
        lista.remove(row);
        fireTableDataChanged();
    }

    private boolean daLiPostoji(Zanr zanr) {
        for (Zanr zanr1 : lista) {
            if (zanr.getZanrID() == zanr1.getZanrID()) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Zanr> getLista() {
        return lista;
    }
    
}
