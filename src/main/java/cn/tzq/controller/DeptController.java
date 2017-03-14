package cn.tzq.controller;

import cn.tzq.model.Dept;
import cn.tzq.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zhiqiang on 2017/3/14.
 */
@RestController
@RequestMapping(value = "/frame")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "/saveUser",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    public String saveUser(@RequestBody Dept dept){
        boolean issaved =  deptService.save(dept);
        return  issaved?"保存成功":"保存失敗";
    }

    @RequestMapping(value = "/user/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    public Dept FindOne(@PathVariable Integer id){
        return deptService.findOne(id);
    }
}
