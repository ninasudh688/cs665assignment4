/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/04/2024
 * File Name: Main.java
 * Description:
 * This class is responsible for acting as Client class to demonstrate the Adapter pattern.
 * It uses the Adapter to request customer info from legacy system/USB via the new system/https.
 * Its also to test outside JUnits.
 */

package edu.bu.met.cs665;

import edu.bu.met.cs665.legacysystemfacilitate.Customer;
import edu.bu.met.cs665.legacysystemfacilitate.CustomerDataViaHttps;
import edu.bu.met.cs665.legacysystemfacilitate.CustomerDataViaUsb;
import edu.bu.met.cs665.legacysystemfacilitate.DataAdapter;
import edu.bu.met.cs665.legacysystemfacilitate.LegacySystemCustomerData;

/**
 * This is the Main class/"Client" class.
 */
public class Main {

  /**
   * A main method to run examples.
   * You may use this method for development purposes as you start building your
   * assignments/final project.  This could prove convenient to test as you are developing.
   * However, please note that every assignment/final projects requires JUnit tests.
   */
  public static void main(String[] args) {
    System.out.println("This is a message for Client/ Main class (aka  Main.java file)");
    System.out.println("---------------------------------------------");
    // Simulate the legacy (USB interface).
    CustomerDataViaUsb legacyData = new LegacySystemCustomerData();
    // Use the adapter to make the legacy system work with the new system.
    CustomerDataViaHttps customerAdapter = new DataAdapter(legacyData);
    // Set up customer details for the new system.
    Customer customer = customerAdapter.getCustomerViaHttps(1, "Alice",
        "USB to https");
    //    System.out.println(customer);
    // Print customer details using the legacy system
    customerAdapter.printCustomer(customer);
  }

}
