package com.reda.mapper;

import com.reda.entity.User;

public interface Test2Mapper {

    User findById(Integer id);

    void update(Integer id);
}
