package application;

public class Application {
    public static void main(String[] args) {
        Ambiente ambiente = new Ambiente();
        ambiente.buscaEmArvoreProfundidade(new Estado("B",false,false));
        System.out.println("Limpei Tudo!!!!!!");

    }


}
