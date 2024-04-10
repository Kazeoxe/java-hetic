package fr.hetic.math;

public class OperationFactory {
    public static Operation createOperation(String operator) {
        switch (operator) {
            case "+":
                return new Addition();
            case "-":
                return new Soustraction();
            case "*":
                return new Multiplication();
            default:
                throw new IllegalArgumentException("Opérateur non supporté: " + operator);
        }
    }
}

