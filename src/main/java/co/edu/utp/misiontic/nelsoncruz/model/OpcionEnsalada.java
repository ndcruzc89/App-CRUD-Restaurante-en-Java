package co.edu.utp.misiontic.nelsoncruz.model;

public class OpcionEnsalada {
    private String nombre;

    public OpcionEnsalada(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Ensalada de " + nombre;
    }
}
