package iscot.events;

import iscot.enums.Areas;
import iscot.enums.Type;

public class RegistrationEvent extends Event {
	private static final long serialVersionUID = 1L;
	private final Type clientType;

	public RegistrationEvent(Type clientType, Areas area) {
		super(clientType, area);
		this.clientType = clientType;
	}
	public Type getClientType() { return clientType; }

	@Override
	public String toString() { return super.toString() + ", clientType=" + clientType + "]"; }
}