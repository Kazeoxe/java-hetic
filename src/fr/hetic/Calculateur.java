package fr.hetic;

public class Calculateur {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java Calculateur <nombre> <nombre> <opérateur>");
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

        double result;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            default:
                System.out.println("Erreur: Opérateur non supporté.");
                return;
        }
        System.out.println("Résultat: " + result);
    }
}
