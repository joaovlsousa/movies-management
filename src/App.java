import interfaces.Filme_IF;
import models.AVL;
import utils.FilmeAux;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println();
        System.out.println(" ");

        Filme_IF[] teste = new FilmeAux().gerarFilmes(8);
        AVL tree = new AVL();

        teste[0].setID(2);
        teste[1].setID(3);
        teste[2].setID(5);
        teste[3].setID(6);
        teste[4].setID(7);
        teste[5].setID(8);
        teste[6].setID(9);
        teste[7].setID(10);

        for (int i = 0; i < 8; i++) {
            tree.insert(teste[i]);;
        }
        tree.search(8);
        tree.remove(5);

        System.out.println(tree.searchNode(teste[0].getID()));
        System.out.println();
        System.out.println(tree.searchNode(teste[1].getID()));
        System.out.println();
        System.out.println(tree.searchNode(teste[2].getID()));
        System.out.println();
        System.out.println(tree.searchNode(teste[3].getID()));
        System.out.println();
        System.out.println(tree.searchNode(teste[4].getID()));
        System.out.println();
        System.out.println(tree.searchNode(teste[5].getID()));
        System.out.println();
        System.out.println(tree.searchNode(teste[6].getID()));
        System.out.println();
        System.out.println(tree.searchNode(teste[7].getID()));
        System.out.println();
        // System.out.println(tree.searchNode(teste[3].getID()));
        System.out.println(tree.isComplete());
        System.out.println();
        System.out.println(tree.height());
        System.out.println();
        System.out.println(tree.size());
        
        System.out.println(tree.toString());
    }
}
