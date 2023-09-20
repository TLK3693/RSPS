package example1;
public class LambdaApp {
    public static void main(String[] args){
        Operationable operation = (int x,int y)->x+y;
        // Определение ссылки на функциональный интерфейс = -> создание лямбда-выражения
        int result = operation.calculate(10, 20);
        System.out.println(result);

        Operationable operation1 = (int x, int y)-> x-y;
        System.out.println(operation1.calculate(20, 10));

        Operationable operation2 = (int x, int y)->x*y;
        System.out.print(operation2.calculate(20, 10));

    }
}