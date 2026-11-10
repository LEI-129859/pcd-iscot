package iscot.events.order;

import iscot.enums.AirConditioningMode;
import iscot.enums.Areas;

public class AreaTemperatureOrderEvent extends HighLevelOrderEvent {
    private static final long serialVersionUID = 1L;

    private final AirConditioningMode mode;
    private final double temperature;     

    public AreaTemperatureOrderEvent(Areas area, AirConditioningMode mode, double temperature) {
        super(area);
        this.mode = mode;
        this.temperature = temperature;
    }

    public AirConditioningMode getMode() { return mode; }
    public double getTemperature() { return temperature; }

    @Override
    public String toString() {
        return super.toString() + ", mode=" + mode + ", temperature=" + temperature + "]";
    }
}
