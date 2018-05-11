package application;

import java.util.ArrayList;

public class Ambiente {

    private ArrayList<Estado> borda;
    private ArrayList<Estado> expandidos;
    private int numExpandidos=0,numGerados=0;

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
        int i = 0;
        while (true) {

            if (borda.isEmpty()) {
                return null;
            }
            System.out.print("Borda "+i+": ");
            for(Estado e:borda)
                System.out.print(e.toString()+", ");

            no = removePrimeiro();
            System.out.println("\nEstado pego da borda:"+no.toString());

            if (testaObjetivo(no)) {
                if(expandidos.size()==1)
                    numExpandidos++;
                break;
            } else {
                numExpandidos++;
                expandirProfundidade(no);
            }
            i++;

        }
        System.out.println("Numero de expandidos: "+numExpandidos);
        System.out.println("Numero de gerados: "+numGerados);
        System.out.println("Numero de profundidade: "+numExpandidos);

        return no;
    }
    /*Quantos foram expandidos
    * Qauntos foram gerados
    * Qual a profundidade
    * */

    private void expandirProfundidade(Estado no) {
        Aspirador agente = new Aspirador();
        Estado aux;
        expandidos.add(no);
        aux = agente.proximoEstado(no, Acao.ASPIRAR);
        if (!expandidos.contains(aux) && !borda.contains(aux)) {
            numGerados++;
            borda.add(0, aux);
        }
        aux = agente.proximoEstado(no, Acao.ESQUERDA);
        if (!expandidos.contains(aux) && !borda.contains(aux)) {
            numGerados++;
            borda.add(0, aux);
        }
        aux = agente.proximoEstado(no, Acao.DIREITA);
        if (!expandidos.contains(aux) && !borda.contains(aux)) {
            numGerados++;
            borda.add(0, aux);
        }
    }

    private Estado removePrimeiro() {
        Estado aux = borda.get(0);
        borda.remove(borda.get(0));
        return aux;
    }

    private boolean testaObjetivo(Estado no) {
        return !no.isA() && !no.isB();
    }
}