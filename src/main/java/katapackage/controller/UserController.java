package katapackage.controller;


import katapackage.model.User;
import katapackage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")

public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        addUsers();
        this.service = service;
    }

    private void addUsers() {
        service.save(new User("Leo", "Bonhart", "lb@mail.ru"));
        service.save(new User("Иван", "Сидоров", "isid@mail.ru"));
        service.save(new User("Henry", "Cavill", "hcav@mail.ru"));
        service.save(new User("Maша", "Иванова", "mi@mail.ru"));
        service.save(new User("Tom", "Cat", "t@mail.ru"));
    }


    @GetMapping("/get")
    public String getUser(ModelMap model) {
        model.addAttribute("users", service.getUsers());
        return "getall";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", service.show(id));
        return "show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {

        return "newUser";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "newUser";
        }
        service.save(user);
        return "redirect:users/get";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", service.show(id));
        return "editUser";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "editUser";
        }
        service.update(id, user);
        return "redirect:/users/get";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        service.delete(id);
        return "redirect:/users/get";
    }
}
