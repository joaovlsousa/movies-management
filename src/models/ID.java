package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import utils.IDAux;

public class ID {
    private static List<Integer> IDs = new ArrayList<Integer>(
        new IDAux().gerarIDs(1_000)
    );

    private static List<Integer> IDsGerados = new ArrayList<Integer>();

    public static int gerarID() {
        int indice = new Random().nextInt(IDs.size());

        int id = IDs.remove(indice);

        IDsGerados.add(id);

        return id;
    }

    public static List<Integer> getIDsGerados() {
        return IDsGerados;
    }
}
