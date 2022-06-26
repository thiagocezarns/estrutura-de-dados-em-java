package aed.trie;

class Alfabeto {

    private char[] caracteres;
    private int tamanho;

    public Alfabeto(String alfabeto) {
        this.caracteres = alfabeto.toCharArray();
        this.ordena();
        this.tamanho = alfabeto.length();
    }

    public char[] getCaracteres() {
        return caracteres;
    }

    public void setCaracteres(char[] caracteres) {
        this.caracteres = caracteres;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public String getStringAlfabeto() {
        String s = "";
        for (char c : this.getCaracteres()) {
            s += c;
        }
        return s;
    }

    private int[] convertToInt(char[] alf) {
        int[] alfN = new int[alf.length];
        for (int i = 0; i < alf.length; i++) {
            alfN[i] = (int) alf[i];
        }

        return alfN;
    }

    private char[] convertToChar(int[] arr, int j) {
        char[] alf = new char[arr.length];
        for (int i = 0; i < j; i++) {
            alf[i] = (char) arr[i];
        }
        return alf;
    }

    public void ordena() {
        int[] arr = this.convertToInt(this.getCaracteres());
        quickSort(arr, 0, arr.length - 1);

        int j = removeDuplicados(arr, arr.length);
        this.setTamanho(j);

        this.setCaracteres(this.convertToChar(arr, j));
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int partition(int[] arr, int low, int high) {

        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }

        }

        swap(arr, i + 1, high);
        return (i + 1);
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int removeDuplicados(int a[], int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int j = 0;

        for (int i = 0; i < n - 1; i++) {
            if (a[i] != a[i + 1]) {
                a[j++] = a[i];
            }
        }

        a[j++] = a[n - 1];

        return j;
    }
}
