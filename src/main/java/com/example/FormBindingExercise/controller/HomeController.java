package com.example.FormBindingExercise.controller;

import com.example.FormBindingExercise.bean.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.concurrent.CopyOnWriteArrayList;

@Controller
public class HomeController {

    //we want to create a thread safe Arraylist. You want to do this in production systems wherer
    //You could potentially have 100,000 people using the system

    private CopyOnWriteArrayList<Car> carList = new CopyOnWriteArrayList<>();

    @GetMapping("/")
    public String goHome(Model model){
        //because we are displaying the list on the home page
        //we need to send it there via the model
        model.addAttribute("carList", carList);
        return "index";
    }


    @GetMapping("add_page")
    public String addCar(Model model){
        //we are add a new car instance to the model.
        //it will be bound by the form.
        model.addAttribute("car", new Car());
        return "add_page";
    }

    //now we are adding the car model to the database
    //we are using postmapping because that is the method we
    //selected in the add_Page
    @PostMapping("/addCar")
    public String addCar(Model model, @ModelAttribute Car car){

        //here we adding it to the arraylist
        carList.add(car);
        model.addAttribute("carList", carList);

        //go back home prevents resubmission from the user
        return "redirect:/";
    }
}
