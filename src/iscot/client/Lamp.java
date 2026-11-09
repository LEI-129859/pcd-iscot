package iscot.client;

import iscot.client.gui.LightIcon;
import iscot.enums.Areas;
import iscot.events.order.AreaLightingOrderEvent;
import iscot.events.order.HighLevelOrderEvent;

public class Lamp extends ActuatorWindow {
	private final LightIcon icone;

	public Lamp(Areas area) { this(area, new LightIcon()); }
	private Lamp(Areas area, LightIcon icone) {
		super("Lâmpada", area, icone);
		this.icone = icone;
	}

	@Override
	protected void apply(HighLevelOrderEvent event) {
		if (event instanceof AreaLightingOrderEvent) {
			AreaLightingOrderEvent o = (AreaLightingOrderEvent) event;
			icone.setIntensidade(o.getIntensity());
			icone.setLigada(o.isActive());
			history.log(o.isActive() ? "Lâmpada ligada" : "Lâmpada desligada");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		if (args.length != 3) { System.err.println("Invalid arguments!"); return; }
		Areas area = Areas.valueOf(args[2]);
		Lamp lampada = new Lamp(area);
		lampada.mostrar();
		Thread.sleep(2000);
		lampada.receive(new AreaLightingOrderEvent(area, true, 100));
		Thread.sleep(2000);
		lampada.receive(new AreaLightingOrderEvent(area, false, 100));
	}
}