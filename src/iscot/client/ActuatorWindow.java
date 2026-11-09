package iscot.client;

import java.awt.BorderLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import iscot.client.gui.ActionHistory;
import iscot.enums.Areas;
import iscot.events.order.HighLevelOrderEvent;

public abstract class ActuatorWindow implements Actuator {
	protected final Areas area;
	protected final ActionHistory history = new ActionHistory();
	private final JFrame janela;

	protected ActuatorWindow(String titulo, Areas area, JComponent icone) {
		this.area = area;
		janela = new JFrame(titulo + " em " + area);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel painel = new JPanel(new BorderLayout());
		painel.add(icone, BorderLayout.CENTER);
		painel.add(history, BorderLayout.SOUTH);
		janela.setContentPane(painel);
		janela.pack();
		janela.setMinimumSize(janela.getSize());
	}

	public void setPosicao(int x, int y) { janela.setLocation(x, y); }
	public void mostrar() { janela.setVisible(true); }

	@Override
	public final void receive(HighLevelOrderEvent event) {
		if (event.getArea() != area) return;
		apply(event);
	}

	protected abstract void apply(HighLevelOrderEvent event);
}