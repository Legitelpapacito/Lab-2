import java.util.ArrayList;
import java.util.Collections;

public class Tablero {
    private int filas;
    private int columnas;
    private Ficha[][] fichas;

    public Tablero(int filas, int columnas, String[] simbolos) {
        this.filas = filas;
        this.columnas = columnas;
        this.fichas = new Ficha[filas][columnas];
        inicializar(simbolos);
    }

    private void inicializar(String[] simbolos) {
        ArrayList<String> lista = new ArrayList<>();
        for (String s : simbolos) {
            lista.add(s);
            lista.add(s); // cada símbolo aparece dos veces
        }
        Collections.shuffle(lista);

        int index = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                fichas[i][j] = new Ficha(lista.get(index));
                index++;
            }
        }
    }

    public void mostrarTablero() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(fichas[i][j] + " ");
            }
            System.out.println();
        }
    }

    public Ficha getFicha(int fila, int col) {
        return fichas[fila][col];
    }

    public boolean todasEmparejadas() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (!fichas[i][j].esEmparejada()) {
                    return false;
                }
            }
        }
        return true;
    }
}
