package com.thymeleaf.springboot.thymeleafdemo.controllers;

import com.thymeleaf.springboot.thymeleafdemo.Service.DepositService;
import com.thymeleaf.springboot.thymeleafdemo.Service.UserService;
import com.thymeleaf.springboot.thymeleafdemo.model.PaymentDeposit;
import com.thymeleaf.springboot.thymeleafdemo.model.PaymentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class DemoController {
    private UserService service;
    private DepositService deposit;

    @Autowired
    public DemoController(UserService service,DepositService deposit) {
        this.service = service;
        this.deposit = deposit;
    }

    @GetMapping("/paymentsDeposits")
    public String getDepositList(Model model){
        List<PaymentDeposit> deposits=deposit.findAll();
        model.addAttribute("deposits",deposits);
        return "users/deposits";
    }


    @GetMapping("/paymentsUsers")
    public String getUsersList(Model model) {
        List<PaymentUser> users = service.findAll();
        users.stream().forEach(e -> e.setDate(new Date(e.getCreateTimestamp()*1000)));
        model.addAttribute("users", users);
        return "users/list-users";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        PaymentUser user = new PaymentUser();
        theModel.addAttribute("user", user);
        return "users/userForm";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("userId") int theID,
                                    Model theModel) {
        PaymentUser user = service.findById(theID);
        theModel.addAttribute("user", user);
        return "users/userForm";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("user") PaymentUser user) {
        user.setCreateTimestamp((int) (System.currentTimeMillis() / 1000));
        service.save(user);
        return "redirect:/paymentsUsers";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("userId") int theId) {
        service.delete(theId);
        return "redirect:/paymentsUsers";
    }

    @PostMapping("/search")
    public String search(@RequestParam("email") String email, Model model) {
        List<PaymentUser> oneUser = service.findByEmail(email.trim());
        model.addAttribute("oneUser", oneUser);
        return "users/User";
    }

    @RequestMapping("/login")
    public String showMyLoginPage() {
        return "users/login";
    }

}
