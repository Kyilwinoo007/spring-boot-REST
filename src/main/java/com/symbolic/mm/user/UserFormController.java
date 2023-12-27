package com.symbolic.mm.user;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserFormController {

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
//        modelAndView.addObject("todoItems", todoItemService.getAll());
        return modelAndView;
    }

}
