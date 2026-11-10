package iscot.events.order;

import iscot.enums.Areas;

public class AreaIrrigationOrderEvent extends HighLevelOrderEvent {
    private static final long serialVersionUID = 1L;

    private final boolean active;   
    private final int zone;         
    private final int duration;     

    
    public AreaIrrigationOrderEvent(Areas area, boolean active, int zone, int duration) {
        super(area);                 
        this.active = active;
        this.zone = zone;
        this.duration = duration;
    }

    public boolean isActive() { return active; }
    public int getZone() { return zone; }
    public int getDuration() { return duration; }

    @Override
    public String toString() {
        return super.toString() + ", active=" + active + ", zone=" + zone + ", duration=" + duration + "]";
    }
}
