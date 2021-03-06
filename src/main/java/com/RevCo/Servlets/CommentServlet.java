package com.RevCo.Servlets;

import com.RevCo.Controller.Management;
import com.RevCo.Controller.Validation;
import com.RevCo.Model.Comment;
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

@WebServlet("/comment")
public class CommentServlet extends HttpServlet
{


    private static final long serialVersionUID = 1L;


    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        PrintWriter out;
        BufferedReader bf = request.getReader();
        String check;
        String password = "";
        String username = "";
        Validation v = new Validation();
        Management m = new Management();
        JsonObject respond = new JsonObject();
        boolean mgrs = false;

        response.setHeader("Content-Type", "text/plain");
        response.setStatus(200);
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("text/html;charset=UTF-8");
        Comment c = new Comment();
        while ((check = bf.readLine()) != null)
        {
            JsonObject json = new Gson().fromJson(check, JsonObject.class);


        }
        bf.close();



        respond.addProperty("Manager", mgrs);
        response.setContentType("application/json");
        out = response.getWriter();
        out.print(respond);
        out.flush();


    }


}
