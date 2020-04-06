package cn.edu.haue.taxi.web;

import cn.edu.haue.taxi.common.ResponseData;
import cn.edu.haue.taxi.common.ResponseInfo;
import cn.edu.haue.taxi.entity.Taxi;
import cn.edu.haue.taxi.service.TaxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/taxi")
public class TaxiController {

    @Autowired
    private TaxiService taxiService;

    @GetMapping
    public ResponseData<List<Taxi>> list(@RequestParam("page") int pageNum, @RequestParam("limit") int pageSize) {
        return taxiService.listAll(pageNum, pageSize);
    }

    @PostMapping
    public ResponseInfo create(Taxi taxi) {
        return taxiService.create(taxi);
    }

    @DeleteMapping("{id}")
    public ResponseInfo delete(@PathVariable("id") Integer id) {
        return taxiService.deleteById(id);
    }
}
