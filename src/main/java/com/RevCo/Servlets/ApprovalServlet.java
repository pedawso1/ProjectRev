package com.RevCo.Servlets;

import com.RevCo.Controller.Management;
import com.RevCo.Controller.Reimbursement;
import com.RevCo.Model.Employee;
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

@WebServlet("/approve")
public class ApprovalServlet extends HttpServlet
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
        JsonObject json = new JsonObject();
        String username = "";
        int id = 0;
        boolean approve = false;
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
            id = json.get("id").getAsInt();
            approve = json.get("currentReview").getAsBoolean();
            username = json.get("userName").getAsString();

        }
        System.out.println(approve);
        boolean rev = false;
        bf.close();

        if (m.applicationReview( approve,id, m.getProfile(username).getId()))
        {
            rev = true;
        }
        json.addProperty("FormRev", rev);
        response.setContentType("application/json");
        out = response.getWriter();
        out.print(json);
        out.flush();

    }
}