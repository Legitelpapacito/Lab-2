public class Ficha {
    private String simbolo;
    private boolean visible;
    private boolean emparejada;

    public Ficha(String simbolo) {
        this.simbolo = simbolo;
        this.visible = false;
        this.emparejada = false;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public boolean isVisible() {
        return visible;
    }

    public boolean esEmparejada() {
        return emparejada;
    }

    public void mostrar() {
        if (!emparejada) {
            visible = true;
        }
    }

    public void ocultar() {
        if (!emparejada) {
            visible = false;
        }
    }

    public void setEmparejada() {
        this.emparejada = true;
        this.visible = true;
    }

    @Override
    public String toString() {
        if (emparejada || visible) {
            return simbolo;
        } else {
            return "❓";
        }
    }
}
