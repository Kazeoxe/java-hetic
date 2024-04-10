package fr.hetic.math;

public class Calcul {
    private final Operation operation;

    public Calcul(Operation operation) {
        this.operation = operation;
    }

    public double calculate(double num1, double num2) {
        return operation.apply(num1, num2);
    }
}

