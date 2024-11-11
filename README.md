| CS-665       | Software Design & Patterns |
|--------------|----------------------------|
| Name         | Nina Sudheesh              |
| Date         | 11/04/2024                 |
| Course       | Fall                       |
| Assignment # | 4                          |

# Assignment Overview

- The goal of the assignment is to create a system while using a design pattern that facilitates
  integration of the connection of the old legacy USB system by using the new HTTPS system to access customer data
in the systems.
- The legacy system retrieves customer data by connecting to external disks via a USB connection  whereas 
the new system retrieves customer data with a HTTPS connection , REST API , and external server.
- The system wants something to allow these system to interact to acess customer data without removing 
or making major changes to old USB system. It is also used to prevent replacing the legacy system with the new system.

 
 # GitHub Repository Link:

https://github.com/ninasudh688/cs665assignment4

# Implementation Description

- The implementation has been kept simple and easy to understand by organizing the code.
    - The interfaces (CustomerDataViaUsb, CustomerDataViaHttps) helps to organize the code logically, ensuring a clean
      separation of concerns.
    - The customer data and system integration are separate following the Adapter Pattern,
      which separates the responsibilities of the legacy system and the new system.
        - This helps to make sure that each system remains decoupled. The DataAdapter class serves as a middleman that,
          adapts the USB data to the HTTPS system's interface without modifying either system's core logic.
    - Each class serves a distinct job making it easy for others to read and maintain.
    - This separation of the classes' roles helps make the code more readable.
    - Also, all the code is documented with doc-blocks that explain each method/class's purpose.


- I chose the Adapter Pattern-Here is how I Set up the classes:
    - CustomerDataViaHttps.js = Target Interface
    - LegacySystemCustomerData.js = Adaptee class implements CustomerDataViaUsb.js
    - CustomerDataViaUsb.js = LegacySystemCustomerData class's interface
    - Main.js = Client class
    - Customer.js = class contains customer data being accessed.
    - DataAdapter.js = Adapter class
        - It has composition relationship with CustomerDataViaUsb interface since you need to adapt it to
          the CustomerDataViaHttps interface
        - DataAdapter has an instance of CustomerDataViaUsb interface in it.


- I chose the DataAdapter Pattern because the problem requires translating or adapting between 2 different systems
    - This pattern is useful when converts the interface of a class into another interface that clients expect
      by creating a compatible interface.
      By using the adapter, we gain flexibility in managing the behavior between these two systems.
    - Without the usage of this pattern, there would be code duplication, and more changes to both system code to
      translate logic between CustomerDataViaUsb and CustomerDataViaHttps would need to be written in multiple places.
    - The pattern also allows for reuse of the adapter in any similar situations where legacy and new systems
      need to communicate, without modifying either system.
    - It also favors composition over inheritance, which helps increase flexibility by allowing classes to be reused.
    - Also, the pattern allows for centralized changes to the adaptation logic.
        - If the legacy interface changes, only the adapter needs to be updated,
          and all clients using the adapter will automatically benefit from the changes without affecting other parts of
          system.


- The implementation is designed with future flexibility in mind.
    - The design pattern allowing the new system to work with the legacy interface
      without modification to either system’s core logic.
    - It also works, if a new data source or customer type needs to be added, only a new adapter is needed,
      without modifying the core logic.

- Code duplication has been carefully avoided:
    - The CustomerDataViaUsb/CustomerDataViaHttps interface sets up 2 methods for printing and getting customerdata
      that is implemented by the Data Adapter class.
        - This prevents duplication by centralizing the conversion logic within the adapter,
          so there’s no need to duplicate logic across other classes.
        - Therefore, the client class (Main) does not handle redundant details related to both system interfaces.
    - The Adapter pattern helped ensure that you don't need to update multiple places in the code when modification
      occurs which keeps the code D.R.Y as well easier to debug.
    - The DataAdapter class centralizes the interaction between the legacy and new systems, so any changes
      to the logic are handled in one place, to make it easy future updates and maintenance.


- Assumptions that I made:
    - I assumed that each customer has name, id, account type, and connection type.
      -I assumed that there are different type of customer such as VIP which why customer have
      an account type and that system should keep track of connection/system type.
    - I assumed that the legacy system provides a basic way for retrieving and printing customer data,

# Running My Code And UML:

- I placed my UML diagram in cs665_assignment4_UMLDiagram_Sudheesh.PDF within this zipped folder
- I placed my code in package legacysystemfacilitate under the edu.bu.met.cs665 package.
- The Main class is outside this package - Its acting as the Client class in Adapter pattern.
- I tested my code using junit tests by using a JUnit test class TestAdapterSystem in the test package.
- The code compiles using mvn clean compile.

# Maven Commands

We'll use Apache Maven to compile and run this project. You'll need to install Apache Maven (https://maven.apache.org/)
on your system.

Apache Maven is a build automation tool and a project management tool for Java-based projects. Maven provides a
standardized way to build, package, and deploy Java applications.

Maven uses a Project Object Model (POM) file to manage the build process and its dependencies. The POM file contains
information about the project, such as its dependencies, the build configuration, and the plugins used for building and
packaging the project.

Maven provides a centralized repository for storing and accessing dependencies, which makes it easier to manage the
dependencies of a project. It also provides a standardized way to build and deploy projects, which helps to ensure that
builds are consistent and repeatable.

Maven also integrates with other development tools, such as IDEs and continuous integration systems, making it easier to
use as part of a development workflow.

Maven provides a large number of plugins for various tasks, such as compiling code, running tests, generating reports,
and creating JAR files. This makes it a versatile tool that can be used for many different types of Java projects.

## Compile

Type on the command line:

```bash
mvn clean compile
```

## JUnit Tests

JUnit is a popular testing framework for Java. JUnit tests are automated tests that are written to verify that the
behavior of a piece of code is as expected.

In JUnit, tests are written as methods within a test class. Each test method tests a specific aspect of the code and is
annotated with the @Test annotation. JUnit provides a range of assertions that can be used to verify the behavior of the
code being tested.

JUnit tests are executed automatically and the results of the tests are reported. This allows developers to quickly and
easily check if their code is working as expected, and make any necessary changes to fix any issues that are found.

The use of JUnit tests is an important part of Test-Driven Development (TDD), where tests are written before the code
they are testing is written. This helps to ensure that the code is written in a way that is easily testable and that all
required functionality is covered by tests.

JUnit tests can be run as part of a continuous integration pipeline, where tests are automatically run every time
changes are made to the code. This helps to catch any issues as soon as they are introduced, reducing the need for
manual testing and making it easier to ensure that the code is always in a releasable state.

To run, use the following command:

```bash
mvn clean test
```

## Spotbugs

SpotBugs is a static code analysis tool for Java that detects potential bugs in your code. It is an open-source tool
that can be used as a standalone application or integrated into development tools such as Eclipse, IntelliJ, and Gradle.

SpotBugs performs an analysis of the bytecode generated from your Java source code and reports on any potential problems
or issues that it finds. This includes things like null pointer exceptions, resource leaks, misused collections, and
other common bugs.

The tool uses data flow analysis to examine the behavior of the code and detect issues that might not be immediately
obvious from just reading the source code. SpotBugs is able to identify a wide range of issues and can be customized to
meet the needs of your specific project.

Using SpotBugs can help to improve the quality and reliability of your code by catching potential bugs early in the
development process. This can save time and effort in the long run by reducing the need for debugging and fixing issues
later in the development cycle. SpotBugs can also help to ensure that your code is secure by identifying potential
security vulnerabilities.

Use the following command:

```bash
mvn spotbugs:gui 
```

For more info see
https://spotbugs.readthedocs.io/en/latest/maven.html

SpotBugs https://spotbugs.github.io/ is the spiritual successor of FindBugs.

## Checkstyle

Checkstyle is a development tool for checking Java source code against a set of coding standards. It is an open-source
tool that can be integrated into various integrated development environments (IDEs), such as Eclipse and IntelliJ, as
well as build tools like Maven and Gradle.

Checkstyle performs static code analysis, which means it examines the source code without executing it, and reports on
any issues or violations of the coding standards defined in its configuration. This includes issues like code style,
code indentation, naming conventions, code structure, and many others.

By using Checkstyle, developers can ensure that their code adheres to a consistent style and follows best practices,
making it easier for other developers to read and maintain. It can also help to identify potential issues before the
code is actually run, reducing the risk of runtime errors or unexpected behavior.

Checkstyle is highly configurable and can be customized to fit the needs of your team or organization. It supports a
wide range of coding standards and can be integrated with other tools, such as code coverage and automated testing
tools, to create a comprehensive and automated software development process.

The following command will generate a report in HTML format that you can open in a web browser.

```bash
mvn checkstyle:checkstyle
```

The HTML page will be found at the following location:
`target/site/checkstyle.html`




