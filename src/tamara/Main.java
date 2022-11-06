package tamara;

import tamara.homework2.*;

public class Main {
    public static void main(String[] args) {
        StringBuilderWithUndoFunction s = new StringBuilderWithUndoFunction("hello,");
        s.append("world");
        System.out.println(s.toString());
        s.replace(5, 8, "a"); // 4
        System.out.println(s.toString());
        s.undo();
        System.out.println(s.toString());
    }
}

//    public static final String ANSI_RESET = "\u001B[0m";
//    public static final String ANSI_BLACK = "\u001B[30m";
//    public static final String ANSI_RED = "\u001B[31m";
//    public static final String ANSI_GREEN = "\u001B[32m";
//    public static final String ANSI_YELLOW = "\u001B[33m";
//    public static final String ANSI_BLUE = "\u001B[34m";
//    public static final String ANSI_PURPLE = "\u001B[35m";
//    public static final String ANSI_CYAN = "\u001B[36m";
//    public static final String ANSI_WHITE = "\u001B[37m";