package qhv.alex.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;
import qhv.alex.spring.model.Role;
import qhv.alex.spring.model.User;
import qhv.alex.spring.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("users", userService.findAll());
        return "user/users";
    }

    @PostMapping
    public String create(User user) {
        return "redirect:/users/" + userService.create(user).getId();
    }

    @GetMapping("/registration")
    public String registration(Model model, User user) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "user/registration";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model) {
//          Тут был Optional, а не стрим
        var user = userService.findById(id);

        if (user == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());

        return "user/user";
    }

    @PostMapping("/{id}/update")
    public String update(User user) {
        userService.update(user);
        return "redirect:/users/{id}";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        if (!userService.delete(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return "redirect:/users";
    }
}
