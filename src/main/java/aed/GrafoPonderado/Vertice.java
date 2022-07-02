package aed.GrafoPonderado;

import java.util.List;
import java.util.ArrayList;

public class Vertice<T, P> {

    private T valor;
    private boolean visitado;
    private String cor;

    private List<Aresta<T, P>> adjacentes;

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

    public List<Aresta<T, P>> getAdjacentes() {
        return this.adjacentes;
    }

    public void setAdjacentes(List<Aresta<T, P>> a) {
        this.adjacentes = a;
    }

    public String getCor() {
        return this.cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void addAdjacente(Aresta<T, P> a) {
        getAdjacentes().add(a);
    }

}
