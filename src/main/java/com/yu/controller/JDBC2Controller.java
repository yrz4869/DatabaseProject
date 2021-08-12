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
public class JDBC2Controller {
    @Autowired
    JdbcTemplate jdbcTemplate;




    @GetMapping("/services.html")
    public String  lfpoem(Model model){

        String sql2 = "select title,author,paragraphs from test10000";
        List<Map<String,Object>> maps= jdbcTemplate.queryForList(sql2);


        List<String> sl2 = new ArrayList<String>();
        for (Map m2 : maps) {
            String a2 = m2.get("title").toString();
            String b2 = m2.get("author").toString();
            String c2 = m2.get("paragraphs").toString();
            String d2 = "------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------";
            sl2.add(a2);
            sl2.add(b2);
            sl2.add(c2);
            sl2.add(d2);
        }
        model.addAttribute("po",sl2);

        return "services";
    }

}








/*package com.yu.controller;

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
public class JDBCController2 {

    @Autowired
    JdbcTemplate jdbcTemplate;




    @GetMapping("/services.html")
    public String  lfpoem(Model model){

        String sql2 = "select title,author,paragraphs from poetsong";
        List<Map<String,Object>> maps= jdbcTemplate.queryForList(sql2);


        List<String> sl = new ArrayList<String>();
        for (Map m : maps) {
            String a = m.get("title").toString();
            String b = m.get("author").toString();
            String c = m.get("paragraphs").toString();
            String d = "------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------";
            sl.add(a);
            sl.add(b);
            sl.add(c);
            sl.add(d);
        }
        model.addAttribute("user",sl);

        return "services";
    }




}

*/


