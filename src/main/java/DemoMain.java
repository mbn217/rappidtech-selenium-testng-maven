public class DemoMain {

    public static void main(String[] args) {
        //    C:\Users\Fatima Amjad\IdeaProjects\rappidtech-selenium-testng-maven   /screenShots/verifyLoginLabel20240224010050.png

        String finalPath;
        String path = "C:\\Users\\Fatima Amjad\\IdeaProjects\\rappidtech-selenium-testng-maven" +"/ScreenShots/file.png";

        finalPath = path.replace("/" , "\\");


        System.out.println(finalPath);
    }
}
