package e2;

import java.util.Arrays;
import java.lang.*;
import java.util.ArrayList;

public class Polymers {

    /**
     * * Given a polymer represented with the letters of the alphabet
     * (uppercase* and lowercase excluding~N), it processes the chain reactions
     * of said* polymer (due to adjoint units of the same type but different
     * polarity , for example: aA).* It returns the polymer without the reactive
     * pairs (it can be an empty string) and it throws an
     * IllegalArgumentException if the String passed* as parameter is null.
     */
    public static String processPolymer(String polymer) throws IllegalArgumentException {

        if (polymer == null) {
            throw new IllegalArgumentException("error");
        }
        int aux = polymer.length();
        for (int i = 0; i < aux; i++) {
            polymer = poli(polymer);

        }

        return polymer;
    }

    private static String poli(String polymer) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < polymer.length(); i++) {
            int code = polymer.codePointBefore(i);
            char codec = (char) code;

            if (Character.isUpperCase(polymer.charAt(i)) && codec == Character.toLowerCase(polymer.charAt(i))) {
                i++;

            } else if (Character.isLowerCase(polymer.charAt(i)) && codec == Character.toUpperCase(polymer.charAt(i))) {
                i++;

            } else {
                sb.append(codec);

            }
            if (i == polymer.length() - 1) {
                sb.append(polymer.charAt(i));
            }

        }

        return sb.toString();
    }

    /**
     * * Given a polymer returns the monomer (existing in the polymer) whose*
     * elimination (both in its positive and negative form) results , after the*
     * consequent chain reactions , in the smallest polymer.* It returns the
     * positive form (lowercase) of the monomer. In case of a* tie , the one
     * with the lowest alphabetical order is returned.* An
     * IllegalArgumentException is thrown if the original polymer is null or* if
     * it is a empty string.
     */
    public static char minProcessedPolymer(String polymer) throws IllegalArgumentException {

        if (polymer == "" || polymer == null) {
            throw new IllegalArgumentException("error");
        }
        
      
        char caracterEliminado;
        String polymerMinusculas = polymer.toLowerCase();
        char[] lista = polymerMinusculas.toCharArray();
        String polimeroedit;
        int cont = polymer.length();
        char resultado = 'z';

        Arrays.sort(lista);

        for (int i = 0; i < polymer.length(); i++) {

            caracterEliminado = lista[i];
            polimeroedit = polymer.replaceAll("" + caracterEliminado, "");
            polimeroedit = polimeroedit.replaceAll("" + Character.toUpperCase(caracterEliminado), "");

            if (cont > processPolymer(polimeroedit).length()) {
                cont = processPolymer(polimeroedit).length();
                resultado = caracterEliminado;
            }
        }
        return resultado;
    }

    public static void main(String[] args) {

        try {
            System.out.println("" + poli("abCDezyXxYZEdcBA"));
            System.out.println("" + processPolymer("abCDezyXxYZEdcBA"));
            System.out.println("" + minProcessedPolymer("gmGmgmGagaGagaG"));
        } catch (IllegalArgumentException e) {
        }
    }

}
