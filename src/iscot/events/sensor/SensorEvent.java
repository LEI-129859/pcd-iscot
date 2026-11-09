package iscot.events.sensor;

import iscot.enums.Areas;
import iscot.enums.Type;
import iscot.events.Event;

public abstract class SensorEvent extends Event {
	private static final long serialVersionUID = 1L;
	private final double value;

	protected SensorEvent(Areas area, double value) {
		super(Type.SENSOR, area);
		this.value = value;
	}
	public double getValue() { return value; }

	@Override
	public String toString() { return super.toString() + ", value=" + value + "]"; }
}