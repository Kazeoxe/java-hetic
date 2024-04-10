package fr.hetic;
import java.util.function.BiFunction;

public class CalculateurFonctionnel {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java Main <nombre> <nombre> <opérateur>");
            return;
        }

        double num1, num2;
        String operator;
        
        try {
            num1 = Double.parseDouble(args[0]);
            num2 = Double.parseDouble(args[1]);
            operator = args[2];
        } catch (NumberFormatException e) {
            System.out.println("Erreur: Les deux premiers arguments doivent être numériques.");
            return;
        }

        BiFunction<Double, Double, Double> operation = null;
        switch (operator) {
            case "+":
                operation = (a, b) -> a + b;
                break;
            case "-":
                operation = (a, b) -> a - b;
                break;
            case "*":
                operation = (a, b) -> a * b;
                break;
            default:
                System.out.println("Erreur: Opérateur non supporté.");
                return;
        }

        double result = operation.apply(num1, num2);
        System.out.println("Résultat: " + result);
    }
}
/*

la multiplication ne marche que en 
/src
java fr/hetic/CalculateurFonctionel.java 2 6 *


*/
