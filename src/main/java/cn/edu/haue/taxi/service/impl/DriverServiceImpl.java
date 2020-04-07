package cn.edu.haue.taxi.service.impl;

import cn.edu.haue.taxi.common.ResponseData;
import cn.edu.haue.taxi.common.ResponseInfo;
import cn.edu.haue.taxi.common.ResultCode;
import cn.edu.haue.taxi.entity.Driver;
import cn.edu.haue.taxi.entity.Taxi;
import cn.edu.haue.taxi.mapper.DriverMapper;
import cn.edu.haue.taxi.mapper.TaxiMapper;
import cn.edu.haue.taxi.service.DriverService;
import cn.edu.haue.taxi.util.MD5Util;
import cn.edu.haue.taxi.util.UUIDUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverMapper driverMapper;

    @Autowired
    private TaxiMapper taxiMapper;

    @Override
    public ResponseData<List<Driver>> listAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Driver> drivers = driverMapper.selectAll();
        PageInfo<Driver> pageInfo = new PageInfo<>(drivers);
        return new ResponseData<>(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public ResponseInfo create(Driver driver) {
        driver.setId(UUIDUtil.SerialNum());
        String identityNum = driver.getDrivingLicenseNum();
        driver.setPassword(MD5Util.MD5EncodeUtf8(identityNum.substring(identityNum.length() - 6)));
        int i = driverMapper.insert(driver);
        if (i == 1) {
            return new ResponseInfo(ResultCode.RESULT_CODE_SUCCESS, "驾驶员新增成功");
        } else {
            return new ResponseInfo(ResultCode.RESULT_CODE_FAIL, "驾驶员新增失败");
        }
    }

    @Override
    public ResponseInfo deleteById(String id) {
        int i = driverMapper.deleteByPrimaryKey(id);
        if (i == 1) {
            return new ResponseInfo(ResultCode.RESULT_CODE_SUCCESS, "驾驶员删除成功");
        } else {
            return new ResponseInfo(ResultCode.RESULT_CODE_FAIL, "驾驶员删除失败");
        }
    }

    @Override
    public ResponseInfo update(Driver driver) {
        try {
            int i = driverMapper.updateByPrimaryKey(driver);
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
    public ResponseData<Driver> findById(String id) {
        Driver driver = driverMapper.selectByPrimaryKey(id);
        if (driver == null) {
            return new ResponseData<>(ResultCode.RESULT_CODE_FAIL, null);
        } else {
            return new ResponseData<>(ResultCode.RESULT_CODE_SUCCESS, driver);
        }
    }
}
