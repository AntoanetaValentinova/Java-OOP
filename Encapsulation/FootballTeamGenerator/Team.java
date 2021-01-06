package FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players=new ArrayList<>();
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String name) {
        boolean isRemoved = this.players.removeIf(player -> player.getName().equals(name));
        if (!isRemoved) {
            System.out.printf("Player %s is not in %s team.%n",name,this.getName());
        }
    }

    public double getRating() {
        double rate=0;
        for (Player player : players) {
            rate +=player.overallSkillLevel();
        }
        return rate;
    }
}
