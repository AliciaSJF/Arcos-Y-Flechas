import java.util.Objects;

public class Juguete {
    private TipoJuguete color;
    private int numero;
    private static int aux;

    public Juguete(TipoJuguete color){
        numero = aux++;
        this.color = color;
    }

    public TipoJuguete getColor() {
        return color;
    }


    @Override
    public String toString() {
        return "Juguete{" +
                "color=" + color +
                ", numero=" + numero +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Juguete juguete = (Juguete) o;
        return numero == juguete.numero && color == juguete.color;
    }


}
