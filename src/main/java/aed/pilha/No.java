package aed.pilha;

public class No<T> {
    private No<T> noProximo;
    private T conteudo;

    public No(T obj) {
        this.noProximo = null;
        this.conteudo = obj;
    }

    public No<T> getNoProximo() {
        return this.noProximo;
    }

    public void setNoProximo(No<T> noRef) {
        this.noProximo = noRef;
    }

    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public void limparReferencias() {
        setNoProximo(null);
    }
}
