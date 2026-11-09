package iscot.events;

import java.io.Serializable;
import java.time.LocalDateTime;
import iscot.enums.Areas;
import iscot.enums.Type;

public abstract class Event implements Serializable {
	private static final long serialVersionUID = 1L;
	private final Type type;
	private final Areas area;
	private final LocalDateTime time;

	protected Event(Type type, Areas area) {
		this.type = type;
		this.area = area;
		this.time = LocalDateTime.now();
	}
	public Type getType() { return type; }
	public Areas getArea() { return area; }
	public LocalDateTime getTime() { return time; }

	@Override
	public String toString() {
		return getClass().getSimpleName() + "[type=" + type + ", area=" + area + ", time=" + time;
	}
}