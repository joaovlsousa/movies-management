package models;

import interfaces.Filme_IF;
import interfaces.TabelaHash_IF;
import utils.TabelaHashAux;

public class TabelaHash implements TabelaHash_IF {
    private Lista[] tabela;

    public TabelaHash(int quantFilmes) {
        this.tabela = new Lista[TabelaHashAux.setSize(quantFilmes)];

        for (int i = 0; i < tabela.length; i++) {
            tabela[i] = new Lista();
        }
    }

    @Override
    public void insert(Filme_IF elemento) {
        int index = hash(elemento.getID());

        tabela[index].insert(elemento);
    }

    @Override
    public Filme_IF remove(long id) throws Exception {
        return tabela[hash(id)].remove(id);
    }

    @Override
    public Filme_IF search(long id) throws Exception {
        return tabela[hash(id)].search(id);
    }

    @Override
    public boolean isEmpty() {
        for (Lista lista : tabela) {
            if (!lista.isEmpty()) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String print() {
        if (this.isEmpty()) {
            return "[]";            
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < tabela.length; i++) {
            result.append(tabela[i].toString());

            String caractere = i == tabela.length - 1
                ? "\n"
                : ",\n";

            result.append(caractere);
        }

        return result.toString();
    }
    
    private int hash(long id) {
        int filmeId = (int) id;

        return filmeId < tabela.length
            ? filmeId
            : filmeId % tabela.length;
    }
}