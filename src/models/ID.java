package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import utils.Globals;
import utils.IDAux;

public class ID {
    private static List<Integer> IDs = new ArrayList<Integer>(
        new IDAux().gerarIDs(Globals.QUANT_IDS)
    );

    private static List<Integer> IDsGerados = new ArrayList<Integer>();

    public static int gerarID() {
        int index = new Random().nextInt(IDs.size());

        int id = IDs.remove(index);

        IDsGerados.add(id);

        return id;
    }

    public static int getRandomGeneratedID() {
        int index = new Random().nextInt(IDsGerados.size());

        return IDs.get(index);
    }

    public static List<Integer> getIDsGerados() {
        return IDsGerados;
    }
}
