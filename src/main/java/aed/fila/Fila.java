package aed.fila;

public class Fila<T> {
    private No<T> noInicio;
    private No<T> noFim;
    private int tamanho;

    public Fila() {
        this.noInicio = null;
        this.noFim = null;
    }

    public void adicionar(T obj) {
        No<T> novoNo = new No(obj);

        if(noInicio == null) {
            noInicio = novoNo;
            noFim = novoNo;
        }
        noFim.setNoProximo(novoNo);
        noFim = novoNo;
        incrementarTamanho();
    }

    public T remover() {
        if(noInicio == null) return null;

        No<T> noAux = noInicio;
        if(noAux == noFim) {
            noInicio = null;
            noFim = null;
        }
        else {
            noInicio = noInicio.getNoProximo();
            noAux.limparReferencias();
        }
        decrementarTamanho();
        return noAux.getConteudo();
    }

    public T acessar() {
        if(noInicio == null) {
            return null;
        }
        else {
            return noInicio.getConteudo();
        }
    }

    public void limpar() {
        if(noInicio == null) return;

        No<T> noAux;

        while(noInicio != null) {
            noAux = noInicio;
            noInicio = noInicio.getNoProximo();
            noAux.limparReferencias();
        }
        noFim = null;
        tamanho = 0;
    }

    public int getTamanho() {
        return tamanho;
    }

    public boolean vazia() {
        return noInicio == null;
    }

    private void incrementarTamanho() {
        tamanho++;
    }

    private void decrementarTamanho() {
        tamanho--;
    }

    public void imprimir() {
        if(noInicio == null) {
            System.out.println("Fila{}");
            return;
        }
        String str = "Fila{";
        str += noInicio.getConteudo();

        No<T> noAux = noInicio.getNoProximo();

        while(noAux != null) {
            str += ", ";
            str += noAux.getConteudo();
            noAux = noAux.getNoProximo();
        }
        str += "}";
        System.out.println(str);

    }
}
