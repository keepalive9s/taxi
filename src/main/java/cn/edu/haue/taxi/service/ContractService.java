package cn.edu.haue.taxi.service;

import cn.edu.haue.taxi.common.ResponseData;
import cn.edu.haue.taxi.common.ResponseInfo;
import cn.edu.haue.taxi.entity.Contract;

import java.util.List;

public interface ContractService {

    ResponseInfo create(Contract contract);

    ResponseInfo update(Contract contract);

    ResponseInfo refund(String id);

    ResponseInfo stop(String id);

    ResponseData<List<Contract>> list(int pageNum, int pageSize);

    ResponseData<List<Contract>> listByDriverId(String id, int pageNum, int pageSize);

    ResponseData<Contract> findById(String id);

    ResponseInfo deleteById(String id);

}
