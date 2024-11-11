/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/05/2024
 * File Name: CustomerDataViaUsb.java
 * Description:This interface is responsible for the methods/attributes of a legacy USB Data system.
 */

package edu.bu.met.cs665.legacysystemfacilitate;

/**
 * CustomerDataViaUsb interface provides methods to accessing and printing customer data
 * from the legacy system via USB connection to external drive.
 */
public interface CustomerDataViaUsb {

  /**
   * Prints customer data using the legacy system's USB connection.
   *
   * @param customer The customer object being access via usb.
   */
  void printCustomerViaUsb(Customer customer);

  /**
   * Retrieves a customer object with customer ID, name, and connection type.
   *
   * @param customerId     The ID of the customer.
   * @param name           The name of the customer.
   * @param connectionType The type of connection (e.g., USB).
   * @return Customer object with id,name,account type, and connection type
   */
  Customer getCustomerViaUsb(int customerId, String name, String connectionType);
}
