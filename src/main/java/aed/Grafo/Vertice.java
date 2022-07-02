package aed.Grafo;

import java.util.ArrayList;
import java.util.List;

public class Vertice<T> {

    private T valor;
    private boolean visitado;
    private String cor;

    private List<Aresta<T>> adjacentes;

    public Vertice(T v) {
        setValor(v);
        setVisitado(false);
        setCor("");
        setAdjacentes(new ArrayList<>());
    }

    public T getValor() {
        return this.valor;
    }

    public void setValor(T v) {
        this.valor = v;
    }

    public boolean getVisitado() {
        return this.visitado;
    }

    public void setVisitado(boolean value) {
        this.visitado = value;
    }

    public List<Aresta<T>> getAdjacentes() {
        return this.adjacentes;
    }

    public void setAdjacentes(List<Aresta<T>> a) {
        this.adjacentes = a;
    }

    public String getCor() {
        return this.cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void addAdjacente(Aresta<T> a) {
        getAdjacentes().add(a);
    }

}
