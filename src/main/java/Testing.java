public class Testing {
    public static void main(String[] args) {
        int result = 0;
        result = addition(4, 5);

        System.out.println(result);
    }

    static int addition(int a, int b) {
        System.out.println("Adding "+a+" with "+b);
        return a+b;
    }
}
