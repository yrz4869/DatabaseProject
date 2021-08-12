package com.yu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;



@Controller
public class JDBCController {

    @Autowired
    JdbcTemplate jdbcTemplate;

   @GetMapping("/property.html")
    public String  lfhuman(Model model){

        String sql = "(select author,jie from authorstang) union (select author,jie from authorssong)";
        List<Map<String,Object>> maps= jdbcTemplate.queryForList(sql);


        List<String> sl = new ArrayList<String>();
        for (Map m : maps) {
            String a = m.get("author").toString();
            String b = m.get("jie").toString();
            String c = "------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------";
            sl.add(a);
            sl.add(b);
            sl.add(c);
        }
       model.addAttribute("user",sl);

       return "property";
    }







}




