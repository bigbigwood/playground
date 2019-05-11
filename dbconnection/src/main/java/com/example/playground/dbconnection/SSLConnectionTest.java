package com.example.playground.dbconnection;


import java.sql.*;
import java.util.Properties;


public class SSLConnectionTest {

    public static void main(String[] args){
        test();
    }

    private static void test(){
        ResultSet rs = null;
        Statement stmt = null;
        Connection conn = null;
        String sql = null;

        try {
            String url="jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=127.0.0.1)(PORT=1521))(CONNECT_DATA=(SID=orcl)))";
            Properties props = new Properties();
            props.setProperty("user", "c##test");
            props.setProperty("password", "123456");
            props.setProperty("oracle.net.encryption_client", "REQUIRED");
            props.setProperty("oracle.net.encryption_types_client", "(AES256,AES192,AES128)");
            conn = DriverManager.getConnection(url, props);

            System.out.println("=======================================");

            stmt = conn.createStatement();
            sql = "select * from MYTABLE";


//            sql = "select sys_context('userenv', 'network_protocol') as network_protocol from dual";
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                String name = rs.getString("name");
                System.out.println("name:" + name);
                System.out.println();
            }
            rs.close();



        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null){
                    rs.close();
                    rs = null;
                }
                if (stmt != null){
                    stmt.close();
                    stmt = null;
                }
                if (conn != null){
                    conn.close();
                    conn = null;
                }


            } catch (Exception ex){
                ex.printStackTrace();
            }
        }

    }
}
