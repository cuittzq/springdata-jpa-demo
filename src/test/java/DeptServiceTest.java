import cn.tzq.model.Dept;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.springframework.data.redis.core.ListOperations;

import javax.transaction.Transactional;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by zhiqiang on 2017/3/14.
 */
public class DeptServiceTest {

    public static void main(String[] args) {
        LamadaTest();

    }

    public static void TimeTest() {
        // Get the system clock as UTC offset
        final Clock clock = Clock.systemUTC();
        System.out.println(clock.instant());
        System.out.println(clock.millis());


        // Get the local date and local time
        final LocalDate date = LocalDate.now();
        final LocalDate dateFromClock = LocalDate.now(clock);

        System.out.println(date);
        System.out.println(dateFromClock);

// Get the local date and local time
        final LocalTime time = LocalTime.now();
        final LocalTime timeFromClock = LocalTime.now(clock);

        System.out.println(time);
        System.out.println(timeFromClock);


        // Get the local date/time
        final LocalDateTime datetime = LocalDateTime.now();
        final LocalDateTime datetimeFromClock = LocalDateTime.now(clock);

        System.out.println(datetime);
        System.out.println(datetimeFromClock);
    }

    public static void LamadaTest() {

        List<Dept> depts = new ArrayList<Dept>();
        Dept deptinfo = null;
        for (int i = 0; i < 100; i++) {
            deptinfo = new Dept();
            deptinfo.setId(i);
            deptinfo.setName(String.format("测试部门%d", i));
            depts.add(deptinfo);
        }
        // 获取所有部门名称
        List<String> names = depts.stream().map(Dept::getName).collect(Collectors.toList());


        depts.stream().forEach(p -> System.out.println(p.getName()));
        depts.parallelStream().filter(p->p.getId()>10 && p.getId()<20).forEach(m->System.out.println(m.getId()+m.getName()));
        Stream<Dept> streaminfo = depts.stream();
        streaminfo.forEach(p -> System.out.println(p.getName()));


        Stream.of(depts).forEach(p -> System.out.println(p));

        Stream<List<Dept>> streaminfo1 = Stream.of(depts);
        streaminfo1.forEach(p -> p.forEach(j->System.out.println(j.getName())));

        String[] array = {"a", "b", "c"};
        for (Integer i : Lists.newArrayList(1, 2, 3)) {
            // map(item -> Strings.padEnd(item, i, '@'))
            Stream.of(array).forEach(p -> System.out.println(p));
        }

    }
}
