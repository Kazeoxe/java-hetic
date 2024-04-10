package fr.hetic.math;

public class Calculator {
    private final Operation operation;

    public Calculator(Operation operation) {
        this.operation = operation;
    }

    public double calculate(double num1, double num2) {
        return operation.apply(num1, num2);
    }
}

