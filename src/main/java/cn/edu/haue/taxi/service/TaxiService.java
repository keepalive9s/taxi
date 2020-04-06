package cn.edu.haue.taxi.service;

import cn.edu.haue.taxi.common.ResponseData;
import cn.edu.haue.taxi.common.ResponseInfo;
import cn.edu.haue.taxi.entity.Taxi;

import java.util.List;

public interface TaxiService {

    ResponseData<List<Taxi>> listAll(int pageNum, int pageSize);

    ResponseInfo deleteById(Integer id);

    ResponseInfo create(Taxi taxi);

}
