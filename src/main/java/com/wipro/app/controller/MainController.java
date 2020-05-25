package com.wipro.app.controller;

import com.wipro.app.service.CreditScoreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MainController {

    @Autowired
    CreditScoreServiceImpl creditService;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        model.addAttribute("message", "Hello There!!!");
        return "index";
    }

    @RequestMapping(value = "/checkEligibility", method = RequestMethod.POST)
    public String checkCreditScore(HttpServletRequest request, HttpServletResponse response) {
        String panNumber = request.getParameter("panNo");
        boolean valid = creditService.isValid(panNumber);
        if(!valid) return "invalid";

        boolean eligible = creditService.isEligible(panNumber);
        if(eligible)
            return "success";
        else
            return "failure";
    }
}
