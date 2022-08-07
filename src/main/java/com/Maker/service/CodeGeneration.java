package com.Maker.service;

import com.Maker.model.Clinic;
import com.Maker.model.UserDTO;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class CodeGeneration {

   public static String GenerateApp(String ClinicName) throws IOException {

       Path path
               = Paths.get("Servers\\"+ClinicName+"\\spring-boot-jwt-25-7\\src\\main\\resources\\application.properties");


        String app_prop = String.format("jwt.secret=javainuse\n" +
                        "spring.datasource.url=jdbc:mysql://localhost:3306/%1$s?useSSL=false&createDatabaseIfNotExist=true\n" +
                        "spring.datasource.username=root\n" +
                        "spring.datasource.password=\n" +
                        "spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver\n" +
                        "spring.datasource.initialization-mode=always\n" +
                        "spring.jpa.hibernate.ddl-auto=update\n" +
                        "spring.jpa.database-platform=org.hibernate.dialect.MySQL57Dialect\n" +
                        "spring.jpa.generate-ddl=true\n" +
                        "spring.jpa.show-sql=true\n"+
                "spring.jmx.default-domain=%1$s"

                , ClinicName

        );








       // with path , content & standard charsets
       Files.writeString(path, app_prop,
               StandardCharsets.UTF_8);


        return app_prop;
    }


    public static String GeneratePom(String ClinicName) throws IOException {

        Path path
                = Paths.get("Servers\\"+ClinicName+"\\spring-boot-jwt-25-7\\pom.xml");


        String app_prop = String.format("<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">\n" +
                "  <modelVersion>4.0.0</modelVersion>\n" +
                "  <groupId>com.javainuse</groupId>\n" +
                "  <artifactId>%s</artifactId>\n" +
                "  <version>0.0.1-SNAPSHOT</version>\n" +
                "\t<packaging>war</packaging>\n" +
                "\t<parent>\n" +
                "\t\t<groupId>org.springframework.boot</groupId>\n" +
                "\t\t<artifactId>spring-boot-starter-parent</artifactId>\n" +
                "\t\t<version>2.1.1.RELEASE</version>\n" +
                "\t\t<relativePath /> <!-- lookup parent from repository -->\n" +
                "\t</parent>\n" +
                "\n" +
                "\n" +
                "\t<properties>\n" +
                "\t\t<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>\n" +
                "\t\t<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>\n" +
                "\t\t<java.version>1.8</java.version>\n" +
                "\t</properties>\n" +
                "\n" +
                "\t<dependencies>\n" +
                "\t\t<dependency>\n" +
                "\t\t\t<groupId>org.springframework.boot</groupId>\n" +
                "\t\t\t<artifactId>spring-boot-starter-tomcat</artifactId>\n" +
                "\t\t\t<scope>provided</scope>\n" +
                "\t\t</dependency>\n" +
                "\t\t<dependency>\n" +
                "\t\t\t<groupId>org.springframework.boot</groupId>\n" +
                "\t\t\t<artifactId>spring-boot-starter-web</artifactId>\n" +
                "\t\t</dependency>\n" +
                "\t\t\n" +
                "\t\t<dependency>\n" +
                "\t\t\t<groupId>org.springframework.boot</groupId>\n" +
                "\t\t\t<artifactId>spring-boot-starter-security</artifactId>\n" +
                "\t\t</dependency>\n" +
                "\t\t<dependency>\n" +
                "\t\t\t<groupId>io.jsonwebtoken</groupId>\n" +
                "\t\t\t<artifactId>jjwt</artifactId>\n" +
                "\t\t\t<version>0.9.1</version>\n" +
                "\t\t</dependency>\n" +
                "\t\t\n" +
                "\t\t<dependency>\n" +
                "\t\t\t<groupId>org.springframework.boot</groupId>\n" +
                "\t\t\t<artifactId>spring-boot-starter-data-jpa</artifactId>\n" +
                "\t\t</dependency>\n" +
                "\t\t<dependency>\n" +
                "\t\t\t<groupId>mysql</groupId>\n" +
                "\t\t\t<artifactId>mysql-connector-java</artifactId>\n" +
                "\t\t</dependency>\n" +
                "\t\t<dependency>\n" +
                "\t\t\t<groupId>org.projectlombok</groupId>\n" +
                "\t\t\t<artifactId>lombok</artifactId>\n" +
                "\t\t\t<version>1.18.24</version>\n" +
                "\t\t</dependency>\n" +
                "\n" +
                "\t</dependencies>\n" +
                "\n" +
                "\t<build>\n" +
                "\t\t<finalName>${artifactId}</finalName>\n" +
                "\t</build>\n" +
                "\n" +
                "</project>"  , ClinicName

        );








        // with path , content & standard charsets
        Files.writeString(path, app_prop,
                StandardCharsets.UTF_8);


        return app_prop;
    }


    public static String GenerateData(Clinic clinic) throws IOException {


       Path path
               = Paths.get("Servers\\"+clinic.getUsername()+"\\spring-boot-jwt-25-7\\src\\main\\resources\\data.sql");

        String data_sql = String.format("INSERT IGNORE into  %1$s.clinic(owner_name,clinic_name,clinic_address,clinic_phone,mobile_phone,username,email) values (\"%2$s\",\"%3$s\",\"%4$s\",\"%5$s\",\"%6$s\",\"%1$s\",\"%7$s\")\n" +
                        "INSERT IGNORE INTO  %1$s.user (address,email,full_name,number,password,role, username) VALUES ('%4$s', '%7$s', '%2$s', '%6$s', '$2a$10$RjBzgUbLdqKTMMvEjKTd9OuJxUoIuYr6FyDV6sFW7Tlh4pX412uXa', '3', '%1$s');\n" +
                        "\n" +
                        "\n" +
                        "--TODO change names\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', '1', 'permanent');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', '2', 'permanent');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', '3', 'permanent');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', '4', 'permanent');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', '5', 'permanent');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', '6', 'permanent');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', '7', 'permanent');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', '8', 'permanent');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', '9', 'permanent');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', '10', 'permanent');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', '11', 'permanent');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', '12', 'permanent');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', '13', 'permanent');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', '14', 'permanent');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', '15', 'permanent');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', '16', 'permanent');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', '17', 'permanent');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', '18', 'permanent');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', '19', 'permanent');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', '20', 'permanent');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', '21', 'permanent');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', '22', 'permanent');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', '23', 'permanent');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', '24', 'permanent');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', '25', 'permanent');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', '26', 'permanent');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', '27', 'permanent');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', '28', 'permanent');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', '29', 'permanent');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', '30', 'permanent');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', '31', 'permanent');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', '32', 'permanent');\n" +
                        "\n" +
                        "\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', 'A', 'deciduous');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', 'B', 'deciduous');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', 'C', 'deciduous');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', 'D', 'deciduous');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', 'E', 'deciduous');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', 'F', 'deciduous');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', 'G', 'deciduous');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', 'H', 'deciduous');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', 'I', 'deciduous');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', 'J', 'deciduous');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', 'K', 'deciduous');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', 'L', 'deciduous');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', 'M', 'deciduous');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', 'N', 'deciduous');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', 'O', 'deciduous');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', 'P', 'deciduous');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', 'Q', 'deciduous');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', 'R', 'deciduous');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', 'S', 'deciduous');\n" +
                        "INSERT IGNORE INTO  %1$s.tooth (id, name, tooth_number, type) VALUES (NULL, 'lower', 'T', 'deciduous');"
                , clinic.getUsername() , clinic.getOwnerName() , clinic.getClinicName() , clinic.getClinicAddress() , clinic.getClinicPhone() , clinic.getMobilePhone(), clinic.getEmail()

        );

       // with path , content & standard charsets
       Files.writeString(path, data_sql,
               StandardCharsets.UTF_8);



        return data_sql;


    }


}
