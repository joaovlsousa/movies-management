package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import utils.IDAux;

public class ID {
    private static List<Integer> IDs = new ArrayList<Integer>(
        new IDAux().gerarIDs(1_000)
    );

    public static Integer gerarID() {
        int indice = new Random().nextInt(IDs.size());

        return IDs.remove(indice);
    }     
}
