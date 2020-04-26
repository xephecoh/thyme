package com.thymeleaf.springboot.thymeleafdemo.controllers;

import com.thymeleaf.springboot.thymeleafdemo.Service.UserService;
import com.thymeleaf.springboot.thymeleafdemo.model.Employee;
import com.thymeleaf.springboot.thymeleafdemo.model.PaymentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DemoController {
    private UserService service;

    @Autowired
    public DemoController(UserService service) {
        this.service = service;
    }

    @GetMapping("/paymentsUsers")
    public String getUsersList(Model model) {
        List<PaymentUser> users = service.findAll();
        model.addAttribute("users", users);
        return "users/list-users";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        PaymentUser user = new PaymentUser();
        theModel.addAttribute("user", user);
        return "users/userForm";
    }
    @GetMapping ("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("userId") int theID,
                                    Model theModel){
        PaymentUser user = service.findById(theID);
        theModel.addAttribute("user",user);
        return "users/userForm";
    }
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("user") PaymentUser user){
        user.setCreateTimestamp((int)(System.currentTimeMillis()/1000));
        service.save(user);
        return "redirect:/paymentsUsers";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("userId") int theId){
        service.delete(theId);
        return "redirect:/paymentsUsers";
    }
}
