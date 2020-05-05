package cn.edu.haue.taxi.web;

import cn.edu.haue.taxi.common.ResponseData;
import cn.edu.haue.taxi.common.ResponseInfo;
import cn.edu.haue.taxi.entity.Admin;
import cn.edu.haue.taxi.entity.Driver;
import cn.edu.haue.taxi.entity.Rule;
import cn.edu.haue.taxi.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(path = "/api/rule")
public class RuleController {

    @Autowired
    private RuleService ruleService;

    @GetMapping
    public ResponseData<List<Rule>> list(@RequestParam("page") int pageNum, @RequestParam("limit") int pageSize) {
        return ruleService.list(pageNum, pageSize);
    }

    @GetMapping("driver")
    public ResponseData<List<Rule>> driver(HttpSession session, @RequestParam("page") int pageNum, @RequestParam("limit") int pageSize) {
        Driver driver = (Driver) session.getAttribute("currentDriver");
        return ruleService.listByDriver(driver.getId(), pageNum, pageSize);
    }

    @GetMapping("{id}")
    public ResponseData<Rule> find(@PathVariable("id") String id) {
        return ruleService.findById(id);
    }

    @PutMapping
    public ResponseInfo update(@RequestBody Rule rule) {
        return ruleService.update(rule);
    }

    @DeleteMapping("{id}")
    public ResponseInfo delete(@PathVariable("id") String id) {
        return ruleService.deleteById(id);
    }

    @PostMapping
    public ResponseInfo create(Rule rule, HttpSession session) {
        Admin admin = (Admin) session.getAttribute("currentAdmin");
        rule.setAdmin(admin.getUsername());
        return ruleService.create(rule);
    }
}
