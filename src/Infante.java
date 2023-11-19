import java.security.SecureRandom;
import java.util.ArrayList;

public class Infante implements Runnable {
    private String nombre;
    private ArrayList<Juguete> bolsillo;
    private SecureRandom generador;
    private ArrayList<Juguete> tiposDejuguetes;
    private Cofre caja;

    public Infante(String nombre, Cofre caja) {
        this.nombre = nombre;
        this.caja = caja;
        generador = new SecureRandom();
        bolsillo = new ArrayList<>();
        tiposDejuguetes = new ArrayList<>()
        {{add(new Juguete(TipoJuguete.Arco));add(new Juguete(TipoJuguete.Flecha));}};
    }

    public void meterJuguete(Juguete juguete){
        bolsillo.add(juguete);
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {
        System.out.println("Soy " +getNombre());

            while (bolsillo.size() < 2) {
                try {
                    System.out.println("Soy " + getNombre() + " y estoy pensando");
                  Thread.sleep(generador.nextInt(3000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                try{
                    Juguete juguete1 = tiposDejuguetes.get(generador.nextInt(tiposDejuguetes.size()));

                    System.out.println("Soy " + getNombre() + " y quiero coger " + juguete1.getColor() );



                    synchronized (caja){
                        if(caja.contenidoCaja().contains(juguete1)){
                            meterJuguete(caja.sacarJuguete(caja.contenidoCaja().indexOf(juguete1)));
                            System.out.println("Soy " + getNombre() + " y he cogido " +  juguete1.getColor());
                        }else{
                            System.out.println("Soy " + getNombre() + " y no he podido coger " + juguete1.getColor());
                        }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        if(bolsillo.contains(tiposDejuguetes.get(0)) && bolsillo.contains(tiposDejuguetes.get(1))){
            System.out.println("Soy " + getNombre() + " y puedo jugar con mi arco y con mi flecha");
        }else{
            if(bolsillo.get(0).equals(tiposDejuguetes.get(0))){
                System.out.println("Soy " + getNombre() + " y estoy triste porque tengo dos " + bolsillo.get(0).getColor() +
                        "y no puedo jugar porque me falta " + tiposDejuguetes.get(1) );
            }else{
                System.out.println("Soy " + getNombre() + " y estoy triste porque tengo dos " + bolsillo.get(0).getColor() +
                        "y no puedo jugar porque me falta " + tiposDejuguetes.get(0) );
            }

        }




    }
}


