import java.lang.reflect.*;

public class Ex39_Reflection {

    static class MathOps {
        public int add(int a, int b) { return a + b; }
        public int multiply(int a, int b) { return a * b; }
    }

    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("Ex39_Reflection$MathOps");
        Object obj = cls.getDeclaredConstructor().newInstance();

        System.out.println("Methods in MathOps:");
        for (Method m : cls.getDeclaredMethods()) {
            System.out.println("  " + m.getName() + " params: " + m.getParameterCount());
        }

        Method addMethod = cls.getMethod("add", int.class, int.class);
        Object result = addMethod.invoke(obj, 10, 20);
        System.out.println("add(10, 20) via reflection = " + result);
    }
}
