import interfaces.Filme_IF;
import models.Pilha;
import utils.FilmeAux;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println();

        Pilha pilha = new Pilha();

        
        Filme_IF filme = new FilmeAux().gerarFilme();
        pilha.push(filme);

        for (int i = 0; i < 3; i++) {
            pilha.push(new FilmeAux().gerarFilme());
        }

        pilha.pop();
        pilha.pop();
        pilha.pop();
        pilha.pop();

        System.out.println(pilha.isEmpty());
        System.out.println(pilha.top().equals(filme));
    }
}
