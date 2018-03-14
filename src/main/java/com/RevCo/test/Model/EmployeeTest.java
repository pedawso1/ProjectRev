package com.RevCo.test.Model;

import com.RevCo.Model.Employee;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Employee Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Feb 25, 2018</pre>
 */
public class EmployeeTest
{
    Employee emp = new Employee();

@Test
public void testInit(){
    emp.setUserName("Sky2");
    Employee test = new Employee(emp.getUserName());
    assertEquals("Termi", test.getFirstName());
}
    /**
     * Method: getId()
     */
    @Test
    public void testGetId()
    {
        emp.setId(1);
        boolean checks = (emp.getId() == 1);
        assertTrue(checks);
    }

    /**
     * Method: setId(int id)
     */
    @Test
    public void testSetId()
    {
        emp.setId(1);
        boolean checks = (emp.getId() == 1);
        assertTrue(checks);
    }

    /**
     * Method: getFirstName()
     */
    @Test
    public void testGetFirstName()
    {
        emp.setFirstName("bob");
        boolean checks = (emp.getFirstName().equals("bob"));
        assertTrue(checks);
    }

    /**
     * Method: setFirstName(String firstName)
     */
    @Test
    public void testSetFirstName()
    {
        emp.setFirstName("bob");
        boolean checks = (emp.getFirstName().equals("bob"));
        assertTrue(checks);
    }

    /**
     * Method: getLastName()
     */
    @Test
    public void testGetLastName()
    {
        emp.setLastName("bob");
        boolean checks = (emp.getLastName().equals("bob"));
        assertTrue(checks);
    }

    /**
     * Method: setLastName(String lastName)
     */
    @Test
    public void testSetLastName()
    {
        emp.setLastName("bob");
        boolean checks = (emp.getLastName().equals("bob"));
        assertTrue(checks);
    }

    /**
     * Method: getUserName()
     */
    @Test
    public void testGetUserName()
    {
        emp.setUserName("bob");
        boolean checks = (emp.getUserName().equals("bob"));
        assertTrue(checks);
    }

    /**
     * Method: setUserName(String userName)
     */
    @Test
    public void testSetUserName()
    {
        emp.setUserName("bob");
        boolean checks = (emp.getUserName().equals("bob"));
        assertTrue(checks);
    }

    /**
     * Method: getPassword()
     */
    @Test
    public void testGetPassword()
    {
        emp.setPassword("bob");
        boolean checks = (emp.getPassword().equals("bob"));
        assertTrue(checks);
    }

    /**
     * Method: setPassword(String password)
     */
    @Test
    public void testSetPassword()
    {
        emp.setPassword("bob");
        boolean checks = (emp.getPassword().equals("bob"));
        assertTrue(checks);
    }

    /**
     * Method: getDept()
     */
    @Test
    public void testGetDept()
    {
        emp.setDept(1);
        boolean checks = (emp.getDept() == 1);
        assertTrue(checks);
    }

    /**
     * Method: setDept(int dept)
     */
    @Test
    public void testSetDept()
    {
        emp.setDept(1);
        boolean checks = (emp.getDept() == 1);
        assertTrue(checks);
    }

    /**
     * Method: getManager()
     */
    @Test
    public void testGetManager()
    {
        emp.setManager(1);
        boolean checks = (emp.getManager() == 1);
        assertTrue(checks);
    }

    /**
     * Method: setManager(int manager)
     */
    @Test
    public void testSetManager()
    {
        emp.setManager(1);
        boolean checks = (emp.getManager() == 1);
        assertTrue(checks);
    }

    /**
     * Method: getReimbursement()
     */
    @Test
    public void testGetReimbursement()
    {
        emp.setManager(1);
        boolean checks = (emp.getManager() == 1);
        assertTrue(checks);
    }

    /**
     * Method: setReimbursement(float reimbursement)
     */
    @Test
    public void testSetReimbursement()
    {
        emp.setReimbursement(1);
        boolean checks = (emp.getReimbursement() == 1);
        assertTrue(checks);
    }

    /**
     * Method: toString()
     */
    @Test
    public void testToString()
    {
        Employee test = new Employee();
        test.setDept(2);
        String one = test.toString();
        String two = emp.toString();
        assertNotEquals(one, two);
    }

    /**
     * Method: equals(Object o)
     */
    @Test
    public void testEquals()
    {
        Employee test = new Employee();
        test.setDept(2);
        assertFalse(test.equals(emp));
    }

    /**
     * Method: hashCode()
     */
    @Test
    public void testHashCode()
    {
        Employee test = new Employee();
        test.setDept(2);
        int one = test.hashCode();
        int two = emp.hashCode();
        assertNotEquals(one, two);
    }


} 
