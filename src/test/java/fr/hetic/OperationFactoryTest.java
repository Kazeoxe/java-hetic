package fr.hetic;
import fr.hetic.math.*;

import static org.junit.Assert.*;
import org.junit.Test;

public class OperationFactoryTest {

    @Test
    public void testCreateAddition() {
        Operation operation = OperationFactory.createOperation("+");
        assertTrue(operation instanceof Addition);
    }

    @Test
    public void testCreateSoustraction() {
        Operation operation = OperationFactory.createOperation("-");
        assertTrue(operation instanceof Soustraction);
    }

    @Test
    public void testCreateMultiplication() {
        Operation operation = OperationFactory.createOperation("*");
        assertTrue(operation instanceof Multiplication);
    }

}
