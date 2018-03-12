package com.RevCo.Controller;

import com.RevCo.DAO.EmployeeDAOImpl;
import com.RevCo.Model.Employee;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;


public class Validation
{

    private static EmployeeDAOImpl eDAO = new EmployeeDAOImpl();
    private Employee user;
    private static Argon2 argon2 = Argon2Factory.create();


    public boolean logins(String username, String pass)
    {

        user = eDAO.getEmployeeByUsername(username);
        try
        {
            if (user.getUserName().equals(username))
            {

                // Verify password
                if (argon2.verify(user.getPassword(),pass))
                {
                    System.out.println("Login Success!");
                    return true;
                }else{
                    System.out.println("Invalid Login");
                }

            } else
            {
                System.out.println("Invalid Credentials");
                return false;
            }
        } catch (NullPointerException e)
        {
            System.out.println("Enter Credentials In Both Fields");
        } finally
        {

            //argon2.wipeArray(user.getPassword().toCharArray());
        }

        return false;
    }


}
