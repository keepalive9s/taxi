package cn.edu.haue.taxi.web;

import cn.edu.haue.taxi.common.ResponseData;
import cn.edu.haue.taxi.common.ResultCode;
import cn.edu.haue.taxi.entity.Admin;
import cn.edu.haue.taxi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(path = "/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("login")
    public ResponseData<Admin> login(@RequestParam String username, @RequestParam String password, HttpSession session) {
        ResponseData<Admin> responseData = adminService.login(username, password);
        if (responseData.getResultCode() == ResultCode.RESULT_CODE_SUCCESS) {
            session.setAttribute("currentAdmin", responseData.getData());
        }
        return responseData;
    }

}
