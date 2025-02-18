package org.checkstyle.suppressionxpathfilter.parameterassignment;

public class InputXpathParameterAssignmentLambdas {

    public interface SomeInterface {
        void method(int a);
    }

    SomeInterface obj1 = q -> q++; // warn
    void method() {
        int q = 12;
        SomeInterface obj = (d) -> {
            SomeInterface b = (c) -> obj1.equals(this);  
            int c = 12;
            c++;
        };
    }
}
