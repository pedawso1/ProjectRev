package com.RevCo.Controller;

import com.RevCo.DAO.EmployeeDAOImpl;
import com.RevCo.DAO.FormDAOImpl;
import com.RevCo.Model.Form;

import java.util.ArrayList;
import java.util.List;

public class Reimbursement
{
    FormDAOImpl form = new FormDAOImpl();
    EmployeeDAOImpl emp = new EmployeeDAOImpl();

    public float getPotentialReimbursement(int eventType, float reimbursement)
    {
        System.out.println(eventType + "::::" + reimbursement);
        System.out.println(form.getEventScalarByFormId(eventType));
        return (reimbursement * form.getEventScalarByFormId(eventType));
    }

    public void updateReimbursement(int empId)
    {

        emp.updateEmployee(empId, form.getNewCost(empId));
    }

    public void setFormCost(int formId)
    {
        form.updateForm(form.getFormById(formId));
    }

    public float getReim(int id){
        float returns = 0;
        returns = form.getPending(id);
        updateReimbursement(id);
        return returns;

    }
    public List<Form> retreiveApps(int empId)
    {
       return form.getAllFormsByEmployeeId(empId);
    }

    public String getEventDesc(int evt){

        return form.getEventNameByFormId(evt);
    }

    public boolean submitForm(Form newForm){
        if(form.addForm(newForm)){
            return true;
        }
        return false;
    }
}
