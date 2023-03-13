package katapackage.controller;

import katapackage.dao.UserDao;
import katapackage.dao.UserDaoImpl;
import katapackage.model.User;
import katapackage.service.UserService;
import katapackage.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService service;


    @GetMapping("/get")
    public String getUser(ModelMap model){
        model.addAttribute("users",service.getUsers());
      return "getall";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id")int id, Model model){
        model.addAttribute("user",service.show(id));
        return "show";
    }
    @GetMapping("/new")
    public String newUser(@ModelAttribute("user")  User user){

        return"newuser";
    }
    @PostMapping()
    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
        return "newuser";
        }
        service.save(user);
        return "redirect:users/new";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model,@PathVariable("id")int id){
        model.addAttribute("user", service.show(id));
        return "edituser";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") @Valid User user,BindingResult bindingResult,@PathVariable("id") int id){
        if(bindingResult.hasErrors()){
            return "edituser";
        }
        service.update(id,user);
        return "redirect:/users/get";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id")int id){
        service.delete(id);
        return "redirect:/users/get";
    }
}
