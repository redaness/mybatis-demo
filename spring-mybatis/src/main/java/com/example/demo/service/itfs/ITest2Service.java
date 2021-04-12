package com.example.demo.service.itfs;

import com.example.demo.entity.User;
import org.springframework.transaction.annotation.Transactional;

public interface ITest2Service {

    @Transactional
    public void doJob2();
}
