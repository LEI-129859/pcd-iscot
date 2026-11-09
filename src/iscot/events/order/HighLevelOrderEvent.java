package iscot.events.order;

import iscot.enums.Areas;
import iscot.enums.Type;
import iscot.events.Event;

public abstract class HighLevelOrderEvent extends Event {
    private static final long serialVersionUID = 1L;

    protected HighLevelOrderEvent(Areas area) {
        super(Type.DECIDER, area);
    }
}
