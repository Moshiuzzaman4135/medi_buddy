
package projectmedidemo1;

import java.sql.ResultSet;
import java.util.Date;

public class ThreadAlarm extends Thread
{
    public void run()
        {
            
        try
        {
            
        //jTextFieldMorning.setText(rs.getString("morningalarm"));
        //jTextFieldDay.setText(rs.getString("dayalarm"));
        //jTextFieldNight.setText(rs.getString("nightalarm")); 
        int flag=0;
        Date ndate = new Date();    
        String ntime = String.format("%2$tH:%2$tM:%2$tS","", ndate);
        System.out.println("Current Time : "+ntime);
        DBConnectAlarmTime DBAT = new DBConnectAlarmTime();
        
        while(true)
            {
        
        ResultSet rs2 = DBAT.getAlarmTime(); 
        while(rs2.next()){  
            
        String morning = rs2.getString("morningalarm");
        String day = rs2.getString("dayalarm");
        String night = rs2.getString("nightalarm");
        //rs2.deleteRow();
            Date date = new Date();    
            String time = String.format("%2$tH:%2$tM:%2$tS","", date);
            
            if(morning.equals(time) && flag==0)
                {
                System.out.println("Wake Up");
                AlarmFrame AF = new AlarmFrame();
                AF.setDataFrame("morning");
                AF.setVisible(true);
                //flag=1;
                Thread.sleep(1000);
                }
            if(day.equals(time) && flag==0)
                {
                System.out.println("Wake Up");
                AlarmFrame AF = new AlarmFrame();
                AF.setDataFrame("day");
                AF.setVisible(true);
                //flag=1;
                Thread.sleep(1000);
                }
            if(night.equals(time) && flag==0)
                {
                System.out.println("Wake Up");
                AlarmFrame AF = new AlarmFrame();
                AF.setDataFrame("night");
                AF.setVisible(true);
                //flag=1;
                Thread.sleep(1000);
                }
            
            
            
            //System.out.println(flag+"    "+night+"\t"+time);
            }
        
        
        
        
        
        
        }
        }
        
        catch(Exception e)
        {
            System.out.println("Error:" +e);
            e.printStackTrace();                    
        }
        
        }
    
}
