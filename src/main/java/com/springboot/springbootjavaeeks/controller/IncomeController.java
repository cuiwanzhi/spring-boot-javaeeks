package com.springboot.springbootjavaeeks.controller;

import com.springboot.springbootjavaeeks.bean.Income;
import com.springboot.springbootjavaeeks.bean.MyDateConverter;
import com.springboot.springbootjavaeeks.bean.User;
import com.springboot.springbootjavaeeks.mapper.IncomeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

/**
 * @author cuiwanzhi
 * @date 2020/7/5 15:33
 */
@Controller
public class IncomeController {
    @Autowired
    MyDateConverter myDateConverter;
    @Autowired
    IncomeMapper incomeMapper;

    @RequestMapping("/getAllIncome")
    public String getAllIncome(Model model, HttpServletRequest request) {
        List<Income> allIncome = null;
        if (request.getSession().getAttribute("level").equals("controller")) {
            allIncome = incomeMapper.getAllIncome();

        } else {
            User user = (User) request.getSession().getAttribute("user");
            allIncome = incomeMapper.getUserIncome(user.getId());
        }
        model.addAttribute("allIncome", allIncome);
        return "selectIncome";

    }

    @RequestMapping("/deleteIncome")
    public String deleteIncome(Income income) {
        incomeMapper.deleteIncome(income.getId());
        return "redirect:/getAllIncome";
    }

    @RequestMapping("/selectIncome")
    public String selectIncome(Income income, Model model) {
        Income income1 = incomeMapper.selectIncome(income.getId());
        model.addAttribute("income", income1);

        return "updateIncome";
    }

    @RequestMapping("/updateIncome")
    public String updateIncome(Income income, String date) {
        income.setIncome_date(myDateConverter.convert(date));
        incomeMapper.updateIncome(income.getId(), income.getUser_id(), income.getIncome_type(), income.getIncome_number(), income.getIncome_date());

        return "redirect:/getAllIncome";
    }

    @RequestMapping("/insertIncome")
    public String insertIncome(Income income, String date,HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        income.setIncome_date(myDateConverter.convert(date));
        incomeMapper.insertIncome(user.getId(), income.getIncome_type(), income.getIncome_number(), income.getIncome_date());
        return "redirect:/getAllIncome";
    }
}
