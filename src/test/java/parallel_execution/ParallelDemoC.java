package parallel_execution;

import org.testng.annotations.Test;

public class ParallelDemoC {


    @Test
    void testOne(){
        System.out.println("Test One Runnning on " + Thread.currentThread().getId());
    }

    @Test
    void testTwo(){
        System.out.println("Test Two Runnning on  " + Thread.currentThread().getId());
    }




}
