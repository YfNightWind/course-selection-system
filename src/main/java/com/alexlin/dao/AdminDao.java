package com.alexlin.dao;

import com.alexlin.model.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminDao {
    Admin adminLogin(@Param("name") String name,
                     @Param("password") String password);
}
