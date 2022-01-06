package com.alexlin.dao;

import com.alexlin.model.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminDao {
    // 管理员登录
    Admin adminLogin(@Param("name") String name,
                     @Param("password") String password);

    // 管理员获取date
    Admin getDate();

    // 管理员修改date
    int modifyDate(@Param("date") int date);

}
