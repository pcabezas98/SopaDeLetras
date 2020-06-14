public class App {
    public static void main(String[] args) throws Exception {
        //INSTANCIAMIENTO DE LOS OBJETOS
        Palabra palabra1 = new Palabra("FUTBOL");
        Palabra palabra2 = new Palabra("RUGBY");
        Palabra palabra3 = new Palabra("TENIS");
        Palabra palabra4 = new Palabra("SKI");
        Palabra palabra5 = new Palabra("BASQUETBOL");
        Palabra palabra6 = new Palabra("GOLF");
        Palabra palabra7 = new Palabra("HOCKEY");
        Palabra palabra8 = new Palabra("HANDBOL");
        Palabra palabra9 = new Palabra("PINGPONG");
        Palabra palabra10 = new Palabra("POOL");

        Concepto concepto1 = new Concepto("Deporte");
        concepto1.agregar_palabra(palabra1);
        concepto1.agregar_palabra(palabra2);
        concepto1.agregar_palabra(palabra3);
        concepto1.agregar_palabra(palabra4);
        concepto1.agregar_palabra(palabra5);
        concepto1.agregar_palabra(palabra6);
        concepto1.agregar_palabra(palabra7);
        concepto1.agregar_palabra(palabra8);
        concepto1.agregar_palabra(palabra9);
        concepto1.agregar_palabra(palabra10);
        ////////////////////////////////
    

        


    }
}
