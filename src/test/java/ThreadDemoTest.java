import com.demo.imooc.DemoThread;
import org.junit.Test;

/**
 * @Description:
 * @Author: jiahuiyang
 * @Date: Created in 9:45 2020/11/2
 */
public class ThreadDemoTest {


    @Test
    public void test() throws InterruptedException{
        DemoThread demoThread1 = new DemoThread();
        DemoThread demoThread2 = new DemoThread();

        demoThread1.start();
        demoThread2.start();

    }


}
