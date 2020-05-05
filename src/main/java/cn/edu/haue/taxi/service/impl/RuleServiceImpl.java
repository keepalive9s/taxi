package cn.edu.haue.taxi.service.impl;

import cn.edu.haue.taxi.common.ResponseData;
import cn.edu.haue.taxi.common.ResponseInfo;
import cn.edu.haue.taxi.common.ResultCode;
import cn.edu.haue.taxi.entity.Rule;
import cn.edu.haue.taxi.mapper.RuleMapper;
import cn.edu.haue.taxi.service.RuleService;
import cn.edu.haue.taxi.util.UUIDUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuleServiceImpl implements RuleService {

    @Autowired
    private RuleMapper ruleMapper;

    @Override
    public ResponseInfo create(Rule rule) {
        rule.setId(UUIDUtil.Id());
        int i = ruleMapper.insert(rule);
        if (i == 1) {
            return new ResponseInfo(ResultCode.RESULT_CODE_SUCCESS, "记录添加成功");
        } else {
            return new ResponseInfo(ResultCode.RESULT_CODE_FAIL, "记录添加失败");
        }
    }

    @Override
    public ResponseInfo update(Rule rule) {
        if (rule.getState() == null) {
            rule.setState(0);
        }
        int i = ruleMapper.updateByPrimaryKey(rule);
        if (i == 1) {
            return new ResponseInfo(ResultCode.RESULT_CODE_SUCCESS, "信息更新成功");
        } else {
            return new ResponseInfo(ResultCode.RESULT_CODE_FAIL, "信息更新失败");
        }
    }

    @Override
    public ResponseData<Rule> findById(String id) {
        Rule rule = ruleMapper.selectByPrimaryKey(id);
        if (rule == null) {
            return new ResponseData<>(ResultCode.RESULT_CODE_FAIL, null);
        } else {
            return new ResponseData<>(ResultCode.RESULT_CODE_SUCCESS, rule);
        }
    }

    @Override
    public ResponseInfo deleteById(String id) {
        int i = ruleMapper.deleteByPrimaryKey(id);
        if (i == 1) {
            return new ResponseInfo(ResultCode.RESULT_CODE_SUCCESS, "记录删除成功");
        } else {
            return new ResponseInfo(ResultCode.RESULT_CODE_FAIL, "记录删除失败");
        }
    }

    @Override
    public ResponseData<List<Rule>> list(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Rule> rules = ruleMapper.selectAll();
        PageInfo<Rule> pageInfo = new PageInfo<>(rules);
        return new ResponseData<>(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public ResponseData<List<Rule>> listByDriver(String id, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Rule> rules = ruleMapper.selectByDriverId(id);
        PageInfo<Rule> pageInfo = new PageInfo<>(rules);
        return new ResponseData<>(pageInfo.getTotal(), pageInfo.getList());
    }
}
