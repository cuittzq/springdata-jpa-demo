package cn.tzq.controller;

import cn.tzq.model.Dept;
import cn.tzq.service.DeptService;
import cn.tzq.service.impl.DeptServiceImpl;
import cn.tzq.utils.RedisTemplateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zhiqiang on 2017/3/14.
 */
@RestController
@RequestMapping(value = "/frame")
public class DeptController {

    private DeptService deptService;

    private RedisTemplateUtils redisTemplateUtils;

    @Autowired
    public DeptController(DeptServiceImpl deptService, RedisTemplateUtils redisTemplateUtils) {
        this.deptService = deptService;
        this.redisTemplateUtils = redisTemplateUtils;
    }

    @RequestMapping(value = "/saveUser",
//            method：  指定请求的method类型， GET、POST、PUT、DELETE等；
            method = RequestMethod.POST,
//           produces 指定返回的内容类型，仅当request请求头中的(Accept)类型中包含该指定类型才返回
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    public String saveUser(@RequestBody Dept dept) {
        boolean issaved = deptService.save(dept);
        return issaved ? "保存成功" : "保存失敗";
    }

    @RequestMapping(value = "/user/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    public Dept FindOne(@PathVariable Integer id) {
        Dept redisdept = null;
        try {
            redisdept = redisTemplateUtils.get(String.format("Dept_%d", id), Dept.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (redisdept == null) {
            redisdept = deptService.findOne(id);
            redisTemplateUtils.set(String.format("Dept_%d", redisdept.getId()), redisdept, 30L);
        }

        return redisdept;
    }
}
