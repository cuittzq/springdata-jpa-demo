package cn.tzq.repository;

import cn.tzq.model.Dept;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by zhiqiang on 2017/3/14.
 */
public interface DeptRepository extends JpaRepository<Dept,Integer> {
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
     * @return 所有的部门信息
     */
    Page<Dept> findAll(Pageable var1);
}
