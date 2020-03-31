package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.mapper.TestMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class TestService {

    private final TestMapper testMapper;

    @Transactional
    public void doJob() {
        testMapper.insert(new User("3r2",55));
        testMapper.insert(new User("fwsg3e",77));
        System.out.println(testMapper.findById(1));
    }

}
