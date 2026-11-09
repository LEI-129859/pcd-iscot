package iscot.client;

import iscot.client.gui.ACIcon;
import iscot.enums.AirConditioningMode;
import iscot.enums.Areas;
import iscot.events.order.AreaTemperatureOrderEvent;
import iscot.events.order.AreaVentilationOrderEvent;
import iscot.events.order.HighLevelOrderEvent;

public class AirConditioner extends ActuatorWindow {
	private final ACIcon icone;

	public AirConditioner(Areas area) { this(area, new ACIcon()); }
	private AirConditioner(Areas area, ACIcon icone) {
		super("Ar condicionado", area, icone);
		this.icone = icone;
	}

	@Override
	protected void apply(HighLevelOrderEvent event) {
		if (event instanceof AreaTemperatureOrderEvent) {
			AreaTemperatureOrderEvent o = (AreaTemperatureOrderEvent) event;
			icone.setTemperatura(o.getTemperature());
			icone.setModo(o.getMode());
			if (o.getMode() == AirConditioningMode.Desligado)
				history.log("Ar condicionado desligado");
			else
				history.log("Ar condicionado em " + o.getMode() + " a " + o.getTemperature() + " °C");
		} else if (event instanceof AreaVentilationOrderEvent) {
			AreaVentilationOrderEvent o = (AreaVentilationOrderEvent) event;
			AirConditioningMode atual = icone.getModo();
			if (atual == AirConditioningMode.Frio || atual == AirConditioningMode.Aquecimento) {
				history.log("Ventilação ignorada (já em " + atual + ")");
			} else if (o.isActive()) {
				icone.setModo(AirConditioningMode.Ventilação);
				history.log("Ar condicionado em Ventilação");
			} else {
				icone.setModo(AirConditioningMode.Desligado);
				history.log("Ar condicionado desligado");
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		if (args.length != 3) { System.err.println("Invalid arguments!"); return; }
		Areas area = Areas.valueOf(args[2]);
		AirConditioner ac = new AirConditioner(area);
		ac.mostrar();
		Thread.sleep(2000);
		ac.receive(new AreaTemperatureOrderEvent(area, AirConditioningMode.Frio, 22));
		Thread.sleep(2000);
		ac.receive(new AreaVentilationOrderEvent(area, true));   // ignorada: já está em Frio
		Thread.sleep(2000);
		ac.receive(new AreaTemperatureOrderEvent(area, AirConditioningMode.Desligado, 22));
	}
}