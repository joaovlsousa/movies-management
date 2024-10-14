package utils;

import java.util.ArrayList;
import java.util.List;

public class IDAux {
    public List<Integer> gerarIDs(int quant) {
        List<Integer> IDs = new ArrayList<Integer>();

        for (int i = 0; i < quant; i++) {
            IDs.add(i);
        }

        return IDs;
    }
}
