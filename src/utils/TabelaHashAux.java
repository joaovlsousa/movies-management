package utils;

public class TabelaHashAux {
    public static int setSize(int quantFilmes) {
        int size = quantFilmes / 4;

        while (!isPrimo(size)) {
            size++;
        }

        return size;
    }

    public static boolean isPrimo(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
