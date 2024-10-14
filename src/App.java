import utils.FilmeAux;

public class App {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println(new FilmeAux().gerarFilme().toString());
        }
    }
}
