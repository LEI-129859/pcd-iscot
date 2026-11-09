package iscot.events.sensor;

import iscot.enums.Areas;

public class HumiditySensorEvent extends SensorEvent {
	private static final long serialVersionUID = 1L;

	public HumiditySensorEvent(Areas area, double value) {
		super(area, value);
	}
}