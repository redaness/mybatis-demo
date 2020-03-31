package com.reda.objectfactory;

import com.reda.entity.User;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

public class MyObjectFactory extends DefaultObjectFactory {
    @Override
    public <T> T create(Class<T> type) {
        if (type == User.class) {
            System.out.printf("MyObjectFactory create %s \n", type.getName());
        }
        return create(type, null, null);
    }
}
