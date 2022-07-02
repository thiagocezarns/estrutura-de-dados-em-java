package aed.GrafoPonderado;


import java.util.ArrayList;
import java.util.List;

public class GrafoPonderado<T, P> {

    private List<Vertice<T,P>> vertices;
    private List<Aresta<T,P>> arestas;

    public GrafoPonderado() {
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

    public Aresta<T,P> addAresta(Vertice<T,P> a, Vertice<T,P> b, P peso) {
        Aresta<T,P> aresta = new Aresta<>(a, b, peso);
        a.addAdjacente(aresta);
        b.addAdjacente(aresta);
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
                Vertice<T, P> v;
                if(aresta.getVerticeDestino() == origem)
                    v = aresta.getVerticeOrigem();
                else
                    v = aresta.getVerticeDestino();
                res += (virgula ? ", " : "") + (v.getValor()+":"+aresta.getPeso());
                virgula = true;
            }
            res += "\n";
        }
        return res;
    }
}
