package cn.tzq.service;

import cn.tzq.model.Dept;
import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by zhiqiang on 2017/3/14.
 */
public interface DeptService {
    /**
     * 持久化部门部门信息
     * 如果信息已经存在, 修改, 反之, 新增
     *
     * @param dept 部门信息
     * @return .
     */
    Boolean save(Dept dept);

    /**
     * 通过部门编号删除部门信息
     *
     * @param id 部门编号
     */
    void delete(Integer id);

    /**
     * 通过部门
     *
     * @param dept 部门信息
     */
    void delete(Dept dept);

    /**
     * 更新部门
     *
     * @param id   部门编号
     * @param dept 部门信息
     * @return 更新结果
     */
    Boolean update(Integer id, Dept dept);

    /**
     * 通过部门编号查询部门信息
     *
     * @param id 部门编号
     * @return 部门信息
     */
    Dept findOne(Integer id);

    /**
     * 通过部门名称关键字模糊查询部门信息
     *
     * @param name 部门名称关键字
     * @return 符合条件的部门的信息
     */
    List<Dept> findByNameLike(String name);

    /**
     * 分页获取部门信息
     *
     * @param var1 分页信息
     * @return 部门信息
     */
    PageInfo<Dept> findbyPage(Pageable var1);

    /**
     * 获取所有部门信息
     *
     * @return 所有的部门信息
     */
    List<Dept> findAll();
}
