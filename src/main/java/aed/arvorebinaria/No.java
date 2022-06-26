package aed.arvorebinaria;

public class No<T extends Comparable<T>> {

    private No<T> noEsquerdo;
    private No<T> noDireito;
    private T conteudo;

    public No(T conteudo) {
        this.noEsquerdo = null;
        this.noDireito = null;
        this.conteudo = conteudo;
    }

    public No<T> getNoEsquerdo() {
        return noEsquerdo;
    }

    public void setNoEsquerdo(No<T> noEsquerdo) {
        this.noEsquerdo = noEsquerdo;
    }

    public No<T> getNoDireito() {
        return noDireito;
    }

    public void setNoDireito(No<T> noDireito) {
        this.noDireito = noDireito;
    }

    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }
}
