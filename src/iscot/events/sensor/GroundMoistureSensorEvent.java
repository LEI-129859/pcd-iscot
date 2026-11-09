package iscot.events.sensor;

import iscot.enums.Areas;
import iscot.events.SensorEvent;

public class GroundMoistureSensorEvent extends SensorEvent {
	private static final long serialVersionUID = 1L;

	public GroundMoistureSensorEvent(Areas area, double value) {
		super(area, value);
	}
}