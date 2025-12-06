package com.employeemanagement.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is the main entry point of the project.
 */
@SpringBootApplication
public class EmployeeManagementBackend1Application {

    /**
     * Runs the main application.
     *
     * @param args The args.
     */
    public final void run(final String[] args) {
        SpringApplication.run(EmployeeManagementBackend1Application.class,
                args);
    }
  /**
  * main class.
  *
  * @param args default arguments.
  */
  public static void main(final String[] args) {
    new EmployeeManagementBackend1Application().run(args);
  }

}
