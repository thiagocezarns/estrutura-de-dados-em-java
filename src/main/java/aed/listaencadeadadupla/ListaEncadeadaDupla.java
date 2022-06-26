package aed.listaencadeadadupla;

public class ListaEncadeadaDupla<T extends Comparable<T>>{
    private No<T> noInicial;
    private int tamanho;

    public ListaEncadeadaDupla() {
        this.noInicial = null;
        this.tamanho = 0;
    }

    public void adicionarOrdenado(T obj) {
        No<T> novoNo = new No<>(obj);
        if(noInicial == null) {
            noInicial = novoNo;
            incrementarTamanho();
        }
        else {
            No<T> noAux = noInicial;
            No<T> ultimoNo = noInicial;
            while(noAux != null) {
                if(obj.compareTo(noAux.getConteudo()) < 0) {
                    if(noAux == noInicial) {
                        novoNo.setNoProximo(noAux);
                        noAux.setNoAnterior(novoNo);
                        noInicial = novoNo;
                        incrementarTamanho();
                        return;
                    }
                    else {
                        noAux.getNoAnterior().setNoProximo(novoNo);
                        novoNo.setNoAnterior(noAux.getNoAnterior());
                        novoNo.setNoProximo(noAux);
                        noAux.setNoAnterior(novoNo);
                        incrementarTamanho();
                        return;
                    }
                }
                ultimoNo = noAux;
                noAux = noAux.getNoProximo();
            }
            ultimoNo.setNoProximo(novoNo);
            novoNo.setNoAnterior(ultimoNo);
            incrementarTamanho();
        }
    }

    public void adicionarNoFinal(T obj) {
        No<T> novoNo = new No(obj);

        if(noInicial == null) {
            noInicial = novoNo;
        }
        else {
            No<T> noAux = noInicial;
            while(noAux.getNoProximo() != null) {
                noAux = noAux.getNoProximo();
            }
            noAux.setNoProximo(novoNo);
            novoNo.setNoAnterior(noAux);

        }
        incrementarTamanho();
    }

    public void adicionarNoInicio(T obj){
        No<T> novoNo = new No(obj);

        if(noInicial == null) {
            noInicial = novoNo;
        }
        else {
            No<T> noAux = noInicial;
            noInicial = novoNo;
            novoNo.setNoProximo(noAux);
            noAux.setNoAnterior(novoNo);
        }
        incrementarTamanho();
    }

    public void remover(T obj) {
        if(noInicial != null) {
            No<T> noAux = noInicial;
            while(noAux != null) {
                if(noAux.getConteudo().compareTo(obj) == 0) {
                    noAux.getNoAnterior().setNoProximo(noAux.getNoProximo());
                    noAux.limparReferencias();
                    decrementarTamanho();
                    return;
                }
                noAux = noAux.getNoProximo();
            }

        }
    }

    public void removerInicio() {
        if(noInicial != null){
            No<T> noAux = noInicial;
            noInicial = noAux.getNoProximo();
            noAux.limparReferencias();
            decrementarTamanho();
        }
    }

    public void removerFinal() {
        if(noInicial != null) {
            No<T> noAux = noInicial;
            while(noAux.getNoProximo() != null) {
                noAux = noAux.getNoProximo();
            }
            if(noAux.getNoAnterior() != null){
                noAux.getNoAnterior().setNoProximo(null);
            }
            noAux.limparReferencias();
            decrementarTamanho();
        }
    }

    public void alterar(T obj, T novoObj){
        if(noInicial != null) {
            No<T> noAux = noInicial;
            while(noAux != null) {
                if(noAux.getConteudo().compareTo(obj) == 0) {
                    noAux.setConteudo(novoObj);
                    return;
                }
                noAux = noAux.getNoProximo();
            }
        }
    }

    public boolean contem(T obj) {
        if(noInicial != null) {
            No<T> noAux = noInicial;
            while(noAux != null) {
                if(noAux.getConteudo().compareTo(obj) == 0)
                    return true;
                noAux = noAux.getNoProximo();
            }
        }
        return false;
    }

    public T buscarNaPosicao(int p) {
        if(p > (getTamanho()-1) || p < 0)
            return null;
        No<T> noAux = noInicial;
        int i=0;
        while(i != p) {
            noAux = noAux.getNoProximo();
            i++;
        }
        return noAux.getConteudo();
    }

    public int indiceDe(T obj) {
        if(noInicial != null) {
            No<T> noAux = noInicial;

            int i=0;
            while(noAux != null) {
                if(noAux.getConteudo().compareTo(obj) == 0)
                    return i;
                i++;
                noAux = noAux.getNoProximo();
            }
        }
        return -1;
    }

    public void limpar() {
        No<T> noAux;
        while(noInicial != null) {
            noAux = noInicial;
            noInicial = noInicial.getNoProximo();
            noAux.limparReferencias();
        }
        tamanho = 0;
    }

    public int getTamanho() {
        return tamanho;
    }

    public boolean vazia() {
        return noInicial == null;
    }

    private void incrementarTamanho(){
        tamanho++;
    }
    private void decrementarTamanho() {
        tamanho--;
    }

    public void imprimir() {
        if(noInicial == null) {
            System.out.println("Lista {}");
            return;
        }
        String str = "Lista {";
        str += noInicial.getConteudo();

        No<T> noAux = noInicial.getNoProximo();

        while(noAux != null) {
            str += ", ";
            str += noAux.getConteudo();
            noAux = noAux.getNoProximo();
        }
        str += "}";
        System.out.println(str);
    }
}