package aed.GrafoPonderadoDirecionado;

import aed.GrafoPonderado.GrafoPonderado;
import aed.GrafoPonderado.Vertice;

public class Teste {
    public static void main(String[] args) {
        GrafoPonderadoDirecionado<String, Integer> G = new GrafoPonderadoDirecionado<>();

        Vertice<String, Integer> a = G.addVertice("a");
        Vertice<String, Integer> b = G.addVertice("b");
        Vertice<String, Integer> c = G.addVertice("c");
        Vertice<String, Integer> d = G.addVertice("d");
        Vertice<String, Integer> e = G.addVertice("e");
        Vertice<String, Integer> f = G.addVertice("f");
        Vertice<String, Integer> g = G.addVertice("g");
        Vertice<String, Integer> h = G.addVertice("h");
        Vertice<String, Integer> i = G.addVertice("i");

        G.addAresta(a,b,1);
        G.addAresta(a,c,2);
        G.addAresta(a,f,3);
        G.addAresta(b,g,4);
        G.addAresta(b,h, 5);
        G.addAresta(c,i, 6);
        G.addAresta(c,d, 7);
        G.addAresta(d,i, 8);
        G.addAresta(e,f, 9);
        G.addAresta(e,g, 10);


        System.out.println(G.toString());
    }
}
