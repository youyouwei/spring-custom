import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

//from w w  w  . ja va2 s.c o m

/**
 * @Description: TestCase用fixture定义一个测试用例来运行多个测试。 这种适合集成测试
 * TestCase是Junit3 写的 新版本也兼容 现在@Test更常用 并且能够显式的表示那些类或则方法需要测试
 * @Author: jiahuiyang
 * @Date: Created in 17:20 2020/11/25
 */
public class TestCaseDemo extends TestCase {
    protected double fValue1;
    protected double fValue2;

    @Before
    public void setUp() {
        System.out.println("setup");
        fValue1= 2.0;
        fValue2= 3.0;
    }

    //@Test可不加不起作用 JUnitCore会自动run所有的方法
    public void testAdd() {
        //count the number of test cases
        System.out.println("No of Test Case = "+ this.countTestCases());

        //test getName
        String name= this.getName();
        System.out.println("Test Case Name = "+ name);

        //test setName
        this.setName("testNewAdd");
        String newName= this.getName();
        System.out.println("Updated Test Case Name = "+ newName);

        assertEquals(5.0, fValue1+fValue2);
    }
    //tearDown used to close the connection or clean up activities
    public void tearDown(  ) {
        System.out.println("clean up.");
    }

    /**
     * 方法需要以test开头 方法必须public
     */
    public void testMethod() {
        System.out.println("test the TestCase method");
    }

    @Test
    public void method() {
        System.out.println("method..........");

    }
}
