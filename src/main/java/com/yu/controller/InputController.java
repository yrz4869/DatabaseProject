package com.yu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
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

public class InputController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/about")
    public String login(Model model,HttpServletRequest request, HttpServletResponse response){
            if(request.getMethod().equals("POST")){
                String search=request.getParameter("search");
                search = "'%" + search + "%'";

                String sql = "select author,jie from authorstang where author like " + search ;
                String sql2 = "select title,author,paragraphs from test10000 where paragraphs like "+search;
                List<Map<String,Object>> maps= jdbcTemplate.queryForList(sql);
                List<Map<String,Object>> maps2= jdbcTemplate.queryForList(sql2);
                List<String> sl = new ArrayList<String>();
                String h = "=======================================================               诗人               ==========================================================";
                sl.add(h);
                for (Map m : maps) {
                    String a = m.get("author").toString();
                    String b = m.get("jie").toString();
                    String c = "------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------";
                    sl.add(a);
                    sl.add(b);
                    sl.add(c);
                }
                String x = "========================================================               诗词               ==========================================================";
                sl.add(x);
                for (Map m : maps2) {
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
            }

        return "about";
    }
    /*public String  lf(Model model){

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

        return "about";
    }*/








}
