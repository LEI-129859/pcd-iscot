package iscot.client;

import iscot.client.gui.VentilatorIcon;
import iscot.enums.Areas;
import iscot.events.order.AreaVentilationOrderEvent;
import iscot.events.order.HighLevelOrderEvent;

public class Ventilator extends ActuatorWindow {
	private final VentilatorIcon icone;

	public Ventilator(Areas area) { this(area, new VentilatorIcon()); }
	private Ventilator(Areas area, VentilatorIcon icone) {
		super("Ventilador", area, icone);
		this.icone = icone;
	}

	@Override
	protected void apply(HighLevelOrderEvent event) {
		if (event instanceof AreaVentilationOrderEvent) {
			AreaVentilationOrderEvent o = (AreaVentilationOrderEvent) event;
			icone.setLigado(o.isActive());
			history.log(o.isActive() ? "Ventilador ligado" : "Ventilador desligado");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		if (args.length != 3) { System.err.println("Invalid arguments!"); return; }
		Areas area = Areas.valueOf(args[2]);
		Ventilator v = new Ventilator(area);
		v.mostrar();
		Thread.sleep(2000);
		v.receive(new AreaVentilationOrderEvent(area, true));
		Thread.sleep(2000);
		v.receive(new AreaVentilationOrderEvent(area, false));
	}
}