public class Ex37_BytecodeInspect {

    static int square(int n) {
        return n * n;
    }

    public static void main(String[] args) {
        int x = 5;
        int result = square(x);
        System.out.println("Square of " + x + " = " + result);
    }
}

/*
 * After compiling: javac Ex37_BytecodeInspect.java
 * Run: javap -c Ex37_BytecodeInspect
 *
 * Sample bytecode output for square():
 *   static int square(int);
 *     Code:
 *        0: iload_0
 *        1: iload_0
 *        2: imul
 *        3: ireturn
 *
 * Interpretation:
 *   iload_0  -> loads int variable (n) onto stack (twice)
 *   imul     -> pops two ints, pushes their product
 *   ireturn  -> returns top of stack as int
 */
