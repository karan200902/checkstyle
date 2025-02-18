/*xml
<module name="Checker">
  <module name="TreeWalker">
    <module name="ReturnCount">
      <property name="max" value="2"/>
      <property name="maxForVoid" value="1"/>
    </module>
  </module>
</module>
*/
package com.puppycrawl.tools.checkstyle.checks.coding.returncount;

import java.util.function.Predicate;

// xdoc section -- start
public class Example3 {
    public Example3() {}
    //below, because default void restriction is 1
    public Example3(int i) { return; }

    public int signA(int x) {
        if (x < -2) { return -1; }
        return 0;
    }
    // violation below, 'max allowed for non-void methods/lambdas is 2'
    public int signB(int x) {
        if (x < -2) { return -1; }
        if (x == 0) { return 0; }
        if (x > 2) { return 2; }
        return 1;
    }
    //below, because non-void restriction is 2
    final Predicate<Integer> lambdaA = i -> {
        if (i > 5) { return true; }
        return false;
    };

    final Predicate<Integer> lambdaB = i -> { return i > 5; };

    public void methodA(int x) {}
    //below, because default void restriction is 1
    public void methodB(int x) { return; }
}
// xdoc section -- end
