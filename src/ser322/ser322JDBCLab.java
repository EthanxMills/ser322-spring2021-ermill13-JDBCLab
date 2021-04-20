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
                    break;
                case "query2":
                    String Dept = args[5];
                    int DeptNo = Integer.parseInt(Dept);
                    query2(con, DeptNo);
                    break;
                case "dml1":
                    String CustomerID = args[5];
                    int CID = Integer.parseInt(CustomerID);
                    String ProductID = args[6];
                    int PID = Integer.parseInt(ProductID);
                    String name = args[7];
                    String quantity = args[8];
                    int Q = Integer.parseInt(quantity);
                    dml1(con,CID,PID,name, Q);
                    break;
                default:
                    System.out.println("Invalid Query Try Again");
                    break;   
            }

        }catch(Exception exception){
            exception.printStackTrace();
        }
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    protected static void query1(Connection con){//creation for query1, assuming args are given as in the doc I can pass the connect
        try{
            Statement stmnt = con.createStatement();//Create Statement

            String queryHolder = "SELECT emp.empno,emp.ename,dept.DNAME from emp,dept WHERE emp.deptno=dept.DEPTNO";//Query to be ran for Act 1.1
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
    protected static void query2(Connection con, int DeptNo){
        try{
            
            
            String prepStat = "select dept.DNAME,customer.NAME,product.PRICE from product,customer,dept where product.MADE_BY=? and product.PRODID=customer.PID";
            PreparedStatement pStat=con.prepareStatement(prepStat);//Back check to work in DeptNo
            pStat.setInt(1,DeptNo);

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
    protected static void dml1(Connection con, int CID, int PID, String name, int quantity){
        try{
            
            String prepStat = "insert dept.DNAME,customer.NAME,product.PRICE from product,customer,dept where product.MADE_BY=? and product.PRODID=customer.PID";
            PreparedStatement pStat=con.prepareStatement(prepStat);
            

            pStat.executeUpdate();//Execute whatever is in the query string and store in rSet

            System.out.println("Success!");
            con.close();
        }catch(SQLException exception){
            exception.printStackTrace();
        }
    }
}