package CounterStriker.models.field;

import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static CounterStriker.common.OutputMessages.COUNTER_TERRORIST_WINS;
import static CounterStriker.common.OutputMessages.TERRORIST_WINS;

public class FieldImpl implements Field {
    @Override
    public String start(Collection<Player> players) {
        List<Player> terrorists = players
                .stream()
                .filter(p -> p.getClass().getSimpleName().equals("Terrorist"))
                .collect(Collectors.toList());
        List<Player> counterTerrorists = players
                .stream()
                .filter(p -> p.getClass().getSimpleName().equals("CounterTerrorist"))
                .collect(Collectors.toList());
        while (terrorists.stream().anyMatch(Player::isAlive) && counterTerrorists.stream().anyMatch(Player::isAlive)) {
            for (int i=0;i<terrorists.size();i++) {
                for (int j=0;j<counterTerrorists.size();j++) {
                    counterTerrorists.get(j).takeDamage(terrorists.get(i).getGun().fire());
                    if (!counterTerrorists.get(j).isAlive()) {
                        counterTerrorists.remove(j);
                        j--;
                    }
                }
            }

            for (int i=0;i<counterTerrorists.size();i++) {
                for (int j=0;j<terrorists.size();j++) {
                    terrorists.get(j).takeDamage(counterTerrorists.get(i).getGun().fire());
                    if (!terrorists.get(j).isAlive()) {
                        terrorists.remove(j);
                        j--;
                    }
                }
            }

        }
        if (counterTerrorists.isEmpty()) {
            return TERRORIST_WINS;
        }
        return COUNTER_TERRORIST_WINS;
    }
}

