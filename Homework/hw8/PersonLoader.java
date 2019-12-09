/*-----------------------------------------------------------------------------
GWU - CS1112 Data Structures and Algorithms - Fall 2019

This program parses data from the people.txt file and creates an array of
person objects.

author: Grayson Buchholz
------------------------------------------------------------------------------*/
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class PersonLoader {

  public static Person[] loadPeople() {
    try {
      final Scanner sc = new Scanner(new File("people.txt"));
      List<Person> people = new ArrayList<Person>();
      while(sc.hasNextLine()) {
        String line = sc.nextLine();
        String[] parts = line.split(",");
        String name = parts[0];
        int age = Integer.parseInt(parts[1]);
        people.add(new Person(name, age));        
      }
      sc.close();
      return people.toArray(new Person[people.size()]);
    } catch(FileNotFoundException e) {
      final String errorMsg = "ERROR: Failed to find file people.txt";
      System.out.println(errorMsg);
      throw new RuntimeException(errorMsg);
    }
  }
}
