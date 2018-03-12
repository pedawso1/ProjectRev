package com.RevCo.Controller;

import com.RevCo.DAO.CommentDAOImpl;
import com.RevCo.DAO.EmployeeDAOImpl;
import com.RevCo.DAO.FormDAOImpl;
import com.RevCo.Model.Comment;
import com.RevCo.Model.Employee;
import com.RevCo.Model.Form;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Management
{

    FormDAOImpl form = new FormDAOImpl();
    EmployeeDAOImpl emp = new EmployeeDAOImpl();
    CommentDAOImpl comm = new CommentDAOImpl();

    public boolean applicationReview(boolean review, int formId, int empId)
    {
        System.out.println(review);

        Date date = Date.valueOf(LocalDate.now());
        Employee employee = emp.getEmployeeById(empId);
        if (review == false || (employee.getDept() == 5))
        {
            form.approveForm(review, formId);
            emp.setEmployeeReview(empId, formId, date);
            return true;
        } else
        {
            emp.setEmployeeReview(empId, formId, date);
            return false;

        }


    }

    public Employee getProfile(String username)
    {
        return emp.getEmployeeByUsername(username);
    }

    public String getDept(int i)
    {
        return emp.getDeptByDeptId(i);
    }

    public String getMgr(int i)
    {
        Employee e = new Employee();
        e = emp.getEmployeeById(i);

        return (e.getFirstName() + " " + e.getLastName());
    }
    public Employee getMgrProfile(int id)
    {
        Employee e = new Employee();
        e = emp.getEmployeeById(id);

        return e;
    }

    public void addComment(int empSender, String empReceiver, int formId, String com)
    {
        int reciever = emp.getEmployeeByUsername(empReceiver).getId();
        Date date = Date.valueOf(LocalDate.now());
        Comment comment = new Comment();
        comment.setDate(date);
        comment.setReceiver(reciever);
        comment.setSender(empSender);
        comment.setForm(formId);
        comment.setComment(com);
        comm.addComment(comment);

    }

    public List<Comment> getAllComments(int empId, int formId)
    {
        List<Comment> list = comm.getAllComments(empId, formId);
        return list;

    }

    public List<Form> getEmployeeForms(String mgr)
    {
        List<Form> empForms = new ArrayList<>();

        for (Form f : form.getAllFormsForMgr(emp.getEmployeeByUsername(mgr).getId()))
        {
            empForms.add(f);
        }

        return empForms;
    }

    public boolean isManager(int id)
    {

        if (emp.getAllEmployeeByMgrId(id).size() >= 1)
        {
            return true;
        }
        return false;
    }

    public List<Employee> getEmployees(int id)
    {
        return emp.getAllEmployeeByMgrId(id);
    }
}
