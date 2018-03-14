package com.RevCo.Model;

import com.RevCo.DAO.EmployeeDAOImpl;

import java.io.Serializable;
import java.util.Objects;

public class Employee implements Serializable
{
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private int dept;
    private int manager;
    private int id;
    private float reimbursement;

    @Override
    public String toString()
    {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", dept=" + dept +
                ", manager=" + manager +
                ", id=" + id +
                ", reimbursement=" + reimbursement +
                '}';
    }

    public Employee(){

    }
    public Employee(String username){
        Employee emp = new EmployeeDAOImpl().getEmployeeByUsername(username);
        this.id = emp.id;
        this.firstName = emp.firstName;
        this.lastName = emp.lastName;
        this.userName = emp.userName;
        this.password = emp.password;
        this.dept = emp.dept;
        this.manager = emp.manager;
        this.reimbursement = emp.reimbursement;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public int getDept()
    {
        return dept;
    }

    public void setDept(int dept)
    {
        this.dept = dept;
    }

    public int getManager()
    {
        return manager;
    }

    public void setManager(int manager)
    {
        this.manager = manager;
    }

    public float getReimbursement()
    {
        return reimbursement;
    }

    public void setReimbursement(float reimbursement)
    {
        this.reimbursement = reimbursement;
    }



    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return getId() == employee.getId() &&
                Float.compare(employee.getReimbursement(), getReimbursement()) == 0 &&
                Objects.equals(getFirstName(), employee.getFirstName()) &&
                Objects.equals(getLastName(), employee.getLastName()) &&
                Objects.equals(getUserName(), employee.getUserName()) &&
                Objects.equals(getPassword(), employee.getPassword()) &&
                Objects.equals(getDept(), employee.getDept()) &&
                Objects.equals(getManager(), employee.getManager());
    }

    @Override
    public int hashCode()
    {

        return Objects.hash(getFirstName(), getLastName(), getUserName(), getPassword(), getDept(), getManager(), getId(), getReimbursement());
    }

}
