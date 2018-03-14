package com.RevCo.DAO;

import com.RevCo.Model.Employee;
import com.RevCo.Utilities.DAOUtilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO
{
    Connection connection = null;    // Our connection to the database
    PreparedStatement stmt = null;
    ResultSet rs = null;

    //    public static void main(String[] args)
//    {
//        EmployeeDAOImpl com.RevCo.test = new EmployeeDAOImpl();
//        Employee tester = new Employee();
//        tester = com.RevCo.test.getEmployeeById(2);
//        System.out.println(tester.toString());
//    }
    @Override
    public List<Employee> getAllEmployee()
    {
        List<Employee> emps = new ArrayList<>();
        try
        {
            connection = DAOUtilities.getConnection();
            String sql = "SELECT id,first_name,last_name,dept_id,mgr_id," +
                    "reimbursment_summary,Username,Password FROM Employee";
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next())
            {
                Employee emp = new Employee();
                emp.setId(rs.getInt("id"));
                emp.setFirstName(rs.getString("first_name"));
                emp.setLastName(rs.getString("last_name"));
                emp.setManager(rs.getInt("mgr_id"));
                emp.setDept(rs.getInt("dept_id"));
                emp.setUserName(rs.getString("Username"));
                emp.setPassword(rs.getString("Password"));
                emp.setReimbursement(rs.getFloat("Reimbursment_Summary"));

                emps.add(emp);
            }
            rs.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            closeResources();
        }
        return emps;
    }

    @Override
    public List<Employee> getAllEmployeeByDept(int dept)
    {
        List<Employee> emps = new ArrayList<>();
        try
        {
            connection = DAOUtilities.getConnection();
            String sql = "SELECT id,first_name,last_name,dept_id,mgr_id," +
                    "reimbursement_summary,Username,Password FROM Employee WHERE " +
                    "dept_id = ?";

            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, dept);
            rs = stmt.executeQuery();
            while (rs.next())
            {
                Employee emp = new Employee();
                emp.setId(rs.getInt("id"));
                emp.setFirstName(rs.getString("first_name"));
                emp.setLastName(rs.getString("last_name"));
                emp.setManager(rs.getInt("mgr_id"));
                emp.setDept(rs.getInt("dept_id"));
                emp.setUserName(rs.getString("Username"));
                emp.setPassword(rs.getString("Password"));
                emp.setReimbursement(rs.getFloat("Reimburement_Summary"));

                emps.add(emp);
            }
            rs.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            closeResources();
        }
        return emps;
    }

    @Override
    public List<Employee> getAllEmployeeByMgrId(int mgr)
    {
        List<Employee> emps = new ArrayList<>();
        try
        {
            connection = DAOUtilities.getConnection();
            String sql = "SELECT id,first_name,last_name,dept_id,mgr_id," +
                    "reimbursment_summary,Username,Password FROM Employee WHERE " +
                    "mgr_id = ? AND employee.id != ?";

            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, mgr);
            stmt.setInt(2, mgr);
            rs = stmt.executeQuery();
            while (rs.next())
            {
                Employee emp = new Employee();
                emp.setId(rs.getInt("id"));
                emp.setFirstName(rs.getString("first_name"));
                emp.setLastName(rs.getString("last_name"));
                emp.setManager(rs.getInt("mgr_id"));
                emp.setDept(rs.getInt("dept_id"));
                emp.setUserName(rs.getString("Username"));
                emp.setPassword(rs.getString("Password"));
                emp.setReimbursement(rs.getFloat("Reimbursment_Summary"));

                emps.add(emp);
            }
            rs.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            closeResources();
        }
        return emps;
    }

    @Override
    public Employee getManagerByEmployeeId(int emp_id)
    {
        Employee emp = new Employee();
        int mgr_id = 0;
        try
        {
            connection = DAOUtilities.getConnection();
            String sql ="";
            sql = "SELECT concat(e.first_name,' ', e.last_name) AS Employee, e.id, " +
                    "concat(m.first_name,' ', m.last_name) AS manager, m.id AS manage_id " +
                    "FROM employee e, employee m " +
                    "WHERE e.mgr_id = m.id AND e.id != m.id AND e.id = ?";


            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, emp_id);
            rs = stmt.executeQuery();

            while (rs.next())
            {
                mgr_id = rs.getInt("manage_id");
            }

            sql = ("SELECT id,first_name,last_name,dept_id,mgr_id," +
                    "reimbursment_summary,username,password FROM employee WHERE " +
                    "id = ?");

            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, mgr_id);
            rs = stmt.executeQuery();

            while (rs.next())
            {

                emp.setId(rs.getInt("id"));
                emp.setFirstName(rs.getString("first_name"));
                emp.setLastName(rs.getString("last_name"));
                emp.setManager(rs.getInt("mgr_id"));
                emp.setDept(rs.getInt("dept_id"));
                emp.setUserName(rs.getString("Username"));
                emp.setPassword(rs.getString("Password"));
                emp.setReimbursement(rs.getFloat("Reimbursment_Summary"));


            }
            rs.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            closeResources();
        }

        return emp;
    }

    @Override
    public String getDeptByDeptId(int i){
        String dept = "";
        try
        {
            connection = DAOUtilities.getConnection();
            String sql = ("SELECT dept_name FROM dept, employee WHERE dept.id = ?");

            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, i);
            rs = stmt.executeQuery();

            while (rs.next())
            {

            dept = rs.getString("dept_name");

            }
            rs.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            closeResources();
        }

        return dept;
    }

    @Override
    public Employee getEmployeeById(int id)
    {
        Employee emp = new Employee();
        try
        {
            connection = DAOUtilities.getConnection();
            String sql = ("SELECT id,first_name,last_name,dept_id,mgr_id," +
                    "reimbursment_summary,username,password FROM employee WHERE " +
                    "id = ?");

            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next())
            {

                emp.setId(rs.getInt("id"));
                emp.setFirstName(rs.getString("first_name"));
                emp.setLastName(rs.getString("last_name"));
                emp.setManager(rs.getInt("mgr_id"));
                emp.setDept(rs.getInt("dept_id"));
                emp.setUserName(rs.getString("Username"));
                emp.setPassword(rs.getString("Password"));
                emp.setReimbursement(rs.getFloat("Reimbursment_Summary"));


            }
            rs.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            closeResources();
        }

        return emp;
    }

    @Override
    public Employee getEmployeeByUsername(String Username)
    {
        ResultSet rs = null;
        Employee emp = new Employee();

        try
        {

            connection = DAOUtilities.getConnection();
            String sql = ("SELECT employee.id,first_name,last_name,dept_id,mgr_id," +
                    "reimbursment_summary,username,password FROM employee WHERE username = ?");

            stmt = connection.prepareStatement(sql);
            stmt.setString(1, Username);
            rs = stmt.executeQuery();

            while (rs.next())
            {

                emp.setId(rs.getInt("id"));
                emp.setFirstName(rs.getString("first_name"));
                emp.setLastName(rs.getString("last_name"));
                emp.setManager(rs.getInt("mgr_id"));
                emp.setDept(rs.getInt("dept_id"));
                emp.setReimbursement(rs.getFloat("reimbursment_summary"));
                emp.setUserName(rs.getString("Username"));
                emp.setPassword(rs.getString("Password"));



            }

            rs.close();
            return emp;
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            closeResources();
        }

        return emp;
    }

    @Override
    public boolean setEmployeeReview(int empId, int formId, Date formDate)
    {
        String sql = "";

        try
        {
            connection = DAOUtilities.getConnection();

            sql = "INSERT INTO manager_form_junction(emp_id,form_id,approval_date) SELECT ?,?,? FROM employee WHERE id = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, empId);
            stmt.setInt(2, formId);
            stmt.setDate(3, formDate);
            stmt.setInt(4, empId);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            closeResources();
        }
        return false;
    }

    @Override
    public boolean addEmployee(String username, String password)
    {


        String sql = "";

        try
        {
            connection = DAOUtilities.getConnection();

            sql = "INSERT INTO employee(first_name,last_name, dept_id,mgr_id,reimbursment_summary,username,password)" +
                    "VALUES('CODE', 'SUCCESS', 1, 1, 0,?,?)";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            closeResources();
        }
        return false;
    }

    @Override
    public boolean addDept()
    {
        return false;
    }

    @Override
    public boolean updateEmployee(int empId, float reimbursement)
    {
        try
        {
            connection = DAOUtilities.getConnection();
            String sql = "UPDATE employee SET reimbursment_summary = ? WHERE employee.id = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setFloat(1, reimbursement);
            stmt.setInt(2, empId);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            closeResources();
        }
        return false;
    }

    private void closeResources()
    {
        try
        {
            if (stmt != null)
                stmt.close();
        } catch (SQLException e)
        {
            System.out.println("Could not close statement!");
            e.printStackTrace();
        }

        try
        {
            if (connection != null)
                connection.close();
        } catch (SQLException e)
        {
            System.out.println("Could not close connection!");
            e.printStackTrace();
        }
    }
}

