package com.RevCo.DAO;

import com.RevCo.Model.Form;

import java.sql.Date;
import java.util.List;

public interface FormDAO
{

    String getEventNameByFormId(int form);

    List<Form> getAllForms();

    void setExpireDate(Form form, int emp);


    float getNewCost(int id);

    List<Form> getAllFormsByDate(Date date);

    float getPending(int id);

    List<Form> getAllFormsByLocation(String location);

    List<Form> getAllFormsByEventType(int evtType);

    List<Form> getAllFormsByEmployeeId(int empId);

    String getGradeTypeByFormId(int form);

    Form getFormById(int formId);

    float getEventScalarByFormId(int form);

    List<Form> getAllFormsForMgr(int mgr);

    boolean approveForm(boolean reviewChoice, int formId);

    boolean addForm(Form form);

    boolean updateForm(Form form);

    boolean deleteFormById(int id);

    boolean deleteFormByEmployeeId(int id);

}
