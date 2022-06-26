package aed.arvorebinaria;

public class ArvoreBinaria<T extends Comparable<T>> {

    private No<T> noRaiz;
    private int tamanho;

    public ArvoreBinaria() {
        this.noRaiz = null;
    }

    public void adicionar(T obj) {
        No<T> novoNo = new No(obj);
        if(noRaiz != null) {
            inserir(noRaiz, novoNo);
        }
        else {
            noRaiz = novoNo;
        }
        incrementarTamanho();
    }

    private void inserir(No<T> noAtual, No<T> novoNo) {
        int res = novoNo.getConteudo().compareTo(noAtual.getConteudo());
        if(res < 0) {
            if(noAtual.getNoEsquerdo() != null)
                inserir(noAtual.getNoEsquerdo(), novoNo);
            else
                noAtual.setNoEsquerdo(novoNo);
        }
        if(res > 0) {
            if(noAtual.getNoDireito() != null)
                inserir(noAtual.getNoDireito(), novoNo);
            else
                noAtual.setNoDireito(novoNo);
        }
    }

    private No<T> removerAtual(No<T> noAtual) {
        No<T> no1, no2;
        if(noAtual.getNoEsquerdo() == null) {
            no2 = noAtual.getNoDireito();
            noAtual.setNoEsquerdo(null);
            noAtual.setNoDireito(null);
            noAtual.setConteudo(null);
            return no2;
        }
        no1 = noAtual;
        no2 = noAtual.getNoEsquerdo();
        while(no2.getNoDireito() != null) {
            no1 = no2;
            no2 = no2.getNoDireito();
        }
        if(no1 != noAtual) {
            no1.setNoDireito(no2.getNoEsquerdo());
            no2.setNoEsquerdo(noAtual.getNoEsquerdo());
        }
        no2.setNoDireito(noAtual.getNoDireito());
        noAtual.setNoEsquerdo(null);
        noAtual.setNoDireito(null);
        return no2;
    }

    public boolean remover(T obj) {
        if(noRaiz == null)
            return false;
        No<T> noAnterior = null;
        No<T> noAtual = noRaiz;
        while(noAtual != null) {
            if(obj.compareTo(noAtual.getConteudo()) == 0) {
                if(obj.compareTo(noRaiz.getConteudo()) == 0)
                    noRaiz = removerAtual(noAtual);
                else {
                    if(noAnterior.getNoDireito() == noAtual)
                        noAnterior.setNoDireito(removerAtual(noAtual));
                    else
                        noAnterior.setNoEsquerdo(removerAtual(noAtual));
                }
                decrementarTamanho();
                return true;
            }
            noAnterior = noAtual;
            if(obj.compareTo(noAtual.getConteudo()) > 0)
                noAtual = noAtual.getNoDireito();
            else
                noAtual = noAtual.getNoEsquerdo();
        }
        return false;
    }

    public T buscar(T obj) {
        No<T> noAtual = noRaiz;
        while(noAtual != null) {
            if(obj.compareTo(noAtual.getConteudo()) == 0)
                return noAtual.getConteudo();
            else if(obj.compareTo(noAtual.getConteudo()) < 0)
                noAtual = noAtual.getNoEsquerdo();
            else if(obj.compareTo(noAtual.getConteudo()) > 0)
                noAtual = noAtual.getNoDireito();
        }
        return null;
    }

    private void exibirEmOrdem(No<T> noAtual) {
        if(noAtual != null){
            exibirEmOrdem(noAtual.getNoEsquerdo());
            String str = "";
            str += noAtual.getConteudo();
            System.out.printf("%s ", str);
            exibirEmOrdem(noAtual.getNoDireito());
        }
    }
    public void exibirEmOrdem() {
        System.out.println();
        System.out.printf("Em ordem: ");
        exibirEmOrdem(noRaiz);
        System.out.println();
    }

    private void exibirPosOrdem(No<T> noAtual) {
        if(noAtual != null){
            exibirPosOrdem(noAtual.getNoEsquerdo());
            exibirPosOrdem(noAtual.getNoDireito());
            String str = "";
            str += noAtual.getConteudo();
            System.out.printf("%s ", str);
        }
    }
    public void exibirPosOrdem() {
        System.out.println();
        System.out.printf("Pos ordem: ");
        exibirPosOrdem(noRaiz);
        System.out.println();
    }

    private void exibirPreOrdem(No<T> noAtual) {
        if(noAtual != null){
            String str = "";
            str += noAtual.getConteudo();
            System.out.printf("%s ", str);
            exibirPreOrdem(noAtual.getNoEsquerdo());
            exibirPreOrdem(noAtual.getNoDireito());
        }
    }
    public void exibirPreOrdem() {
        System.out.println();
        System.out.printf("Pre ordem: ");
        exibirPreOrdem(noRaiz);
        System.out.println();
    }

    private void limparNo(No<T> noAtual) {
        if(noAtual == null)
            return;
        limparNo(noAtual.getNoEsquerdo());
        limparNo(noAtual.getNoDireito());
        noAtual.setNoEsquerdo(null);
        noAtual.setNoDireito(null);
        decrementarTamanho();
    }
    public void limpar() {
        if(noRaiz == null)
            return;
        limparNo(noRaiz);
        noRaiz = null;
    }

    private void incrementarTamanho() {
        tamanho++;
    }
    private void decrementarTamanho() {
        if(tamanho > 0)
            tamanho--;
    }

    public int totalNos() {
        return tamanho;
        //return totalNos(noRaiz);
    }

    private int altura(No<T> noAtual) {
        if(noAtual == null)
            return 0;
        int altEsquerda = altura(noAtual.getNoEsquerdo());
        int altDireita = altura(noAtual.getNoDireito());
        if(altEsquerda > altDireita)
            return (altEsquerda + 1);
        else
            return (altDireita + 1);
    }
    public int altura() {
        return altura(noRaiz);
    }
    public boolean vazia() {
        return noRaiz == null;
    }
}

