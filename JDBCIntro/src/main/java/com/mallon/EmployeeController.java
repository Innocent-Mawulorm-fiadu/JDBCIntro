package com.mallon;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeController {
        static{
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
            }
            catch( ClassNotFoundException e ){
                System.out.println(e);
            }
        }

        private String username = "root";
        private String password = "";
        private Connection con = null;

        public EmployeeController(){
            try{
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", this.username, this.password);
            } catch (SQLException e){
                e.printStackTrace();
            }
        }

        public List<Employee> getAllEmployees(){
            List<Employee> listOfEmployees = new ArrayList<>();
            ResultSet res = null;
            try{
                Statement stmt = null;
                stmt = con.createStatement();
                res =stmt.executeQuery("SELECT * FROM employees");
                Employee e;
                while (res.next()){
                    e = new Employee();
                    e.setAge(res.getInt(4));
                    e.setFirstName(res.getString(2));
                    e.setLastName(res.getString(3));
                    listOfEmployees.add(e);
                    }
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return listOfEmployees;
        }


        public boolean createEmployee(String firstname, String lastname, int age) {
            try{
                PreparedStatement stmt = null;
                stmt = con.prepareStatement("Insert into employees (firstname, lastname, age) values(?,?,?)");
                stmt.setString(1,firstname);
                stmt.setString(2,lastname);
                stmt.setInt(3,age);
                stmt.executeUpdate();
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return true;
        }


        public boolean deleteEmployee(String firstname, String lastname) {
            try{
                PreparedStatement stmt = null;
                stmt = con.prepareStatement("delete from employees where firstname= ? and lastname = ? ");
                stmt.setString(1, firstname);
                stmt.setString(2, lastname);
                stmt.executeUpdate();
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return true;
        }

    }


