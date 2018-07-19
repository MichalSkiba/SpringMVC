package com.michal.SpringMVC.Controller;

import com.michal.SpringMVC.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/customer")
    public String list(Model model) {
        model.addAttribute("customer", customerService.getAllCustomers());
        return "customers";
    }
}
