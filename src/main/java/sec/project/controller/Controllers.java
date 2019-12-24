package sec.project.controller;

import sec.project.database.SignupDao;
import sec.project.domain.Signup;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sec.project.repository.SignupRepository;

@Controller
public class Controllers {

    @Autowired
    private SignupRepository signupRepository;

    @RequestMapping("*")
    public String defaultMapping() {
        return "redirect:/form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String loadForm() {
        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String submitForm(@RequestParam String name, @RequestParam String address, @RequestParam String religion) throws SQLException {
        SignupDao signupDbCall = new SignupDao();
        signupDbCall.addSignup(name, address, religion);
        // signupRepository.save(new Signup(name, address));
        return "done";
    }

    @RequestMapping("/admin")
    public String adminPage() {
        return "admin";
    }

    @RequestMapping("/list")
    public String listPage(Model model) {
        List<Signup> signups;

        try {
            signups = signupRepository.findAll();
        } catch (Exception e) {
            signups = null;
        }
        
        model.addAttribute("signups", signups);
        return "list";
    }

}
