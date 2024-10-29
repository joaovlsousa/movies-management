import interfaces.Filme_IF;
import models.BST;
import utils.FilmeAux;

public class App {
    
    public static void main(String[] args) throws Exception {
        BST tree = new BST();
        Filme_IF[] filmes = new Filme_IF[7];

        for (int i = 0; i < 7; i++) {
            filmes[i] = new FilmeAux().gerarFilme();            
        }
        filmes[0].setID(4);
        filmes[1].setID(6);
        filmes[1].setNome("teste direita");
        filmes[2].setID(5);
        filmes[3].setID(7);
        filmes[4].setID(2);
        filmes[5].setID(3);
        filmes[5].setNome("teste 2");
        filmes[6].setID(1);
        filmes[6].setNome("teste");;

        for (int i = 0; i < 7; i++) {
            tree.insert(filmes[i]);
        }

        // System.out.println(tree.searchNode(4));
        System.out.println();
        // System.out.println(tree.searchNode(3));
        System.out.println();
        // System.out.println(tree.searchNode(6));
        System.out.println();
        
        // System.out.println(tree.size());
        System.out.println();
        // System.out.println(tree.height());
        System.out.println();
        System.out.println();
        // System.out.println(tree.isComplete());
        
        System.out.println();
        System.out.println();
        // System.out.println(tree.searchNode(5));
        System.out.println();
        // System.out.println(tree.searchNode(6));
        System.out.println();
        // System.out.println(tree.searchNode(5));
        System.out.println();
        // System.out.println(tree.searchNode(3));
        System.out.println(tree.searchNode(4));
        tree.remove(4);
        tree.remove(5);
        tree.remove(6);
        tree.remove(7);
        tree.remove(2);

        System.out.println(tree.searchNode(3));
        System.out.println();
        System.out.println(tree.searchNode(1));
        // System.out.println(tree.searchNode(5));
        System.out.println();
        // System.out.println(tree.searchNode(4));
        // System.out.println(tree.searchNode(3));
        // tree.remove(6);
        // System.out.println(tree.searchNode(6));
        System.out.println(tree.size());
        System.out.println();
        System.out.println(tree.height());
        System.out.println();
        System.out.println();
        
        // System.out.println(tree.isEmpty());
        
        // tree.insert(filmes);
        
        // System.out.println(tree.isEmpty());

        // System.out.println(tree.root());

        // Fila fila = new Fila();
        
        // fila.enqueue(filme);

        // for (int i = 0; i < 3; i++) {
        //     fila.enqueue(new FilmeAux().gerarFilme());
        // }

        // Pilha pilha = new Pilha();

        // System.out.println(pilha.toString());
    }
}
