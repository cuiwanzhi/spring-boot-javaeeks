package com.springboot.springbootjavaeeks.controller;

import com.springboot.springbootjavaeeks.bean.Year;
import com.springboot.springbootjavaeeks.bean.MyDateConverter;
import com.springboot.springbootjavaeeks.bean.User;
import com.springboot.springbootjavaeeks.bean.Year;
import com.springboot.springbootjavaeeks.mapper.YearMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author cuiwanzhi
 * @date 2020/7/5 15:33
 */
@Slf4j
@Controller
public class YearController {
    @Autowired
    MyDateConverter myDateConverter;
    @Autowired
    YearMapper yearMapper;

    @RequestMapping("/getAllYear")
    public String getAllYear(Model model, HttpServletRequest request) {
        List<Year> allYear = null;
        if (request.getSession().getAttribute("level").equals("controller")) {
            allYear = yearMapper.getAllYear();
            model.addAttribute("allYear", allYear);
            return "controllerSelectYear";

        } else {
            User user = (User) request.getSession().getAttribute("user");
            allYear = yearMapper.getUserYear(user.getId());
        }
        model.addAttribute("allYear", allYear);
        return "selectYear";

    }

    @RequestMapping("/deleteYear")
    public String deleteYear(Year year) {
        yearMapper.deleteYear(year.getId());
        return "redirect:/getAllYear";
    }

    @RequestMapping("/selectYear")
    public String selectYear(Year year, Model model) {
        Year year1 = yearMapper.selectYear(year.getId());
        model.addAttribute("year", year1);

        return "updateYear";
    }

    @RequestMapping("/updateYear")
    public String updateYear(Year year, String date) {
        year.setYear_date(myDateConverter.convert(date));
        log.debug(String.valueOf(myDateConverter.convert(date)));
        log.debug(String.valueOf(year.getYear_date()));
        yearMapper.updateYear(year.getId(), year.getUser_id(), year.getYear_type(), year.getYear_number(), year.getYear_date());

        return "redirect:/getAllYear";
    }

    @RequestMapping("/insertYear")
    public String insertYear(Year year, String date,HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        year.setYear_date(myDateConverter.convert(date));
        yearMapper.insertYear(user.getId(), year.getYear_type(), year.getYear_number(), year.getYear_date());
        return "redirect:/getAllYear";
    }
}
