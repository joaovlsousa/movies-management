import java.util.Scanner;

import models.TabelaHash;
import utils.FilmeAux;
import utils.Globals;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println();
        System.out.println();


        TabelaHash tabelaHash = new TabelaHash(Globals.QUANT_FILMES);
        FilmeAux filmeAux = new FilmeAux();
        Scanner scanner = new Scanner(System.in);
        
        for (int i = 0; i < Globals.QUANT_FILMES; i++) {
            tabelaHash.insert(filmeAux.gerarFilme());
        }
        
        System.out.println(tabelaHash.print());
        long id = 0;

        do {
            id = scanner.nextLong();
            tabelaHash.remove(id);

            System.out.println(tabelaHash.print());
            System.out.println(tabelaHash.isEmpty());    
        } while (id > 0);
        System.out.println(tabelaHash.isEmpty());

        scanner.close();
    }
}
