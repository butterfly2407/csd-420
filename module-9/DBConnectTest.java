/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 18038
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectTest {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/databasedb";
        String user = "student1";
        String password = "pass";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Succesfully connected");
            conn.close();
        } catch (SQLException e) {
            System.out.println("Umable to connect");
            e.printStackTrace();
        }
    }
}

