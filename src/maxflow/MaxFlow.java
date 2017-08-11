/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxflow;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author thais
 */
public class MaxFlow {
    static Grafo grafo_residual;
    static int tempo;
    static int flow;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        int idVertice = 0, n_vertice, n_aresta, s, t;
        File file = new File("tests/caso10.txt");
        grafo_residual = new Grafo();
        StringTokenizer aux;
        try {
            FileReader read = new FileReader(file);
            BufferedReader buffer = new BufferedReader(read);
            String line = buffer.readLine();
            aux = new StringTokenizer(line, " ");
            n_vertice = Integer.parseInt(aux.nextToken());
            n_aresta = Integer.parseInt(aux.nextToken());
            s = Integer.parseInt(aux.nextToken());
            t = Integer.parseInt(aux.nextToken());
            while(n_vertice > 0){
                grafo_residual.addVertice(idVertice);
                idVertice++;
                n_vertice--;
            }
            line = buffer.readLine();
            while(line != null){
                aux = new StringTokenizer(line, " ");
                grafo_residual.addAresta(Integer.parseInt(aux.nextToken()), Integer.parseInt(aux.nextToken()), Integer.parseInt(aux.nextToken()));
                line = buffer.readLine();
            }
            System.out.println(max_flow(s, t));
        } catch (FileNotFoundException e) {
        }
        
    }
    
    private static int max_flow(Integer s, Integer t){
        No no;
        int a;
        flow = 0;
        tempo = 1;
        no = grafo_residual.getNo(s);
        while((a = dfs(s, t, no.getSomaCapacidadeIncidencia())) > 0){
            flow += a;
            tempo++;
        }
        return flow;
    }
    
    private static int dfs(int s, int t, int f){
        No no, adj;
        int a, min;
        if(s == t) return f;
        grafo_residual.setSeenVertice(s, tempo);
        no = grafo_residual.getNo(s);
        for(int i = 0; i < no.getIncidencias().size(); i++){
            adj = grafo_residual.getNo(no.getIncidencias().get(i).vertice);
            if(adj.getSeen() < tempo && (no.getIncidencias().get(i).c - no.getIncidencias().get(i).f) > 0){
                if(f < (no.getIncidencias().get(i).c - no.getIncidencias().get(i).f)){
                 min = f;
                }else{
                    min = no.getIncidencias().get(i).c - no.getIncidencias().get(i).f;
                }
                a = dfs(adj.getId(), t, min);
                if(a > 0){//tem caminho = tem que atualizar e retornar (apenas um caminho)
                    no.getIncidencias().get(i).setF(no.getIncidencias().get(i).getF() + a);
                    for(int j = 0; j < adj.getIncidencias().size(); j++){
                        if(adj.getIncidencias().get(j).getVertice() == no.getId()){
                            adj.getIncidencias().get(j).setF(adj.getIncidencias().get(j).getF() - a);
                            break;
                        }
                    }
                    return a;
                }
            }
        }
        return 0;
    }
}
