/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/07/2024
 * File Name: Customer.java
 * Description:
 * This class is responsible for the methods/attributes of a Customer.
 */

package edu.bu.met.cs665.legacysystemfacilitate;


/**
 * Customer class represents all information about customer being transferred.
 */
public class Customer {
  private final int customerId;
  private String name;
  private String accountType;
  private String connectionType;

  /**
   * Constructs a Customer object with the id,name,account type,and connection type.
   *
   * @param customerId     The unique identifier of the customer.
   * @param name           The name of the customer.
   * @param accountType    The type of account (e.g., VIP or Standard).
   * @param connectionType The type of connection used for data access.
   */
  public Customer(int customerId, String name, String accountType, String connectionType) {
    this.customerId = customerId;
    this.name = name;
    this.accountType = accountType;
    this.connectionType = connectionType;
  }

  /**
   * Retrieves the customer's unique identifier.
   *
   * @return The customer ID.
   */
  public int getCustomerId() {
    return customerId;
  }

  /**
   * Retrieves the name of the customer.
   *
   * @return The name of the customer.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the customer.
   *
   * @param name The name of the customer.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Retrieves the type of account associated with the customer.
   *
   * @return The account type, such as "VIP" .
   */
  public String getAccountType() {
    return accountType;
  }

  /**
   * Sets the account type for the customer.
   *
   * @param accountType The type of account to assign to the customer.
   */
  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }

  /**
   * Retrieves the type of connection used to access customer data.
   *
   * @return The connection type, such as "USB" or "HTTPS."
   */
  public String getConnectionType() {
    return connectionType;
  }

  /**
   * Sets the connection type used to access customer data.
   *
   * @param connectionType The type of connection to assign to the customer.
   */
  public void setConnectionType(String connectionType) {
    this.connectionType = connectionType;
  }

  /**
   * Returns a string representation of the Customer object attributes.
   *
   * @return A formatted string of customer details.
   */
  @Override
  public String toString() {
    return "Customer ID: " + customerId + ", Name: " + name + ", "
        + "Account Type: " + accountType + ", Connection Type: " + connectionType;
  }


}


