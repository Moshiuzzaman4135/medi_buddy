
package projectmedidemo1;

import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class ProjectMediDemo1MainClass 
{
    public static void main(String[] args) 
    {
    try
        {        
        int rowcount=0;
        DBConnectMedicineInformation D = new DBConnectMedicineInformation();
        ResultSet rs3 = D.getOutOfMed();
        while(rs3.next())
        {
        rowcount++; 
        }
        System.out.println(rowcount);
        if(rowcount>0)
        {
        OutOfMedFrame OMF = new OutOfMedFrame();
        OMF.setTable(rs3);    
        OMF.setVisible(true);
        }    
        }
    catch(Exception e)
        {
            System.out.println("Error:" +e);
            e.printStackTrace();                    
        } 
    ThreadAlarm tt = new ThreadAlarm();
    tt.start();
    FirstInfoFrame FIF = new FirstInfoFrame();
    FIF.setVisible(true);
    
    }
    
}
