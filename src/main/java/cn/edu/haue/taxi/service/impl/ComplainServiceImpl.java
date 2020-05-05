package cn.edu.haue.taxi.service.impl;

import cn.edu.haue.taxi.common.ResponseData;
import cn.edu.haue.taxi.common.ResponseInfo;
import cn.edu.haue.taxi.common.ResultCode;
import cn.edu.haue.taxi.entity.Complain;
import cn.edu.haue.taxi.entity.Contract;
import cn.edu.haue.taxi.entity.Passenger;
import cn.edu.haue.taxi.mapper.ComplainMapper;
import cn.edu.haue.taxi.mapper.ContractMapper;
import cn.edu.haue.taxi.mapper.PassengerMapper;
import cn.edu.haue.taxi.service.ComplainService;
import cn.edu.haue.taxi.util.UUIDUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplainServiceImpl implements ComplainService {

    @Autowired
    private ComplainMapper complainMapper;

    @Autowired
    private ContractMapper contractMapper;

    @Autowired
    private PassengerMapper passengerMapper;

    @Override
    public ResponseInfo create(Complain complain) {
        //乘客是否现有，否则新增
        Passenger passenger = passengerMapper.selectByPhone(complain.getPassengerPhone());
        if (passenger == null) {
            passengerMapper.insert(new Passenger(complain.getPassengerName(), complain.getPassengerPhone()));
            passenger = passengerMapper.selectByPhone(complain.getPassengerPhone());
        }
        /*
        确保投诉发生在签约期内
        确保能找到当事司机
         */
        complain.setId(UUIDUtil.Id());
        if (complain.getDriverId() != null && !complain.getDriverId().equals("")) { //根据司机编号找当事司机
            List<Contract> contracts = contractMapper.selectByDriverId(complain.getDriverId());
            for (Contract item : contracts) {
                if (item.getEndTime().after(complain.getTime()) && item.getCreateTime().before(complain.getTime())) {
                    complain.setDriverId(item.getDriverId());
                    complain.setTaxiId(item.getTaxiId());
                    complain.setPassengerId(passenger.getId());
                    int i = complainMapper.insert(complain);
                    if (i == 1) {
                        return new ResponseInfo(ResultCode.RESULT_CODE_SUCCESS, "投诉成功，编号:" + complain.getId() + "，请记下投诉编号以查询结果");
                    } else {
                        return new ResponseInfo(ResultCode.RESULT_CODE_FAIL, "投诉失败");
                    }
                }
            }
        } else if (complain.getPlateNum() != null && !complain.getPlateNum().equals("")) {//根据车牌号找当事司机
            List<Contract> contracts = contractMapper.selectByPlateNum(complain.getPlateNum());
            for (Contract item : contracts) {
                if (item.getEndTime().after(complain.getTime()) && item.getCreateTime().before(complain.getTime())) {
                    complain.setDriverId(item.getDriverId());
                    complain.setTaxiId(item.getTaxiId());
                    complain.setPassengerId(passenger.getId());
                    int i = complainMapper.insert(complain);
                    if (i == 1) {
                        return new ResponseInfo(ResultCode.RESULT_CODE_SUCCESS, "投诉成功，编号:" + complain.getId() + "，请记下投诉编号以查询结果");
                    } else {
                        return new ResponseInfo(ResultCode.RESULT_CODE_FAIL, "投诉失败");
                    }
                }
            }
        } else if (complain.getTaxiId() != null) {//根据车辆编号找当事司机
            List<Contract> contracts = contractMapper.selectByTaxiId(complain.getTaxiId());
            for (Contract item : contracts) {
                if (item.getEndTime().after(complain.getTime()) && item.getCreateTime().before(complain.getTime())) {
                    complain.setDriverId(item.getDriverId());
                    complain.setTaxiId(item.getTaxiId());
                    complain.setPassengerId(passenger.getId());
                    int i = complainMapper.insert(complain);
                    if (i == 1) {
                        return new ResponseInfo(ResultCode.RESULT_CODE_SUCCESS, "投诉成功，编号:" + complain.getId() + "，请记下投诉编号以查询结果");
                    } else {
                        return new ResponseInfo(ResultCode.RESULT_CODE_FAIL, "投诉失败");
                    }
                }
            }
        }
        return new ResponseInfo(ResultCode.RESULT_CODE_FAIL, "投诉失败，信息不足无法找到当事司机");
    }

    @Override
    public ResponseInfo update(Complain complain) {
        if (complain.getState() == null) {
            complain.setState(0);
        }
        int i = complainMapper.updateByPrimaryKey(complain);
        if (i == 1) {
            return new ResponseInfo(ResultCode.RESULT_CODE_SUCCESS, "信息更新成功");
        } else {
            return new ResponseInfo(ResultCode.RESULT_CODE_FAIL, "信息更新失败");
        }
    }

    @Override
    public ResponseData<Complain> findById(String id) {
        Complain complain = complainMapper.selectByPrimaryKey(id);
        if (complain == null) {
            return new ResponseData<>(ResultCode.RESULT_CODE_FAIL, "查询失败", null);
        } else {
            return new ResponseData<>(ResultCode.RESULT_CODE_SUCCESS, complain);
        }
    }

    @Override
    public ResponseInfo deleteById(String id) {
        int i = complainMapper.deleteByPrimaryKey(id);
        if (i == 1) {
            return new ResponseInfo(ResultCode.RESULT_CODE_SUCCESS, "记录删除成功");
        } else {
            return new ResponseInfo(ResultCode.RESULT_CODE_FAIL, "记录删除失败");
        }
    }

    @Override
    public ResponseData<List<Complain>> list(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Complain> complains = complainMapper.selectAll();
        PageInfo<Complain> pageInfo = new PageInfo<>(complains);
        return new ResponseData<>(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public ResponseData<List<Complain>> listByDriver(String id, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Complain> complains = complainMapper.selectByDriverId(id);
        PageInfo<Complain> pageInfo = new PageInfo<>(complains);
        return new ResponseData<>(pageInfo.getTotal(), pageInfo.getList());
    }
}
