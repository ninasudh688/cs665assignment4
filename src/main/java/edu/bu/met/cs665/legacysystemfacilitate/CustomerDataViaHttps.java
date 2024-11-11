/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/05/2024
 * File Name: CustomerDataViaHttps.java
 * Description:This interface is responsible for the methods/attributes of a Https New system.
 */

package edu.bu.met.cs665.legacysystemfacilitate;

/**
 * CustomerDataViaHttps interface provides methods to access and print customer data
 * from the new system using HTTPS connection.
 * It is the New System & the Target interface in the Adapter pattern.
 */
public interface CustomerDataViaHttps {
  /**
   * Prints customer data in a format compatible with the new system.
   *
   * @param customer Customer data object being accessed.
   */
  void printCustomer(Customer customer);

  /**
   * Retrieves a customer object based on ID, name, and connection type using HTTPS.
   *
   * @param customerId     The ID of the customer.
   * @param name           The name of the customer.
   * @param connectionType The type of connection (e.g. HTTPS).
   * @return Customer object with ID, name,account type and connection type
   */
  Customer getCustomerViaHttps(int customerId, String name, String connectionType);

}
