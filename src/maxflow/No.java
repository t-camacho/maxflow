/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxflow;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thais
 */
public class No {
    int id;
    int seen;
    List<Incidencia> incidencias;

    public No(int id) {
        this.id = id;
        this.seen = 0;
        this.incidencias = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Incidencia> getIndicencias() {
        return incidencias;
    }

    public void setIndicencias(List<Incidencia> indicencias) {
        this.incidencias = indicencias;
    }
    
    public void addIncidencia(Incidencia i){
        incidencias.add(i);
    }

    public int getSeen() {
        return seen;
    }

    public void setSeen(int seen) {
        this.seen = seen;
    }

    public List<Incidencia> getIncidencias() {
        return incidencias;
    }

    public void setIncidencias(List<Incidencia> incidencias) {
        this.incidencias = incidencias;
    }
    
    public int getSomaCapacidadeIncidencia(){
        int aux = 0;
        for(int i = 0; i < incidencias.size(); i++){
            aux += incidencias.get(i).getC();
        }
        return aux;
    }
}
