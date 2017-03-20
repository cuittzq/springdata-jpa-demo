package cn.tzq.controller;

import cn.tzq.model.Dept;
import cn.tzq.service.DeptService;
import cn.tzq.service.impl.DeptServiceImpl;
import cn.tzq.utils.RedisTemplateUtils;
import com.github.pagehelper.PageInfo;
import com.querydsl.core.types.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.OrderBy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhiqiang on 2017/3/14.
 */
@RestController
@RequestMapping(value = "/Dept")
public class DeptController {

    private DeptService deptService;

    private RedisTemplateUtils redisTemplateUtils;

    @Autowired
    public DeptController(DeptServiceImpl deptService, RedisTemplateUtils redisTemplateUtils) {
        this.deptService = deptService;
        this.redisTemplateUtils = redisTemplateUtils;
    }

    @RequestMapping(value = "/saveDept",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    public String saveUser(@RequestBody Dept dept) {
        boolean issaved = deptService.save(dept);
        return issaved ? "保存成功" : "保存失敗";
    }


    @RequestMapping(value = "/deleteDept",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    public boolean deleteDept(@RequestBody Dept dept) {
        deptService.delete(dept);
        return true;
    }

    @RequestMapping(value = "/getdeptInfo/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    public Dept findOne(@PathVariable Integer id) {
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

    /*
    * 分页获取部门信息
    * */
    @RequestMapping(value = "/getdeptInfo/page",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    public PageInfo<Dept> findAll(Integer pageNumber, Integer pageSize) {
        PageRequest request = this.buildPageRequest(pageNumber, pageSize);
        PageInfo<Dept> deptPageList = this.deptService.findbyPage(request);
        return deptPageList;
    }

    @RequestMapping(value = "/getdeptInfo/maxdept",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    public List<Dept> findMaxDept(Integer pageNumber, Integer pageSize) {
        PageRequest request = this.buildPageRequest(pageNumber, pageSize);
        PageInfo<Dept> deptPageList = this.deptService.findbyPage(request);
        List<Integer> prices = new ArrayList<>();
        final int max = prices.stream().reduce(0, Math::max);
        return deptPageList.getList();
    }

    /**
     * 获取全部的部门信息
     *
     * @return 部门信息
     */
    @RequestMapping(value = "/getdeptInfo/all",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    public List<Dept> getDpetAll() {
        return this.deptService.findAll();
    }

    //构建PageRequest
    private PageRequest buildPageRequest(Integer pageNumber, Integer pagzSize) {
        return new PageRequest(pageNumber - 1, pagzSize, Sort.Direction.ASC, "id");
    }
}
