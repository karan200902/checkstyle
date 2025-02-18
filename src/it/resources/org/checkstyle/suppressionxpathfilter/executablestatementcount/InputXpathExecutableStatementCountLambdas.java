package org.checkstyle.suppressionxpathfilter.executablestatementcount;

import java.util.function.Consumer;
import java.util.function.Function;

public class InputXpathExecutableStatementCountLambdas {
    Consumer c = (s) -> { // warn
        String str = s.toString();
        str = str + "!";
    };

    Consumer t = a -> a.toString().trim();  
    Function x1 = a -> a;  
    Function y = a -> null;  
}
