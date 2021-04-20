package src.ser322;
import java.sql.*;


class ser322JDBCLab{
    
    public static void main(String[] args){
        try{

            Connection con = null;
            String url = args[0]; 
            String user = args[1];
            String pwd = args[2];
            String driver = args[3];
            String query = args[4];

            try{

                Class.forName(driver);
                con = DriverManager.getConnection(url, user, pwd);

            }catch(Exception exception){
                System.out.println(exception);
            }

            switch(query){
                case "query1":
                    query1(con);
                case "query2":
                    query2(con);
                case "dml1":
                    query1(con);//CHANGE TO dml1
                default:
                    System.out.println("Invalid Query Try Again");   
            }

        }catch(Exception exception){
            exception.printStackTrace();
        }
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    protected static void query1(Connection con){//creation for query1, assuming args are given as in the doc I can pass the connect
        try{
            Statement stmnt = con.createStatement();//Create Statement

            String queryHolder = "SELECT empno,ename,dept.DNAME from emp,dept WHERE emp.deptno=dept.DEPTNO";//Query to be ran for Act 1.1
            ResultSet rSet = stmnt.executeQuery(queryHolder);//Execute whatever is in the query string and store in rSet

            while(rSet.next()){
                System.out.println(rSet.getInt(1) + " | " + rSet.getString(2) + " | " + rSet.getString(3));//Adding space with border to allign the columns
            }
            con.close();
        }catch(SQLException exception){
            exception.printStackTrace();
        }
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    protected static void query2(Connection con){
        try{
            
            String prepStat = "select dept.DNAME,customer.NAME,product.PRICE from product,customer,dept where product.MADE_BY and product.PRODID=customer.PID;";
            PreparedStatement pStat=con.prepareStatement(prepStat);

            ResultSet rSet = pStat.executeQuery();//Execute whatever is in the query string and store in rSet

            while(rSet.next()){
                System.out.println(rSet.getInt(1) + " | " + rSet.getString(2) + " | " + rSet.getString(3));//Adding space with border to allign the columns
            }
            con.close();
        }catch(SQLException exception){
            exception.printStackTrace();
        }

    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    protected static void dml1(Connection con){
        try{
            

            
        }catch(SQLException exception){
            exception.printStackTrace();
        }
    }
}