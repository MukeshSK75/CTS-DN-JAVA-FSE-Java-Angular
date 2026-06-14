public class Ex38_Decompile {

    static String encode(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray())
            sb.append((char)(c + 1));
        return sb.toString();
    }

    public static void main(String[] args) {
        String original = "Hello";
        String encoded = encode(original);
        System.out.println("Original: " + original);
        System.out.println("Encoded:  " + encoded);
    }
}

/*
 * To decompile:
 * 1. Compile: javac Ex38_Decompile.java
 * 2. Using CFR (command line):
 *      java -jar cfr.jar Ex38_Decompile.class
 * 3. Using JD-GUI:
 *      Open JD-GUI, drag and drop Ex38_Decompile.class
 *      The decompiled source will appear in the viewer.
 *
 * Note: CFR can be downloaded from: https://github.com/leibnitz27/cfr/releases
 */
