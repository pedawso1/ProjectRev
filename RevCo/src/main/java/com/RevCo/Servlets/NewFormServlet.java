package com.RevCo.Servlets;

import com.RevCo.Controller.Management;
import com.RevCo.Controller.Reimbursement;
import com.RevCo.Controller.Validation;
import com.RevCo.Model.Form;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet ("/NewForm")
public class NewFormServlet extends HttpServlet
{

    private static final long serialVersionUID = 1L;


    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        PrintWriter out;
        response.setHeader("Content-Type", "application/json");
        response.setStatus(200);
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("text/html;charset=UTF-8");
        BufferedReader bf = request.getReader();
        String check;
        boolean success = false;
        Management m = new Management();
        Reimbursement r = new Reimbursement();
        StringBuilder temp = new StringBuilder();
        String usern;
        Form form = new Form();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD hh:mm:ss A Z");
        String dTime;
        while ((check = bf.readLine()) != null)
        {
            JsonObject json = new Gson().fromJson(check, JsonObject.class);

            form.setLocation(json.get("location").getAsString());
            form.setCost(json.get("cost").getAsFloat());
            form.setWorkExcuse(json.get("work").getAsString());
            form.setEventType(json.get("event").getAsInt());
            form.setGradeFormat(json.get("grade").getAsInt());
            dTime = json.get("date").getAsString();
            form.setDate(Date.valueOf((dTime.split("T"))[0]));
            form.setTime(dTime.split("T")[1].substring(0,dTime.split("T")[1].length()-5));
            form.setDescription(json.get("description").getAsString());
            usern = json.get("username").getAsString();
            form.setEmployeeId(m.getProfile(usern).getId());
            form.setApprove(false);
            form.setCost(r.getPotentialReimbursement(form.getEventType(),form.getCost()));
            if (r.submitForm(form))
            {
                success = true;
            }
        }
        bf.close();
        JsonObject respond = new JsonObject();
        respond.addProperty("Applied", success);
        response.setContentType("application/json");
        out = response.getWriter();
        out.print(respond);
        out.flush();


    }
}