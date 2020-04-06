package cn.edu.haue.taxi.service;

import cn.edu.haue.taxi.common.ResponseData;
import cn.edu.haue.taxi.common.ResponseInfo;
import cn.edu.haue.taxi.entity.Driver;

import java.util.List;

public interface DriverService {

    ResponseData<List<Driver>> listAll(int pageNum, int pageSize);

    ResponseInfo create(Driver driver);

    ResponseInfo deleteById(String id);

    ResponseInfo update(Driver driver);

    ResponseData<Driver> findById(String id);
}
