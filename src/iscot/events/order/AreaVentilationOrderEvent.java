package iscot.events.order;

import iscot.enums.Areas;

public class AreaVentilationOrderEvent extends HighLevelOrderEvent {
    private static final long serialVersionUID = 1L;

    private final boolean active;  

    public AreaVentilationOrderEvent(Areas area, boolean active) {
        super(area);
        this.active = active;
    }

    public boolean isActive() { return active; }

    @Override
    public String toString() {
        return super.toString() + ", active=" + active + "]";
    }
}
