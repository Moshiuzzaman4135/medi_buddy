
package projectmedidemo1;
import  java.sql.*;
//import java.beans.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DBConnectUserInfo 
{
 private Connection con;
    private Statement st;
    private ResultSet rs;
    private FirstInfoFrame F;
    public void setFIF(FirstInfoFrame f)
            {
            this.F =f;
            }
    public DBConnectUserInfo()
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
    public void insertIntoDB(ArrayList row)
    {
        try
        {
            String query="insert into userinfo(name,age,gender,bloodgroup) values('"
            +row.get(0)+"','"+row.get(1)+"','"+row.get(2)
            +"','"+row.get(3)+"'"+");";
            System.out.println(query);
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"User info Added Successfully");
            
            
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null,"Insert into database Exception :"+e); 
            System.out.println(e);
        }
        
    }
    public void updateDB(ArrayList row)
    {
        try
        {
            //String query1="insert into userinfo(name,age,gender,bloodgroup) values('"
            //+row.get(0)+"','"+row.get(1)+"','"+row.get(2)
            //+"','"+row.get(3)+"'"+");";
            String query="update userinfo set name='"+row.get(0)+"' ,age='"+row.get(1)+"', gender='"+row.get(2)+"' ,bloodgroup='"+row.get(3)+"' where name='"+row.get(0)+"';";
            System.out.println(query);
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"User info Updated Successfully");
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null,"Updatingdatabase Exception :"+e); 
            System.out.println(e);
        }
        
    }
    
    public ResultSet getResultSet(String name) 
    {
        try 
        {
            String query = "select name,age,gender,bloodgroup from userinfo where name='"+name+"';";
            rs = st.executeQuery(query);
        } 
        catch (Exception e) 
        {
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
        return rs;
    }
    
    public ResultSet getResultUserName() 
    {
        try 
        {
            String query = "select name from userinfo;";
            rs = st.executeQuery(query);
        } 
        catch (Exception e) 
        {
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
        return rs;
    }
    
    
    public void deleteUser(String name) 
    {
        try 
        {
            String query = "delete from userinfo where name='"+name+"';";            
            st.executeUpdate(query);
            query = "delete from medicineinfo where username='"+name+"';";
            st.executeUpdate(query);
            
            
        } 
        catch (Exception e) 
        {
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
        
    }


    
}
