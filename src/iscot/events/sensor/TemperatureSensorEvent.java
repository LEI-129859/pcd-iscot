package iscot.events.sensor;

import iscot.enums.Areas;
import iscot.events.SensorEvent;

public class TemperatureSensorEvent extends SensorEvent {
	private static final long serialVersionUID = 1L;

	public TemperatureSensorEvent(Areas area, double value) {
		super(area, value);
	}
}