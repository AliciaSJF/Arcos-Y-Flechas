import java.util.ArrayList;

public class Cofre {
    private  ArrayList<Juguete> juguetes = new ArrayList<>();
    {
        juguetes.add(new Juguete(TipoJuguete.Flecha));
        juguetes.add(new Juguete(TipoJuguete.Flecha));
        juguetes.add(new Juguete(TipoJuguete.Arco));
        juguetes.add(new Juguete(TipoJuguete.Arco));
    }

    public ArrayList<Juguete> contenidoCaja(){
        return juguetes;
    }

    public Juguete sacarJuguete(int pos){
        Juguete aux = juguetes.get(pos);
        juguetes.remove(pos);
        return aux;
    }

    @Override
    public String toString() {
        return "Cofre{" +
                "juguetes=" + juguetes +
                '}';
    }
}
