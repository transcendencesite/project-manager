package site.transcendence.projectmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import site.transcendence.projectmanager.model.request.CreateUserRequest;
import site.transcendence.projectmanager.model.user.UserService;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String userRegistration(Model model){
        model.addAttribute("user", new CreateUserRequest());
        return "register";
    }

    @PostMapping("/register")
    public String userRegistration(@Valid @ModelAttribute("user") CreateUserRequest user, BindingResult result){
        if (result.hasErrors()){
            return "register";
        }
        userService.createUser(user);
        return "redirect:register?success";
    }

}