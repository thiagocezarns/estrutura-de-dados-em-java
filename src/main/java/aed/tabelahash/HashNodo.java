package aed.tabelahash;

class HashNodo<K, V> {

    private K chave;
    private V valor;
    private HashNodo<K, V> proximo;

    public HashNodo(K chave, V valor) {
        this.chave = chave;
        this.valor = valor;
        this.proximo = null;
    }

    public K getChave() {
        return chave;
    }

    public void setChave(K chave) {
        this.chave = chave;
    }

    public V getValor() {
        return valor;
    }

    public void setValor(V valor) {
        this.valor = valor;
    }

    public HashNodo<K,V> getProximo() {
        return proximo;
    }

    public void setProximo(HashNodo<K,V> proximo) {
        this.proximo = proximo;
    }

}