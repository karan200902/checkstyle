package com.google.checkstyle.test.chapter7javadoc.rule731selfexplanatory;

/**
 * The following is a bad tag.
 *
 * @mytag Hello
 */
public class InputJavadocMethodAndMissingJavadocMethod extends OverrideClasss {
  // with comments

  /**
   * Some javadoc.
   *
   * @return Some javadoc.
   */
  int foo1() {
    return 1;
  }

  /** Some javadoc. */
  String foo2() {
    return "Fooooooooooooooo" + "ooooo" + "ooo";
  }

  /** Some javadoc. */
  void foo3() {
    foo2();
  }

  /** Some javadoc. */
  void foo4() {}

  // without comments

  int foo5() {
    return 1;
  }

  String foo6() {
    return "Fooooooooooooooo" + "oooooooo";
  }

  // violation below 'Missing a Javadoc comment.'
  public String foo7() {
    // making the method
    // exceed "minLineCount" property limit ( 2 )
    return "Fooooooooooooooo" + "ooooo" + "ooo";
  }

  //private method does not require javadoc
  private String correct(String param) {
    return "Fooooooooooooooo" + "ooooo" + "ooo" + param;
  }

  //default scope method does not require javadoc
  String defaultScope(int x) {
    return "Fooooooooooooooo" + "ooooo" + "ooo" + x;
  }

  /** some javadoc. */
  public void smallMethod1() {
    foo2();
  }

  /** some javadoc. */
  protected void smallMethod2() {
    foo2();
  }

  /** Ok, missing params tags and return tags in javadoc are allowed. */
  public String testingParams(String param1, String param2) {
    return "Fooooooooooooooo" + "ooooo" + "ooo" + param1 + param2;
  }

  /** Ok, missing params tags and return tags in javadoc are allowed. */
  protected String testingParams(int param1, int param2) {
    return "Fooooooooooooooo" + "ooooo" + "ooo" + param1 + param2;
  }

  // violation below 'Missing a Javadoc comment.'
  public InputJavadocMethodAndMissingJavadocMethod() {
    foo2();
    foo91();
    foo4();
    foo3();
  }

  //private constructor does not require javadoc
  private InputJavadocMethodAndMissingJavadocMethod(float x) {
    foo2();
    foo91();
    foo4();
    foo3();
  }

  //default scope constructor does not require javadoc
  InputJavadocMethodAndMissingJavadocMethod(int a) {
    foo2();
    foo91();
    foo4();
    foo3();
  }

  /** some javadoc. */
  public InputJavadocMethodAndMissingJavadocMethod(int a, int b) {
    foo2();
  }

  //constructors smaller than 2 lines does not require javadoc
  private InputJavadocMethodAndMissingJavadocMethod(float a, float b) {
    foo2();
  }

  /** Ok, missing params tags in javadoc are allowed. */
  public InputJavadocMethodAndMissingJavadocMethod(double a, double b) {
    foo2();
    foo91();
    foo5();
    foo82();
  }

  void foo81() {
    foo2();
  }

  void foo82() {}

  void paramviolation(String param) {
    foo2();
  }

  @MyAnnotationn
  String foo91() {
    return "Fooooooooooooooo" + "ooooo" + "ooo";
  }

  @Override
  public String foo92() {
    return "Fooooo" + "ooo" + "ooooooo" + "ooooo" + "ooo";
  }

  int xyz = 99;

  public int getXyz() {
    return xyz;
  }

  public void setXyz(int xyz) {
    this.xyz = xyz;
  }

  int abc = 101;

  // violation below 'Missing a Javadoc comment.'
  public int getAbc() {
    abc = 55;
    abc += 1;
    return abc;
  }

  // violation below 'Missing a Javadoc comment.'
  public void setAbc(int abc) {
    abc = 55;
    abc += 1;
    this.abc = abc;
  }
}

// violation below 'Top-level class OverrideClasss has to reside in its own source file.'
class OverrideClasss {

  public String foo92() {
    return "Fooooo" + "ooo" + "ooooooo" + "ooooo" + "ooo";
  }
}

// violation below 'Top-level class MyAnnotationn has to reside in its own source file.'
@interface MyAnnotationn {}
