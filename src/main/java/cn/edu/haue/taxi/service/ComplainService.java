package cn.edu.haue.taxi.service;

import cn.edu.haue.taxi.common.ResponseData;
import cn.edu.haue.taxi.common.ResponseInfo;
import cn.edu.haue.taxi.entity.Complain;

import java.util.List;

public interface ComplainService {

    ResponseInfo create(Complain complain);

    ResponseInfo update(Complain complain);

    ResponseData<Complain> findById(String id);

    ResponseInfo deleteById(String id);

    ResponseData<List<Complain>> list(int pageNum, int pageSize);

}
