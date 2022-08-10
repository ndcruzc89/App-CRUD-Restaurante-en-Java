package co.edu.utp.misiontic.nelsoncruz.model;

import java.util.Objects;

public class OpcionEnsalada {
    private String nombre;
    private Integer id;

    public OpcionEnsalada(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Ensalada de " + nombre;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OpcionEnsalada other = (OpcionEnsalada) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}