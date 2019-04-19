package com.sanshao.SpringBootDemo.service;


import com.sanshao.SpringBootDemo.logs.LogAnnotation;
import com.sanshao.SpringBootDemo.model.SimpleUser;
import com.sanshao.SpringBootDemo.model.SimpleUserRepository;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class SimpleUserService {

//    static Logger logger = LoggerFactory.getLogger(SimpleUser.class);

    @Autowired
    private SimpleUserRepository simpleUserRepository;

    @LogAnnotation("Add User")
    public SimpleUser addUser(SimpleUser simpleUser) {
        log.info("Add a User");
        return simpleUserRepository.save(simpleUser);

    }

    @LogAnnotation("Get Users")
    public List<SimpleUser> getSimpleUsers(String name, int page, int size) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);

        //返回Page对象。所有
        Page<SimpleUser> simpleUsers = simpleUserRepository.findAll(pageable);
        //返回Page对象。name查询
        simpleUsers = simpleUserRepository.findByNameLike("%" + name + "%", pageable);
        //返回Page对象。name查询，前五个
        simpleUsers = simpleUserRepository.findFirst5ByNameLike("%" + name + "%", pageable);
        //返回Page对象。name查询，前五个
        simpleUsers = simpleUserRepository.findTop5ByNameLike("%" + name + "%", pageable);

        return simpleUsers.getContent();

    }

    @LogAnnotation("Update User")
    public SimpleUser updateSimpleUser(String name, long id) {
        int flag = simpleUserRepository.modifyNameById(name, id);
        if (flag > 0) {
            return simpleUserRepository.findById(id).get();
        }
        return null;
    }

}
