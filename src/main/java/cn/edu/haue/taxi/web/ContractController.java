package cn.edu.haue.taxi.web;

import cn.edu.haue.taxi.common.ResponseData;
import cn.edu.haue.taxi.common.ResponseInfo;
import cn.edu.haue.taxi.entity.Contract;
import cn.edu.haue.taxi.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/contract")
public class ContractController {

    @Autowired
    private ContractService contractService;

    @PostMapping
    public ResponseInfo create(Contract contract) {
        System.out.println(contract.getEndTime());
        return contractService.create(contract);
    }

    @GetMapping
    public ResponseData<List<Contract>> list(@RequestParam("page") int pageNum, @RequestParam("limit") int pageSize) {
        return contractService.list(pageNum, pageSize);
    }

    @GetMapping("{id}")
    public ResponseData<Contract> find(@PathVariable("id") String id) {
        return contractService.findById(id);
    }

    @GetMapping("refund/{id}")
    public ResponseInfo refund(@PathVariable("id") String id) {
        return contractService.refund(id);
    }

    @GetMapping("stop/{id}")
    public ResponseInfo stop(@PathVariable("id") String id) {
        return contractService.stop(id);
    }

    @PutMapping
    public ResponseInfo update(@RequestBody Contract contract) {
        return contractService.update(contract);
    }
}
