package com.RevCo.test.Model;

import com.RevCo.Model.Form;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

/**
 * Form Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Feb 25, 2018</pre>
 */
public class FormTest
{
    Form form = new Form();

    /**
     * Method: isApprove()
     */


    @Test
    public void testInit(){
        form.setEmployeeId(1);
        Form test = new Form(form);
        assertEquals(test.getEmployeeId(),form.getEmployeeId());
    }
    @Test
    public void testGetCost()
    {
        form.setCost(1);
        assertTrue(form.getCost() == 1);
    }

    @Test
    public void testSetCost()
    {
        form.setCost(1);
        assertTrue(form.getCost() == 1);
    }

    @Test
    public void testIsApprove()
    {
        form.setApprove(true);
        assertTrue(form.isApprove());
    }

    /**
     * Method: setApprove(boolean approve)
     */
    @Test
    public void testSetApprove()
    {
        form.setApprove(true);
        assertTrue(form.isApprove());
    }

    /**
     * Method: getFormId()
     */
    @Test
    public void testGetFormId()
    {
        form.setFormId(1);
        assertTrue(form.getFormId() == 1);
    }

    /**
     * Method: setFormId(int formId)
     */
    @Test
    public void testSetFormId()
    {
        form.setFormId(1);
        assertTrue(form.getFormId() == 1);
    }

    /**
     * Method: getDate()
     */
    @Test
    public void testGetDate()
    {
        form.setDate(Date.valueOf("2018-2-2"));
        assertTrue(form.getDate().equals(Date.valueOf("2018-2-2")));
    }

    /**
     * Method: setDate(Date date)
     */
    @Test
    public void testSetDate()
    {
        form.setDate(Date.valueOf("2018-2-2"));
        assertTrue(form.getDate().equals(Date.valueOf("2018-2-2")));
    }

    /**
     * Method: getLocation()
     */
    @Test
    public void testGetLocation()
    {
        form.setLocation("bob");
        assertTrue(form.getLocation().equals("bob"));
    }

    /**
     * Method: setLocation(String location)
     */
    @Test
    public void testSetLocation()
    {
        form.setLocation("bob");
        assertTrue(form.getLocation().equals("bob"));
    }

    /**
     * Method: getDescription()
     */
    @Test
    public void testGetDescription()
    {
        form.setDescription("bob");
        assertTrue(form.getDescription().equals("bob"));
    }

    /**
     * Method: setDescription(String description)
     */
    @Test
    public void testSetDescription()
    {
        form.setDescription("bob");
        assertTrue(form.getDescription().equals("bob"));
    }

    /**
     * Method: getGradeFormat()
     */
    @Test
    public void testGetGradeFormat()
    {
        form.setGradeFormat(1);
        assertTrue(form.getGradeFormat() == 1);
    }

    /**
     * Method: setGradeFormat(int gradeFormat)
     */
    @Test
    public void testSetGradeFormat()
    {
        form.setGradeFormat(1);
        assertTrue(form.getGradeFormat() == 1);
    }

    /**
     * Method: getEventType()
     */
    @Test
    public void testGetEventType()
    {
        form.setEventType(1);
        assertTrue(form.getEventType() == 1);
    }

    /**
     * Method: setEventType(int eventType)
     */
    @Test
    public void testSetEventType()
    {
        form.setEventType(1);
        assertTrue(form.getEventType() == 1);
    }

    /**
     * Method: getWorkExcuse()
     */
    @Test
    public void testGetWorkExcuse()
    {
        form.setWorkExcuse("bob");
        assertTrue(form.getWorkExcuse().equals("bob"));
    }

    /**
     * Method: setWorkExcuse(String workExcuse)
     */
    @Test
    public void testSetWorkExcuse()
    {
        form.setWorkExcuse("bob");
        assertTrue(form.getWorkExcuse().equals("bob"));
    }

    /**
     * Method: getEmployeeId()
     */
    @Test
    public void testGetEmployeeId()
    {
        form.setEmployeeId(1);
        assertTrue(form.getEmployeeId() == 1);
    }

    /**
     * Method: setEmployeeId(int employeeId)
     */
    @Test
    public void testSetEmployeeId()
    {
        form.setEmployeeId(1);
        assertTrue(form.getEmployeeId() == 1);
    }

    /**
     * Method: toString()
     */
    @Test
    public void testToString()
    {
        Form test = new Form();
        test.setEmployeeId(2);
        String one = test.toString();
        String two = form.toString();
        assertFalse(one.equals(two));
    }

    /**
     * Method: equals(Object o)
     */
    @Test
    public void testEquals()
    {
        Form test = new Form();
        test.setEmployeeId(2);
        String one = test.toString();
        String two = form.toString();
        assertFalse(test.equals(form));
    }

    /**
     * Method: hashCode()
     */
    @Test
    public void testHashCode()
    {
        Form test = new Form();
        test.setEmployeeId(2);
        int one = test.hashCode();
        int two = form.hashCode();
        assertNotEquals(one, two);
    }


} 
