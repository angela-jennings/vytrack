package vytrack_utils;

public class BrowserUtils {
    public static void sleep(int second) {

        second*=1000;

        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {
            System.out.println("Something happened in the sleep method");
        }

    }
}
