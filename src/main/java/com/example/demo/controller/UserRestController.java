package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller
public class UserRestController {

    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = "/springJSP/", method = RequestMethod.GET)
    public String index() {
        return "redirect:/list";
    }

    @RequestMapping(value = "/springJSP/list", method = RequestMethod.GET)
    public String list(Model model) {
        System.out.println("查询所有");
        List<User> users = userService.findAll();

        model.addAttribute("users", users);
        return "user/list";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "user/userAdd";
    }

    @RequestMapping("/add")
    public String add(User user) {
        userService.addUser(user);
        return "redirect:/list";
    }

    @RequestMapping("/toEdit")
    public String toEdit(Model model, Long id) {
        Optional<User> user = userService.findUserById(id);
        model.addAttribute("user", user.orElse(null));
        return "user/userEdit";
    }

    @RequestMapping("/edit")
    public String edit(User user) {
        userService.updateUser(user);
        return "redirect:/list";
    }

    @RequestMapping("/toDelete")
    public String delete(Long id) {
        userService.deleteUser(id);
        return "redirect:/list";
    }
}
