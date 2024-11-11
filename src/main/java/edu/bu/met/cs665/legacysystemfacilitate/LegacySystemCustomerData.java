/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/08/2024
 * File Name: LegacySystemCustomerData.java
 * Description:
 * This class is responsible for implementing the usb interface for customer data accessed via USB.
 */

package edu.bu.met.cs665.legacysystemfacilitate;

/**
 * The legacy system is the adaptee and interacts with customer data via USB.
 * It implements 2 methods to print customer data and get customer details from a legacy
 * USB storage system so that its compatible with adapter.
 */
public class LegacySystemCustomerData implements CustomerDataViaUsb {

  /**
   * Prints customer data fetched from USB based on customerId.
   *
   * @param customer customer object containing all customer details to be printed
   */
  @Override
  public void printCustomerViaUsb(Customer customer) {
    System.out.println("\nCustomer data  for customer ID: " + customer.getCustomerId()
        + " fetched from legacy USB system:");
    System.out.println("Customer ID: " + customer.getCustomerId());
    System.out.println("Name: " + customer.getName());
    System.out.println("Account Type: " + customer.getAccountType());
    System.out.println("Connection Type: " + customer.getConnectionType());
  }

  /**
   * Retrieves a Customer object to simulate fetching from usb.
   *
   * @param customerId     The ID of the customer to get.
   * @param name           The name of the customer.
   * @param connectionType The type of connection used (e.g., USB /HTTPS).
   * @return A Customer object with specified details.
   */
  @Override
  public Customer getCustomerViaUsb(int customerId, String name, String connectionType) {
    System.out.println("Fetching customer data from legacy USB "
        + "system for customer ID: " + customerId);
    String accountType = (customerId % 2 == 0) ? "VIP" : "Standard";
    return new Customer(customerId, name, accountType, connectionType);
  }
}


