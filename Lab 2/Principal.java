import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nombres de jugadores
        System.out.print("Nombre del Jugador 1: ");
        String nombre1 = sc.nextLine();
        System.out.print("Nombre del Jugador 2: ");
        String nombre2 = sc.nextLine();

        String[] simbolos = {"🐶", "🐱", "🐭", "🐹", "🐰", "🦊", "🐻", "🐼"};

        JuegoMemoria juego = new JuegoMemoria(nombre1, nombre2, 4, 4, simbolos);

        while (!juego.hayGanador()) {
            Jugador actual = juego.getJugadorActual();
            System.out.println("\nTurno de " + actual.getNombre());
            juego.getTablero().mostrarTablero();

            System.out.print("Fila de la primera ficha: ");
            int f1 = sc.nextInt();
            System.out.print("Columna de la primera ficha: ");
            int c1 = sc.nextInt();

            System.out.print("Fila de la segunda ficha: ");
            int f2 = sc.nextInt();
            System.out.print("Columna de la segunda ficha: ");
            int c2 = sc.nextInt();

            Ficha ficha1 = juego.getTablero().getFicha(f1, c1);
            Ficha ficha2 = juego.getTablero().getFicha(f2, c2);

            if (f1 == f2 && c1 == c2) {
                System.out.println("No puedes seleccionar la misma casilla dos veces.");
                continue;
            }

            if (ficha1.esEmparejada() || ficha2.esEmparejada()) {
                System.out.println("Una de las fichas ya está emparejada.");
                continue;
            }

            ficha1.mostrar();
            ficha2.mostrar();
            juego.getTablero().mostrarTablero();

            if (ficha1.getSimbolo().equals(ficha2.getSimbolo())) {
                System.out.println("¡Acertaste!");
                ficha1.setEmparejada();
                ficha2.setEmparejada();
                actual.sumarPunto();
            } else {
                System.out.println("No coinciden. Turno perdido.");
                ficha1.ocultar();
                ficha2.ocultar();
                juego.cambiarTurno();
            }
        }

        // Resultados
        System.out.println("\nJuego terminado!");
        for (Jugador j : juego.getJugadores()) {
            System.out.println(j.getNombre() + ": " + j.getPuntaje() + " puntos");
        }

        if (juego.getJugadores()[0].getPuntaje() > juego.getJugadores()[1].getPuntaje()) {
            System.out.println("Ganador: " + juego.getJugadores()[0].getNombre());
        } else if (juego.getJugadores()[1].getPuntaje() > juego.getJugadores()[0].getPuntaje()) {
            System.out.println("Ganador: " + juego.getJugadores()[1].getNombre());
        } else {
            System.out.println("Empate!");
        }

        sc.close();
    }
}
