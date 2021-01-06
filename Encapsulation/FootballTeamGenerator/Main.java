package FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        List<Team> teams = new ArrayList<>();
        while (!input.equals("END")) {
            String[] tokens = input.split(";");
            String command = tokens[0];
            switch (command) {
                case "Team":
                    String teamName = tokens[1];
                    addTeam(teamName, teams);
                    break;
                case "Add":
                    addPlayer(teams, tokens);
                    break;
                case "Remove":
                    removePlayer(teams, tokens);
                    break;
                case "Rating":
                    getRating(teams, tokens[1]);
                    break;
            }

            input = scan.nextLine();
        }
    }

    private static void addTeam(String teamName, List<Team> teams) {
        try {
            Team team = new Team(teamName);
            teams.add(team);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void getRating(List<Team> teams, String token) {
        String teamN = token;
        boolean isFind = false;
        for (Team team : teams) {
            if (teamN.equals(team.getName())) {
                isFind = true;
                team.getRating();
                System.out.printf("%s - %d%n", team.getName(), Math.round(team.getRating()));
            }
        }
        if (!isFind) {
            System.out.printf("Team %s does not exist.%n", teamN);
        }
    }

    private static void removePlayer(List<Team> teams, String[] tokens) {
        String teamN = tokens[1];
        for (Team team : teams) {
            if (team.getName().equals(teamN)) {
                String playerN = tokens[2];
                team.removePlayer(playerN);
            }
        }
    }

    private static void addPlayer(List<Team> teams, String[] tokens) {
        String teamN = tokens[1];
        boolean isFind = false;
        for (Team team : teams) {
            if (team.getName().equals(teamN)) {
                isFind = true;
                String playerName = tokens[2];
                int endurance = Integer.parseInt(tokens[3]);
                int sprint = Integer.parseInt(tokens[4]);
                int dribble = Integer.parseInt(tokens[5]);
                int passing = Integer.parseInt(tokens[6]);
                int shooting = Integer.parseInt(tokens[7]);
                try {
                    Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                    team.addPlayer(player);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        if (!isFind) {
            System.out.printf("Team %s does not exist.%n", teamN);
        }
    }
}
