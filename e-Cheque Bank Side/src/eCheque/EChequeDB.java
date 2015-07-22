/*
 * EChequeDB.java
 *
 * Created on June 6, 2007, 6:02 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package eCheque;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Saad
 */


public class EChequeDB {
    
    private static final String JDBC_DRIVER ="com.mysql.jdbc.Driver";   
    private static final String DATABASE_URL = "jdbc:mysql://ebankSeng426.db.9903859.hostedresource.com";; //DATABASE_URL = "jdbc:mysql://localhost/ebank";
    private String userName;
    private String password;
    private Connection connection = null; 
    private Statement  sqlStatement = null; 
    private int databaseMode;
    private ResultSet resultSet;


    /** Creates a new instance of EChequeDB */
    public EChequeDB() {
        userName ="se426g01";
        password="8cLWdS5Q";

        //userName ="seng426";
        //password="log2IT05";
        
    }
    
    private boolean connectToDataBase()throws ClassNotFoundException, SQLException{
         // Initialize Connection to DB:
         Class.forName(JDBC_DRIVER); // load database driver class
         // establish connection to database                              
         connection = DriverManager.getConnection( DATABASE_URL,userName,password);
         return true;
    }
    
    private boolean closeDataBaseConnection(){
        try {
            // close the database connection channel
            connection.close();                                     
            sqlStatement.close();
            //JOptionPane.showMessageDialog(null,"You are disconnected to e-Cheque Bank DB","DB State",JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        catch(SQLException exp){
            //JOptionPane.showMessageDialog(null,exp.getMessage(),"DB Error",JOptionPane.ERROR_MESSAGE);
            exp.printStackTrace();
            return false;
        }
    }
    
    private boolean createStatement()throws SQLException{
        
        sqlStatement = connection.createStatement();
        return true;
    }
    
    private void executeSQLStatement(String statement, int statType) throws SQLException{
        
        // Initialize sql statement and excute it.
        
        if(statType == 0){
            resultSet = sqlStatement.executeQuery(statement);
            
        }
        if(statType==1){
            sqlStatement.executeUpdate(statement);
        }
    
    }

    // returns true if database query succeeds, otherwise returns false
    public boolean runDB(int mode, String databaseStat){
        databaseMode = mode;
        boolean flag= false;
        try{
            connectToDataBase();
            //JOptionPane.showMessageDialog(null,"You are connected to e-Cheque Bank DB","DB State",JOptionPane.INFORMATION_MESSAGE);
            createStatement();
            //JOptionPane.showMessageDialog(null,"You have created statement","DB State",JOptionPane.INFORMATION_MESSAGE);
                 
            // run the specific sql statement
            executeSQLStatement(databaseStat, databaseMode);
            flag = true;
        }
        catch(ClassNotFoundException exp){
            //JOptionPane.showMessageDialog(null,exp.getMessage(),"DB Error",JOptionPane.ERROR_MESSAGE);
            exp.printStackTrace();
            
        }
        catch(SQLException exp){
            //JOptionPane.showMessageDialog(null,exp.getMessage(),"DB Error",JOptionPane.ERROR_MESSAGE);
            exp.printStackTrace();
                    
        }
        finally{
            closeDataBaseConnection();
        }
        if(flag)
            return true;
        else
            return false;
    }

    public boolean runDBAndSetBalanceFromResultSet(int mode, String databaseStat, double[] balance){
        databaseMode = mode;
        boolean flag= false;
        
        try{
            connectToDataBase();
            JOptionPane.showMessageDialog(null,"You are connected to e-Cheque Bank DB","DB State",JOptionPane.INFORMATION_MESSAGE);
            createStatement();
            JOptionPane.showMessageDialog(null,"You have created statement","DB State",JOptionPane.INFORMATION_MESSAGE);
                 
            // run the specific sql statement
            executeSQLStatement(databaseStat, databaseMode);
            if(resultSet.next()){
                balance[0] = resultSet.getDouble(1);
                flag = true;
            }
            else {
                balance[0]=0.0;
                flag = false;
            }
        }
        catch(ClassNotFoundException exp){
            JOptionPane.showMessageDialog(null,exp.getMessage(),"DB Error",JOptionPane.ERROR_MESSAGE);
            exp.printStackTrace();
            
        }
        catch(SQLException exp){
            JOptionPane.showMessageDialog(null,exp.getMessage(),"DB Error",JOptionPane.ERROR_MESSAGE);
            exp.printStackTrace();
                    
        }
        finally{
            closeDataBaseConnection();
        }
        if(flag)
            return true;
        else
            return false;
    }

    // returns true if database  query returns a result set with >= 1 row, otherwise returns false
    public boolean runDBAndCheckResultSetHasMoreThanZeroRows(int mode, String databaseStat){
        databaseMode = mode;
        boolean flag= false;
        
        try{
            connectToDataBase();
            JOptionPane.showMessageDialog(null,"You are connected to e-Cheque Bank DB","DB State",JOptionPane.INFORMATION_MESSAGE);
            createStatement();
            JOptionPane.showMessageDialog(null,"You have created statement","DB State",JOptionPane.INFORMATION_MESSAGE);
                 
            // run the specific sql statement
            executeSQLStatement(databaseStat, databaseMode);
            if(resultSet.next()){
                 flag = true;
            }
            else {
                 flag = false;
            }
        }
        catch(ClassNotFoundException exp){
            JOptionPane.showMessageDialog(null,exp.getMessage(),"DB Error",JOptionPane.ERROR_MESSAGE);
            exp.printStackTrace();
            
        }
        catch(SQLException exp){
            JOptionPane.showMessageDialog(null,exp.getMessage(),"DB Error",JOptionPane.ERROR_MESSAGE);
            exp.printStackTrace();
        }
        finally{
            closeDataBaseConnection();
        }
        if(flag)
            return true;
        else
            return false;
    }
}