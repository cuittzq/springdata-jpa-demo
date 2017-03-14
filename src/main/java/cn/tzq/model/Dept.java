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

//    /**
//     * 员工信息
//     */
//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "dept")
//    List<Employee> employees;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
