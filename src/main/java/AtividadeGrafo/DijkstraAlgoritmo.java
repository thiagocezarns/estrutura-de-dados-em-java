package AtividadeGrafo;

import aed.GrafoPonderado.Aresta;
import aed.GrafoPonderado.Vertice;
import aed.GrafoPonderadoDirecionado.GrafoPonderadoDirecionado;

import java.util.PriorityQueue;

public class DijkstraAlgoritmo<T,P>  {
    private Aresta<T,P>[] edgeTo;
    private double[] distTo;
    private PriorityQueue<Vertice<T,P>> pq;

    public DijkstraAlgoritmo(GrafoPonderadoDirecionado<T,P> G, Vertice<T,P> s) {
        int[] pathCost = new int[G.numeroDeVertices()];
        boolean[] finalizedSet =  new boolean[G.numeroDeVertices()];
        int numFinalized = 0;

        int srcIndex = G.getVertices().indexOf(s);
        if(srcIndex == -1) return;

        for(int i=0; i<G.numeroDeVertices(); i++) {
            finalizedSet[i] = false;
            pathCost[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Road> foo = new PriorityQueue<>();
        foo.add(new Road(srcIndex, 0.0));
        pathCost[srcIndex] = 0;
        ver
    }
}