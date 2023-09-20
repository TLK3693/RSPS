package example3;

public class LambdaApp {
    public static void main(String[] args) {

        Printable printer = s -> System.out.println(s);
        printer.print("Hello Java!");
    }
}
