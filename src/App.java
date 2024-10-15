import interfaces.Filme_IF;
import models.Fila;
import utils.FilmeAux;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println();

        Fila fila = new Fila();
        
        Filme_IF filme = new FilmeAux().gerarFilme();
        fila.enqueue(filme);

        for (int i = 0; i < 3; i++) {
            fila.enqueue(new FilmeAux().gerarFilme());
        }

        // fila.dequeue();
        // fila.dequeue();
        // fila.dequeue();
        // fila.dequeue();

        System.out.println(fila.isEmpty());
        System.out.println(fila.head().equals(filme));
    }
}
