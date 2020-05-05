package cn.edu.haue.taxi.web;

import cn.edu.haue.taxi.common.ResponseData;
import cn.edu.haue.taxi.common.ResponseInfo;
import cn.edu.haue.taxi.entity.Complain;
import cn.edu.haue.taxi.entity.Driver;
import cn.edu.haue.taxi.service.ComplainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(path = "/api/complain")
public class ComplainController {

    @Autowired
    private ComplainService complainService;

    @GetMapping
    public ResponseData<List<Complain>> list(@RequestParam("page") int pageNum, @RequestParam("limit") int pageSize) {
        return complainService.list(pageNum, pageSize);
    }

    @GetMapping("driver")
    public ResponseData<List<Complain>> list(HttpSession session, @RequestParam("page") int pageNum, @RequestParam("limit") int pageSize) {
        Driver driver = (Driver) session.getAttribute("currentDriver");
        return complainService.listByDriver(driver.getId(), pageNum, pageSize);
    }

    @GetMapping("{id}")
    public ResponseData<Complain> find(@PathVariable("id") String id) {
        return complainService.findById(id);
    }

    @PostMapping
    public ResponseInfo create(Complain complain) {
        return complainService.create(complain);
    }

    @PutMapping
    public ResponseInfo update(@RequestBody Complain complain) {
        return complainService.update(complain);
    }

    @DeleteMapping("{id}")
    public ResponseInfo delete(@PathVariable("id") String id) {
        return complainService.deleteById(id);
    }
}
