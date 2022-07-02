package aed.GrafoPonderadoDirecionado;

import aed.GrafoPonderado.Aresta;
import aed.GrafoPonderado.Vertice;

import java.util.ArrayList;
import java.util.List;

public class GrafoPonderadoDirecionado<T, P> {

    private List<Vertice<T,P>> vertices;
    private List<Aresta<T,P>> arestas;

    public GrafoPonderadoDirecionado() {
        setVertices(new ArrayList<>());
        setArestas(new ArrayList<>());
    }

    public void setVertices(List<Vertice<T,P>> v) {
        this.vertices = v;
    }

    public List<Vertice<T,P>> getVertices() {
        return this.vertices;
    }

    public void setArestas(List<Aresta<T,P>> a) {
        this.arestas = a;
    }

    public List<Aresta<T,P>> getArestas() {
        return this.arestas;
    }

    public Vertice<T,P> addVertice(T v) {
        Vertice<T,P> vertice = new Vertice<>(v);
        getVertices().add(vertice);
        return vertice;
    }

    public Aresta<T,P> addAresta(Vertice<T,P> origem, Vertice<T,P> destino, P peso) {
        Aresta<T,P> aresta = new Aresta<>(origem, destino, peso);
        origem.addAdjacente(aresta);
        getArestas().add(aresta);
        return aresta;
    }

    public int numeroDeVertices() {
        return this.getVertices().size();
    }

    @Override
    public String toString() {
        String res = "";
        boolean virgula;
        for (Vertice<T,P> origem : getVertices()) {
            res += origem.getValor() + " >>> ";
            virgula = false;
            for (Aresta<T, P> aresta : origem.getAdjacentes()) {
                Vertice<T, P> v = aresta.getVerticeDestino();
                res += (virgula ? ", " : "") + (v.getValor()+":"+aresta.getPeso());
                virgula = true;
            }
            res += "\n";
        }
        return res;
    }
}