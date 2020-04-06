package cn.edu.haue.taxi.service.impl;

import cn.edu.haue.taxi.common.ResponseData;
import cn.edu.haue.taxi.common.ResultCode;
import cn.edu.haue.taxi.entity.Admin;
import cn.edu.haue.taxi.mapper.AdminMapper;
import cn.edu.haue.taxi.service.AdminService;
import cn.edu.haue.taxi.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public ResponseData<Admin> login(String username, String password) {
        Admin admin = adminMapper.selectByPrimaryKey(username);
        if (admin == null) {
            return new ResponseData<>(ResultCode.RESULT_CODE_FAIL, "账号不存在",null);
        } else if (admin.getPassword().equals(MD5Util.MD5EncodeUtf8(password))) {
            return new ResponseData<>(ResultCode.RESULT_CODE_SUCCESS, "登陆成功", admin);
        } else {
            return new ResponseData<>(ResultCode.RESULT_CODE_FAIL, "账号或密码错误",null);
        }
    }
}
