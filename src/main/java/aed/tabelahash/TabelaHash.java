package aed.tabelahash;

public class TabelaHash<K, V> {

    private final HashNodo<K,V>[] tabela;
    private final int tamanho;
    private int qtdElementos;

    public TabelaHash(){
        this.tamanho = 50;
        this.tabela = new HashNodo[tamanho];
        this.qtdElementos = 0;
        for (int i = 0; i < tamanho; i++) {
            tabela[i] = null;
        }
    }

    public TabelaHash(int tamanho){
        this.tamanho = tamanho;
        this.tabela = new HashNodo[tamanho];
        this.qtdElementos = 0;
        for (int i = 0; i < tamanho; i++) {
            tabela[i] = null;
        }
    }

    private int tamanho() {
        return tamanho;
    }

    public int getQtdElementos() {
        return qtdElementos;
    }

    private void setQtdElementos(int qtdElementos) {
        this.qtdElementos = qtdElementos;
    }

    private void incrementaQtdElementos() {
        setQtdElementos(getQtdElementos() + 1);
    }

    private void decrementaQtdElementos() {
        int qtd = getQtdElementos();
        if(qtd > 0) {
            setQtdElementos(qtd - 1);
        }
    }


    private void tabelaSetHashNodo(int indice, HashNodo<K,V> n) {
        this.tabela[indice] = n;
    }
    private HashNodo<K,V> tabelaGetHashNodo(int indice) {
        return this.tabela[indice];
    }


    private int funcaoHash(K chave) {
        int i = (int)chave.hashCode() % this.tamanho();
        if(i<0) {
            i = i*(-1);
        }
        return i;
    }

    public void inserir(K chave, V valor) {
        HashNodo<K,V> novoNodo = new HashNodo<>(chave, valor);
        int indice = funcaoHash(chave);
        HashNodo<K,V> inicio = tabelaGetHashNodo(indice);
        if(inicio == null) {
            tabelaSetHashNodo(indice, novoNodo);
            incrementaQtdElementos();
        } else {
            HashNodo<K,V> antarior = inicio;
            while(inicio != null) {
                if(inicio.getChave().equals(chave)){
                    inicio.setValor(valor);
                    return;
                }
                antarior = inicio;
                inicio = inicio.getProximo();
            }
            antarior.setProximo(novoNodo);
            incrementaQtdElementos();
        }
    }

    public V buscar(K chave) {
        int indice = funcaoHash(chave);
        HashNodo<K,V> aux;
        aux = tabelaGetHashNodo(indice);
        if(!(aux == null)) {
            while(aux != null) {
                if(aux.getChave().equals(chave))
                    return (V) aux.getValor();
            }
        }
        return null;
    }

    public void remover(K chave) {
        int indice = funcaoHash(chave);
        HashNodo<K,V> aux;
        aux = tabelaGetHashNodo(indice);
        if(!(aux == null)) {
            if(aux.getChave().equals(chave)) {
                tabelaSetHashNodo(indice, aux.getProximo());
                removeNodo(aux);
            } else {
                HashNodo<K,V> anterior = aux;
                while (aux != null) {
                    if (aux.getChave().equals(chave)) {
                        anterior.setProximo(aux.getProximo());
                        removeNodo(aux);
                    }
                    aux = aux.getProximo();
                }
            }
            decrementaQtdElementos();
        }
    }

    public void limpar() {
        for(int i=0; i<tamanho(); i++){
            HashNodo<K,V> aux = tabelaGetHashNodo(i);
            HashNodo<K,V> aux2 = aux;
            while(aux != null) {
                aux = aux.getProximo();
                removeNodo(aux2);
                decrementaQtdElementos();
            }
            tabelaSetHashNodo(i, null);
        }
    }

    private void removeNodo(HashNodo<K,V> n) {
        n.setChave(null);
        n.setValor(null);
        n.setProximo(null);
    }


    public boolean contemChave(K chave) {
        int indice = funcaoHash(chave);
        HashNodo<K,V> aux;
        aux = tabelaGetHashNodo(indice);
        if(aux != null) {
            while(aux != null) {
                if (aux.getChave().equals(chave))
                    return true;
                aux = aux.getProximo();
            }
        }
        return false;
    }

    public void imprimir() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("Tabela Hash");
        for(int i=0; i<tamanho(); i++) {
            HashNodo<K,V> aux = tabelaGetHashNodo(i);
            while(aux != null) {
                s.append("\n[").append(aux.getValor()).append("]");
                aux = aux.getProximo();
            }
        }
        return s.toString();
    }
}
