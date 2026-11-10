package iscot.events.order;

import iscot.enums.Areas;

public class AreaLightingOrderEvent extends HighLevelOrderEvent {
    private static final long serialVersionUID = 1L;

    private final boolean active;    
    private final int intensity;     

    public AreaLightingOrderEvent(Areas area, boolean active, int intensity) {
        super(area);
        this.active = active;
        this.intensity = intensity;
    }

    public boolean isActive() { return active; }
    public int getIntensity() { return intensity; }

    @Override
    public String toString() {
        return super.toString() + ", active=" + active + ", intensity=" + intensity + "]";
    }
}
