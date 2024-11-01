import interfaces.Filme_IF;
import java.util.Scanner;
import models.AVL;
import models.BST;
import models.Fila;
import models.Lista;
import models.Pilha;
import models.TabelaHash;
import utils.Actions;
import utils.FilmeAux;
import utils.Menus;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println();
        System.out.println(" ");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantos filmes deseja gerar? ");
        int quantFilmes = scanner.nextInt();

        Filme_IF[] filmes = new FilmeAux().gerarFilmes(quantFilmes);

        Lista lista = new Lista();
        Fila fila = new Fila();
        Pilha pilha = new Pilha();
        TabelaHash tabelaHash = new TabelaHash(quantFilmes);
        BST bst = new BST();
        AVL avl = new AVL();

        for (Filme_IF filme : filmes) {
            lista.insert(filme);
            fila.enqueue(filme);
            pilha.push(filme);
            tabelaHash.insert(filme);
            bst.insert(filme);
            avl.insert(filme);
        }

        int action = 0, dataEstructure = 0;

        do {
            Menus.menu();

            System.out.print("O que deseja fazer? ");
            action = scanner.nextInt();

            if (action == 0) {
                continue;                
            }

            Menus.subMenu();

            System.out.print("Em qual estrutura deseja fazer essa ação? ");
            dataEstructure = scanner.nextInt();

            switch (dataEstructure) {
                case 1:
                    Actions.listaActions(lista, action);
                    break;
                case 2:
                    Actions.pilhaActions(pilha, action);

                    break;
                case 3:
                    Actions.filaActions(fila, action);

                    break;
                case 4:
                    Actions.tabelaHashActions(tabelaHash, action);

                    break;
                case 5:
                    Actions.bstActions(bst, action);

                    break;
                case 6:
                    Actions.avlActions(avl, action);

                    break;

                case 0:
                    continue;
            }
        } while (action != 0);

        scanner.close();
    }
}
