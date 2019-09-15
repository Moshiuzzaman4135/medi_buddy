package projectmedidemo1;
import  java.sql.*;
//import java.beans.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class DBConnectMedicineInformation 

{
    
private Connection con;
    private Statement st;
    private ResultSet rs;
    public DBConnectMedicineInformation()
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
            String query="insert into medicineinfo(medname,username,count,morningalarm,dayalarm,nightalarm) values "
            +"('"+row.get(0)+"','"+row.get(1)+"',"+row.get(2)+",'"+row.get(3)+"','"+row.get(4)+"','"+row.get(5)+"');";
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
    public void updateMedInfo(ArrayList row,String mName,String uName)
    {
        try
        {
            String query="update medicineinfo set medname='"+row.get(0)+"' ,username='"+row.get(1)+"' ,count="+row.get(2)+" ,morningalarm='"+row.get(3)+"' ,dayalarm='"+row.get(4)+"' ,nightalarm='"+row.get(5)+"' where medname='"+mName+"' and username='"+uName+"';";
            System.out.println(query);
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Medicine info Updated Successfully");
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null,"Updatingdatabase Exception :"+e); 
            System.out.println(e);
        }
        
    }
    
    
    public void updateAlarmMed(String name)
    {
        try
        {
            String query="update medicineinfo set count=count-1 where "+name+"alarm='ON' and count>0;";
            System.out.println(query);
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Medicine info Updated Successfully");
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null,"Updatingdatabase Exception :"+e); 
            System.out.println(e);
        }
        
    }
    
    
    
    
    public ResultSet getResultMnN(String mName,String uName) 
    {
        try 
        {
            String query = "select count,morningalarm,dayalarm,nightalarm from medicineinfo where medname='"+mName+"' and username='"+uName+"';";
            rs = st.executeQuery(query);
        } 
        catch (Exception e) 
        {
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
        return rs;
    }
    
    
    public ResultSet getResultSet(String uName) 
    {
        try 
        { 
            System.out.println("Hello");
            String query = "select medname,username,count,morningalarm,dayalarm,nightalarm from medicineinfo where username='"+uName+"';";
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
    
    public ResultSet getResultSpecificTime(String time) 
    {
        try 
        {
            String query = "select medname,username,count from medicineinfo where "+time+"alarm='ON' and count !=0;";
            rs = st.executeQuery(query);
        } 
        catch (Exception e) 
        {
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
        return rs;
    }
    
    
    public ResultSet getOutOfMed() 
    {
        try 
        {
            String query = "select medname,username,count from medicineinfo where count<3;";
            rs = st.executeQuery(query);
        } 
        catch (Exception e) 
        {
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
        return rs;
    }
    
    
    
    
    
    public void deleteMed(String uName,String mName) 
    {
        try 
        {
            String query = "delete from medicineinfo where username='"+uName+"' and medname='"+mName+"';";
            st.executeUpdate(query);
            FirstInfoFrame FIF = new FirstInfoFrame();
            FIF.loadDoClick();
            
        } 
        catch (Exception e) 
        {
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
        
    }


        
}
