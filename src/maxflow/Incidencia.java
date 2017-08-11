/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxflow;

/**
 *
 * @author thais
 */
public class Incidencia {
    int vertice;
    int id;
    int c;
    int f;

    public Incidencia(int id, int vertice, int c, int f) {
        this.vertice = vertice;
        this.c = c;
        this.f = f;
        this.id = id;
    }

    public int getVertice() {
        return vertice;
    }

    public void setVertice(int vertice) {
        this.vertice = vertice;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }
    
}
