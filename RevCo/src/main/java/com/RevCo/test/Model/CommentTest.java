package com.RevCo.test.Model;

import com.RevCo.Model.Comment;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

/** 
* Comment Tester. 
* 
* @author <Authors name> 
* @since <pre>Feb 25, 2018</pre> 
* @version 1.0 
*/ 
public class CommentTest {
    Comment com = new Comment();

    /**
* 
* Method: getId() 
* 
*/ 
@Test
public void testGetId()
{

com.setId(1);
boolean checks = (com.getId()==1);
assertTrue(checks);
} 

/** 
* 
* Method: setId(int id) 
* 
*/ 
@Test
public void testSetId()
{
    com.setId(1);
    boolean checks = (com.getId()==1);
    assertTrue(checks);
} 

/** 
* 
* Method: getDate() 
* 
*/ 
@Test
public void testGetDate()
{
    com.setDate(Date.valueOf("2018-02-22"));
    boolean checks = (com.getDate().equals(Date.valueOf("2018-02-22")));
    assertTrue(checks);
}



    /**
* 
* Method: setDate(Date date) 
* 
*/ 
@Test
public void testSetDate()
{
    com.setDate(Date.valueOf("2018-02-22"));
    boolean checks = (com.getDate().equals(Date.valueOf("2018-02-22")));
    assertTrue(checks);
} 

/** 
* 
* Method: getSender() 
* 
*/ 
@Test
public void testGetSender()
{
    com.setSender(1);
    boolean checks = (com.getSender() == 1);
    assertTrue(checks);
} 

/** 
* 
* Method: setSender(int sender) 
* 
*/ 
@Test
public void testSetSender()
{
    com.setSender(1);
    boolean checks = (com.getSender() == 1);
    assertTrue(checks);
} 

/** 
* 
* Method: getReceiver() 
* 
*/ 
@Test
public void testGetReceiver()
{
    com.setReceiver(1);
    boolean checks = (com.getReceiver() == 1);
    assertTrue(checks);
} 

/** 
* 
* Method: setReceiver(int receiver) 
* 
*/ 
@Test
public void testSetReceiver()
{
    com.setReceiver(1);
    boolean checks = (com.getReceiver() == 1);
    assertTrue(checks);
} 

/** 
* 
* Method: getForm() 
* 
*/ 
@Test
public void testGetForm()
{
    com.setForm(1);
    boolean checks = (com.getForm() == 1);
    assertTrue(checks);
} 

/** 
* 
* Method: setForm(int form) 
* 
*/ 
@Test
public void testSetForm()
{
    com.setForm(1);
    boolean checks = (com.getForm() == 1);
    assertTrue(checks);
} 

/** 
* 
* Method: getComment() 
* 
*/ 
@Test
public void testGetComment()
{
    com.setComment("1");
    boolean checks = (com.getComment().equals("1"));
    assertTrue(checks);
} 

/** 
* 
* Method: setComment(String comment) 
* 
*/ 
@Test
public void testSetComment()
{
    com.setComment("1");
    boolean checks = (com.getComment().equals("1"));
    assertTrue(checks);
} 


} 
