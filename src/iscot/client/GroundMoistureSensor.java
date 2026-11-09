package iscot.client;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import iscot.client.gui.SensorControl;
import iscot.enums.Areas;
import iscot.events.sensor.GroundMoistureSensorEvent;

public class GroundMoistureSensor {

	public static void main(String[] args) {
		if (args.length != 3) {
			System.err.println("Invalid arguments!");
			return;
		}
		// TODO connect to the server and register
		Areas area = Areas.valueOf(args[2]);

		JFrame janela = new JFrame("Humidade do solo em " + area);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel painel = new JPanel(new BorderLayout());
		SensorControl sensorControl = new SensorControl("~", "Humidade do solo - " + area, "%",
				0, 100, 1, 50,
				valor -> System.out.println(new GroundMoistureSensorEvent(area, valor)));
		painel.add(sensorControl, BorderLayout.CENTER);
		janela.setContentPane(painel);
		janela.setLocation(600, 400);
		janela.pack();
		janela.setMinimumSize(janela.getSize());
		janela.setVisible(true);
	}
}