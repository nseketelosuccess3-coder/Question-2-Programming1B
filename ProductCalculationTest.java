package productapp.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import productapp.ProductCalculations;

/**
 * Unit tests for the ProductCalculations class (Q.2.6), using the price from the sample (R3500).
 */
class ProductCalculationsTest {

    private ProductCalculations calculations;

    @BeforeEach
    void setUp() {
        calculations = new ProductCalculations(3500);
    }

    @Test
    void GetVat_WithValidData_ReturnsCorrectValue() {
        assertEquals(525.0, calculations.GetVat(), 0.001);
    }

    @Test
    void GetTotal_WithValidData_ReturnsCorrectValue() {
        assertEquals(4200.0, calculations.GetTotal(), 0.001);
    }
}/*
 
public class ProductCalculationTest {
    
}
