package application;

public class Aspirador /*extends Agent*/{
    protected void setup() {
        System.out.println("COE RAPAZIADA");
    }

    public Acao condAcao(Estado atual) {
        if (atual.getPosicao().equals("A")) {
            if (atual.isA()) {
                return Acao.ASPIRAR;
            }else{
                return Acao.DIREITA;
            }
        } else {
            if (atual.isB()) {
                return Acao.ASPIRAR;
            } else{
                return Acao.ESQUERDA;
            }
        }
    }

    public Estado proximoEstado(Estado atual, Acao acao) {
        if (atual.getPosicao().equals("A")) {
            if (acao == Acao.ASPIRAR) {
                return new Estado("A", false, atual.isB());
            } else if (acao == Acao.DIREITA) {
                return new Estado("B", atual.isA(), atual.isB());
            } else {
                return atual;
            }
        } else {
            if (acao == Acao.ASPIRAR) {
                return new Estado("B", atual.isA(), false);
            } else if (acao == Acao.ESQUERDA) {
                return new Estado("A", atual.isA(), atual.isB());
            } else {
                return atual;
            }
        }
    }
}