package iscot.events.order;

import iscot.enums.Areas;

public class AreaIrrigationOrderEvent extends HighLevelOrderEvent {
    private static final long serialVersionUID = 1L;

    private final boolean active;   // ligar (true) ou desligar (false) a rega
    private final int zone;         // zona do jardim: 1, 2 ou 3
    private final int duration;     // duração da rega

    // 2. Construtor: recebe a área + os campos próprios
    public AreaIrrigationOrderEvent(Areas area, boolean active, int zone, int duration) {
        super(area);                 // a mãe trata da área e do tipo DECIDER
        this.active = active;
        this.zone = zone;
        this.duration = duration;
    }

    // 3. Getters: para o atuador conseguir ler a ordem
    public boolean isActive() { return active; }
    public int getZone() { return zone; }
    public int getDuration() { return duration; }

    // 4. toString: continua o da mãe e fecha o "["
    @Override
    public String toString() {
        return super.toString() + ", active=" + active + ", zone=" + zone + ", duration=" + duration + "]";
    }
}