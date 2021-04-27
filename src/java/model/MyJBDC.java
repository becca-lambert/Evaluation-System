/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.*;
import java.sql.*;
/**
 *
 * @author BECCA
 */
public class MyJBDC {
    //Connect to DB
    public static Connection getConnection() {
        Connection con=null;
        try {
            //Connect to MyDB
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/MyDB", "admin", "admin");
        } 
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }return con;
    }
    //Code for login auth
    public static int loginauth(com.UserInput e){
        int status=0;
     
        
        try {
            Connection con=MyJBDC.getConnection(); 
            PreparedStatement ps=con.prepareStatement("select * from APP.USERS where UNAME = ? and PASSWD = ?  and ROLE = 'teamleader'");
            ps.setString(1,e.getUsername());
            ps.setString(2,e.getPassword());
            
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            boolean test = rs.next();
            if (test){
                status = 2;
                return status;
            }
            else{
                status = 0;
            }
            con.close();
            
        }catch(Exception ex) {ex.printStackTrace();}
        
        try {
            Connection con=MyJBDC.getConnection(); 
            PreparedStatement ps=con.prepareStatement("select * from APP.USERS where UNAME = ? and PASSWD = ?  and ROLE = 'employee'");
            ps.setString(1,e.getUsername());
            ps.setString(2,e.getPassword());
            
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            boolean test = rs.next();
            if (test){
                status = 3;
                return status;
            }
            else{
                status = 0;
            }
            con.close();
            
        }catch(Exception ex) {ex.printStackTrace();}
        
        try {
            Connection con=MyJBDC.getConnection(); 
            PreparedStatement ps=con.prepareStatement("select * from APP.USERS where UNAME = ? and PASSWD = ?  and ROLE = 'headoffice'");
            ps.setString(1,e.getUsername());
            ps.setString(2,e.getPassword());
            
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            boolean test = rs.next();
            if (test){
                status = 5;
                return status;
            }
            else{
                status = 0;
            }
            con.close();
            
        }catch(Exception ex) {ex.printStackTrace();}
        
        try {
            Connection con=MyJBDC.getConnection(); 
            PreparedStatement ps=con.prepareStatement("select * from APP.USERS where UNAME = ? and PASSWD = ?  and ROLE = 'manager'");
            ps.setString(1,e.getUsername());
            ps.setString(2,e.getPassword());
            
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            boolean test = rs.next();
            if (test){
                status = 6;
                return status;
            }
            else{
                status = 0;
            }
            con.close();
            
        }catch(Exception ex) {ex.printStackTrace();}
        
 
        return status;
    }
    //Code for adding to USERS table
    public static int saveuser(com.UserInput e){
        int status=0;
        try {
            Connection con=MyJBDC.getConnection();
            PreparedStatement ps=con.prepareStatement("insert into APP.USERS(UNAME, PASSWD, ROLE) values (?,?,?)");   
            ps.setString(1,e.getUsername());
            ps.setString(2,e.getPassword());
            ps.setString(3,e.getRole());
            
            status=ps.executeUpdate();
            con.close();
        }catch(Exception ex) {ex.printStackTrace();}
        return status;
    }
    public static int saveEmployeeDetails(com.UserInput e){
        int status=0;
        try {
            Connection con=MyJBDC.getConnection();
            PreparedStatement ps=con.prepareStatement("insert into APP.EMPLOYEE(ENAME, EADDRESS, UNAME) values (?,?,?)");   
            ps.setString(1,e.getName());
            ps.setString(2,e.getAddress());
            ps.setString(3,e.getUsername());
            
            status=ps.executeUpdate();
            con.close();
        }catch(Exception ex) {ex.printStackTrace();}
        return status;
    }
    

    public static int savedate(com.UserInput e){
        int status=0;
        try {
            Connection con=MyJBDC.getConnection();
            PreparedStatement ps=con.prepareStatement("insert into APP.MEETINGS(DATE, TIME, REASON, NAME, MANAGER) values (?,?,?,?,?)");  

            ps.setString(1,e.getDate());
            ps.setString(2,e.getTime());
            ps.setString(3,e.getReason());
            ps.setString(4,e.getName());
            ps.setString(5,e.getDN());
              
            
            
            status=ps.executeUpdate();
            con.close();
        }catch(Exception ex) {ex.printStackTrace();}
        return status;
    }
    
    
    
    
 

    
    public static List<com.UserInput> getAllDates(){
        List list=new ArrayList();
        try{
            Connection con=MyJBDC.getConnection();
            
          
            PreparedStatement ps=con.prepareStatement("select * from APP.SCHEDULE");
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                com.UserInput e= new com.UserInput();
            
                e.setDate(rs.getString(1));
                e.setBR(rs.getString(2));
                e.setKIT(rs.getString(3));
                e.setBAR(rs.getString(4));
                e.setSERVICE(rs.getString(5));
                e.setDF(rs.getString(6));
              
                list.add(e);
            }
            con.close();
        }catch(Exception x){x.printStackTrace();}
        return list;
    }




   
    public static int Complaint(com.UserInput e){
        int status=0;
        try {
            Connection con=MyJBDC.getConnection();
            PreparedStatement ps=con.prepareStatement("insert into APP.COMPLAINTS(NAME,ISSUE, MADEBY, DATE) values (?,?,?,?)");   
            ps.setString(1,e.getCName());
            ps.setString(2,e.getissue());
            ps.setString(3,e.getCdate());
            ps.setString(4,e.getMadeBy());
            
            
            
            status=ps.executeUpdate();
            con.close();
        }catch(Exception ex) {ex.printStackTrace();}
        return status;
    }
 
     public static int SelfEvaluation(com.UserInput e){
        int status=0;
        try {
            Connection con=MyJBDC.getConnection();
            PreparedStatement ps=con.prepareStatement("insert into APP.SELFEVALUATION(Q1,Q2, ENAME,Q3,Q4,Q5,Q6,Q7,Q8,Q9) values (?,?,?,?,?,?,?,?,?,?)");   
            ps.setInt(1,e.getEQ1());
            ps.setString(3,e.getEQname());
            ps.setInt(2,e.getEQ2());
            ps.setInt(4,e.getEQ3());
            ps.setInt(5,e.getEQ4());
            ps.setInt(6,e.getEQ5());
            ps.setInt(7,e.getEQ6());
            ps.setInt(8,e.getEQ7());
            ps.setInt(9,e.getEQ8());
            ps.setInt(10,e.getEQ9());
            
      
            status=ps.executeUpdate();
            con.close();
        }catch(Exception ex) {ex.printStackTrace();}
        return status;
     }
      public static List<com.UserInput> getSchedule(com.UserInput e){
        List list=new ArrayList();
        try{
            Connection con=MyJBDC.getConnection();
            
            PreparedStatement ps=con.prepareStatement("select * from APP.SCHEDULE where NAME = ?");
            
            ps.setString(1,e.getun());
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                com.UserInput x= new com.UserInput();
           
          
                x.setName(rs.getString(1));
                x.setAddress(rs.getString(3));
                
                list.add(x);
            }
            con.close();
        }catch(Exception x){x.printStackTrace();}
        return list;
    }
       public static List<com.UserInput> getMeetings(){
        List list=new ArrayList();
        try{
            Connection con=MyJBDC.getConnection();
            
            
            PreparedStatement ps=con.prepareStatement("select * from APP.MEETINGS");
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                com.UserInput e= new com.UserInput();
                 
                e.setDate(rs.getString(2));
                e.setTime(rs.getString(4));
                e.setReason(rs.getString(3));
                e.setName(rs.getString(1));
                e.setDN(rs.getString(5));
                list.add(e);
            }
            con.close();
        }catch(Exception x){x.printStackTrace();}
        return list;
    }
       
       public static List<com.UserInput> getComplaints(){
        List list=new ArrayList();
        try{
            Connection con=MyJBDC.getConnection();
            
           
            PreparedStatement ps=con.prepareStatement("select * from APP.COMPLAINTS");
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                com.UserInput e= new com.UserInput();
                 
                e.setCName(rs.getString(1));
                e.setissue(rs.getString(2));
                e.setCdate(rs.getString(3));
                e.setMadeBy(rs.getString(4));
               
                list.add(e);
            }
            con.close();
        }catch(Exception x){x.printStackTrace();}
        return list;
    }
      public static int EmployeeEvaluation(com.UserInput e){
        int status=0;
        try {
            Connection con=MyJBDC.getConnection();
            PreparedStatement ps=con.prepareStatement("insert into APP.EVALUATION(Q1,Q2, ENAME,Q3,Q4,Q5,Q6,Q7,Q8,Q9) values (?,?,?,?,?,?,?,?,?,?)");   
            ps.setInt(1,e.getEQ1());
            ps.setString(3,e.getEQname());
            ps.setInt(2,e.getEQ2());
            ps.setInt(4,e.getEQ3());
            ps.setInt(5,e.getEQ4());
            ps.setInt(6,e.getEQ5());
            ps.setInt(7,e.getEQ6());
            ps.setInt(8,e.getEQ7());
            ps.setInt(9,e.getEQ8());
            ps.setInt(10,e.getEQ9());
            
      
            status=ps.executeUpdate();
            con.close();
        }catch(Exception ex) {ex.printStackTrace();}
        return status;
     }
             public static List<com.UserInput> getBranch(){
        List list=new ArrayList();
        try{
            Connection con=MyJBDC.getConnection();
            
           
            PreparedStatement ps=con.prepareStatement("select * from APP.BRANCHDATA");
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                com.UserInput e= new com.UserInput();
                e.setjans(rs.getInt(1));
                e.setfebs(rs.getInt(2));
                e.setmarchs(rs.getInt(3));
              
                list.add(e);
            }
            con.close();
        }catch(Exception x){x.printStackTrace();}
        return list;
    }
             
     public static int Schedule(com.UserInput e){
        int status=0;
        try {
            Connection con=MyJBDC.getConnection();
            PreparedStatement ps=con.prepareStatement("insert into APP.SCHEDULE(DATE,BR, KIT,BAR,SERVICE,DAYOFF) values (?,?,?,?,?,?)");   
            ps.setString(1,e.getDate());
            ps.setString(2,e.getBR());
            ps.setString(3,e.getKIT());
            ps.setString(4,e.getBAR());
            ps.setString(5,e.getSERVICE());
            ps.setString(6,e.getDF());
            
            
            
            status=ps.executeUpdate();
            con.close();
        }catch(Exception ex) {ex.printStackTrace();}
        return status;
    }
     
     
     
      public static List<com.UserInput> getResults(){
        List list=new ArrayList();
        try{
            Connection con=MyJBDC.getConnection();
            
           
            PreparedStatement ps=con.prepareStatement("select * from APP.DATA");
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                com.UserInput e= new com.UserInput();
                e.setEQ1(rs.getInt(1));
                e.setEQ2(rs.getInt(2));
               e.setEQ3(rs.getInt(3));
               e.setEQ4(rs.getInt(4));
               e.setEQ5(rs.getInt(5));
               e.setEQ6(rs.getInt(6));
               e.setEQ7(rs.getInt(7));
               e.setEQ8(rs.getInt(8));
               e.setEQ9(rs.getInt(9));
               e.setlates(rs.getInt(10));
               e.setweeksales(rs.getInt(11));
               e.setadvsales(rs.getInt(12));
               e.setlastweeksales(rs.getInt(13));
              
                list.add(e);
            }
            con.close();
        }catch(Exception x){x.printStackTrace();}
        return list;
    }

    
     
}