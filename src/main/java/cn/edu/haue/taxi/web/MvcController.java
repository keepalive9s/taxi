package cn.edu.haue.taxi.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MvcController {

    @RequestMapping("login")
    public String login() {
        return "login";
    }

    @RequestMapping("admin")
    public String admin() {
        return "admin";
    }

    @RequestMapping("driver")
    public String driver() {
        return "driver";
    }

    @RequestMapping("complain")
    public String complain() {
        return "complain";
    }

    //注销登陆
    @RequestMapping("logout")
    public String signOut(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

}
