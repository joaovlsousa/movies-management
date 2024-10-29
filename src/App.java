import interfaces.Filme_IF;
import models.BST;
import utils.FilmeAux;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println();
        System.out.println(" ");

        BST tree = new BST();
        FilmeAux filmeAux = new FilmeAux();

        Filme_IF[] filmes = {
            filmeAux.gerarFilme(),
            filmeAux.gerarFilme(),
            filmeAux.gerarFilme(),
            filmeAux.gerarFilme(),
        };

        for (Filme_IF filme : filmes) {
            tree.insert(filme);
        }

        System.out.println(tree.toString());
    }
}
