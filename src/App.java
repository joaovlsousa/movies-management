import interfaces.Filme_IF;
import models.BST;
import utils.FilmeAux;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println();
        System.out.println(" ");

        BST tree = new BST();
        FilmeAux filmeAux = new FilmeAux();

        for (int i = 0; i < 2; i++) {
            teste[i] = new FilmeAux().gerarFilme();
        }

        teste[0].setID(2);
        teste[1].setID(1);
        BST tree = new BST();

        for (int i = 0; i < 2; i++) {
            tree.insert(teste[i]);;
        }

        // Filme_IF f = filmeAux.gerarFilme();
        // f.setID(1);
        System.out.println(tree.searchNode(1));
        tree.remove(2);
        System.out.println(tree.searchNode(1));


        // System.out.println(f.toString());
        // System.out.println(tree.remove(f.getID()).toString());
    }
}
