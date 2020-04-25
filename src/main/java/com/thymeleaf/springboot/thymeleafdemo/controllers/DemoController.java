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

    private List<Employee> list;

    @PostConstruct
    public void loadList() {
        list = new ArrayList<>();
        list.add(new Employee("John", " Smith", "JavaDeveloper", 7200, "johnSmith@gmail.com"));
        list.add(new Employee("Natalie", " Bush", "HR", 720, "natalieBush@gmail.com"));
        list.add(new Employee("Igor", " Alexandrov", "FrontEnd", 7300, "igorAlexandrov@gmail.com"));
    }

    @GetMapping("/employeeList")
    public String getList(Model model) {
        model.addAttribute("employees", list);
        return "employees";
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
        service.save(user);
        return "redirect:/paymentsUsers";
    }
}
