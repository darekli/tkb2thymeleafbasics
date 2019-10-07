package com.example.thymeleafbasics;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class CarController {

    private List<Car> cars;

    public CarController() {
        Car car1 = new Car("Fiat", "Bravo");
        Car car2 = new Car("Opel", "Astra");
        Car car3 = new Car("Ford", "Focus");
        Car car4 = new Car("Peugeot", "308");

        cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);

    }

    @GetMapping("/car")
    public String getCar(Model model) {
        model.addAttribute("cars", cars);
        model.addAttribute("newCar", new Car());
        return "car";
    }

    //metoda na dodawanie danych
    @PostMapping("/add-car")
    public String addCar(@ModelAttribute Car car) {
        cars.add(car);
        // System.out.println(car);
        // return "car"; samo car wywala bledy nalezy przekierować
        return "redirect:/car";
    }

    @DeleteMapping("/delete-car")
    public String deleteCar(@ModelAttribute Car car) {
     //   cars.delete(car);
        // System.out.println(car);
        // return "car"; samo car wywala bledy nalezy przekierować
        return "redirect:/car";
    }
}