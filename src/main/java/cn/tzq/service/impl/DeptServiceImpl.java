package cn.tzq.service.impl;

import cn.tzq.model.Dept;
import cn.tzq.repository.DeptRepository;
import cn.tzq.service.DeptService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by zhiqiang on 2017/3/14.
 */
@Service
@Transactional
public class DeptServiceImpl implements DeptService {

    private final DeptRepository repository;

    @Autowired
    public DeptServiceImpl(DeptRepository repository) {
        this.repository = repository;
    }

    @Override
    public Boolean save(Dept dept) {
        Dept savedDept = repository.save(dept);
        return savedDept != null;
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }

    @Override
    public void delete(Dept dept) {
        repository.delete(dept);
    }

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

    @Override
    public Dept findOne(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public List<Dept> findByNameLike(String name) {
        return repository.findByNameLike("%" + name + "%");
    }
}
