package com.isep.utils;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Class InputParser
 */
public class InputParser {

  //
  // Fields
  //
  private final Scanner scanner;


  //
  // Constructors
  //
  public InputParser () {
    scanner = new Scanner(System.in);
  }
  
  //
  // Methods
  //
  public String askStringUser(String question) {
    System.out.print(question);
    return scanner.next();
  }

  public int askColumnUser(String question) {
    System.out.print(question);
    String input = scanner.next();
    String [] columnNames = {"a", "b", "c", "d", "e", "f", "g", "h"};
    int[] columnValues = {1, 2, 3, 4, 5, 6, 7, 8};
    int selectedColumn;
    while (true) {
      if (input.length() == 1) {
        if (contains(columnNames, input)){
          selectedColumn = columnValues[Arrays.binarySearch(columnNames, input)];
          break;
        } else {
          System.out.println("\nERROR !");
          System.out.print(question);
          input = scanner.next();
        }
      } else {
        System.out.println("\nERROR !");
        System.out.print(question);
        input = scanner.next();
      }
    }
    return selectedColumn;
  }

  public int askIntUser(String question) {
    System.out.print(question);
    int input = 0;
    while (true) {
      try {
        input = Integer.parseInt(scanner.next());
        break;
      } catch (Exception e) {
        System.out.println("\nERROR !");
        System.out.print(question);
      }
    }
    return input;
  }

  public static boolean contains(final String[] arr, final String key) {
    return Arrays.asList(arr).contains(key);
  }

}
