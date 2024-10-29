import interfaces.Filme_IF;
import models.BST;
import utils.FilmeAux;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println();


        BST tree = new BST();
        FilmeAux filmeAux = new FilmeAux();

        Filme_IF f = filmeAux.gerarFilme();
        tree.insert(f);

        System.out.println(f.toString());
        System.out.println(tree.remove(f.getID()).toString());
    }
}
