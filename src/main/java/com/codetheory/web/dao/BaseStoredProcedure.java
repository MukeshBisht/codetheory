package com.codetheory.web.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.object.StoredProcedure;

public class BaseStoredProcedure extends StoredProcedure{

    public BaseStoredProcedure(JdbcTemplate template, String procedure_name){
        super(template, procedure_name);
        setFunction(false);
    }
}