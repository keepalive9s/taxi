package cn.edu.haue.taxi.service.impl;

import cn.edu.haue.taxi.common.ResponseData;
import cn.edu.haue.taxi.common.ResponseInfo;
import cn.edu.haue.taxi.common.ResultCode;
import cn.edu.haue.taxi.entity.Contract;
import cn.edu.haue.taxi.entity.Driver;
import cn.edu.haue.taxi.entity.Taxi;
import cn.edu.haue.taxi.mapper.ContractMapper;
import cn.edu.haue.taxi.mapper.DriverMapper;
import cn.edu.haue.taxi.mapper.TaxiMapper;
import cn.edu.haue.taxi.service.ContractService;
import cn.edu.haue.taxi.util.UUIDUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractMapper contractMapper;

    @Autowired
    private TaxiMapper taxiMapper;

    @Autowired
    private DriverMapper driverMapper;

    @Override
    public ResponseInfo create(Contract contract) {
        if (contract.getEndTime().before(new Date())) {
            return new ResponseInfo(ResultCode.RESULT_CODE_FAIL, "签约到期时间不得早于当前时间");
        }
        Taxi taxi = taxiMapper.selectByPrimaryKey(contract.getTaxiId());
        Driver driver = driverMapper.selectEndTimeByPrimaryKey(contract.getDriverId());
        System.out.println(driver.getEndTime());
        if (taxi.getEndTime() != null && taxi.getEndTime().after(new Date())) {
            return new ResponseInfo(ResultCode.RESULT_CODE_FAIL, "当前车辆已分配且未到期，无法重复分配");
        }
        if (driver.getEndTime() != null && driver.getEndTime().after(new Date())) {
            return new ResponseInfo(ResultCode.RESULT_CODE_FAIL, "当前驾驶员已签约且签约未到期，无法重复签约");
        }
        contract.setId(UUIDUtil.Id());
        int i = contractMapper.insert(contract);
        if (i == 1) {
            return new ResponseInfo(ResultCode.RESULT_CODE_SUCCESS, "签约添加成功");
        } else {
            return new ResponseInfo(ResultCode.RESULT_CODE_FAIL, "签约添加失败");
        }
    }

    @Override
    public ResponseInfo update(Contract contract) {
        int i = contractMapper.updateByPrimaryKey(contract);
        if (i == 1) {
            return new ResponseInfo(ResultCode.RESULT_CODE_SUCCESS, "信息更新成功");
        } else {
            return new ResponseInfo(ResultCode.RESULT_CODE_FAIL, "信息更新失败");
        }
    }

    @Override
    public ResponseInfo stop(String id) {
        Contract contract = contractMapper.selectByPrimaryKey(id);
        if (contract.getEndTime().after(new Date())) {
            //违约金20%
            contract.setDeposit(contract.getDeposit() * 0.8);
            //中止时间为现在
            contract.setEndTime(new Date());
            int i = contractMapper.updateByPrimaryKey(contract);
            if (i == 1) {
                return new ResponseInfo(ResultCode.RESULT_CODE_SUCCESS, "签约中止成功");
            } else {
                return new ResponseInfo(ResultCode.RESULT_CODE_FAIL, "签约中止失败");
            }
        } else {
            return new ResponseInfo(ResultCode.RESULT_CODE_FAIL, "签约已失效无需中止");
        }
    }

    @Override
    public ResponseInfo refund(String id) {
        Contract contract = contractMapper.selectByPrimaryKey(id);
        if (contract.getEndTime().before(new Date())) {
            if (contract.getDeposit() > 0) {
                //将押金置为0
                contract.setDeposit(0d);
                int i = contractMapper.updateByPrimaryKey(contract);
                if (i == 1) {
                    return new ResponseInfo(ResultCode.RESULT_CODE_SUCCESS, "押金退还成功");
                } else {
                    return new ResponseInfo(ResultCode.RESULT_CODE_FAIL, "押金退还失败");
                }
            } else {
                return new ResponseInfo(ResultCode.RESULT_CODE_FAIL, "押金已退还，请不要重复操作");
            }
        } else {
            return new ResponseInfo(ResultCode.RESULT_CODE_FAIL, "签约生效中无法退还押金");
        }
    }

    @Override
    public ResponseData<List<Contract>> list(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Contract> contracts = contractMapper.selectAll();
        PageInfo<Contract> pageInfo = new PageInfo<>(contracts);
        return new ResponseData<>(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public ResponseData<List<Contract>> listByDriverId(String id, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Contract> contracts = contractMapper.selectByDriverId(id);
        PageInfo<Contract> pageInfo = new PageInfo<>(contracts);
        return new ResponseData<>(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public ResponseData<Contract> findById(String id) {
        Contract contract = contractMapper.selectByPrimaryKey(id);
        if (contract == null) {
            return new ResponseData<>(ResultCode.RESULT_CODE_FAIL, null);
        } else {
            return new ResponseData<>(ResultCode.RESULT_CODE_SUCCESS, contract);
        }
    }

    @Override
    public ResponseInfo deleteById(String id) {
        int i = contractMapper.deleteByPrimaryKey(id);
        if (i == 1) {
            return new ResponseInfo(ResultCode.RESULT_CODE_SUCCESS, "删除成功");
        } else {
            return new ResponseInfo(ResultCode.RESULT_CODE_FAIL, "删除失败");
        }
    }
}
