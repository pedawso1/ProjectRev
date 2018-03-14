package com.RevCo.Servlets;

import com.RevCo.Controller.Management;
import com.RevCo.Controller.Reimbursement;
import com.RevCo.Controller.Validation;
import com.RevCo.Model.Employee;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ProfileServlet extends HttpServlet
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
        JsonObject respond = new JsonObject();
        String check;
        String username;
        float nums = 0;
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
            JsonObject json = new Gson().fromJson(check, JsonObject.class);
            username = json.get("userName").getAsString();
            e = m.getProfile(username);
            nums = r.getReim(e.getId());
        }
        bf.close();


        respond.addProperty("pend",nums);
        respond.addProperty("id", e.getId());
        respond.addProperty("first", e.getFirstName());
        respond.addProperty("last", e.getLastName());
        respond.addProperty("user", e.getUserName());
        respond.addProperty("pass", e.getPassword());
        respond.addProperty("dept", m.getDept(e.getDept()));
        respond.addProperty("manager", m.getMgr(e.getManager()));
        respond.addProperty("reim", e.getReimbursement());

        response.setContentType("application/json");
        out = response.getWriter();
        out.print(respond);
        out.flush();


    }


}