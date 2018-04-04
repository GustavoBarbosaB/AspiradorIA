package application;

public class Application {
    public static void main(String[] args) {
        Ambiente ambiente = new Ambiente();
//        ambiente.buscaEmArvoreProfundidade(new Estado("B",true,true));
        ambiente.buscaEmArvoreLargura(new Estado("B",true,true));
        System.out.println("Limpei Tudo!!!!!!");

    }


}
