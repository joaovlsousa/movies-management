import interfaces.Filme_IF;
import models.BST;
import utils.FilmeAux;

public class App {
    public static void main(String[] args) throws Exception {
        BST tree = new BST();
        Filme_IF filme = new FilmeAux().gerarFilme();

        // System.out.println(tree.isEmpty());
        System.out.println(tree.size());
        
        for (int i = 0; i < 10; i++) {
            tree.insert(new FilmeAux().gerarFilme());
        }

        System.out.println();
        System.out.println();
        System.out.println(tree.treeMinimum().getFilme());
        System.out.println(tree.treeMaximum().getFilme());
        System.out.println();
        System.out.println();
        
        Filme_IF[] teste = tree.postOrder();
        
        System.out.println();
        System.out.println();



        for (int j = 0; j < 10; j++) {
            System.out.println(teste[j]);
        }
        // Fila fila = new Fila();
        
        // fila.enqueue(filme);

        // for (int i = 0; i < 3; i++) {
        //     fila.enqueue(new FilmeAux().gerarFilme());
        // }

        // // fila.dequeue();
        // // fila.dequeue();
        // // fila.dequeue();
        // // fila.dequeue();

        // System.out.println(fila.isEmpty());
        // System.out.println(fila.head().equals(filme));
    }
}
