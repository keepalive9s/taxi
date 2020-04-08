package cn.edu.haue.taxi.service;

import cn.edu.haue.taxi.common.ResponseData;
import cn.edu.haue.taxi.common.ResponseInfo;
import cn.edu.haue.taxi.entity.Rule;

import java.util.List;

public interface RuleService {

    ResponseInfo create(Rule rule);

    ResponseInfo update(Rule rule);

    ResponseData<Rule> findById(String id);

    ResponseInfo deleteById(String id);

    ResponseData<List<Rule>> list(int pageNum, int pageSize);

}
