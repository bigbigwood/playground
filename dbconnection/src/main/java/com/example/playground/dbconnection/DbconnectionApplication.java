package com.example.playground.dbconnection;

import com.zaxxer.hikari.HikariDataSource;

import oracle.jdbc.pool.OracleDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

@SpringBootApplication
public class DbconnectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbconnectionApplication.class, args);
    }

    @Bean
    public DataSource dataSource() throws SQLException {
        String url="jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=127.0.0.1)(PORT=1521))(CONNECT_DATA=(SID=orcl)))";
        Properties props = new Properties();
        props.setProperty("oracle.net.encryption_client", "REQUIRED");
        props.setProperty("oracle.net.encryption_types_client", "(AES256,AES192,AES128)");


        OracleDataSource oracleDs = new OracleDataSource();
        oracleDs.setURL(url);
        oracleDs.setUser("c##test");
        oracleDs.setPassword("123456");
        oracleDs.setConnectionProperties(props);
        // other Oracle related settings...

        HikariDataSource hikariDs = new HikariDataSource();
        hikariDs.setDataSource(oracleDs);
//        hikariDs.setConnectionInitSql("ALTER SESSION SET CURRENT_SCHEMA = MY_SCHEMA");

        return hikariDs;
    }

}
