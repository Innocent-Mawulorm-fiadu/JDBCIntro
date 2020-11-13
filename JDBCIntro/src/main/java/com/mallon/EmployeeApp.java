package com.mallon;

import java.util.List;

public class EmployeeApp {
    public static void main(String[] args) {
        List<Employee> listOfEmployees;
        EmployeeController employeeCtrl = new EmployeeController();
        listOfEmployees = employeeCtrl.getAllEmployees();
        for( Employee e : listOfEmployees){
            System.out.println(e);
        }

        //System.out.println("***** Creating a new employee****");
        //employeeCtrl.createEmployee("Valttari", "Bottas", 31);
        //System.out.println(employeeCtrl.getAllEmployees());

        //System.out.println("***** Deleting an employee****");
        //employeeCtrl.deleteEmployee("Valttari", "Bottas");
        //System.out.println(employeeCtrl.getAllEmployees());


        
    }
}
