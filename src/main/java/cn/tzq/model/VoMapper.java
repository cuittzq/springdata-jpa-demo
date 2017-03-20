package cn.tzq.model;

import cn.tzq.model.Dept;
import cn.tzq.model.DeptVo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhiqiang on 2017/3/20.
 */
public class VoMapper {

    /**
     * @param dept
     * @return
     */
    public static DeptVo Do2Vo(Dept dept) {
        return new DeptVo(dept.getId(), dept.getName(), dept.getDescribe());
    }


    /**
     * @param deptVo
     * @return
     */
    public static Dept Vo2Do(DeptVo deptVo) {
        return new Dept(deptVo.getId(), deptVo.getName(), deptVo.getDescribe());
    }


    /**
     * @param deptlist
     * @return
     */
    public static List<DeptVo> Do2VoList(List<Dept> deptlist) {
        List<DeptVo> deptVolist = new ArrayList<>();
        for (Dept dept : deptlist) {
            deptVolist.add(new DeptVo(dept.getId(), dept.getName(), dept.getDescribe()));
        }

        return deptVolist;
    }


    /**
     * @param deptvolist
     * @return
     */
    public static List<Dept> Vo2DoList(List<DeptVo> deptvolist) {
        List<Dept> deptlist = new ArrayList<>();
        for (DeptVo dept : deptvolist) {
            deptlist.add(new Dept(dept.getId(), dept.getName(), dept.getDescribe()));
        }
        return deptlist;
    }
}
