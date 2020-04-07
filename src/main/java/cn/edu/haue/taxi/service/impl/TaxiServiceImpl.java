package cn.edu.haue.taxi.service.impl;

import cn.edu.haue.taxi.common.ResponseData;
import cn.edu.haue.taxi.common.ResponseInfo;
import cn.edu.haue.taxi.common.ResultCode;
import cn.edu.haue.taxi.entity.Taxi;
import cn.edu.haue.taxi.mapper.TaxiMapper;
import cn.edu.haue.taxi.service.TaxiService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxiServiceImpl implements TaxiService {

    @Autowired
    private TaxiMapper taxiMapper;

    @Override
    public ResponseData<List<Taxi>> listAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Taxi> taxis = taxiMapper.selectAll();
        PageInfo<Taxi> pageInfo = new PageInfo<>(taxis);
        return new ResponseData<>(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public ResponseInfo deleteById(Integer id) {
        int i = taxiMapper.deleteByPrimaryKey(id);
        if (i == 1) {
            return new ResponseInfo(ResultCode.RESULT_CODE_SUCCESS, "删除成功");
        } else {
            return new ResponseInfo(ResultCode.RESULT_CODE_FAIL, "删除失败");
        }
    }

    @Override
    public ResponseInfo create(Taxi taxi) {
        int i = taxiMapper.insert(taxi);
        if (i == 1) {
            return new ResponseInfo(ResultCode.RESULT_CODE_SUCCESS, "新增出租车成功");
        } else {
            return new ResponseInfo(ResultCode.RESULT_CODE_FAIL, "新增出租车失败");
        }
    }

    @Override
    public ResponseInfo update(Taxi taxi) {
        try {
            int i = taxiMapper.updateByPrimaryKey(taxi);
            if (i == 1) {
                return new ResponseInfo(ResultCode.RESULT_CODE_SUCCESS, "信息更新成功");
            } else {
                return new ResponseInfo(ResultCode.RESULT_CODE_FAIL, "信息更新失败");
            }
        } catch (DataAccessException e) {
            e.printStackTrace();
            return new ResponseInfo(ResultCode.RESULT_CODE_FAIL, "信息更新失败");
        }
    }

    @Override
    public ResponseData<Taxi> findById(Integer id) {
        Taxi taxi = taxiMapper.selectByPrimaryKey(id);
        if (taxi == null) {
            return new ResponseData<>(ResultCode.RESULT_CODE_FAIL, null);
        } else {
            return new ResponseData<>(ResultCode.RESULT_CODE_SUCCESS, taxi);
        }
    }
}
