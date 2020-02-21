package e2_e3;

import java.util.Comparator;

public class Comparador implements Comparator<EuroCoin> {

    @Override
    public int compare(EuroCoin o1, EuroCoin o2) {

        int resultado = 0;

        if (o1.getPais().compareToIgnoreCase(o2.getPais()) == 0) {

            if (o1.getValor() == o2.getValor()) {

                if (o1.getFecha() == o2.getFecha()) {
                    resultado = 0;

                } else if (o1.getFecha() < o2.getFecha()) {
                    resultado = -1;
                } else if (o1.getFecha() > o2.getFecha()) {
                    resultado = 1;
                }

            } else if (o1.getValor() < o2.getValor()) {
                resultado = 1;

            } else if (o1.getValor() > o2.getValor()) {
                resultado = -1;
            }

        } else if (o1.getPais().compareToIgnoreCase(o2.getPais()) < 0) {
            resultado = -1;
        } else if (o1.getPais().compareToIgnoreCase(o2.getPais()) > 0) {
            resultado = 1;
        }

        return resultado;
    }
}
