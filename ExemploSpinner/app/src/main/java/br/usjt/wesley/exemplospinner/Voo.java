package br.usjt.wesley.exemplospinner;


import java.util.Date;

public class Voo implements Comparable<Voo>{
    private String origem;
    private String destino;

    public static final String NAO_ENCONTRADA = "Não encontrado.";

    public Voo(String origem, String destino) {
        this.origem = origem;
        this.destino = destino;

    }
    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }
    public String getOrigem() {
        return origem;
    }
    public String getDestino() {
        return destino;
    }


    @Override
    public String toString() {
        return "" + origem + "\\" + destino  ;
    }

    @Override
    public int compareTo(Voo voo) {
        if (origem.equals(voo.getOrigem())
                && destino.equals(voo.getDestino()))
                {
            return 0;
        }
        return 1;
    }
}
