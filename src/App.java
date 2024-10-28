import models.Filme;
import models.Pilha;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println();
        System.out.println("test");

        Filme[] filmes = {
            new Filme(3, "D", 2020, 5),
            new Filme(1, "B", 2021, 4),
            new Filme(0, "A", 2020, 5),
            new Filme(2, "C", 2019, 5),
        };

        Pilha pilha = new Pilha();

        for (Filme filme : filmes) {
            pilha.push(filme);
        }

        System.out.println(pilha.toString());
    }
}
