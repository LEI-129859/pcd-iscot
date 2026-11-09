package iscot.client;

import iscot.client.gui.IrrigationIcon;
import iscot.enums.Areas;
import iscot.events.order.AreaIrrigationOrderEvent;
import iscot.events.order.HighLevelOrderEvent;

public class Irrigation extends ActuatorWindow {
	private final IrrigationIcon icone;

	public Irrigation(Areas area) { this(area, new IrrigationIcon()); }
	private Irrigation(Areas area, IrrigationIcon icone) {
		super("Rega", area, icone);
		this.icone = icone;
	}

	@Override
	protected void apply(HighLevelOrderEvent event) {
		if (event instanceof AreaIrrigationOrderEvent) {
			AreaIrrigationOrderEvent o = (AreaIrrigationOrderEvent) event;
			icone.setZona(o.getZone());
			icone.setDuracao(o.getDuration());
			icone.setAtiva(o.isActive());
			history.log(o.isActive()
					? "Rega ligada (zona " + o.getZone() + ", " + o.getDuration() + " min)"
					: "Rega desligada");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		if (args.length != 3) { System.err.println("Invalid arguments!"); return; }
		Areas area = Areas.valueOf(args[2]);
		Irrigation r = new Irrigation(area);
		r.mostrar();
		Thread.sleep(2000);
		r.receive(new AreaIrrigationOrderEvent(area, true, 2, 15));
		Thread.sleep(2000);
		r.receive(new AreaIrrigationOrderEvent(area, false, 2, 15));
	}
}