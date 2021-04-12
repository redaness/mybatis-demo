package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.mapper.TestMapper;
import com.example.demo.service.itfs.ITest2Service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class Test2Service implements ITest2Service {

    private final TestMapper testMapper;

    @Override
    public void doJob2() {
        testMapper.insert(new User("3r2",55));
        testMapper.insert(new User("fwsg3e",77));
        System.out.println(testMapper.findById(1));
    }
}
