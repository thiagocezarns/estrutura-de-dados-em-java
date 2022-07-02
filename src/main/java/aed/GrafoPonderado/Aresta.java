package aed.GrafoPonderado;

public class Aresta<T, P> {

    private P peso;
    private Vertice<T, P> verticeOrigem;
    private Vertice<T,P> verticeDestino;

    public Aresta(Vertice<T,P> a, Vertice<T,P> b, P peso) {
        setVerticeOrigem(a);
        setVerticeDestino(b);
        setPeso(peso);
    }

    public P getPeso() {
        return this.peso;
    }

    public void setPeso(P peso) {
        this.peso = peso;
    }

    public Vertice<T,P> getVerticeOrigem() {
        return this.verticeOrigem;
    }

    public void setVerticeOrigem(Vertice<T,P> v) {
        this.verticeOrigem = v;
    }

    public Vertice<T,P> getVerticeDestino() {
        return this.verticeDestino;
    }

    public void setVerticeDestino(Vertice<T,P> v) {
        this.verticeDestino = v;
    }

}

