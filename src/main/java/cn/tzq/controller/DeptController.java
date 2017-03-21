package cn.tzq.controller;

import cn.tzq.model.Dept;
import cn.tzq.model.DeptVo;
import cn.tzq.model.VoMapper;
import cn.tzq.service.DeptService;
import cn.tzq.service.impl.DeptServiceImpl;
import cn.tzq.utils.RedisTemplateUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public String saveDept(@RequestBody DeptVo dept) {
        boolean issaved = deptService.save(VoMapper.Vo2Do(dept));
        return issaved ? "保存成功" : "保存失敗";
    }


    @RequestMapping(value = "/deleteDept",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    public boolean deleteDept(@RequestBody DeptVo dept) {
        deptService.delete(VoMapper.Vo2Do(dept));
        return true;
    }

    @RequestMapping(value = "/getdeptInfo/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    public DeptVo findOne(@PathVariable Integer id) {
        DeptVo redisdept = null;
        try {
            redisdept = redisTemplateUtils.get(String.format("Dept_%d", id), DeptVo.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (redisdept == null) {
            redisdept = VoMapper.Do2Vo(deptService.findOne(id));
            redisTemplateUtils.set(String.format("Dept_%d", redisdept.getId()), redisdept, 30L);
        }

        return redisdept;
    }


    /**
     * 获取部门信息
     *
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/getdeptInfo/page",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    public PageInfo<DeptVo> findAll(Integer pageNumber, Integer pageSize) {
        PageInfo<DeptVo> deptPageList = this.deptService.findbyPage(pageNumber, pageSize);
        return deptPageList;
    }

    @RequestMapping(value = "/getdeptInfo/maxdept",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    public List<DeptVo> findMaxDept(Integer pageNumber, Integer pageSize) {
        PageInfo<DeptVo> deptPageList = this.deptService.findbyPage(pageNumber, pageSize);
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
    public List<DeptVo> getDpetAll() {
        List<Dept> depts = this.deptService.findAll();
        return VoMapper.Do2VoList(depts);
    }
}
