package fr.hetic.math;

public class Calculateur {
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
        Operation operation = OperationFactory.createOperation(operator);

        Calcul calculator = new Calcul(operation);

        double result = calculator.calculate(num1, num2);
        System.out.println("Résultat: " + result);
    }
}
