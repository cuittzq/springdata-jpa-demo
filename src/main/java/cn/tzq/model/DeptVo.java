package cn.tzq.model;

import java.io.Serializable;

/**
 * Created by zhiqiang on 2017/3/14.
 */
public class DeptVo implements Serializable {
    private static final long serialVersionUID = -8459755922288527580L;
    /**
     * 部门编号
     */
    Integer id;

    /**
     * 部门名称
     */
    String name;

    /**
     * 部门编号
     */
    public Integer getId() {
        return id;
    }
    /**
     * 部门编号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 部门名称
     */
    public String getName() {
        return name;
    }

    /**
     * 部门名称
     */
    public void setName(String name) {
        this.name = name;
    }
}
