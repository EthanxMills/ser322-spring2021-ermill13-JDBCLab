package src.ser322;
import java.sql.*;

import javax.naming.spi.DirStateFactory.Result;


class ser322JDBCLab{
    
    
    public void query1(){//creation for query1, I downloaded the JDBC Driver From SQL Community so hope this works

        try{

            Class.forName("com.mysql.jdbc.Driver");//Line to Load the Driver from MySQL Community

            Connection con=DriverManager.getConnection(
            "jdbc:mysql://127.0.0.1:3306/jdbclab","root","romanmiller"); //The LocalInstance made by Workbench was all weird so I made a new one, should connect
            
            Statement stmnt = con.createStatement();//Create Statement

            String queryHolder = "SELECT empno,ename,dept.DNAME from emp,dept WHERE emp.deptno=dept.DEPTNO";
            ResultSet rSet = stmnt.executeQuery(queryHolder);//Execute whatever is in the query string and store in rSet


        }catch(Exception exception){
            System.out.println(exception);
        }

    }
}