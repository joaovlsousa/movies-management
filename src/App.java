import interfaces.Filme_IF;
import models.BST;
import models.Filme;
import models.Pilha;
import utils.FilmeAux;

public class App {
    public static void main(String[] args) throws Exception {
        BST tree = new BST();
        Filme_IF filme = new FilmeAux().gerarFilme();

        System.out.println(tree.isEmpty());
        
        tree.insert(filme);
        
        System.out.println(tree.isEmpty());

        System.out.println(tree.root());

        // Fila fila = new Fila();
        
        // fila.enqueue(filme);

        // for (int i = 0; i < 3; i++) {
        //     fila.enqueue(new FilmeAux().gerarFilme());
        // }

        Pilha pilha = new Pilha();

        for (Filme filme : filmes) {
            pilha.push(filme);
        }

        System.out.println(pilha.toString());
    }
}
