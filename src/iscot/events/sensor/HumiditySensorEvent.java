package iscot.events.sensor;

import iscot.enums.Areas;
import iscot.events.SensorEvent;

public class HumiditySensorEvent extends SensorEvent {
	private static final long serialVersionUID = 1L;

	public HumiditySensorEvent(Areas area, double value) {
		super(area, value);
	}
}