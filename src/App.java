// import java.util.Scanner;

// import interfaces.Filme_IF;
// import interfaces.Func;
// import models.AVL;
// import models.BST;
// import models.Fila;
// import models.ID;
// import models.Lista;
// import models.Pilha;
// import models.TabelaHash;
// import utils.FilmeAux;
// import utils.Globals;

// public class App {
//     public static void menu() {
//         System.out.println();
//         System.out.println("1 - Mostrar");
//         System.out.println("2 - Buscar");
//         System.out.println("3 - Remover");
//         System.out.println("0 - Sair");
//         System.out.println();
//     }

//     public static void subMenu() {
//         System.out.println();
//         System.out.println("1 - Lista");
//         System.out.println("2 - Pilha");
//         System.out.println("3 - Fila");
//         System.out.println("4 - Tabela Hash");
//         System.out.println("5 - BST");
//         System.out.println("6 - AVL");
//         System.out.println("0 - Voltar");
//         System.out.println();
//     }

//     public static void execute(Func func) {
//         long tempoInicial = System.nanoTime();

//         func.execute();

//         double tempoFinal = (System.nanoTime() - tempoInicial) / 1_000_000_000.0;

//         System.out.println("Tempo de execução: " + tempoFinal);
//     }

//     public static boolean isMovieValid() {
//         System.out.print("Você quer buscar/remover um filme válido? (s/n) ");

//         @SuppressWarnings("resource")
//         char op = new Scanner(System.in).nextLine().charAt(0);

//         return op == 's' ? true : false;
//     }

//     public static void listaActions(Lista lista, int op) {
//         if (op == 1) {
//             Func print = () -> {
//                 System.out.println(lista.toString());
//             };

//             execute(print);
//         }

//         if (op == 2) {
//             System.out.println(lista.size());

//             Func search = () -> {
//                 try {
//                     int filmeID = isMovieValid() 
//                         ? ID.getRandomGeneratedID()
//                         : Globals.QUANT_IDS + 1;

//                     lista.search(filmeID);
//                 } catch (Exception e) {
//                     System.out.println(e.getMessage());
//                 }
//             };

//             execute(search);
//         }

//         if (op == 3) {  
//             Func remove = () -> {
//                 try {
//                     System.out.println(isMovieValid());

//                     int filmeID = isMovieValid() 
//                         ? ID.getRandomGeneratedID()
//                         : Globals.QUANT_IDS + 1;

//                     System.out.println(filmeID);
//                     System.out.println(lista.remove(filmeID));
//                 } catch (Exception e) {
//                     System.out.println(e.getMessage());
//                 }
//             };

//             execute(remove);
//         }
//     }

//     public static void main(String[] args) throws Exception {
//         System.out.println();
//         System.out.println(" ");

//         Scanner scanner = new Scanner(System.in);

//         System.out.print("Quantos filmes deseja gerar? ");
//         int quantFilmes = scanner.nextInt();

//         Filme_IF[] filmes = new FilmeAux().gerarFilmes(quantFilmes);

//         Lista lista = new Lista();
//         Fila fila = new Fila();
//         Pilha pilha = new Pilha();
//         TabelaHash tabelaHash = new TabelaHash(quantFilmes);
//         BST bst = new BST();
//         AVL avl = new AVL();

//         for (Filme_IF filme : filmes) {
//             lista.insert(filme);
//             fila.enqueue(filme);
//             pilha.push(filme);
//             tabelaHash.insert(filme);
//             bst.insert(filme);
//             avl.insert(filme);
//         }

//         int action = 0, dataEstructure = 0;

//         do {
//             menu();

//             System.out.print("O que deseja fazer? ");
//             action = scanner.nextInt();

//             if (action == 0) {
//                 continue;                
//             }

//             subMenu();

//             System.out.print("Em qual estrutura deseja fazer essa ação? ");
//             dataEstructure = scanner.nextInt();

//             switch (dataEstructure) {
//                 case 1:
//                     listaActions(lista, action);
//                     break;
//                 case 2:
                    
//                     break;
//                 case 3:
                    
//                     break;
//                 case 4:
                    
//                     break;
//                 case 5:
                    
//                     break;
//                 case 6:
                    
//                     break;
//                 case 0:
//                     continue;

//             }
//         } while (action != 0);

//         scanner.close();
//     }
// }

import interfaces.Filme_IF;
import models.AVL;
import utils.FilmeAux;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println();
        System.out.println(" ");

        Filme_IF[] teste = new FilmeAux().gerarFilmes(1000);
        AVL tree = new AVL();

        // teste[0].setID(2);
        // teste[1].setID(3);
        // teste[2].setID(5);
        // teste[3].setID(6);
        // teste[4].setID(7);
        // teste[5].setID(8);
        // teste[6].setID(9);
        // teste[7].setID(10);

        for (int i = 0; i < 1000; i++) {
            tree.insert(teste[i]);
        }
        tree.searchNode(0);
        for (int i = 0; i < 1000; i++) {
            System.out.println(tree.searchNode(teste[i].getID()));
            System.out.println();
        }

        // tree.search(8);
        // tree.remove(5);

        // System.out.println(tree.searchNode(teste[0].getID()));
        // System.out.println();
        // System.out.println(tree.searchNode(teste[1].getID()));
        // System.out.println();
        // System.out.println(tree.searchNode(teste[2].getID()));
        // System.out.println();
        // System.out.println(tree.searchNode(teste[3].getID()));
        // System.out.println();
        // System.out.println(tree.searchNode(teste[4].getID()));
        // System.out.println();
        // System.out.println(tree.searchNode(teste[5].getID()));
        // System.out.println();
        // System.out.println(tree.searchNode(teste[6].getID()));
        // System.out.println();
        // System.out.println(tree.searchNode(teste[7].getID()));
        // System.out.println();
        // // System.out.println(tree.searchNode(teste[3].getID()));
        // System.out.println(tree.isComplete());
        // System.out.println();
        // System.out.println(tree.height());
        // System.out.println();
        // System.out.println(tree.size());
        
        // System.out.println(tree.toString());
    }
}