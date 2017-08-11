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
public class Grafo {
    List<No> vertices;
    int idAresta;

    public Grafo() {
        this.vertices = new ArrayList<>();
        idAresta = 0;
    }
    
    public void addAresta(Integer u, Integer v, Integer w){ //w = capacidade
        Incidencia e = new Incidencia(this.idAresta, v, w, 0);
        Incidencia er = new Incidencia(this.idAresta, u, 0, 0);
        vertices.forEach((no) -> {
            if(no.getId() == u){
                no.addIncidencia(e);
            }
        });
        this.idAresta++;
         vertices.forEach((no) -> {
            if(no.getId() == v){
                no.addIncidencia(er);
            }
        });
    }
    
    public void addVertice(int id){
        No no = new No(id);
        vertices.add(no);
    }
    
    public void imprimeGrafo(){
        vertices.forEach((no) -> {
            System.out.println("Vertice #" + no.getId() + " senn = " + no.getSeen());
            no.incidencias.forEach((i) -> {
                System.out.println("  =>  " + i.getVertice() + " " + i.getC() + " " + i.getF());
            });
        });
    }

    public List<No> getVertices() {
        return vertices;
    }

    public void setVertices(List<No> vertices) {
        this.vertices = vertices;
    }
    
    public void setSeenVertice(int id, int tempo){
        vertices.forEach((no) -> {
            if(no.getId() == id){
                no.setSeen(tempo);
            }
        });
    }
    
    public No getNo(int id){
        for(int i = 0; i < vertices.size(); i++){
            if(vertices.get(i).getId() == id){
                return vertices.get(i); 
            }
        }
    return null;
    }
}
