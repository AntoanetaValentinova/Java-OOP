package TrafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String [] startLights=scan.nextLine().split("\\s+");
        int countUpdates= Integer.parseInt(scan.nextLine());

        List<TrafficLights> trafficLightsList=new ArrayList<TrafficLights>();

        for (String light : startLights) {
            TrafficLights trafficLights=new TrafficLights(Signal.valueOf(light));
            trafficLightsList.add(trafficLights);
        }

        for (int i = 0; i <countUpdates ; i++) {
            for (TrafficLights trafficLights : trafficLightsList) {
                trafficLights.update();
                System.out.print(trafficLights.getLight()+" ");
            }
            System.out.println();
        }
    }
}
