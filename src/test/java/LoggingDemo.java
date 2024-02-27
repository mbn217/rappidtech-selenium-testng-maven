
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class LoggingDemo {
    private static final Logger logger = LogManager.getLogger(LoggingDemo.class);

    @Test
    public void demoLogging(){
        logger.info("Im inside the Demo Logging test case");
        logger.warn("This is a warnning logs");
        logger.debug("This is debug logs");
        logger.error("This is error log");
        System.out.println("Demo");
    }
    @Test
    public void demoLogginTwo(){
        int a = 2 ;
        int b = 3;
        if( a == b ){
            logger.info("Test case passed");
            //System.out.println("Test case passed");
        }else{
            logger.error("Test case failed");
            //System.out.println("Test case failed");
        }
    }



}
