package br.usjt.wesley.exemplospinner;


import java.util.ArrayList;
import java.util.TreeSet;

public class Especialista {
    private static final ArrayList<Voo> voos = cadastroVoos();

    public Especialista() {

    }

    public TreeSet<Voo> listarVoos(String origem, String destino) {
        TreeSet<Voo> voos = new TreeSet<Voo>();

        if (origem.length() > 0 && destino.length() > 0) {
            voos = buscarOrigemDestino(origem, destino);
        }
        else if (origem.length() > 0) {
            voos = buscarOrigem(origem);
        }
        else if (destino.length() > 0) {
            voos = buscarDestino(destino);
        }
        else {
            voos = todos();
        }
        return voos;
    }
    private TreeSet<Voo> buscarOrigemDestino(String origem, String destino) {
        TreeSet<Voo> lista = new TreeSet<Voo>();
        for (Voo voo : voos) {
            if (origem.equals(voo.getOrigem())
                    && destino.equals(voo.getDestino())
                    ) {
                lista.add(voo);
            }
        }
        return lista;
    }
    private TreeSet<Voo> buscarOrigem(String origem) {
        TreeSet<Voo> lista = new TreeSet<Voo>();
        for (Voo voo : voos) {
            if (origem.equals(voo.getOrigem())) {
                lista.add(voo);
            }
        }
        return lista;
    }
    private TreeSet<Voo> buscarDestino(String destino) {
        TreeSet<Voo> lista = new TreeSet<Voo>();
        for (Voo voo : voos) {
            if (destino.equals(voo.getDestino())) {
                lista.add(voo);
            }
        }
        return lista;
    }

    private TreeSet<Voo> todos() {
        TreeSet<Voo> lista = new TreeSet<Voo>();
        for (Voo voo : voos) {
            lista.add(voo);
        }
        return lista;
    }

    private static ArrayList<Voo> cadastroVoos() {
        ArrayList<Voo> voos = new ArrayList<Voo>();
        voos.add(new Voo("Congonhas(SP)", "Campinas(Interior)"));
        voos.add(new Voo("Campinas(Interior)", "Congonhas(SP)"));
        return voos;
    }
}