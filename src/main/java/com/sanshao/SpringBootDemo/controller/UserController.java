package com.sanshao.SpringBootDemo.controller;


import com.sanshao.SpringBootDemo.exceptions.SimpleException;
import com.sanshao.SpringBootDemo.model.SimpleUser;
import com.sanshao.SpringBootDemo.service.SimpleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    SimpleUserService simpleUserService;

    @PostMapping("/simpleuser")
    public SimpleUser addSimpleUser(@RequestBody SimpleUser simpleUser) {
        return simpleUserService.addUser(simpleUser);
    }


    @GetMapping("/simpleuser")
    public List<SimpleUser> getSimpleUsers(@RequestParam(value = "name") String name, @RequestParam(value = "page") int page, @RequestParam(value = "size") int size) {
        return simpleUserService.getSimpleUsers(name, page, size);
    }

    @GetMapping("/simpleuser/{id}")
    public SimpleUser getSimpleUsers(@PathVariable(value = "id") long id) {
        return simpleUserService.getSimpleUser(id);
    }

    @PutMapping("/simpleuser")
    public SimpleUser updateSimpleUser(@RequestParam(value = "name") String name, @RequestParam(value = "id") long id) {
        return simpleUserService.updateSimpleUser(name, id);
    }

    @DeleteMapping("/simpleuser/{id}")
    public boolean deleteSimpleUser(@PathVariable("id") long id){
        return simpleUserService.deleteSimpleUser(id);
    }


    @GetMapping("/exception")
    public void testException(@RequestParam(value = "code") int code) throws Exception {
        if(code == -1) {
            throw new SimpleException(-1, "0 为除数");
        }else {
            throw new Exception();
        }
    }


}
