package co.edu.utp.misiontic.nelsoncruz.model;

public class Bandeja extends OpcionPedido {

    public Bandeja(Integer precio) {
        super(precio);
    }

    public Bandeja(Integer precio, OpcionPrincipio principio, OpcionCarne carne, OpcionEnsalada ensalada,
            OpcionJugo jugo) {
        super(precio, principio, carne, ensalada, jugo);
    }

    public Bandeja(Integer precio, OpcionPrincipio principio, OpcionCarne carne, OpcionJugo jugo) {
        super(precio, principio, carne, jugo);
    }
    
    @Override
    public String toString() {
        return "Bandeja [precio=" + getPrecio() + ", principio=" + getPrincipio()
                + ", carne=" + getCarne() + ", ensalada=" + getEnsalada() + ", jugo=" + getJugo() + "]";
    }
    
}
