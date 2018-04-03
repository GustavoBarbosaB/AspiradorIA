package application;

public class Application {
    public static void main(String[] args) {
        Ambiente ambiente = new Ambiente();
        //ambiente.buscaEmArvoreLargura(new Estado("B",true,false));
        ambiente.buscaEmArvoreProfundidade(new Estado("B",true,true));
        System.out.println("Limpei Tudo!!!!!!");

    }
}
