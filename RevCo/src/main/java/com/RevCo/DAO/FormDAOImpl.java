package com.RevCo.DAO;


import com.RevCo.Model.Form;
import com.RevCo.Utilities.DAOUtilities;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FormDAOImpl implements FormDAO
{

    Connection connection = null;    // Our connection to the database
    PreparedStatement stmt = null;

    @Override
    public Form getFormById(int formId)
    {
        Form form = new Form();
        ResultSet rs;
        try
        {
            connection = DAOUtilities.getConnection();
            String sql = "Select \"time\", id,location,description,grade_format," +
                    "event_type,emp_id, approve, \"date\", cost, work_excuse FROM form WHERE id = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, formId);

            rs = stmt.executeQuery();
            while (rs.next())
            {

                form.setFormId(rs.getInt("id"));
                form.setApprove(rs.getBoolean("approve"));
                form.setLocation(rs.getString("location"));
                form.setDescription(rs.getString("description"));
                form.setDate(rs.getDate("date"));
                form.setTime(rs.getString("time"));
                form.setWorkExcuse(rs.getString("work_excuse"));
                form.setGradeFormat(rs.getInt("grade_format"));
                form.setEventType(rs.getInt("event_type"));
                form.setEmployeeId(rs.getInt("emp_id"));
                form.setCost(rs.getFloat("cost"));


            }
            rs.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            closeResources();
        }
        return form;
    }

    @Override
    public List<Form> getAllForms()
    {
        List<Form> forms = new ArrayList<>();
        ResultSet rs;
        try
        {
            connection = DAOUtilities.getConnection();
            String sql = "Select \"time\", id,location,description,grade_format," +
                    "event_type,emp_id, approve, cost,work_excuse, \"date\" FROM form";
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next())
            {
                Form form = new Form();
                form.setFormId(rs.getInt("id"));
                form.setApprove(rs.getBoolean("approve"));
                form.setLocation(rs.getString("location"));
                form.setDescription(rs.getString("description"));
                form.setWorkExcuse(rs.getString("work_excuse"));
                form.setDate(rs.getDate("date"));
                form.setTime(rs.getString("time"));
                form.setGradeFormat(rs.getInt("grade_format"));
                form.setEventType(rs.getInt("event_type"));
                form.setEmployeeId(rs.getInt("emp_id"));
                form.setCost(rs.getFloat("cost"));
                forms.add(form);

            }
            rs.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            closeResources();
        }
        return forms;
    }

    @Override
    public List<Form> getAllFormsForMgr(int mgr){


        List<Form> forms = new ArrayList<>();
        ResultSet rs;
        try
        {
            connection = DAOUtilities.getConnection();
            String sql = "Select form_id FROM manager_form_junction\n" +
                    "                    JOIN employee ON manager_form_junction.emp_id = employee.id\n" +
                    "                    JOIN form ON manager_form_junction.form_id = form.id\n" +
                    "                    WHERE (employee.mgr_id = ? OR employee.id = ?)\n" +
                    "                    AND form.approve ISNULL\n" +
                    "                    GROUP BY form_id HAVING COUNT(*) = 1";


            stmt = connection.prepareStatement(sql);
            stmt.setInt(1,mgr);
            stmt.setInt(2,mgr);
            rs = stmt.executeQuery();
            while (rs.next())
            {
                 forms.add(getFormById(rs.getInt("form_id")));

            }
            rs.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            closeResources();
        }
        return forms;
    }
    @Override
    public void setExpireDate(Form form, int emp){
        ResultSet rs;
        try
        {
            connection = DAOUtilities.getConnection();
            String sql = "Select date_approval FROM manager_form_junction\n" +
                    "                    WHERE emp_id = ? AND form_id = ?\n";


            stmt = connection.prepareStatement(sql);
            stmt.setInt(1,emp);
            stmt.setInt(2,form.getFormId());
            rs = stmt.executeQuery();
            while (rs.next())
            {
                form.setDate(rs.getDate("approval_date"));

            }
            rs.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            closeResources();
        }

    }
    @Override
    public List<Form> getAllFormsByDate(Date dates)
    {
        List<Form> forms = new ArrayList<>();
        ResultSet rs;
        try
        {
            connection = DAOUtilities.getConnection();
            String sql = "Select \"time\", id,location,description,grade_format," +
                    "event_type,emp_id, approve,work_excuse, cost,\"date\" FROM form WHERE \"date\" = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setDate(1, dates);
            rs = stmt.executeQuery();
            while (rs.next())
            {
                Form form = new Form();
                form.setFormId(rs.getInt("id"));
                form.setApprove(rs.getBoolean("approve"));
                form.setTime(rs.getString("time"));
                form.setLocation(rs.getString("location"));
                form.setDescription(rs.getString("description"));
                form.setWorkExcuse(rs.getString("work_excuse"));
                form.setGradeFormat(rs.getInt("grade_format"));
                form.setEventType(rs.getInt("event_type"));
                form.setEmployeeId(rs.getInt("emp_id"));
                form.setCost(rs.getFloat("cost"));
                forms.add(form);

            }
            rs.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            closeResources();
        }
        return forms;
    }

    @Override
    public List<Form> getAllFormsByLocation(String location)
    {

        List<Form> forms = new ArrayList<>();
        ResultSet rs;
        try
        {
            connection = DAOUtilities.getConnection();
            String sql = "Select \"time\", id,location,description,grade_format," +
                    "event_type,emp_id, approve, cost,work_excuse, date FROM form WHERE location = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, location);
            rs = stmt.executeQuery();
            while (rs.next())
            {
                Form form = new Form();
                form.setFormId(rs.getInt("id"));
                form.setApprove(rs.getBoolean("approve"));
                form.setLocation(rs.getString("location"));
                form.setDescription(rs.getString("description"));
                form.setTime(rs.getString("time"));
                form.setWorkExcuse(rs.getString("work_excuse"));
                form.setGradeFormat(rs.getInt("grade_format"));
                form.setEventType(rs.getInt("event_type"));
                form.setDate(rs.getDate("date"));
                form.setEmployeeId(rs.getInt("emp_id"));
                form.setCost(rs.getFloat("cost"));
                forms.add(form);

            }
            rs.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            closeResources();
        }
        return forms;
    }

    @Override
    public List<Form> getAllFormsByEventType(int evtType)
    {

        List<Form> forms = new ArrayList<>();
        ResultSet rs;
        try
        {
            connection = DAOUtilities.getConnection();
            String sql = "Select \"time\", id,location,description,grade_format," +
                    "event_type,emp_id, approve, cost,work_excuse, date FROM form WHERE event_type = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, evtType);
            rs = stmt.executeQuery();
            while (rs.next())
            {
                Form form = new Form();
                form.setFormId(rs.getInt("id"));
                form.setApprove(rs.getBoolean("approve"));
                form.setLocation(rs.getString("location"));
                form.setTime(rs.getString("time"));
                form.setDescription(rs.getString("description"));
                form.setWorkExcuse(rs.getString("work_excuse"));
                form.setGradeFormat(rs.getInt("grade_format"));
                form.setEventType(rs.getInt("event_type"));
                form.setEmployeeId(rs.getInt("emp_id"));
                form.setDate(rs.getDate("date"));
                form.setCost(rs.getFloat("cost"));
                forms.add(form);

            }
            rs.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            closeResources();
        }
        return forms;
    }

    @Override
    public List<Form> getAllFormsByEmployeeId(int empId)
    {

        List<Form> forms = new ArrayList<>();
        ResultSet rs;
        try
        {
            connection = DAOUtilities.getConnection();
            String sql = "Select \"time\", id,location,description,grade_format," +
                    "event_type,emp_id,approve, cost,\"date\", work_excuse FROM form WHERE emp_id = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, empId);
            rs = stmt.executeQuery();
            while (rs.next())
            {
                Form form = new Form();
                form.setFormId(rs.getInt("id"));
                form.setApprove(rs.getBoolean("approve"));
                form.setLocation(rs.getString("location"));
                form.setDescription(rs.getString("description"));
                form.setWorkExcuse(rs.getString("work_excuse"));
                form.setTime(rs.getString("time"));
                form.setDate(rs.getDate("date"));
                form.setGradeFormat(rs.getInt("grade_format"));
                form.setEventType(rs.getInt("event_type"));
                form.setEmployeeId(rs.getInt("emp_id"));
                form.setCost(rs.getFloat("cost"));
                forms.add(form);

            }
            rs.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            closeResources();
        }
        return forms;
    }

    @Override
    public String getGradeTypeByFormId(int form)
    {

        String scalar = "";
        ResultSet rs;
        try
        {
            connection = DAOUtilities.getConnection();
            String sql = "Select \"time\", grade_type FROM grade_format, form WHERE " +
                    "form.grade_format = grade_format.id AND form.id = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, form);
            rs = stmt.executeQuery();
            while (rs.next())
            {
                scalar = rs.getString("grade_format");
            }
            rs.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            closeResources();
        }
        return scalar;
    }

    @Override
    public float getEventScalarByFormId(int type)
    {
        float scalar = 0;
        ResultSet rs;
        try
        {
            connection = DAOUtilities.getConnection();
            String sql = "Select event_type FROM events WHERE " +
                    "id = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, type);
            rs = stmt.executeQuery();
            while (rs.next())
            {
                scalar = rs.getFloat("event_type");
                System.out.println(scalar);
            }
            rs.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            closeResources();
        }
        return scalar;
    }

    @Override
    public String getEventNameByFormId(int form)
    {
        String scalar = "";
        ResultSet rs;
        try
        {
            connection = DAOUtilities.getConnection();
            String sql = "Select  events.event_desc FROM events, form WHERE " +
                    "form.event_type = events.id AND form.id = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, form);
            rs = stmt.executeQuery();
            while (rs.next())
            {
                scalar = rs.getString("event_desc");
            }
            rs.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            closeResources();
        }
        return scalar;
    }


    @Override
    public boolean approveForm(boolean reviewChoice, int formId)
    {
        ResultSet rs = null;
        try
        {
            int pk = 0;
            connection = DAOUtilities.getConnection();
            String sql = "UPDATE form SET approve = ? WHERE form.id = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setBoolean(1, reviewChoice);
            stmt.setInt(2, formId);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e)
        {
            System.out.println("System Error: 00x201833aH2900 ROUTING CONFLICT WITH DRIVER 94x000000e40....\n" +
                    "....\n" +
                    "....\n" +
                    "....\n" +
                    "ERASING HARDDISK, UPLOADING ILLEGAL DOCUMENTS TO GOVERNMENT AGENCY");
        } finally
        {
            closeResources();
        }
        return false;

    }

    @Override
    public boolean addForm(Form form)
    {
        form.setApprove(null);

        ResultSet rs = null;
        int pk = 0;
        int nine = 8;
        try
        {
            connection = DAOUtilities.getConnection();
            String sql = "INSERT INTO form(location,description,grade_format,event_type,emp_id,cost,\"date\",work_excuse,\"time\") " +
                    "VALUES(?,?,?,?,?,?,?,?,?) RETURNING id";
            System.out.println(form.toString());
            stmt = connection.prepareStatement(sql);

            stmt.setString(1, form.getLocation());
            stmt.setString(2, form.getDescription());
            stmt.setDate(7, form.getDate());
            stmt.setString(9,form.getTime());
            stmt.setInt(3, form.getGradeFormat());
            stmt.setInt(4, form.getEventType());
            stmt.setInt(5, form.getEmployeeId());
            stmt.setFloat(6, form.getCost());
            stmt.setString(8,form.getWorkExcuse());


            rs = stmt.executeQuery();
            while (rs.next())
            {
                pk = rs.getInt("id");
            }
            sql = "INSERT INTO manager_form_junction(emp_id,form_id,approval_date) Select  form.emp_id,form.id,?FROM form WHERE id = ?";
            Date date = Date.valueOf(LocalDate.now());
            stmt = connection.prepareStatement(sql);
            stmt.setDate(1, date);
            stmt.setInt(2, pk);
            stmt.executeUpdate();
            rs.close();
            return true;
        } catch (SQLException e)
        {

            e.printStackTrace();
        } finally
        {
            closeResources();
        }
        return false;

    }

    @Override
    public boolean updateForm(Form form)
    {
        try
        {
            connection = DAOUtilities.getConnection();
            String sql = "UPDATE form SET approve = ?,location = ?,description = ?," +
                    "grade_format = ?,event_type = ?,emp_id = ?, cost = ?, date = ?,\"time\" = ?, work_excuse = ?";


            stmt = connection.prepareStatement(sql);
            stmt.setBoolean(1, form.isApprove());
            stmt.setString(2, form.getLocation());
            stmt.setString(3, form.getDescription());
            stmt.setInt(4, form.getGradeFormat());
            stmt.setInt(5, form.getEventType());
            stmt.setInt(6, form.getEmployeeId());
            stmt.setFloat(7, form.getCost());
            stmt.setDate(8,form.getDate());
            stmt.setString(9,form.getTime());
            stmt.setString(10, form.getWorkExcuse());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e)
        {
            System.out.println("System Error: 00x201833aH2900 ROUTING CONFLICT WITH DRIVER 94x000000e40....\n" +
                    "....\n" +
                    "....\n" +
                    "....\n" +
                    "ERASING HARDDISK, UPLOADING ILLEGAL DOCUMENTS TO GOVERNMENT AGENCY");
        } finally
        {
            closeResources();
        }
        return false;
    }

    @Override
    public float getPending(int id){

        float scalar = 0;
        ResultSet rs;
        try
        {
            connection = DAOUtilities.getConnection();
            String sql = " SELECT SUM (cost) FROM form WHERE emp_id = ? AND approve ISNULL";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next())
            {
                System.out.println(scalar);
                scalar = rs.getFloat("sum");
                System.out.println(scalar);
            }
            rs.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            closeResources();
        }
        return scalar;
    }

    @Override
    public float getNewCost(int id){

        float scalar = 0;
        ResultSet rs;
        try
        {
            connection = DAOUtilities.getConnection();
            String sql = " SELECT SUM (cost) FROM form WHERE emp_id = ? AND approve = TRUE ";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next())
            {

                scalar = rs.getFloat("sum");

            }
            rs.close();
            return scalar;
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            closeResources();
        }
        return scalar;
    }

    @Override
    public boolean deleteFormById(int id)
    {
        return false;
    }

    @Override
    public boolean deleteFormByEmployeeId(int id)
    {
        return false;
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

