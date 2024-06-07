/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group3_motorph_payrollpaymentsystemV2;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Filehandling {

    // Method to read CSV file and return records
    public static List<String[]> readCSV(String csvFile) throws IOException {

        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            List<String[]> records = reader.readAll();
            // Assuming the first row is the header
            records.remove(0);
            System.out.print(records);
            
            return records;
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "File not found: " + csvFile, "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
            throw e; // rethrow the exception to indicate failure

        }
    }

    // Method to parse records into Employee objects
    public static List<Employee> parseRecords(List<String[]> records) {
        List<Employee> employees = new ArrayList<>();
        for (String[] record : records) {
            String employeeNumber = record[0];
            String lastName = record[1];
            String firstName = record[2];
            String employeeBirthday = record[3];
            String address = record[4];
            String phoneNumber = record[5];
            String sssNumber = record[6];
            String philHealthNumber = record[7];
            String tinNumber = record[8];
            String pagIbigNumber = record[9];
            String status = record[10];
            String position = record[11];
            String immediateSupervisor = record[12];
            String basicSalary = record[13];
            String riceSubsidy = record[14];
            String phoneAllowance = record[15];
            String clothingAllowance = record[16];

            Employee employee = new Employee(employeeNumber, lastName, firstName, employeeBirthday, address, phoneNumber, sssNumber, philHealthNumber, tinNumber, pagIbigNumber, status, position, immediateSupervisor, basicSalary, riceSubsidy, phoneAllowance, clothingAllowance);
            employees.add(employee);
        }
        return employees;
    }

    private static void printEmployees(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println("no." + employee.getEmployeeNumber() + "  " + employee.getLastName() + " ," + employee.getFirstName());

        }
    }

    public static void exportTableToCSV(JTable table) {
        String csvFile = "MotorPH_Update.csv";
        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFile))) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            // Write column headers
            int columnCount = model.getColumnCount();
            String[] columnNames = new String[columnCount];
            for (int i = 0; i < columnCount; i++) {
                columnNames[i] = model.getColumnName(i);
            }
            writer.writeNext(columnNames);

            // Write rows
            int rowCount = model.getRowCount();
            for (int i = 0; i < rowCount; i++) {
                String[] rowData = new String[columnCount];
                for (int j = 0; j < columnCount; j++) {
                    rowData[j] = model.getValueAt(i, j).toString();
                }
                writer.writeNext(rowData);
            }

             JOptionPane.showMessageDialog(null,"Database updated successfully");
        } catch (IOException e) {
             JOptionPane.showMessageDialog(null,"Failed to export data to CSV file.");
        }
    }
   

}
