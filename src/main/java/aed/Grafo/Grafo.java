package aed.Grafo;

import java.util.ArrayList;
import java.util.List;

public class Grafo<T> {

    private List<Vertice<T>> vertices;
    private List<Aresta<T>> arestas;

    public Grafo() {
        setVertices(new ArrayList<>());
        setArestas(new ArrayList<>());
    }

    public void setVertices(List<Vertice<T>> v) {
        this.vertices = v;
    }

    public List<Vertice<T>> getVertices() {
        return this.vertices;
    }

    public void setArestas(List<Aresta<T>> a) {
        this.arestas = a;
    }

    public List<Aresta<T>> getArestas() {
        return this.arestas;
    }

    public Vertice<T> addVertice(T v) {
        Vertice<T> vertice = new Vertice<>(v);
        getVertices().add(vertice);
        return vertice;
    }

    public Aresta<T> addAresta(Vertice<T> origem, Vertice<T> destino) {
        Aresta<T> aresta = new Aresta<>(origem, destino);
        origem.addAdjacente(aresta);
        destino.addAdjacente(aresta);
        getArestas().add(aresta);
        return aresta;
    }

    @Override
    public String toString() {
        String res = "";
        boolean virgula;
        for (Vertice<T> origem : getVertices()) {
            res += origem.getValor() + " >>> ";
            virgula = false;
            for (Aresta<T> aresta : origem.getAdjacentes()) {
                Vertice<T> v;
                if(aresta.getVerticeDestino() == origem)
                    v = aresta.getVerticeOrigem();
                else
                    v = aresta.getVerticeDestino();
                res += (virgula ? ", " : "") + v.getValor();
                virgula = true;
            }
            res += "\n";
        }
        return res;
    }

}
