import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class Pangram {

  boolean checkIfPangram(String sentence) 
  {

    Set<Character> alphSet = new HashSet<>();

    // Add all characters from 'a' to 'z' in hashset
    for (int i = 'a'; i <= 'z'; i++) 
    {
      alphSet.add((char) i);
    }

    // Remove every character and check
    // if set becomes empty at any point of time
    for (int i = 0; i < sentence.length(); i++) 
    {
      alphSet.remove(sentence.charAt(i));
      if (alphSet.isEmpty())
        return true;
    }

    return false;
  }
  public static void main(String args[])
  {
    Pangram ob = new Pangram();
    try (Scanner ss = new Scanner(System.in)) {
        System.out.println("Enter a sentence : ");
        String set = ss.nextLine();

        System.out.println( ob.checkIfPangram(set));
    }

  }

}