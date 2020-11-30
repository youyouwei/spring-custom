import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * @Description: main 函数入口类
 * @Author: jiahuiyang
 * @Date: Created in 17:22 2020/11/25
 */
public class Main {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestCaseDemo.class);
        for (Failure failure : result.getFailures()) {
            //Test case failure
            System.out.println(failure.toString());
        }
        //Test case success
        System.out.println(result.wasSuccessful());
    }
}
