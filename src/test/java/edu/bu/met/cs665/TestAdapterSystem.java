/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/09/2024
 * File Name: TestAdapterSystem.java
 * Description: This class is responsible for testing methods/classes for adapter system.
 */

package edu.bu.met.cs665;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.bu.met.cs665.legacysystemfacilitate.Customer;
import edu.bu.met.cs665.legacysystemfacilitate.CustomerDataViaHttps;
import edu.bu.met.cs665.legacysystemfacilitate.CustomerDataViaUsb;
import edu.bu.met.cs665.legacysystemfacilitate.DataAdapter;
import edu.bu.met.cs665.legacysystemfacilitate.LegacySystemCustomerData;

/**
 * Junit test for my program
 */

public class TestAdapterSystem {
  public TestAdapterSystem() {
  }

  @Test
  public void testPrintCustomerViaUsb() {
    // Given: A legacy system instance and a customer with USB connection type
    CustomerDataViaUsb legacySystem = new LegacySystemCustomerData();
    Customer customer = new Customer(1, "Anice", "Standard",
        "USB");

    // When: The customer details are printed via USB
    legacySystem.printCustomerViaUsb(customer);

    // Then: Verify that the connection type is USB
    assertEquals("USB", customer.getConnectionType());
  }

  @Test
  public void testGetCustomerViaUsb() {
    // Given: A legacy system instance to retrieve customer data
    CustomerDataViaUsb legacySystem = new LegacySystemCustomerData();

    // When: A customer with ID 2 is retrieved via USB
    Customer customer = legacySystem.getCustomerViaUsb(2,
        "Dylan", "USB");

    // Then: Check the customer's ID, name, and account type
    assertEquals(2, customer.getCustomerId());
    assertEquals("Dylan", customer.getName());
    assertEquals("VIP", customer.getAccountType());
  }

  @Test
  public void testGetCustomerViaHttps() {
    // Given: A legacy system and an adapter to convert data for HTTPS connection
    CustomerDataViaUsb legacySystem = new LegacySystemCustomerData();
    CustomerDataViaHttps adapter = new DataAdapter(legacySystem);

    // When: A customer is retrieved via HTTPS using the adapter
    Customer customer = adapter.getCustomerViaHttps(3,
        "Carol", "HTTPS");

    // Then: Verify the customer's details, account type, and connection type
    assertEquals(3, customer.getCustomerId());
    assertEquals("Carol", customer.getName());
    assertEquals("Standard", customer.getAccountType());
    assertEquals("HTTPS", customer.getConnectionType());
  }

  @Test
  public void testPrintCustomerViaHttps() {
    // Given: A customer with a VIP account and HTTPS connection using the adapter
    CustomerDataViaUsb legacySystem = new LegacySystemCustomerData();
    CustomerDataViaHttps adapter = new DataAdapter(legacySystem);
    Customer customer = new Customer(4, "Diana",
        "VIP", "HTTPS");

    // When: The customer details are printed via HTTPS
    adapter.printCustomer(customer);

    // Then: Verify that the customer's connection type is HTTPS
    assertEquals("HTTPS", customer.getConnectionType());
  }



}
