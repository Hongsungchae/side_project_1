package org.joinup.app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.DriverManager;

@SpringBootTest
class AppApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void DBConnectionTests() {


        try (
                Connection con = DriverManager.getConnection(
                        "jdbc:mariadb://localhost:3306/joinupdb??characterEncoding=UTF-8",
                        "joinup_jy",
                        "wjddyd123"
                )) {
            System.out.println(con);
        } catch (Exception e) {

        }

    }
}
