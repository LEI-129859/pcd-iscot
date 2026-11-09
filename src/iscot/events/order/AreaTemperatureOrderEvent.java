package iscot.events.order;

import iscot.enums.AirConditioningMode;
import iscot.enums.Areas;

public class AreaTemperatureOrderEvent extends HighLevelOrderEvent {
    private static final long serialVersionUID = 1L;

    private final AirConditioningMode mode;  // Ventilação, Frio, Aquecimento ou Desligado
    private final double temperature;        // 16 a 30 °C, como no ACIcon

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