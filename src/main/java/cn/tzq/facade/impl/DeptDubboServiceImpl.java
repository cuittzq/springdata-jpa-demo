package cn.tzq.facade.impl;

import cn.tzq.facade.DeptDubboService;
import cn.tzq.model.VoMapper;
import cn.tzq.model.Dept;
import cn.tzq.model.DeptVo;
import cn.tzq.service.DeptService;
import cn.tzq.service.impl.DeptServiceImpl;
import cn.tzq.utils.RedisTemplateUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhiqiang on 2017/3/20.
 */
@Service(version = "1.0.0")
public class DeptDubboServiceImpl implements DeptDubboService {

    private DeptService deptService;

    private RedisTemplateUtils redisTemplateUtils;

    @Autowired
    public DeptDubboServiceImpl(DeptServiceImpl deptService, RedisTemplateUtils redisTemplateUtils) {
        this.deptService = deptService;
        this.redisTemplateUtils = redisTemplateUtils;
    }

    /**
     * @param dept 部门信息
     * @return
     */
    public String saveDept(DeptVo dept) {
        boolean issaved = deptService.save(VoMapper.Vo2Do(dept));
        return issaved ? "保存成功" : "保存失敗";
    }


    /**
     * @param dept 部门信息
     * @return
     */
    public boolean deleteDept(DeptVo dept) {
        deptService.delete(VoMapper.Vo2Do(dept));
        return true;
    }


    /**
     * @param id 部门ID
     * @return
     */
    public DeptVo getdeptInfo(Integer id) {
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

        return VoMapper.Do2Vo(redisdept);
    }

    /**
     * 分页获取部门信息
     *
     * @param pageNumber
     * @param pageSize
     * @return
     */
    public PageInfo<DeptVo> getdeptInfoByPage(Integer pageNumber, Integer pageSize) {
        PageRequest request = this.buildPageRequest(pageNumber, pageSize);
        PageInfo<DeptVo> deptPageList = this.deptService.findbyPage(request);
        return deptPageList;
    }


    /**
     * @param pageNumber
     * @param pageSize
     * @return
     */
    public List<DeptVo> findMaxDept(Integer pageNumber, Integer pageSize) {
        PageRequest request = this.buildPageRequest(pageNumber, pageSize);
        PageInfo<DeptVo> deptPageList = this.deptService.findbyPage(request);
        List<Integer> prices = new ArrayList<>();
        final int max = prices.stream().reduce(0, Math::max);
        return deptPageList.getList();
    }

    /**
     * 获取全部的部门信息
     *
     * @return 部门信息
     */
    public List<DeptVo> getDpetAll() {
        List<Dept> depts = this.deptService.findAll();
        return VoMapper.Do2VoList(depts);
    }

    //构建PageRequest
    private PageRequest buildPageRequest(Integer pageNumber, Integer pagzSize) {
        return new PageRequest(pageNumber - 1, pagzSize, Sort.Direction.ASC, "id");
    }
}
