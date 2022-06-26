package aed.listaencadeadadupla;


public class No<T extends Comparable<T>> {
    private No<T> noProximo;
    private No<T> noAnterior;
    private T conteudo;

    public No(T obj) {
        this.noProximo = null;
        this.noAnterior = null;
        this.conteudo = obj;
    }

    public No<T> getNoProximo() {
        return this.noProximo;
    }

    public void setNoProximo(No<T> noRef) {
        this.noProximo = noRef;
    }

    public No<T> getNoAnterior() {
        return this.noAnterior;
    }

    public void setNoAnterior(No<T> noRef) {
        this.noAnterior = noRef;
    }

    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public void limparReferencias() {
        setNoAnterior(null);
        setNoProximo(null);
    }
}
