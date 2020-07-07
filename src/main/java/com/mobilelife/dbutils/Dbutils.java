package com.mobilelife.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbutils {


    private static Connection connection = null;

    public static Connection getConnection() {
        try  {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/telco","root","root");
            return con;
        }
        catch(Exception ex) {
            System.out.println("Database.getConnection() Error -->" + ex.getMessage());
            return null;
        }
    }

     public static void close(Connection con) {
        try  {
            con.close();
        }
        catch(Exception ex) {
        		ex.printStackTrace();
        }
    }
  }
