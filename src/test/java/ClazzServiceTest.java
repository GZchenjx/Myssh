import com.jx.bean.Clazz;
import com.jx.bean.Stu;
import com.jx.comment.Pager;
import com.jx.service.ClazzService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

/**
 * Created by CHEN JX on 2017/11/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:/config/spring-*.xml")
public class ClazzServiceTest {

    @Autowired
    private ClazzService clazzService;


    @Test
    public void testSave(){
        Clazz clazz = new Clazz();
        clazz.setTitle("宏图软件");
        clazzService.save(clazz);
    }
    @Test
    public void testGetById() {
        Clazz byId = clazzService.getById(1L);
        System.out.println(byId.getTitle());
        Set<Stu> stuSet = byId.getStuSet();
        System.out.println(stuSet.iterator().next().getRealName());
        System.out.println(stuSet.iterator().next().getNum());

    }

    @Test
    public void testPager() {
        Pager<Clazz> clazzPager = clazzService.listPager(1, 2);
        System.out.println(clazzPager.getTotal());
        System.out.println(clazzPager.getPages());
        System.out.println(clazzPager.getRows().get(0).getTitle());
    }
}
