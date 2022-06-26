package aed.pilha;

public class Pilha<T> {

    private No<T> noTopo;
    private int tamanho;

    public Pilha() {
        this.noTopo = null;
        this.tamanho = 0;
    }

    public void adicionar(T obj) {
        No<T> novoNo = new No(obj);

        if(vazia()) {
            noTopo = novoNo;
        }
        else {
            novoNo.setNoProximo(noTopo);
            noTopo = novoNo;
        }
        incrementarTamanho();
    }

    public T remover() {
        if(vazia()) {
            return null;
        }

        No<T> noAux = noTopo;
        noTopo = noTopo.getNoProximo();
        noAux.limparReferencias();
        decrementarTamanho();
        return noAux.getConteudo();
    }

    public T topo() {
        if(vazia()) {
            return null;
        }
        return noTopo.getConteudo();
    }

    public void limpar() {
        No<T> noAux;
        while(!vazia()) {
            noAux = noTopo;
            noTopo = noTopo.getNoProximo();
            noAux.setNoProximo(null);
            decrementarTamanho();
        }
    }

    public int getTamanho() {
        return tamanho;
    }

    public boolean vazia() {
        return tamanho == 0;
    }

    private void incrementarTamanho() {
        tamanho++;
    }
    private void decrementarTamanho() {
        if(tamanho != 0) {
            tamanho--;
        }
    }

    public void imprimir() {
        if(noTopo == null) {
            System.out.println("Pilha{}");
            return;
        }
        String str = "Pilha{";
        No<T> noAux = noTopo;
        while(noAux != null) {
            str += "\n" + noAux.getConteudo();
            noAux = noAux.getNoProximo();
        }
        str += "\n}";
        System.out.println(str);
        System.out.println();
    }



}
