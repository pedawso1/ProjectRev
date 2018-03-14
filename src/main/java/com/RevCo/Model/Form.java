package com.RevCo.Model;

import com.RevCo.Controller.Expire;
import com.RevCo.DAO.FormDAOImpl;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import java.util.Timer;

public class Form implements Serializable
{
    private int formId;
    private int eventType;
    private int employeeId;
    private int gradeFormat;
    private Date date;
    private float cost;
    private String location;
    private String description;
    private String workExcuse;
    private Boolean approve;
    private String event;
    private int warn;
    private boolean initial;

    public boolean isSubmitWarn()
    {
        return submitWarn;
    }

    public void setSubOff(){
        this.initial = false;
    }
    public void setSubmitWarn()
    {

            Expire e = new Expire();
            this.submitWarn = e.submitTimeClose(this.date);

    }

    private boolean submitWarn;

    public String getTime()
    {
        return time;
    }

    public void setTime(String time)
    {
        this.time = time;
    }

    private String time;

    public Form()
    {
        this.initial = true;
    }

    public Form(Form form)
    {
        this.formId = form.formId;
        this.date = form.date;
        this.cost = form.cost;
        this.location = form.location;
        this.description = form.description;
        this.gradeFormat = form.gradeFormat;
        this.eventType = form.eventType;
        this.workExcuse = form.workExcuse;
        this.employeeId = form.employeeId;
    }

    public float getCost()
    {
        return cost;
    }

    public void setCost(float cost)
    {
        this.cost = cost;
    }

    public Boolean isApprove()
    {
        return approve;
    }

    public void setApprove(Boolean approve)
    {
        this.approve = approve;
    }

    public int getFormId()
    {
        return formId;
    }

    public void setFormId(int formId)
    {
        this.formId = formId;
        FormDAOImpl f = new FormDAOImpl();
        this.event = f.getEventNameByFormId(formId);;
    }

    public Date getDate()
    {
        return date;

    }
    public void setWarn(){
        Expire time = new Expire();
        warn = time.timeWarm(this.date);
    }
    public int getWarn(){
        return warn;
    }
    public void setDate(Date date)
    {
        this.date = date;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public int getGradeFormat()
    {
        return gradeFormat;
    }

    public void setGradeFormat(int gradeFormat)
    {
        this.gradeFormat = gradeFormat;
    }

    public int getEventType()
    {
        return eventType;
    }

    public void setEventType(int eventType)
    {
        this.eventType = eventType;
    }

    public String getWorkExcuse()
    {
        return workExcuse;
    }

    public void setWorkExcuse(String workExcuse)
    {
        this.workExcuse = workExcuse;
    }

    public int getEmployeeId()
    {
        return employeeId;
    }

    public void setEmployeeId(int employeeId)
    {
        this.employeeId = employeeId;
    }

    @Override
    public String toString()
    {
        return "Form{" +
                "formId=" + formId +
                ", date=" + date +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", gradeFormat='" + gradeFormat + '\'' +
                ", eventType='" + eventType + '\'' +
                ", workExcuse='" + workExcuse + '\'' +
                ", employeeId=" + employeeId +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Form form = (Form) o;
        return getFormId() == form.getFormId() &&
                getEmployeeId() == form.getEmployeeId() &&
                Objects.equals(getDate(), form.getDate()) &&
                Objects.equals(getLocation(), form.getLocation()) &&
                Objects.equals(getDescription(), form.getDescription()) &&
                Objects.equals(getGradeFormat(), form.getGradeFormat()) &&
                Objects.equals(getEventType(), form.getEventType()) &&
                Objects.equals(getWorkExcuse(), form.getWorkExcuse());
    }

    @Override
    public int hashCode()
    {

        return Objects.hash(getFormId(), getDate(), getLocation(), getDescription(), getGradeFormat(), getEventType(), getWorkExcuse(), getEmployeeId());
    }

}
