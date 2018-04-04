package application;

import java.util.ArrayList;

public class Ambiente {

    private ArrayList<Estado> borda;
    private ArrayList<Estado> expandidos;
    private int tempo = 2;

    public Ambiente() {
        borda = new ArrayList<Estado>();
        expandidos = new ArrayList<Estado>();
    }

    public Estado buscaEmArvoreLargura(Estado inicial) {
        borda.add(inicial);
        Estado no;
        while (true) {
            if (borda.isEmpty()) {
                return null;
            }
            no = removePrimeiro();
            System.out.println(no.toString());

            if (testaObjetivo(no)) {
                return no;
            } else {
                expandirLargura(no);
            }
        }
    }

    private void expandirLargura(Estado no) {
        Aspirador agente = new Aspirador();
        Estado aux;
        aux = agente.proximoEstado(no, Acao.ASPIRAR);
        if (!expandidos.contains(aux) && !borda.contains(aux)) {
            borda.add(aux);
        }
        aux = agente.proximoEstado(no, Acao.ESQUERDA);
        if (!expandidos.contains(aux) && !borda.contains(aux)) {
            borda.add(aux);
        }
        aux = agente.proximoEstado(no, Acao.DIREITA);
        if (!expandidos.contains(aux) && !borda.contains(aux)) {
            borda.add(aux);
        }
    }

    public Estado buscaEmArvoreProfundidade(Estado inicial) {
        borda.add(inicial);
        Estado no;
        while (true) {
            if (borda.isEmpty()) {
                return null;
            }

            no = removePrimeiro();
            System.out.println(no.toString());
            if (testaObjetivo(no)) {
                return no;
            } else {
                expandirProfundidade(no);
            }

        }
    }

    private void expandirProfundidade(Estado no) {
        Aspirador agente = new Aspirador();
        Estado aux;
        aux = agente.proximoEstado(no, Acao.ASPIRAR);
        if (!expandidos.contains(aux) && !borda.contains(aux)) {
            borda.add(0, aux);
        }
        aux = agente.proximoEstado(no, Acao.ESQUERDA);
        if (!expandidos.contains(aux) && !borda.contains(aux)) {
            borda.add(0, aux);
        }
        aux = agente.proximoEstado(no, Acao.DIREITA);
        if (!expandidos.contains(aux) && !borda.contains(aux)) {
            borda.add(0, aux);
        }
    }

    private Estado removePrimeiro() {
        Estado aux = borda.get(0);
        borda.remove(borda.get(0));
        expandidos.add(aux);
        return aux;
    }

    private boolean testaObjetivo(Estado no) {
        return !no.isA() && !no.isB();
    }
}