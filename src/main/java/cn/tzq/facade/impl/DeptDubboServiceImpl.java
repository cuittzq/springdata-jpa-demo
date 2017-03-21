package cn.tzq.facade.impl;

import cn.tzq.facade.DeptDubboService;
import cn.tzq.model.DeptVo;
import cn.tzq.model.VoMapper;
import cn.tzq.service.DeptService;
import cn.tzq.service.impl.DeptServiceImpl;
import cn.tzq.utils.RedisTemplateUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

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
    @Override
    public Boolean saveDept(DeptVo dept) {
        return this.deptService.save(VoMapper.Vo2Do(dept));
    }

    /**
     * @param dept 部门信息
     * @return
     */
    @Override
    public void deleteDept(DeptVo dept) {
        this.deptService.delete(VoMapper.Vo2Do(dept));
    }

    /**
     * @param id 部门ID
     * @return
     */
    @Override
    public DeptVo getDeptInfo(Integer id) {
        return VoMapper.Do2Vo(this.deptService.findOne(id));
    }

    /**
     * 分页获取部门信息
     *
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<DeptVo> getDeptInfoByPage(Integer pageNumber, Integer pageSize) {
        return this.deptService.findbyPage(pageNumber, pageSize);
    }

    /**
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @Override
    public List<DeptVo> findMaxDept(Integer pageNumber, Integer pageSize) {
        return null;
    }

    /**
     * 获取全部的部门信息
     *
     * @return 部门信息
     */
    @Override
    public List<DeptVo> getDpetAll() {
        return null;
    }
}
