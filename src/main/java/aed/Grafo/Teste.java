package aed.Grafo;

public class Teste {
    public static void main(String[] args) {
        Grafo<String> G = new Grafo<>();


        Vertice<String> a = G.addVertice("a");
        Vertice<String> b = G.addVertice("b");
        Vertice<String> c = G.addVertice("c");
        Vertice<String> d = G.addVertice("d");
        Vertice<String> e = G.addVertice("e");
        Vertice<String> f = G.addVertice("f");
        Vertice<String> g = G.addVertice("g");
        Vertice<String> h = G.addVertice("h");
        Vertice<String> i = G.addVertice("i");

        G.addAresta(a,b);
        G.addAresta(a,c);
        G.addAresta(a,f);
        G.addAresta(b,g);
        G.addAresta(b,h);
        G.addAresta(c,i);
        G.addAresta(c,d);
        G.addAresta(d,i);
        G.addAresta(e,f);
        G.addAresta(e,g);


        System.out.println(G.toString());
    }

}
