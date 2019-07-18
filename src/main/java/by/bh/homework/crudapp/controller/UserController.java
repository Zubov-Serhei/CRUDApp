package by.bh.homework.crudapp.controller;

import by.bh.homework.crudapp.model.User;
import by.bh.homework.crudapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Locale;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String userForm(Locale locale, Model model) {
        model.addAttribute("users", userService.list());
        return "editUsers";
    }

    @ModelAttribute("user")
    public User formBackingObject() {
        return new User();
    }

    @PostMapping("/addUser")
    public String saveUser(@Valid @ModelAttribute("user") User user,
                           BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("users", userService.list());
            System.out.println(user.toString());
            return "editUsers";
        }
        System.out.println(user.toString());
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/updateUser")
    public String updateUser(@RequestParam("userId") Long id, Model model){
        model.addAttribute("user",userService.getUserById(id));
        return "updateUser";
    }

    @PostMapping("/updateUser")
    public String update(@Valid @ModelAttribute("user") User user,
                         BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("user",user);
            return "updateUser";
        }
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("userId") Long id){
        userService.deleteUser(id);
        return "redirect:/";
    }
}