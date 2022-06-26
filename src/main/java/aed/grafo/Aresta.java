package aed.grafo;

public class Aresta<T> {

    private Vertice<T> verticeOrigem;
    private Vertice<T> verticeDestino;

    Aresta(Vertice<T> a, Vertice<T> b) {
        setVerticeOrigem(a);
        setVerticeDestino(b);
    }

    public Vertice<T> getVerticeOrigem() {
        return this.verticeOrigem;
    }

    public void setVerticeOrigem(Vertice<T> v) {
        this.verticeOrigem = v;
    }

    public Vertice<T> getVerticeDestino() {
        return this.verticeDestino;
    }

    public void setVerticeDestino(Vertice<T> v) {
        this.verticeDestino = v;
    }

}
