package e3;

import java.lang.Math;
import java.util.Scanner;
import javax.swing.Spring;

public class Rectangle {

    int base;
    int height;

    public static int base() {
        Scanner teclado = new Scanner(System.in);
        String baseString;
        baseString = teclado.nextLine();
        int base;
        base = Integer.parseInt(baseString);
        return base;
    }

    public static int altura() {
        Scanner teclado = new Scanner(System.in);
        String heigthString;
        heigthString = teclado.nextLine();
        int height;
        height = Integer.parseInt(heigthString);
        return height;
    }

    public Rectangle(int base, int height) throws IllegalArgumentException {

        if (base > 0 && height > 0) {
            setBase(base);
            setHeight(height);

        } else {
            throw new IllegalArgumentException("No se han introducido argumentos validos");
        }
    }

    public Rectangle(Rectangle r) {
        this(r.getBase(), r.getHeight());
    }

    public int getBase() {
        return base;
    }

    public int getHeight() {
        return height;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isSquare() {
        boolean cuadrado = false;
        if (base == height) {
            cuadrado = true;
        }
        return cuadrado;
    }

    public int area() {
        int a;
        a = (base * height);
        return a;
    }

    public int perimeter() {
        int p;
        p = base * 2 + height * 2;
        return p;
    }

    public double diagonal() {
        double d;
        double raiz = (base * base) + (height * height);
        d = Math.sqrt(raiz);
        return d;
    }

    public void turn() {
        int cbase = base;
        int cheight = height;

        base = cheight;
        height = cbase;

    }

    public void putHorizontal() {

        if (base >= height) {

        } else {

            turn();
        }

    }

    public void putVertical() {

        if (base >= height) {
            turn();
        } else {

        }
    }

    public boolean equals(Rectangle r) {

        if (r == null) {
            return false;

        } else {

            boolean equal = false;
            Rectangle a = new Rectangle(r);

            if (base >= height) {
                a.putHorizontal();

            } else {
                a.putVertical();

            }

            if (base == a.getBase() && height == a.getHeight()) {
                equal = true;

            } else {
                equal = false;
            }

            return equal;

        }
    }

    // It  complies  with  the  hashCode  contract  and is  consistent  with  the  equals.
    @Override
    public int hashCode() {
        int result = 10;

        result = 5 * result + base * height;

        return result;
    }

    public static void main(String[] args) {
        System.out.println("Por favor introduce la base y la altura deseada.");
        System.out.print("BASE:");
        int base = base();
        System.out.print("Altura:");
        int altura = altura();
        Rectangle r1 = new Rectangle(base, altura);
        System.out.println("¿Es cuadrado? " + r1.isSquare());
        System.out.println("Area:" + r1.area());
        System.out.println("Perimetro: " + r1.perimeter());
        System.out.println("Diagonal :" + r1.diagonal());
        System.out.println("Por favor introduce la base y la altura de un nuevo rectangulo.");
        System.out.print("BASE:");
        base = base();
        System.out.print("Altura:");
        altura = altura();
        Rectangle r2 = new Rectangle(base, altura);
        System.out.println("¿Es igual el primer rectangulo al segundo?: ");
        System.out.println("" + r1.equals(r2));

    }

}
