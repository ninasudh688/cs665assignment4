/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/06/2024
 * File Name: DataAdapter.java
 * Description:
 * This class is responsible for the methods/attributes of an adapter class.
 * It is used to allow the new HTTPS system interface to interact with the USB interfaces.
 * It adapts the method calls to ensure compatibility between the two interfaces.
 */

package edu.bu.met.cs665.legacysystemfacilitate;

/**
 * DataAdapter adapts CustomerDataViaUsb to be facilitated with  CustomerDataViaHttps interface.
 * It also implements the 2 methods of the new Https interface.
 */
public class DataAdapter implements CustomerDataViaHttps {
  private CustomerDataViaUsb adaptee;

  /**
   * Creates an DataAdapter object with a legacy system interface.
   *
   * @param adaptee The legacy CustomerDataViaUsb system to adapt.
   */
  public DataAdapter(CustomerDataViaUsb adaptee) {
    this.adaptee = adaptee;
  }

  /**
   * adapts a customer with HTTPS to usb by calling legacy USB system's method.
   *
   * @param customerId     The ID of the customer to retrieve.
   * @param name           The name of the customer to retrieve.
   * @param connectionType The type of connection used (e.g., USB).
   * @return Customer object from legacy system with id, name, account type & connection type.
   */
  @Override
  public Customer getCustomerViaHttps(int customerId, String name, String connectionType) {
    System.out.println("Getting customer data via HTTPS Adapter");
    return adaptee.getCustomerViaUsb(customerId, name, connectionType);
  }

  /**
   * Prints customer data using the USB system's method.
   *
   * @param customer The customer object retrieved to be printed.
   */
  @Override
  public void printCustomer(Customer customer) {
    adaptee.printCustomerViaUsb(customer);
  }
}


