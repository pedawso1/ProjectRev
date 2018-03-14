package com.RevCo.DAO;

import com.RevCo.Model.Comment;

import java.util.List;

public interface CommentDAO
{
    boolean addComment(Comment comment);
    List<Comment> getAllComments(int empId, int formId);
}
