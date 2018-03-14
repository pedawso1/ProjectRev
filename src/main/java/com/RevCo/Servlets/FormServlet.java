package com.RevCo.Servlets;

import com.RevCo.Controller.Management;
import com.RevCo.Controller.Reimbursement;
import com.RevCo.Controller.Validation;
import com.RevCo.Model.Employee;
import com.RevCo.Model.Form;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


@WebServlet ("/FormServlet")
public class FormServlet extends HttpServlet
{

    private static final long serialVersionUID = 1L;
    Employee e;
    Management m;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        PrintWriter out;
        BufferedReader bf = request.getReader();
        Reimbursement r = new Reimbursement();
        Gson gson = new Gson();
        JsonObject json;
        String check;
        e = new Employee();
        m = new Management();

        response.setHeader("Content-Type", "text/plain");
        response.setStatus(200);
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE");
        response.setContentType("text/html;charset=UTF-8");

        while ((check = bf.readLine()) != null)
        {
            json = new Gson().fromJson(check, JsonObject.class);
            e = m.getProfile(json.get("userName").getAsString());
        }
        bf.close();

        List<Form> form =  r.retreiveApps(e.getId());
        for(Form f : form){
            if(f.getWarn() == -4){
                m.applicationReview(true, f.getFormId(),e.getId());
            }
            f.setWarn();
        }

        String forms = gson.toJson(form);
        response.setContentType("application/json");
        out = response.getWriter();
        out.print(forms);
        out.flush();
    }


}