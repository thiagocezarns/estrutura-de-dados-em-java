package aed.trie;

public class Trie<V>{
    private int qtd;
    private final Alfabeto alfabeto;
    private No<V> noRaiz;

    public Trie(String alfabeto) {
        this.alfabeto = new Alfabeto(alfabeto);
        this.noRaiz = new No<>(this.alfabeto.getTamanho());
        this.qtd = 0;
    }


    private int getQtd() {
        return qtd;
    }

    private void setQtd(int qtd) {
        this.qtd = qtd;
    }

    private Alfabeto getAlfabeto() {
        return alfabeto;
    }

    private No<V> getNoRaiz() {
        return noRaiz;
    }

    private void setNoRaiz(No<V> noRaiz) {
        this.noRaiz = noRaiz;
    }

    public int tamanho() {
        return this.getQtd();
    }

    public boolean vazia() {
        return this.getQtd() == 0;
    }

    private void incrementaTamanho() {
        this.setQtd(this.getQtd() + 1);
    }

    private void decrementaTamanho() {
        if(this.getQtd() > 0) {
            this.setQtd(this.getQtd() - 1);
        }
    }

    public void inserir(String chave, V valor) {
        int tamanhoChave = chave.length();
        No<V> noAux = this.getNoRaiz();
        for(int i=0; i<tamanhoChave; i++){
            int index = indiceDe(chave.charAt(i));
            if(index != -1) {
                if (noAux.filhos[index] == null)
                    noAux.filhos[index] = new No<>(this.getAlfabeto().getTamanho());
                noAux = noAux.filhos[index];
            } else {
                throw new InvalidCharacterException("Chave informada possui caracteres inválidos.");
            }
        }
        noAux.setValor(valor);
        this.incrementaTamanho();
    }

    private int indiceDe(char c) {
        return indiceDe(this.getAlfabeto().getCaracteres(), 0, this.getAlfabeto().getTamanho()-1, c);
    }

    private int indiceDe(char[] arr, int inicio, int fim, char x) {
        if (fim >= inicio) {
            int mid = inicio + ((fim - inicio) / 2);
            if (arr[mid] == x)
                return mid;
            if (arr[mid] > x)
                return indiceDe(arr, inicio, mid - 1, x);
            return indiceDe(arr, mid + 1, fim, x);
        }
        return -1;
    }

    public V buscar(String chave) {
        int tamanhoChave = chave.length();
        No<V> noAux = this.getNoRaiz();
        for(int i=0; i<tamanhoChave; i++){
            int index = indiceDe(chave.charAt(i));
            if(index != -1) {
                if (noAux.filhos[index] == null)
                    return null;
                noAux = noAux.filhos[index];
            } else {
                throw new InvalidCharacterException("Chave informada possui caracteres inválidos.");
            }
        }
        if(noAux.getValor() == null)
            return null;
        else
            return (V) noAux.getValor();
    }

    public boolean contemChave(String chave) {
        No<V> noAux = this.getNoRaiz();
        for(int i=0; i<chave.length(); i++){
            int index = indiceDe(chave.charAt(i));
            if(index != -1) {
                if (noAux.filhos[index] == null)
                    return false;
                noAux = noAux.filhos[index];
            }  else {
                throw new InvalidCharacterException("Chave informada possui caracteres inválidos.");
            }
        }
        return noAux.getValor() != null;
    }

    private No<V> remover(No<V> n, String chave, int i) {
        if(n == null)
            return null;
        if(i == chave.length()) {
            n.setValor(null);

            this.decrementaTamanho();
        } else {
            int indice = indiceDe(chave.charAt(i));
            if(indice != -1) {
                n.filhos[indice] = remover(n.filhos[indice], chave, i+1);
            }  else {
                throw new InvalidCharacterException("Chave informada possui caracteres inválidos.");
            }
        }
        if(n.getValor() != null) return n;

        for(int j=0; j<this.getAlfabeto().getTamanho(); j++) {
            if (n.filhos[j] != null) return n;
        }
        return null;
    }
    public boolean remover(String chave) {
        int qtd = this.getQtd();
        this.setNoRaiz(remover(this.getNoRaiz(), chave, 0));
        return this.getQtd() < qtd;
    }

    @Override
    public String toString() {
        String s = "";
        String w[] = {""};

        for(int i=0; i<this.getAlfabeto().getTamanho(); i++) {
            print(this.getNoRaiz().filhos[i], s, i, w);
        }
        return w[0];
    }

    private void print(No<V> n, String s, int d, String[] words) {
        if(n == null)
            return;
        s += this.getAlfabeto().getCaracteres()[d];
        if(n.getValor() != null) {
            words[0] += s;
            words[0] += (": " + n.getValor());
            words[0] += "\n";
        }
        for(int i=0; i<this.getAlfabeto().getTamanho(); i++) {
            print(n.filhos[i], s, i, words);
        }
    }

    public void imprimir() {
        System.out.println(this.toString());
    }
}
