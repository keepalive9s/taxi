package cn.edu.haue.taxi.service.impl;

import cn.edu.haue.taxi.common.ResponseData;
import cn.edu.haue.taxi.common.ResponseInfo;
import cn.edu.haue.taxi.common.ResultCode;
import cn.edu.haue.taxi.entity.Contract;
import cn.edu.haue.taxi.entity.Driver;
import cn.edu.haue.taxi.mapper.ContractMapper;
import cn.edu.haue.taxi.mapper.DriverMapper;
import cn.edu.haue.taxi.service.DriverService;
import cn.edu.haue.taxi.util.MD5Util;
import cn.edu.haue.taxi.util.UUIDUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverMapper driverMapper;

    @Autowired
    private ContractMapper contractMapper;

    @Override
    public ResponseData<List<Driver>> list(int pageNum, int pageSize) {
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

    @Override
    public ResponseData<Driver> findInfoById(String id) {
        Driver driver = driverMapper.selectByPrimaryKey(id);
        List<Contract> contracts = contractMapper.selectByDriverId(id);
        Double freeDeposit = 0.0;
        for (Contract item : contracts) {
            if (driver.getEndTime() == null || driver.getEndTime().before(item.getEndTime())) {
                driver.setEndTime(item.getEndTime());
            }
            if (item.getEndTime().after(new Date())) {
                driver.setTaxiId(item.getTaxiId());
                driver.setPlateNum(item.getPlateNum());
                driver.setDeposit(item.getDeposit());
                driver.setEndTime(item.getEndTime());
            } else if (item.getDeposit() != null) {
                freeDeposit = freeDeposit + item.getDeposit();
            }
        }
        driver.setFreeDeposit(freeDeposit);
        if (driver.getEndTime() == null) {
            driver.setState("未签约");
        } else if (driver.getEndTime().after(new Date())) {
            driver.setState("签约生效");
        } else {
            driver.setState("签约过期");
        }
        return new ResponseData<>(ResultCode.RESULT_CODE_SUCCESS, driver);
    }

    @Override
    public ResponseData<Driver> login(String id, String password) {
        Driver driver = driverMapper.selectByPrimaryKey(id);
        if (driver == null) {
            return new ResponseData<>(ResultCode.RESULT_CODE_FAIL, "账号不存在", null);
        } else if (driver.getPassword().equals(MD5Util.MD5EncodeUtf8(password))) {
            return new ResponseData<>(ResultCode.RESULT_CODE_SUCCESS, "登陆成功", driver);
        } else {
            return new ResponseData<>(ResultCode.RESULT_CODE_FAIL, "账号或密码错误", null);
        }
    }
}
