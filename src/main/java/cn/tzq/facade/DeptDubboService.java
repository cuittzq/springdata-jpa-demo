package cn.tzq.facade;

import cn.tzq.model.DeptVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by zhiqiang on 2017/3/20.
 */
public interface DeptDubboService {
    /**
     * @param dept 部门信息
     * @return
     */
    String saveDept(DeptVo dept);


    /**
     * @param dept 部门信息
     * @return
     */
    boolean deleteDept(DeptVo dept);


    /**
     * @param id 部门ID
     * @return
     */
    DeptVo getdeptInfo(Integer id);

    /**
     * 分页获取部门信息
     *
     * @param pageNumber
     * @param pageSize
     * @return
     */
    PageInfo<DeptVo> getdeptInfoByPage(Integer pageNumber, Integer pageSize);

    /**
     * @param pageNumber
     * @param pageSize
     * @return
     */
    List<DeptVo> findMaxDept(Integer pageNumber, Integer pageSize);

    /**
     * 获取全部的部门信息
     *
     * @return 部门信息
     */
    List<DeptVo> getDpetAll();
}
