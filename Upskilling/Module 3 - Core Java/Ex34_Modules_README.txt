Java Modules Exercise (Ex34)
==============================

Java modules require a specific directory structure and cannot be contained
in a single .java file. Below is the complete setup:

Directory structure:
  ex34_modules/
  ├── com.utils/
  │   ├── module-info.java
  │   └── com/utils/StringUtil.java
  └── com.greetings/
      ├── module-info.java
      └── com/greetings/Main.java

----- com.utils/module-info.java -----
module com.utils {
    exports com.utils;
}

----- com.utils/com/utils/StringUtil.java -----
package com.utils;

public class StringUtil {
    public static String greet(String name) {
        return "Hello, " + name + "!";
    }
}

----- com.greetings/module-info.java -----
module com.greetings {
    requires com.utils;
}

----- com.greetings/com/greetings/Main.java -----
package com.greetings;

import com.utils.StringUtil;

public class Main {
    public static void main(String[] args) {
        System.out.println(StringUtil.greet("World"));
    }
}

Compile & Run commands:
  javac -d mods/com.utils com.utils/module-info.java com.utils/com/utils/StringUtil.java
  javac --module-path mods -d mods/com.greetings com.greetings/module-info.java com.greetings/com/greetings/Main.java
  java --module-path mods -m com.greetings/com.greetings.Main
