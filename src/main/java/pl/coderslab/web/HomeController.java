package pl.coderslab.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.User;
import pl.coderslab.service.UserService;

@Controller
public class HomeController {

    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String index(@RequestParam(defaultValue = "Nieznajomy") String name, Model model){
        model.addAttribute("name", name);
        return "index";
    }

    @GetMapping("/admin")
    @ResponseBody
    public String admin() { return "admin"; }

    @RequestMapping("/create-user")
    @ResponseBody
    public void createUser(){
        User user = new User();
        user.setUsername("arek");
        user.setPassword("arek");
        userService.saveUser(user);
    }
}
