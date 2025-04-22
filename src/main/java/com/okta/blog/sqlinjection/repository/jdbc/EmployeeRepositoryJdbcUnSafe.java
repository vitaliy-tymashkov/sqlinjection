package com.okta.blog.sqlinjection.repository.jdbc;

import com.okta.blog.sqlinjection.controller.EmployeeController;
import com.okta.blog.sqlinjection.domain.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepositoryJdbcUnSafe extends EmployeeRepositoryJdbc {
    private static final Logger log = LoggerFactory.getLogger(EmployeeRepositoryJdbcUnSafe.class);

    @Override
    public List<Employee> filterByUsername(String name) {
        String query = "select * from employee where name ='" + name + "'";
        log.info("SQL query is: " + query);

        return jdbcTemplate.query("select * from employee where name ='" + name + "'", new EmployeeRowMapper());
    }


}
