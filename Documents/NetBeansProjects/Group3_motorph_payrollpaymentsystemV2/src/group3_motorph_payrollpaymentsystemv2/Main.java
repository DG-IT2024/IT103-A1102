/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group3_motorph_payrollpaymentsystemv2;

import group3_motorph_payrollpaymentsystemV2.Employee;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author danilo
 */
public class Main {

    public static void main(String args[]) throws FileNotFoundException, IOException {

        new EmployeeProfile().setVisible(true);
    }

     private static void printEmployees(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println("no." + employee.getEmployeeNumber() + "  " + employee.getLastName() + " ," + employee.getFirstName());

        }
    }

  
}
