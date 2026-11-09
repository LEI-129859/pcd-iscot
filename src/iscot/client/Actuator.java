package iscot.client;

import iscot.events.order.HighLevelOrderEvent;

public interface Actuator {
	void receive(HighLevelOrderEvent event);
}