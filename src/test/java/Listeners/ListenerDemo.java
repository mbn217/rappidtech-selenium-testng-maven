package Listeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(MyTestsListener.class)
public class ListenerDemo {


    @Test
    public void test1(){
        System.out.println("Im insdie test 1 ");
    }

    @Test
    public void test2(){
        System.out.println("Im insdie test 2 ");
        Assert.assertEquals(true, true);
    }

    @Test
    public void test3(){
        System.out.println("Im insdie test 3 ");
    }


}
