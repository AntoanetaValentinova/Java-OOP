package FirstAndReserveTeam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<FirstAndReserveTeam.Person> players = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            try {
                players.add(new FirstAndReserveTeam.Person(input[0], input[1], Integer.parseInt(input[2]), Double.parseDouble(input[3])));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }


        Team team=new Team("Black Eagles");

        for (Person person : players) {
          team.addPlayer(person);
        }

        System.out.printf("First team have %d players%n",team.getFirstTeam().size());
        System.out.printf("Reserve team have %d players%n",team.getReserveTeam().size());
    }



}
