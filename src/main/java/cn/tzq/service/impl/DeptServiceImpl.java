package cn.tzq.service.impl;

import cn.tzq.model.Dept;
import cn.tzq.repository.DeptRepository;
import cn.tzq.service.DeptService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhiqiang on 2017/3/14.
 */
@Service
@Transactional
public class DeptServiceImpl implements DeptService {

    private final DeptRepository repository;


    /**
     * @param repository
     */
    @Autowired
    public DeptServiceImpl(DeptRepository repository) {
        this.repository = repository;
    }

    /**
     * @param dept 部门信息
     * @return
     */
    @Override
    public Boolean save(Dept dept) {
        Dept savedDept = repository.save(dept);
        return savedDept != null;
    }

    /**
     * @param id 部门编号
     */
    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }

    /**
     * @param dept 部门信息
     */
    @Override
    public void delete(Dept dept) {
        repository.delete(dept);
    }

    /**
     * @param id   部门编号
     * @param dept 部门信息
     * @return
     */
    @Override
    public Boolean update(Integer id, Dept dept) {
        Assert.notNull(id, "部门编号不能为空.");

        Dept tempDept = findOne(id);
        Assert.notNull(tempDept, "部门信息不存在.修改失败..");

        BeanUtils.copyProperties(dept, tempDept);

        tempDept.setId(id);
        dept = repository.save(tempDept);
        return dept != null;

    }

    /**
     * @param id 部门编号
     * @return
     */
    @Override
    public Dept findOne(Integer id) {
        return repository.findOne(id);
    }

    /**
     * @param name 部门名称关键字
     * @return
     */
    @Override
    public List<Dept> findByNameLike(String name) {
        return repository.findByNameLike("%" + name + "%");
    }

    /**
     * 分页获取部门信息
     *
     * @param var1 分页信息
     * @return 部门信息
     */
    @Override
    public List<Dept> findbyPage(Pageable var1) {
        Page<Dept> deptpageinfo = repository.findAll(var1);
        return deptpageinfo.getContent();
    }

    /**
     * 获取所有部门信息
     *
     * @return 所有的部门信息
     */
    @Override
    public List<Dept> findAll() {
        return repository.findAll();
    }
}
