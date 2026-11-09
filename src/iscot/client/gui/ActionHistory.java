package iscot.client.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;

public class ActionHistory extends JPanel {
	private static final long serialVersionUID = 1L;
	private static final DateTimeFormatter HORA = DateTimeFormatter.ofPattern("HH:mm:ss");
	private final JTextArea area = new JTextArea(6, 22);

	public ActionHistory() {
		super(new BorderLayout());
		area.setEditable(false);
		JScrollPane scroll = new JScrollPane(area);
		scroll.setPreferredSize(new Dimension(220, 110));
		setBorder(BorderFactory.createTitledBorder("Histórico"));
		add(scroll, BorderLayout.CENTER);
	}

	public void log(String acao) {
		String linha = acao + " - " + LocalTime.now().format(HORA) + "\n";
		SwingUtilities.invokeLater(() -> area.append(linha));
	}
}