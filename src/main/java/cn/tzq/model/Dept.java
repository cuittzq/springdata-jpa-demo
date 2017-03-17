package cn.tzq.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by zhiqiang on 2017/3/14.
 */
@Entity
@Table(name = "m_dept")
public class Dept  implements Serializable {
    private static final long serialVersionUID = -8459755922288527580L;

    /**
     * 部门编号
     */
    @Id
    @Column(name = "dept_id")
    @GeneratedValue
    Integer id;

    /**
     * 部门名称
     */
    @Column(name = "dept_name", length = 10)
    String name;



    /**
     * 部门描述
     */
    @Column(name = "dept_describe", length = 255)
    String describe;

    /**
     * @return
     */
    public String getDescribe() {
        return describe;
    }

    /**
     * @param describe
     */
    public void setDescribe(String describe) {
        this.describe = describe;
    }

    /**
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}
