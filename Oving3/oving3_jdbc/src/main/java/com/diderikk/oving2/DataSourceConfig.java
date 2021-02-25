package com.diderikk.oving2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource getDataSource() throws IOException {
        BufferedReader bReader = new BufferedReader(new FileReader("./configuration"));
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:mysql://mysql.stud.iie.ntnu.no:3306/diderikk");
        String dbUser = bReader.readLine();
        String pass = bReader.readLine();
        bReader.close();
        dataSourceBuilder.username(dbUser);
        dataSourceBuilder.password(pass);
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");

        return dataSourceBuilder.build();
    }
}
