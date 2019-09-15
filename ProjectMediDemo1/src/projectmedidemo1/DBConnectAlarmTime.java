
package projectmedidemo1;

import  java.sql.*;
//import java.beans.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class DBConnectAlarmTime {
    private Connection con;
    private Statement st;
    private ResultSet rs;
    public DBConnectAlarmTime()
        {
        try
            {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Medi Buddy","root","");
            st = con.createStatement();
            }catch(Exception e)
                {
                System.out.println("Error :"+e);
                e.printStackTrace();
                }
        
        }
    public ResultSet getAlarmTime() 
    {
        try 
        {
            String query = "select morningalarm,dayalarm,nightalarm from alarmtable;";
            rs = st.executeQuery(query);
            //System.out.println(rs);
        } 
        catch (Exception e) 
        {
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
        return rs;
    }
    
    public void setAlarmTime(String morningalarm,String dayalarm,String nightalarm) 
    {
        try
        {
            String query="update alarmtable set morningalarm='"+morningalarm+"',dayalarm='"+dayalarm+"',nightalarm='"+nightalarm+"';"; 
            System.out.println(query);
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Alarms Set Successfully");
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null,"Updatingdatabase Exception :"+e); 
            System.out.println(e);
        }
    }
    
}
