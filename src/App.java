import interfaces.Filme_IF;
import models.Lista;
import utils.FilmeAux;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println();

        Lista lista = new Lista();

        
        Filme_IF filme = new FilmeAux().gerarFilme();
        lista.insert(filme);

        for (int i = 0; i < 8; i++) {
            lista.insert(new FilmeAux().gerarFilme());
        }

        Filme_IF filme2 = new FilmeAux().gerarFilme();
        lista.insert(filme2);
        
        for (int i = 0; i < 7; i++) {
            lista.insert(new FilmeAux().gerarFilme());
        }

        lista.remove(filme.getID());
        System.out.println(lista.search(filme2.getID()).toString());
        System.out.println(lista.size());
        System.out.println(lista.search(filme.getID()) == null);
    }
}
