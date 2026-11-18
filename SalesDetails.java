package productapp;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Builds the sale summary text and saves it to data.txt (Q.2.3).
 */
public class SaleDetails {

    private static final String FILE_NAME = "data.txt";
    private static final String LINE = "*".repeat(30);

    private final String customerName;
    private final String productName;
    private final IProductCalculations calculations;

    public SaleDetails(String customerName, String productName, IProductCalculations calculations) {
        this.customerName = customerName;
        this.productName = productName;
        this.calculations = calculations;
    }

    /** Text shown in the Message Box. */
    public String toMessage() {
        return "Customer Name: " + customerName
                + "\nProduct: " + productName
                + "\nVAT: R " + calculations.GetVat()
                + "\nCOMMISSION: R " + calculations.GetCommission()
                + "\nTOTAL: R " + calculations.GetTotal();
    }

    /** Appends this sale to data.txt in the layout of the sample. */
    public void saveToFile() throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME, true))) {
            writer.println("DATA LOG");
            writer.println(LINE);
            writer.println(toMessage());
            writer.println(LINE);
            writer.println();
        }
    }
}/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */
public class SalesDetails {
    
}
package productapp;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Builds the sale summary text and saves it to data.txt (Q.2.3).
 */
public class SaleDetails {

    private static final String FILE_NAME = "data.txt";
    private static final String LINE = "*".repeat(30);

    private final String customerName;
    private final String productName;
    private final IProductCalculations calculations;

    public SaleDetails(String customerName, String productName, IProductCalculations calculations) {
        this.customerName = customerName;
        this.productName = productName;
        this.calculations = calculations;
    }

    /** Text shown in the Message Box. */
    public String toMessage() {
        return "Customer Name: " + customerName
                + "\nProduct: " + productName
                + "\nVAT: R " + calculations.GetVat()
                + "\nCOMMISSION: R " + calculations.GetCommission()
                + "\nTOTAL: R " + calculations.GetTotal();
    }

    /** Appends this sale to data.txt in the layout of the sample. */
    public void saveToFile() throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME, true))) {
            writer.println("DATA LOG");
            writer.println(LINE);
            writer.println(toMessage());
            writer.println(LINE);
            writer.println();
        }
    }
}