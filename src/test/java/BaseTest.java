import com.feiyang.interviewdemo.springDemo.springcontext.CustomerConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 11:43 2019/10/21
 */
public class BaseTest {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CustomerConfig.class);

    @Test
    public void method() {
        System.out.println("base test method");
    }

    @Test
    public void method1() {

        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }

//        context显式执行close才会执行@PreDestroy注解的方法
        context.close();

    }

}
