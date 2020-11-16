package TrafficLights;

public class TrafficLights {
    private Signal light;

    public TrafficLights(Signal light) {
        this.light = light;
    }

    public Signal getLight() {
        return light;
    }

    public void update () {
        switch (light) {
            case RED:
                this.light=Signal.GREEN;
                break;
            case GREEN:
                this.light=Signal.YELLOW;
                break;
            case YELLOW:
                this.light=Signal.RED;
                break;
        }
    }
}
