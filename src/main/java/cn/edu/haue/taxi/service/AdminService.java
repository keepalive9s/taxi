package cn.edu.haue.taxi.service;

import cn.edu.haue.taxi.common.ResponseData;
import cn.edu.haue.taxi.entity.Admin;

public interface AdminService {
    ResponseData<Admin> login(String username, String password);
}
