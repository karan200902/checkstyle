/*xml
<module name="Checker">
  <module name="TreeWalker">
    <module name="VariableDeclarationUsageDistance">
      <property name="validateBetweenScopes" value="true"/>
    </module>
  </module>
</module>
*/
package com.puppycrawl.tools.checkstyle.checks.coding.variabledeclarationusagedistance;

// xdoc section -- start
public class Example4 {

  public void foo1() {
    int num;        // violation, distance = 4
    final double PI;   //final variables not checked
    System.out.println("Statement 1");
    System.out.println("Statement 2");
    System.out.println("Statement 3");
    num = 1;
    PI = 3.14;
  }

  public void foo2() {
    int a;          //distance = 2
    int b;          //distance = 3
    int count = 0;  // violation, distance = 4

    {
      System.out.println("Inside inner scope");
      a = 1;
      b = 2;
      count++;
    }
  }
}
// xdoc section -- end
