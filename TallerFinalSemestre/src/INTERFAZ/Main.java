package INTERFAZ;
import OBJ.*;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {

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


        Palabra palabra11 = new Palabra("MANZANA");
        Palabra palabra12 = new Palabra("PERA");
        Palabra palabra13 = new Palabra("NARANJA");
        Palabra palabra14 = new Palabra("SANDIA");
        Palabra palabra15 = new Palabra("MELON");
        Palabra palabra16 = new Palabra("FRUTILLA");
        Palabra palabra17 = new Palabra("ARANDANO");
        Palabra palabra18 = new Palabra("KIWI");
        Palabra palabra19 = new Palabra("PLATANO");
        Palabra palabra20 = new Palabra("MANGO");

        Concepto concepto2 = new Concepto("Frutas");
        concepto2.agregar_palabra(palabra11);
        concepto2.agregar_palabra(palabra12);
        concepto2.agregar_palabra(palabra13);
        concepto2.agregar_palabra(palabra14);
        concepto2.agregar_palabra(palabra15);
        concepto2.agregar_palabra(palabra16);
        concepto2.agregar_palabra(palabra17);
        concepto2.agregar_palabra(palabra18);
        concepto2.agregar_palabra(palabra19);
        concepto2.agregar_palabra(palabra20);
        ////////////////////////////////
        //ksjdfah


        Palabra palabra21 = new Palabra("APIO");
        Palabra palabra22 = new Palabra("LECHUGA");
        Palabra palabra23 = new Palabra("COLIFLOR");
        Palabra palabra24 = new Palabra("CEBOLLA");
        Palabra palabra25 = new Palabra("BROCOLI");
        Palabra palabra26 = new Palabra("ZANAHORIA");
        Palabra palabra27 = new Palabra("NABO");
        Palabra palabra28 = new Palabra("ESPINACA");
        Palabra palabra29 = new Palabra("REMOLACHA");
        Palabra palabra30 = new Palabra("ACELGA");

        Concepto concepto3 = new Concepto("Verduras");
        concepto3.agregar_palabra(palabra21);
        concepto3.agregar_palabra(palabra22);
        concepto3.agregar_palabra(palabra23);
        concepto3.agregar_palabra(palabra24);
        concepto3.agregar_palabra(palabra25);
        concepto3.agregar_palabra(palabra26);
        concepto3.agregar_palabra(palabra27);
        concepto3.agregar_palabra(palabra28);
        concepto3.agregar_palabra(palabra29);
        concepto3.agregar_palabra(palabra30);
        ////////////////////////////////


        Palabra palabra31 = new Palabra("ESTUCHE");
        Palabra palabra32 = new Palabra("CALCULADORA");
        Palabra palabra33 = new Palabra("CUADERNO");
        Palabra palabra34 = new Palabra("LAPIZ");
        Palabra palabra35 = new Palabra("GOMA");
        Palabra palabra36 = new Palabra("REGLA");
        Palabra palabra37 = new Palabra("TRANSPORTADOR");
        Palabra palabra38 = new Palabra("PEGAMENTO");
        Palabra palabra39 = new Palabra("CARPETA");
        Palabra palabra40 = new Palabra("LIBROS");

        Concepto concepto4 = new Concepto("Utiles escolares");
        concepto4.agregar_palabra(palabra31);
        concepto4.agregar_palabra(palabra32);
        concepto4.agregar_palabra(palabra33);
        concepto4.agregar_palabra(palabra34);
        concepto4.agregar_palabra(palabra35);
        concepto4.agregar_palabra(palabra36);
        concepto4.agregar_palabra(palabra37);
        concepto4.agregar_palabra(palabra38);
        concepto4.agregar_palabra(palabra39);
        concepto4.agregar_palabra(palabra40);
        ////////////////////////////////
        

        Palabra palabra41 = new Palabra("CHILE");
        Palabra palabra42 = new Palabra("ARGENTINA");
        Palabra palabra43 = new Palabra("BRASIL");
        Palabra palabra44 = new Palabra("MEXICO");
        Palabra palabra45 = new Palabra("URUGUAY");
        Palabra palabra46 = new Palabra("VENEZUELA");
        Palabra palabra47 = new Palabra("ECUADOR");
        Palabra palabra48 = new Palabra("BOLIVIA");
        Palabra palabra49 = new Palabra("PERU");
        Palabra palabra50 = new Palabra("COLOMBIA");

        Concepto concepto5 = new Concepto("Paises Latinoamericanos");
        concepto5.agregar_palabra(palabra41);
        concepto5.agregar_palabra(palabra42);
        concepto5.agregar_palabra(palabra43);
        concepto5.agregar_palabra(palabra44);
        concepto5.agregar_palabra(palabra45);
        concepto5.agregar_palabra(palabra46);
        concepto5.agregar_palabra(palabra47);
        concepto5.agregar_palabra(palabra48);
        concepto5.agregar_palabra(palabra49);
        concepto5.agregar_palabra(palabra50);
        ////////////////////////////////


        Palabra palabra51 = new Palabra("CLASICA");
        Palabra palabra52 = new Palabra("POP");
        Palabra palabra53 = new Palabra("ROCK");
        Palabra palabra54 = new Palabra("METAL");
        Palabra palabra55 = new Palabra("JAZZ");
        Palabra palabra56 = new Palabra("DISCO");
        Palabra palabra57 = new Palabra("REGGAETON");
        Palabra palabra58 = new Palabra("CUMBIA");
        Palabra palabra59 = new Palabra("PUNK");
        Palabra palabra60 = new Palabra("TECHNO");

        Concepto concepto6 = new Concepto("Generos musicales");
        concepto6.agregar_palabra(palabra51);
        concepto6.agregar_palabra(palabra52);
        concepto6.agregar_palabra(palabra53);
        concepto6.agregar_palabra(palabra54);
        concepto6.agregar_palabra(palabra55);
        concepto6.agregar_palabra(palabra56);
        concepto6.agregar_palabra(palabra57);
        concepto6.agregar_palabra(palabra58);
        concepto6.agregar_palabra(palabra59);
        concepto6.agregar_palabra(palabra60);
        ////////////////////////////////


        Palabra palabra61 = new Palabra("PERRO");
        Palabra palabra62 = new Palabra("GATO");
        Palabra palabra63 = new Palabra("CONEJO");
        Palabra palabra64 = new Palabra("MONO");
        Palabra palabra65 = new Palabra("CABALLO");
        Palabra palabra66 = new Palabra("OSO");
        Palabra palabra67 = new Palabra("MAPACHE");
        Palabra palabra68 = new Palabra("GALLINA");
        Palabra palabra69 = new Palabra("ARDILLA");
        Palabra palabra70 = new Palabra("ZORRO");

        Concepto concepto7 = new Concepto("Animales terrestres");
        concepto7.agregar_palabra(palabra61);
        concepto7.agregar_palabra(palabra62);
        concepto7.agregar_palabra(palabra63);
        concepto7.agregar_palabra(palabra64);
        concepto7.agregar_palabra(palabra65);
        concepto7.agregar_palabra(palabra66);
        concepto7.agregar_palabra(palabra67);
        concepto7.agregar_palabra(palabra68);
        concepto7.agregar_palabra(palabra69);
        concepto7.agregar_palabra(palabra70);
        ////////////////////////////////


        Palabra palabra71 = new Palabra("SALMON");
        Palabra palabra72 = new Palabra("BALLENA");
        Palabra palabra73 = new Palabra("TIBURON");
        Palabra palabra74 = new Palabra("LANGOSTA");
        Palabra palabra75 = new Palabra("PULPO");
        Palabra palabra76 = new Palabra("DELFIN");
        Palabra palabra77 = new Palabra("ALMEJA");
        Palabra palabra78 = new Palabra("CANGREJO");
        Palabra palabra79 = new Palabra("CALAMAR");
        Palabra palabra80 = new Palabra("FOCA");

        Concepto concepto8 = new Concepto("Animales marinos");
        concepto8.agregar_palabra(palabra71);
        concepto8.agregar_palabra(palabra72);
        concepto8.agregar_palabra(palabra73);
        concepto8.agregar_palabra(palabra74);
        concepto8.agregar_palabra(palabra75);
        concepto8.agregar_palabra(palabra76);
        concepto8.agregar_palabra(palabra77);
        concepto8.agregar_palabra(palabra78);
        concepto8.agregar_palabra(palabra79);
        concepto8.agregar_palabra(palabra80);
        ////////////////////////////////


        Palabra palabra81 = new Palabra("MARIPOSA");
        Palabra palabra82 = new Palabra("HORMIGA");
        Palabra palabra83 = new Palabra("ORUGA");
        Palabra palabra84 = new Palabra("GRILLO");
        Palabra palabra85 = new Palabra("LIBELULA");
        Palabra palabra86 = new Palabra("MOSCA");
        Palabra palabra87 = new Palabra("SALTAMONTES");
        Palabra palabra88 = new Palabra("ESCARABAJO");
        Palabra palabra89 = new Palabra("ABEJA");
        Palabra palabra90 = new Palabra("AVISPA");

        Concepto concepto9 = new Concepto("Insectos");
        concepto9.agregar_palabra(palabra81);
        concepto9.agregar_palabra(palabra82);
        concepto9.agregar_palabra(palabra83);
        concepto9.agregar_palabra(palabra84);
        concepto9.agregar_palabra(palabra85);
        concepto9.agregar_palabra(palabra86);
        concepto9.agregar_palabra(palabra87);
        concepto9.agregar_palabra(palabra88);
        concepto9.agregar_palabra(palabra89);
        concepto9.agregar_palabra(palabra90);
        ////////////////////////////////


        Palabra palabra91 = new Palabra("GIRASOL");
        Palabra palabra92 = new Palabra("ROSAS");
        Palabra palabra93 = new Palabra("HORTENCIAS");
        Palabra palabra94 = new Palabra("TULIPANES");
        Palabra palabra95 = new Palabra("DALIAS");
        Palabra palabra96 = new Palabra("LIRIOS");
        Palabra palabra97 = new Palabra("CLAVELES");
        Palabra palabra98 = new Palabra("NARCISOS");
        Palabra palabra99 = new Palabra("ORQUIDEAS");
        Palabra palabra100 = new Palabra("MARGARITAS");

        Concepto concepto10 = new Concepto("Flores");
        concepto10.agregar_palabra(palabra91);
        concepto10.agregar_palabra(palabra92);
        concepto10.agregar_palabra(palabra93);
        concepto10.agregar_palabra(palabra94);
        concepto10.agregar_palabra(palabra95);
        concepto10.agregar_palabra(palabra96);
        concepto10.agregar_palabra(palabra97);
        concepto10.agregar_palabra(palabra98);
        concepto10.agregar_palabra(palabra99);
        concepto10.agregar_palabra(palabra100);
        ////////////////////////////////
        ArrayList<Concepto> conjunto_de_conceptos = new ArrayList<Concepto>();
        conjunto_de_conceptos.add(concepto1);
        conjunto_de_conceptos.add(concepto2);
        conjunto_de_conceptos.add(concepto3);
        conjunto_de_conceptos.add(concepto4);
        conjunto_de_conceptos.add(concepto5);
        conjunto_de_conceptos.add(concepto6);
        conjunto_de_conceptos.add(concepto7);
        conjunto_de_conceptos.add(concepto8);
        conjunto_de_conceptos.add(concepto9);
        conjunto_de_conceptos.add(concepto10);


        frmCreaSopaLetras f = new frmCreaSopaLetras(conjunto_de_conceptos);
        f.setVisible(true);
    }
    //Notas: Error al agregar palabra de 1 letra
}

