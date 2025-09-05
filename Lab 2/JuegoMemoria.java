public class JuegoMemoria {
    private Jugador[] jugadores;
    private Tablero tablero;
    private int turnoActual;

    public JuegoMemoria(String nombre1, String nombre2, int filas, int columnas, String[] simbolos) {
        jugadores = new Jugador[2];
        jugadores[0] = new Jugador(nombre1);
        jugadores[1] = new Jugador(nombre2);
        tablero = new Tablero(filas, columnas, simbolos);
        turnoActual = 0;
    }

    public Jugador getJugadorActual() {
        return jugadores[turnoActual];
    }

    public void cambiarTurno() {
        turnoActual = (turnoActual + 1) % 2;
    }

    public Jugador[] getJugadores() {
        return jugadores;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public boolean hayGanador() {
        return tablero.todasEmparejadas();
    }
}

