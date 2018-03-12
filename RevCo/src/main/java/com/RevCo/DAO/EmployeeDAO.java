package com.RevCo.DAO;

import com.RevCo.Model.Employee;

import java.sql.Date;
import java.util.List;

public interface EmployeeDAO
{
    List<Employee> getAllEmployee();
    List<Employee> getAllEmployeeByDept(int dept);
    List<Employee> getAllEmployeeByMgrId(int mgr);
    Employee getManagerByEmployeeId(int empId );
    Employee getEmployeeById(int id);
    Employee getEmployeeByUsername(String username);
    boolean setEmployeeReview(int empId, int formId, Date formDate);
    boolean addEmployee(String username, String password);
    String getDeptByDeptId(int i);
    boolean addDept();
    boolean updateEmployee(int empId, float reimbursement);



}
