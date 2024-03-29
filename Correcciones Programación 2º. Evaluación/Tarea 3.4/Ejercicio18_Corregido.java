/** @author Lucía González Rosas */

/* 18º.) Realiza un programa para calcular la suma de los cuadrados de los 5 primeros números naturales = */

public class Ejercicio18_Corregido {
    public static void main(String[] args) {

        int numero = 5;
        int suma = 0;

        for (int i = 1; i <= numero; i++) {
            suma += i * i;

        }

        System.out.println("La suma de los cuadrados de los primeros " + numero + " números naturales es " + suma);

    }
}