package example5;

public class LambdaApp {
    public static void main(String[] args){
        //Локальные переменные уровня метода мы также можем использовать в
        //лямбдах, но изменять их значение нельзя
        int n = 70;
        int m = 30;
        Operationable op = ()->{
            return m+n;
        };
        System.out.println(op.calculate());
    }
}
