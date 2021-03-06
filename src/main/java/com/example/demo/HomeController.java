package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

@Autowired
    EmployeeRepository employeeRepository;

@RequestMapping("/")
    public String index(Model model){

    //First lets create employee
    Employee employee= new Employee();
    employee.setName("Stephen Bullock");
    employee.setSsn("555-12-1234");


    //Now let's create a laptop
    Laptop laptop=new Laptop();

    laptop.setBrand("Dell");
    laptop.setModel("Latitude XL");


    //Add the laptop to employee
    employee.setLaptop(laptop);

    //save the employee to the database
    employeeRepository.save(employee);

    //Grab all the employees from the database and send them to the template
    model.addAttribute("employees",employeeRepository.findAll());
    return "index";
}
}
