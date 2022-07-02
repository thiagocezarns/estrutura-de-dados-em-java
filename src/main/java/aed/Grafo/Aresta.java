package aed.Grafo;

public class Aresta<T> {
    private Vertice<T> verticeVOrigem;
    private Vertice<T> verticeVDestino;

    public Aresta(Vertice<T> a, Vertice<T> b) {
        setVerticeOrigem(a);
        setVerticeDestino(b);
    }

    public Vertice<T> getVerticeOrigem() {
        return this.verticeVOrigem;
    }

    public void setVerticeOrigem(Vertice<T> v) {
        this.verticeVOrigem = v;
    }

    public Vertice<T> getVerticeDestino() {
        return this.verticeVDestino;
    }

    public void setVerticeDestino(Vertice<T> v) {
        this.verticeVDestino = v;
    }

}
