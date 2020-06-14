import java.util.ArrayList;


public class Concepto {
    //atributos
    ArrayList<Palabra> lista_de_palabras = new ArrayList<Palabra>();
    String nombre;
    ////////////////////////////////

    //constructores
    public Concepto( String nombre_concepto) {
        this.nombre = nombre_concepto;
    }
    ////////////////////////////////



    //metodos GET AND SET
    public ArrayList<Palabra> getLista_palabras() {
        return this.lista_de_palabras;
    }

    public void setLista_palabras(ArrayList<Palabra> lista_palabras) {
        this.lista_de_palabras = lista_palabras;
    }

    public String getNombre_concepto() {
        return this.nombre;
    }

    public void setNombre_concepto(String nombre_concepto) {
        this.nombre = nombre_concepto;
    }
    ////////////////////////////////


    //metodos
    public void agregar_palabra(Palabra palabra){ 
        this.lista_de_palabras.add(palabra);
    }
    ////////////////////////////////

}