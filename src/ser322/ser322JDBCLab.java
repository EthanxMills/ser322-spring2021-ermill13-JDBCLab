package src.ser322;
import java.sql.*;


class ser322JDBCLab{
    
    
    public void query1(){//creation for query1, I downloaded the JDBC Driver From SQL Community so hope this works

        try{

            Class.forName("com.mysql.jdbc.Driver");//Line to Load the Driver from MySQL Community

        }catch(Exception exception){
            System.out.println(exception);
        }

    }
}