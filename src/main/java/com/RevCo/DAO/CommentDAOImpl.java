package com.RevCo.DAO;
//Java Mail
import com.RevCo.Model.Comment;
import com.RevCo.Utilities.DAOUtilities;

import java.sql.*;
import java.util.*;

public class CommentDAOImpl implements CommentDAO
{

    Connection connection;
    PreparedStatement stmt;

    public boolean addComment(Comment comment){
        try
        {
            int three = 3;
            int four = 4;
            int five = 5;
            int six = 6;
            connection = DAOUtilities.getConnection();
            String sql = "INSERT INTO \"comment\"(form_id,emp_sender,emp_receiver,date_posted,post,\"type\")" +
                    " VALUES (?,?,?,?,?,?) ";
            stmt.setInt(1,comment.getForm());
            stmt.setInt(2,comment.getSender());
            stmt.setInt(three,comment.getReceiver());
            stmt.setDate(four,comment.getDate());
            stmt.setString(five,comment.getComment());
            stmt.setString(six,comment.getComment());
            stmt = connection.prepareStatement(sql);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            closeResources();
        }


        return false;
    }

    public List<Comment> getAllComments(int empId, int formId){
        List<Comment> list = new ArrayList<>();
        ResultSet rs;
        try
        {
            connection = DAOUtilities.getConnection();
            String sql = "SELECT id, form_id,emp_sender,emp_receiver,date_posted, \"type\", " +
                    "post FROM \"comment\" WHERE emp_receiver = ? AND form_id = ?";
            stmt.setInt(1,empId);
            stmt.setInt(2,formId);
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
            Comment com = new Comment();
            com.setId(rs.getInt("id"));
            com.setForm(rs.getInt("form_id"));
            com.setSender(rs.getInt("emp_sender"));
            com.setReceiver(rs.getInt("emp_receiver"));
            com.setType(rs.getString("type"));
            com.setDate(rs.getDate("date_posted"));
            com.setComment(rs.getString("post"));
            list.add(com);
            }
            rs.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            closeResources();
        }
        return list;


    }

    private void closeResources()
    {
        try
        {
            if (stmt != null)
                stmt.close();
        } catch (SQLException e)
        {
            System.out.println("Could not close statement!");
            e.printStackTrace();
        }

        try
        {
            if (connection != null)
                connection.close();
        } catch (SQLException e)
        {
            System.out.println("Could not close connection!");
            e.printStackTrace();
        }
    }
}
