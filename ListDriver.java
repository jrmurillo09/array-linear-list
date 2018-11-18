/**
 * CS310 Fall 2015 <br>
 * Example driver for program 1
 * 
 * @see http://pindar.sdsu.edu/cs310/prog1.php
 * @version 1.0
 */

import data_structures.ArrayLinearList;
import data_structures.LinearListADT;

public class ListDriver {

  /**
   * The Unit Under Test. Through polymorphism we may assign any object that
   * implements this interface to this variable. For this driver, we use an
   * ArrayLinearList as the concrete class.
   */
  LinearListADT<Integer> uut;

  /**
   * Increase this value to see the impact of quadratic timing on the remove
   * method.
   */
  final int arraySize = 32;

  final int numItemsToPrint = 25;

  /**
   * When instantiated, this object automatically prepares and performs a series
   * of supported operations demonstrating basic functionality. 
   */
  public ListDriver() {
    setup();
    runTests();
  }

  private void setup() {
    uut = new ArrayLinearList<Integer>(arraySize);
  }

  private void testFrontRearAddRemove() {

    printBanner("Adding 10 items to front");
    for (int i = 0; i < 10; i++) {
      uut.addFirst(i + 1);
    }
    printContents(numItemsToPrint);
    printSumContentsBoxed();

    printBanner("Adding 10 items to rear");
    for (int i = 0; i < 10; i++) {
      uut.addLast(i + 1);
    }
    printContents(numItemsToPrint);
    printSumContentsBoxed();

    printBanner("Removing 5 items from front");
    for (int i = 0; i < 5; i++) {
      uut.removeFirst();
    }
    printContents(numItemsToPrint);
    printSumContentsBoxed();

    printBanner("Removing 5 items from rear");
    for (int i = 0; i < 5; i++) {
      uut.removeLast();
    }
    printContents(numItemsToPrint);
    printSumContentsBoxed();

    printBanner("Adding 5 items to front and rear (10 total)");
    for (int i = 0; i < 5; i++) {
      uut.addFirst((i + 1) * 7);
      uut.addLast((i + 1) * 3);
    }
    printContents(numItemsToPrint);
    printSumContentsBoxed();
  }

  private void runTests() {

    testFrontRearAddRemove();

    printBanner("Clearing contents");
    uut.clear();
    printContents(10);

    printBanner("Capacity test");
    int counter = 0;
    while (uut.addFirst(counter)) {
      uut.addLast(counter++);
    }
    System.out.println("Filled Array (front/back)");
    printContents(numItemsToPrint);

    while (uut.size() > 0) {
      uut.removeFirst();
    }
    System.out.println("Removed all from front");
    printContents(numItemsToPrint);

    while (uut.addFirst(counter)) {
      uut.addLast(counter++);
    }
    System.out.println("Filled Array (front/back)");
    printContents(numItemsToPrint);

    printBanner("Removing from Middle");
    printContents(numItemsToPrint);
    uut.remove(17);
    printContents(numItemsToPrint);
    uut.remove(17);
    printContents(numItemsToPrint);

  }

  private static void printBanner(String description) {
    System.out.println('\n' + "*** " + description + " ***");
  }

  private void printSumContentsBoxed() {

    Long sum = new Long(0);
    for (Integer e : uut) {
      sum += e;
    }
    System.out.println("Sum: " + sum);
  }

  private void printContents(int size) {
    System.out.print("Contents: ");
    for (int e : uut) {
      System.out.print(e + " ");
    }
    System.out.print('\n');
  }

  public static void main(String[] args) {
    new ListDriver();
  }
}
