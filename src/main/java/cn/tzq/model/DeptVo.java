package cn.tzq.model;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * Created by zhiqiang on 2017/3/14.
 */
public class DeptVo implements Serializable {
    private static final long serialVersionUID = -8459755922288527580L;

    /**
     * 部门编号
     */
    private Integer id;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 部门描述
     */
    private String describe;

    /**
     * @param id
     * @param name
     * @param describe
     */
    public DeptVo(Integer id, String name, String describe) {
        this.id = id;
        this.name = name;
        this.describe = describe;
    }

    public DeptVo() {
    }

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

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
