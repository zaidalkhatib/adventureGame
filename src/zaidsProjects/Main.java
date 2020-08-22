package zaidsProjects;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Map<Integer, Location> locations = new HashMap<Integer, Location>();
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        locations.put(0, new Location(0, "You are setting in front of the computer writing Java code "));
        locations.put(1, new Location(1, "You are standing at the end of the road before a small brick building"));
        locations.put(2, new Location(2, "You are at the top of a hill"));
        locations.put(3, new Location(3, "You are inside of a building, a well house for the spring"));
        locations.put(4, new Location(4, "You are in a valley beside a steam"));
        locations.put(5, new Location(5, "You are in forest"));
        locations.get(1).addExit("N", 5);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("W", 2);
        locations.get(1).addExit("E", 3);
        locations.get(1).addExit("Q", 0);

        locations.get(2).addExit("N", 5);
        locations.get(2).addExit("Q", 0);

        locations.get(3).addExit("W", 1);
        locations.get(3).addExit("Q", 0);

        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("W", 2);
        locations.get(4).addExit("Q", 0);


        locations.get(5).addExit("s", 1);
        locations.get(5).addExit("w", 2);
        locations.get(5).addExit("Q", 0);

        Map<String, String> vocabulary = new HashMap<>();
        vocabulary.put("WEST", "W");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("NORTH", "N");
        vocabulary.put("EAST", "E");
        vocabulary.put("QUIT", "Q");


        int loc = 1;
        while (true) {
            System.out.println(locations.get(loc).getDescription());

            if (loc ==0) {
                break;
            }
            Map<String, Integer> exits = locations.get(loc).getExists();
            for(String  s : vocabulary.keySet())
            {
                System.out.print(s+" ");
            }
            System.out.println();
            System.out.print("input: ");
            System.out.println();
            String userKey = input.nextLine().toUpperCase();
            String[] array = userKey.split(" ");
            String vocKey="";
            for(String s : array)
            {
                if (s.contains("SOUTH") || s.contains("EAST") || s.contains("WEST")||s.contains("NORTH")) {
                    userKey = s;
                    vocKey = vocabulary.get(userKey);
                }
                else if(s.contains("S")||s.contains("W")||s.contains("N")||s.contains("E"))
                {
                    userKey = s;
                    vocKey = userKey;
                }
            }

             if(exits.containsKey(vocKey))
            {
                loc = exits.get(vocKey);
            }
            else {
                System.out.println("You can't go this dirction");
            }

        }


    }
}
