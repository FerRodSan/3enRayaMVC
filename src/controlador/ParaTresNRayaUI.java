package controlador;
import vista.TresNRayaUI;

public class ParaTresNRayaUI extends TresNRayaUI {
	TresNRaya control = new TresNRaya();
	MyActionListener listener = new MyActionListener(control, this);
	public ParaTresNRayaUI() {
		super();
		actualizarTablero();
		txtMensaje.setText(this.control.muestraLetrero());
		for (int i = 0; i < this.botonera.botones.length; i++) {
			for (int j = 0; j < this.botonera.botones[i].length; j++) {
				this.botonera.botones[i][j].addActionListener(listener);
			}
		}
	}
	/**
	 * Comprobamos el boton pulsado en la coordenada correspondiente
	 * 
	 * @param coordenadas
	 */
	public void comprobarJugada(String coordenadas) {
		txtMensaje.setText(this.control.muestraLetrero());
		int posicionX = dameCoordenada(coordenadas)[0];
		int posicionY = dameCoordenada(coordenadas)[1];
		if (!this.control.comprobarTresEnRaya()) {
			this.control.destinox = posicionX;
			this.control.destinoy = posicionY;
			if (!this.control.realizarJugada()) {
				txtMensaje.setText(this.control.indicarAnomalia());
			} else {
				comprobarTablero();
			}
		} else {
			comprobarTablero();
			indicarGanagador();
		}
	}
	/**
	 * comprobamos como esta quedando el tablero despues de cada jugada que se hace
	 */
	private void comprobarTablero() {
		colocarSimbolo();
		actualizarTablero();
	}
	/**
	 * Actualizamos el tablero para que nos aparezcan todos los simbolos colocados
	 * en pantalla
	 */
	private void actualizarTablero() {
		for (int i = 0; i < this.botonera.botones.length; i++) {
			for (int j = 0; j < this.botonera.botones.length; j++) {
				String simbolito = String.valueOf(this.control.retornaSimbolo(this.control.tablero[i][j]));
				this.botonera.botones[i][j].setText(simbolito);
			}
		}
	}
	/**
	 * indicamos el jugador que ha ganado, estamos obligados a cambiarlo a mano para
	 * evitar el fallo
	 */
	private void indicarGanagador() {
		// me salta al turno del siguiente jugador, por lo que tengo que cambiar el
		// turno si o si
		int turnito = cambiarTurno();
		txtMensaje.setText("El jugador " + turnito + " ha Ganadooooo!!!!");
	}
	/**
	 * cambio el turno por lo explicado arriba
	 * 
	 * @return
	 */
	private int cambiarTurno() {
		if (this.control.verTurno() == 2) {
			return 1;
		} else {
			return 2;
		}
	}
	/**
	 * Ponemos el simbolo en el lugar correspondiente segun turno y posicion
	 * elegida, para ello vamos pasando casilla por casilla.
	 */
	private void colocarSimbolo() {
		for (int i = 0; i < this.control.tablero.length; i++) {
			for (int j = 0; j < this.control.tablero.length; j++) {
				if (this.control.tablero[i][j] == this.control.verTurno()) {
					String simbolo = String.valueOf(this.control.retornaSimbolo(this.control.verTurno()));
					this.botonera.botones[i][j].setText(simbolo);
				}
			}
		}
		// Nos obliga a comprobar si hay 3 en raya despues de cada jugada porque si hay
		// un ganador hasta que el jugador siguiente no "clike" una casilla no lo
		// detecta.
		if (this.control.comprobarTresEnRaya()) {
			indicarGanagador();
		}
	}
	/**
	 * Conseguimos la coordenada del boton pulsado
	 * 
	 * @param coordenada
	 * @return
	 */
	public int[] dameCoordenada(String coordenada) {
		int[] posicion = { 0, 0 };
		posicion[0] = Character.getNumericValue((coordenada.charAt(0)));
		posicion[1] = Character.getNumericValue((coordenada.charAt(1)));
		return posicion;
	}
}