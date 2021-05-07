package example01;


public class Demo2 {
    public static void main(String[] args) {
        System.out.println(System.getProperty("name"));

        for (String arg : args) {
            System.out.println("-->" + arg);
        }
    }
}
