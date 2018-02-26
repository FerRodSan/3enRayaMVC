package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class MyActionListener implements ActionListener {
	TresNRaya control;
	ParaTresNRayaUI paraUi;

	/**
	 * Entro en el constructor el control y el ParaUI para poder usarlo (me costo
	 * pillarlo)
	 * 
	 * @param control
	 * @param paraUi
	 */
	public MyActionListener(TresNRaya control, ParaTresNRayaUI paraUi) {
		super();
		this.control = control;
		this.paraUi = paraUi;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton botoncito = (JButton) e.getSource();
		String coordenadas = botoncito.getName();
		paraUi.comprobarJugada(coordenadas);
	}
}
