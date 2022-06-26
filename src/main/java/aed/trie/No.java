package aed.trie;

class No<T>{
    T valor;
    No<T>[] filhos;

    No(int tamanho) {
        filhos = new No[tamanho];
        for(int i=0; i<tamanho; i++)
            filhos[i] = null;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public No<T>[] getFilhos() {
        return filhos;
    }

    public void setFilhos(No<T>[] filhos) {
        this.filhos = filhos;
    }

}
