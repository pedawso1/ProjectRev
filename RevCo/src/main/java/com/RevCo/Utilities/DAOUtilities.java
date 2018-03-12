package com.RevCo.Utilities;

import com.RevCo.DAO.EmployeeDAO;
import com.RevCo.DAO.EmployeeDAOImpl;
import com.RevCo.DAO.FormDAO;
import com.RevCo.DAO.FormDAOImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DAOUtilities
{

    private static final String url = "jdbc:postgresql://pdawson-db.cica0meynnvy.us-east-2.rds.amazonaws.com/Rev.Co";
    private static final String username = "pdawson2090";
    private static String password;
    static BufferedReader in;
    private static Connection connection;

    public static synchronized Connection getConnection() throws SQLException
    {
        if (connection == null)
        {
            try
            {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e)
            {
                System.out.println("Could not register driver!");
                e.printStackTrace();
            }
            try
            {

                in = new BufferedReader(new FileReader(new File("C:/Program Files/Git/my_git_repos/1802_Feb5_Java/RevCo/src/main/resources/Secure/doc1.txt")));
                password = in.readLine();
                connection = DriverManager.getConnection(url, username, password);
                System.out.println("Connection Established");

            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        //If connection was closed then retrieve a new connection
        if (connection.isClosed())
        {
            System.out.println("Opening new connection...");
            connection = DriverManager.getConnection(url,username,password);
        }
        return connection;
    }

    public static EmployeeDAO getEmployeeDAO()
    {
        return new EmployeeDAOImpl();
    }

    public static FormDAO getFormDAO()
    {
        return new FormDAOImpl();
    }
}