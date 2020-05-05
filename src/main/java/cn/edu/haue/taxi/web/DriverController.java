package cn.edu.haue.taxi.web;

import cn.edu.haue.taxi.common.ResponseData;
import cn.edu.haue.taxi.common.ResponseInfo;
import cn.edu.haue.taxi.common.ResultCode;
import cn.edu.haue.taxi.entity.Driver;
import cn.edu.haue.taxi.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(path = "/api/driver")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping("login")
    public ResponseData<Driver> login(@RequestParam String id, @RequestParam String password, HttpSession session) {
        ResponseData<Driver> responseData = driverService.login(id, password);
        if (responseData.getResultCode() == ResultCode.RESULT_CODE_SUCCESS) {
            session.setAttribute("currentDriver", responseData.getData());
        }
        return responseData;
    }

    @GetMapping
    public ResponseData<List<Driver>> list(@RequestParam("page") int pageNum, @RequestParam("limit") int pageSize) {
        return driverService.list(pageNum, pageSize);
    }

    @GetMapping("info")
    public ResponseData<Driver> info(HttpSession session) {
        Driver driver = (Driver) session.getAttribute("currentDriver");
        return driverService.findInfoById(driver.getId());
    }

    @GetMapping("{id}")
    public ResponseData<Driver> findById(@PathVariable("id") String id) {
        return driverService.findById(id);
    }

    @PostMapping
    public ResponseInfo create(Driver driver) {
        return driverService.create(driver);
    }

    @DeleteMapping("{id}")
    public ResponseInfo delete(@PathVariable("id") String id) {
        return driverService.deleteById(id);
    }

    @PutMapping
    public ResponseInfo update(@RequestBody Driver driver) {
        return driverService.update(driver);
    }
}
