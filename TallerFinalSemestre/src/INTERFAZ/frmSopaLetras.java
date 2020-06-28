package INTERFAZ;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;


import OBJ.*;
import java.util.ArrayList;
import javax.swing.event.MouseInputListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import javax.swing.border.LineBorder;



//SE BORRO "ActionListener" DEL IMPLEMENTS
public class frmSopaLetras extends JFrame implements MouseListener{
    private JLabel botones[][];
    private JMenuItem JMICrear;
    private JCheckBoxMenuItem cuadricula,JMIPinta;
    private Sopaletras sopa;
    private Color color;
    private JPanel pane;
    private Concepto  conjunto_de_palabras;
    private int  aux=0, tamaño_max, posANTESX=0, posANTESY=0, posx_despues=0,posy_despues=0;
    private Boolean  cuadricola_on = true;

    public frmSopaLetras(Sopaletras xSopa, Concepto xconjunto_de_palabras, int filas_max){
        super("jSopaLetras");
        color = null;
        sopa = xSopa;
        tamaño_max= filas_max;
        conjunto_de_palabras = xconjunto_de_palabras;
        IniciaComponentes();
        int ancho,alto;
        ancho = (int)(26.85 * sopa.getTotalColumnas());
        alto = (int) (25.1 * sopa.getTotalFilas());
        if(ancho < 250)
            ancho = 250;
        if(alto < 127)
            alto = 127;
        this.setSize(ancho,alto);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    public void IniciaComponentes(){
        pane = new JPanel(new GridLayout(sopa.getTotalFilas(),sopa.getTotalColumnas()));
        JPanel panePrincipal = new JPanel(new BorderLayout());
        JMenuBar barraMenu = new JMenuBar();
            JMenu mnuArchivo = new JMenu("Archivo");
            JMICrear = new JMenuItem("Crear nuevo...");
            JMICrear.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    ShowCreaSopaLetra();
                }
            });
            JMenuItem JMIpintarCuadriculas = new JMenuItem("MARCAR / DESCAMARCAR cuadriculas");
            JMIpintarCuadriculas.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    BotonesEnCuadricula();
                }
            });
            JMenuItem JMISalir = new JMenuItem("Salir");
            JMISalir.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });
            mnuArchivo.add(JMICrear);
            mnuArchivo.add(JMIpintarCuadriculas);
            mnuArchivo.add(JMISalir);
            barraMenu.add(mnuArchivo);

               
        botones = sopa.getJLabel();
        int i,j;
        for(i = 0; i < sopa.getTotalFilas(); i++){
            for(j = 0; j < sopa.getTotalColumnas(); j++){
                botones[i][j].addMouseListener(this);
                pane.add(botones[i][j]);
            }
        }
        panePrincipal.add(barraMenu, BorderLayout.NORTH);
        panePrincipal.add(pane,BorderLayout.CENTER);
        this.add(panePrincipal);
    }

    private void BotonesEnCuadricula(){
        int i,j;
        if(cuadricola_on == false){
            for(i = 0; i < sopa.getTotalFilas(); i++){
                for(j = 0; j < sopa.getTotalColumnas(); j++)
                    botones[i][j].setBorder(null);
            }
            cuadricola_on = true;
        }else{
            for(i = 0; i < sopa.getTotalFilas(); i++){
                for(j = 0; j < sopa.getTotalColumnas(); j++)
                    botones[i][j].setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
            }
            cuadricola_on =false;
        }
        
    }

    private void ShowCreaSopaLetra(){
        //DIALOGO PARA CONFIRMAR SI DESEAS RENICIAR, METODO SHOWCONFIRMDIALOG
        if(JOptionPane.showConfirmDialog(rootPane, "Desea cambiar de nivel", "jSopaLetras", 1)==0){
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
            frmCreaSopaLetras frm = new frmCreaSopaLetras(conjunto_de_conceptos);
            frm.setVisible(true);
            this.dispose();
        
        }
    }

    public void mouseClicked(MouseEvent e) {
        JLabel label = (JLabel)e.getSource();
        int pose;

        if(label.getBackground().equals(Color.RED) || label.getBackground().equals(Color.pink)){
            return;
        }
        if(label.getBackground().equals(Color.blue)){
            label.setBackground(Color.GREEN);
            aux--;
        }else{
            if(label.getBackground().equals(Color.orange)){
                label.setBackground(color);
                aux--;
            }else{
                if(label.getBackground().equals(Color.GREEN)){
                    label.setBackground(color);
                    label.setBackground(Color.blue);
                }else{
                    label.setBackground(Color.orange);
                }
                if(aux==0){
                    pose = label.getName().indexOf("e");
                    posANTESX = Integer.parseInt(label.getName().substring(0,pose));
                    posANTESY = Integer.parseInt(label.getName().substring(pose+1));
                    System.out.println(posANTESX+","+posANTESY);
                    aux++;
                    System.out.println("pasa"+aux);
                }else{
                    if(aux==1){
                        pose = label.getName().indexOf("e");
                        posx_despues = Integer.parseInt(label.getName().substring(0,pose));
                        posy_despues = Integer.parseInt(label.getName().substring(pose+1));
                        System.out.println(posx_despues+","+posy_despues);
                        System.out.println("pasaasasasa");
                    }
                    
                    check_camino(buscar_camino(posx_despues,posy_despues,posANTESX,posANTESY));
                    
                    aux =0;
                }
                
            }

        }
        if(conjunto_de_palabras.lista_de_palabras.size() == 0){
            System.out.println("FIN DEL JUEGO PERRA");
        }
        
        System.out.println("-------");
    }
    
    public int buscar_camino(int posX, int posY, int posANTESX,int posANTESY) {
        //forma = 1 izquierda, 2 derecha, 3 arriba, 4 abajo
        // 5 abajo izquierda
        // 6 arriba izquierda
        // 7  Arriba derecha
        // 8 Abajo derecha
        //buscar si se encuentra hacia abajo
        for(int j=posANTESY; j>=0; j--){
            if((j==posY) && (posX==posANTESX)){
                return 1;
            }
        }
        for(int j=posANTESY; j<=tamaño_max; j++){
            if((j==posY) && (posX==posANTESX)){
                return 2;
            }
        }
        for(int i=posANTESX; i>=0; i--){
            if((posANTESY==posY) && (posX==i)){
                return 3;
            }
        }
        for(int i=posANTESX; i<=tamaño_max; i++){
            if((posANTESY==posY) && (posX==i)){
                return 4;
            }
        }
        for(int i=posANTESX , j = posANTESY; j<=tamaño_max; i++, j++){
            if((j==posY) && (posX==i)){
                return 5;
            }
        }
        for(int i=posANTESX , j = posANTESY; j>=0; i--, j--){
            if((j==posY) && (posX==i)){
                return 6;
            }
        }
        for(int i=posANTESX , j = posANTESY; i>=0; i--, j++){
            if((j==posY) && (posX==i)){
                return 7;
            }
        }
        for(int i=posANTESX , j = posANTESY; i<=tamaño_max; i++, j--){
            if((j==posY) && (posX==i)){
                return 8;
            }
        }

        return 0;
    }

    public Boolean verificar_palabraBoolean(String palabrax){
        System.out.println(palabrax);
        String palabra_invertida = "";
        for (int x=palabrax.length()-1;x>=0;x--)
            palabra_invertida = palabra_invertida + palabrax.charAt(x);


        for (Palabra p : conjunto_de_palabras.lista_de_palabras) {
            if(palabrax.equals(p.palabra)){
                conjunto_de_palabras.lista_de_palabras.remove(p);
                return true;
            }
        }

        System.out.println(palabra_invertida);
        for (Palabra p : conjunto_de_palabras.lista_de_palabras) {
            if(palabra_invertida.equals(p.palabra)){
                conjunto_de_palabras.lista_de_palabras.remove(p);
                return true;
            }
        }
        return false;
    }
    
    public void check_camino(int m){
        //forma = 1 izquierda, 2 derecha, 3 arriba, 4 abajo
        // 5 abajo izquierda
        // 6 arriba izquierda
        // 7  Arriba derecha
        // 8 Abajo derecha
        String palabra ="";
        switch (m){
            case 0:
                Thread parpadeo = new Thread(){
                    public void run(){
                           //update the GUI in the event dispatch thread
                        try {
                            int posANTESX_1 =posANTESX, posANTESY_1 = posANTESY, posx_despues_1 = posx_despues, posy_despues_1 = posy_despues;
                            if( sopa.jletra[posANTESX_1][posANTESY_1].getBackground().equals(Color.GREEN) ||  sopa.jletra[posANTESX_1][posANTESY_1].getBackground().equals(Color.blue)){
                                sopa.jletra[posANTESX_1][posANTESY_1].setBackground(Color.pink);  
                            }else{
                                sopa.jletra[posANTESX_1][posANTESY_1].setBackground(Color.RED);
                                
                            }
                            if( sopa.jletra[posx_despues_1][posy_despues_1].getBackground().equals(Color.GREEN) || sopa.jletra[posx_despues_1][posy_despues_1].getBackground().equals(Color.blue)){
                                sopa.jletra[posx_despues_1][posy_despues_1].setBackground(Color.pink);  
                            }else{
                                sopa.jletra[posx_despues_1][posy_despues_1].setBackground(Color.RED);
                            }
                            System.out.println("1"); 
                            Thread.sleep(1*500);
                            System.out.println("2"); 
                            if( sopa.jletra[posANTESX_1][posANTESY_1].getBackground().equals(Color.pink)){
                                sopa.jletra[posANTESX_1][posANTESY_1].setBackground(Color.GREEN);  
                                
                            }else{
                                sopa.jletra[posANTESX_1][posANTESY_1].setBackground(color); 
                            }
                            if( sopa.jletra[posANTESX_1][posANTESY_1].getBackground().equals(Color.pink)){
                                sopa.jletra[posx_despues_1][posy_despues_1].setBackground(Color.GREEN);  
                            }else{
                                sopa.jletra[posx_despues_1][posy_despues_1].setBackground(color); 
                            }
                            Thread.sleep(1*500);
                            
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                };
                parpadeo.start();
                break;
            case 1:
                //ALMACENA LA PALABRA
                for(int i=posANTESY; i>=posy_despues; i--){
                    palabra= palabra+sopa.jletra[posANTESX][i].getText();
                }
                if(verificar_palabraBoolean(palabra)==true){
                    //pinta la palabra correcta
                    for(int i=posANTESY; i>=posy_despues; i--){
                        sopa.jletra[posANTESX][i].setBackground(Color.green);
                    }
                }else{
                    //parpadea
                    Thread parpadeo2 = new Thread(){
                        public void run(){
                               //update the GUI in the event dispatch thread
                            try {
                                int posANTESX_1 =posANTESX, posANTESY_1 = posANTESY;
                                for(int i=posANTESY_1; i>=posy_despues; i--){
                                    if(sopa.jletra[posANTESX_1][i].getBackground().equals(Color.GREEN) || sopa.jletra[posANTESX_1][i].getBackground().equals(Color.blue)){
                                        sopa.jletra[posANTESX_1][i].setBackground(Color.pink);  
                                    }else{
                                        sopa.jletra[posANTESX_1][i].setBackground(Color.RED);
                                    }
                                }
                                System.out.println("1"); 
                                Thread.sleep(1*500);
                                System.out.println("2"); 
                                for(int i=posANTESY_1; i>=posy_despues; i--){
                                    if(sopa.jletra[posANTESX_1][i].getBackground().equals(Color.pink)){
                                        sopa.jletra[posANTESX_1][i].setBackground(Color.GREEN);  
                                    }else{
                                        sopa.jletra[posANTESX_1][i].setBackground(color);
                                    }
                                }
                                Thread.sleep(1*500);
                                
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                        }
                    };
                    parpadeo2.start();
                }
                
                break;
            case 2:
                for(int i=posANTESY; i<=posy_despues; i++){
                   palabra = palabra+sopa.jletra[posANTESX][i].getText();
                   System.out.println(sopa.jletra[posANTESX][i].getText());
                }

                if(verificar_palabraBoolean(palabra)==true){
                    for(int i=posANTESY; i<=posy_despues; i++){
                        sopa.jletra[posANTESX][i].setBackground(Color.green);
                    }
                }else{
                    //parpadea
                    Thread parpadeo3 = new Thread(){
                        public void run(){
                               //update the GUI in the event dispatch thread
                            try {
                                int posANTESX_1 =posANTESX, posANTESY_1 = posANTESY;
                                for(int i=posANTESY_1; i<=posy_despues; i++){
                                    if(sopa.jletra[posANTESX_1][i].getBackground().equals(Color.GREEN) || sopa.jletra[posANTESX_1][i].getBackground().equals(Color.blue)){
                                        sopa.jletra[posANTESX_1][i].setBackground(Color.pink);  
                                    }else{
                                        sopa.jletra[posANTESX_1][i].setBackground(Color.RED);
                                    }
                                }
                                System.out.println("1"); 
                                Thread.sleep(1*500);
                                System.out.println("2"); 
                                for(int i=posANTESY_1; i<=posy_despues; i++){
                                    if(sopa.jletra[posANTESX_1][i].getBackground().equals(Color.pink)){
                                        sopa.jletra[posANTESX_1][i].setBackground(Color.GREEN);  
                                    }else{
                                        sopa.jletra[posANTESX_1][i].setBackground(color);
                                    }
                                }
                                Thread.sleep(1*500);
                                
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                        }
                    };
                    parpadeo3.start();
                }
                
                break;
            case 3:
                for(int i=posANTESX; i>=posx_despues; i--){
                    palabra = palabra+sopa.jletra[i][posANTESY].getText();
                }
                System.out.println(palabra);
                if(verificar_palabraBoolean(palabra)==true){
                    for(int i=posANTESX; i>=posx_despues; i--){
                        sopa.jletra[i][posANTESY].setBackground(Color.green);
                    }
                }else{
                    //parpadea
                    Thread parpadeo4 = new Thread(){
                        public void run(){
                               //update the GUI in the event dispatch thread
                            try {
                                int posANTESX_1 =posANTESX, posANTESY_1 = posANTESY;
                                for(int i=posANTESX_1; i>=posx_despues; i--){
                                    if(sopa.jletra[i][posANTESY_1].getBackground().equals(Color.GREEN) || sopa.jletra[i][posANTESY_1].getBackground().equals(Color.blue)){
                                        sopa.jletra[i][posANTESY_1].setBackground(Color.pink);  
                                    }else{
                                        sopa.jletra[i][posANTESY_1].setBackground(Color.RED);
                                    }
                                }
                                System.out.println("1"); 
                                Thread.sleep(1*500);
                                System.out.println("2"); 
                                for(int i=posANTESX_1; i>=posx_despues; i--){
                                    if(sopa.jletra[i][posANTESY_1].getBackground().equals(Color.pink)){
                                        sopa.jletra[i][posANTESY_1].setBackground(Color.GREEN);  
                                    }else{
                                        sopa.jletra[i][posANTESY_1].setBackground(color);
                                    }
                                }
                                Thread.sleep(1*500);
                                
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                        }
                    };
                    parpadeo4.start();
                }
                break;
            case 4:
                for(int i=posANTESX; i<=posx_despues; i++){
                    palabra = palabra+sopa.jletra[i][posANTESY].getText();           
                }
                if(verificar_palabraBoolean(palabra)==true){
                    for(int i=posANTESX; i<=posx_despues; i++){
                        sopa.jletra[i][posANTESY].setBackground(Color.green);
                    }
                }else{
                    //parpadea
                    Thread parpadeo5 = new Thread(){
                        public void run(){
                               //update the GUI in the event dispatch thread
                            try {
                                int posANTESX_1 =posANTESX, posANTESY_1 = posANTESY;
                                for(int i=posANTESX_1; i<=posx_despues; i++){
                                    if(sopa.jletra[i][posANTESY_1].getBackground().equals(Color.GREEN) || sopa.jletra[i][posANTESY_1].getBackground().equals(Color.blue)){
                                        sopa.jletra[i][posANTESY_1].setBackground(Color.pink);  
                                    }else{
                                        sopa.jletra[i][posANTESY_1].setBackground(Color.RED);
                                    }
                                }
                                System.out.println("1"); 
                                Thread.sleep(1*500);
                                System.out.println("2"); 
                                for(int i=posANTESX_1; i<=posx_despues; i++){
                                    if(sopa.jletra[i][posANTESY_1].getBackground().equals(Color.pink)){
                                        sopa.jletra[i][posANTESY_1].setBackground(Color.GREEN);  
                                    }else{
                                        sopa.jletra[i][posANTESY_1].setBackground(color);
                                    }
                                }
                                Thread.sleep(1*500);
                                
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                        }
                    };
                    parpadeo5.start();
                }
                break;
            case 5:
                for(int i=posANTESX, j = posANTESY; i<=posx_despues; i++,j++){
                    palabra = palabra+sopa.jletra[i][j].getText();     
                }
                if(verificar_palabraBoolean(palabra)==true){
                    for(int i=posANTESX, j = posANTESY; i<=posx_despues; i++,j++){
                        sopa.jletra[i][j].setBackground(Color.green);
                    }
                }else{
                    //parpadea
                    Thread parpadeo6 = new Thread(){
                        public void run(){
                               //update the GUI in the event dispatch thread
                            try {
                                int posANTESX_1 =posANTESX, posANTESY_1 = posANTESY;
                                for(int i=posANTESX_1, j = posANTESY_1; i<=posx_despues; i++,j++){
                                    if(sopa.jletra[i][j].getBackground().equals(Color.GREEN) || sopa.jletra[i][j].getBackground().equals(Color.blue)){
                                        sopa.jletra[i][j].setBackground(Color.pink);  
                                    }else{
                                        sopa.jletra[i][j].setBackground(Color.RED);
                                    }
                                }
                                System.out.println("1"); 
                                Thread.sleep(1*500);
                                System.out.println("2"); 
                                for(int i=posANTESX_1, j = posANTESY_1; i<=posx_despues; i++,j++){
                                    if(sopa.jletra[i][j].getBackground().equals(Color.pink)){
                                        sopa.jletra[i][j].setBackground(Color.GREEN);  
                                    }else{
                                        sopa.jletra[i][j].setBackground(color);
                                    }
                                }
                                Thread.sleep(1*500);
                                
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                        }
                    };
                    parpadeo6.start();
                }
                break;
            case 6:
                for(int i=posANTESX, j = posANTESY; i>=posx_despues; i--,j--){
                    palabra = palabra+sopa.jletra[i][j].getText(); 
                }
                if(verificar_palabraBoolean(palabra)==true){
                    for(int i=posANTESX, j = posANTESY; i>=posx_despues; i--,j--){
                        sopa.jletra[i][j].setBackground(Color.green);
                    }
                }else{
                    //parpadea
                    Thread parpadeo7 = new Thread(){
                        public void run(){
                               //update the GUI in the event dispatch thread
                            try {
                                int posANTESX_1 =posANTESX, posANTESY_1 = posANTESY;
                                for(int i=posANTESX_1, j = posANTESY_1; i>=posx_despues; i--,j--){
                                    if(sopa.jletra[i][j].getBackground().equals(Color.GREEN) || sopa.jletra[i][j].getBackground().equals(Color.blue)){
                                        sopa.jletra[i][j].setBackground(Color.pink);  
                                    }else{
                                        sopa.jletra[i][j].setBackground(Color.RED);
                                    }
                                }
                                System.out.println("1"); 
                                Thread.sleep(1*500);
                                System.out.println("2"); 
                                for(int i=posANTESX_1, j = posANTESY_1; i>=posx_despues; i--,j--){
                                    if(sopa.jletra[i][j].getBackground().equals(Color.pink)){
                                        sopa.jletra[i][j].setBackground(Color.GREEN);  
                                    }else{
                                        sopa.jletra[i][j].setBackground(color);
                                    }
                                }
                                Thread.sleep(1*500);
                                
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                        }
                    };
                    parpadeo7.start();
                }
                break;
                
            case 7:
                for(int i=posANTESX, j = posANTESY; i>=posx_despues; i--,j++){
                    palabra = palabra+sopa.jletra[i][j].getText();
                }
                if(verificar_palabraBoolean(palabra)==true){
                    for(int i=posANTESX, j = posANTESY; i>=posx_despues; i--,j++){
                        sopa.jletra[i][j].setBackground(Color.green);
                    }
                }else{
                    //parpadea
                    Thread parpadeo8 = new Thread(){
                        public void run(){
                               //update the GUI in the event dispatch thread
                            try {
                                int posANTESX_1 =posANTESX, posANTESY_1 = posANTESY;
                                for(int i=posANTESX_1, j = posANTESY_1; i>=posx_despues; i--,j++){
                                    if(sopa.jletra[i][j].getBackground().equals(Color.GREEN) || sopa.jletra[i][j].getBackground().equals(Color.blue)){
                                        sopa.jletra[i][j].setBackground(Color.pink);  
                                    }else{
                                        sopa.jletra[i][j].setBackground(Color.RED);
                                    }
                                }
                                System.out.println("1"); 
                                Thread.sleep(1*500);
                                System.out.println("2"); 
                                for(int i=posANTESX_1, j = posANTESY_1; i>=posx_despues; i--,j++){
                                    if(sopa.jletra[i][j].getBackground().equals(Color.pink)){
                                        sopa.jletra[i][j].setBackground(Color.GREEN);  
                                    }else{
                                        sopa.jletra[i][j].setBackground(color);
                                    }
                                }
                                Thread.sleep(1*500);
                                
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                        }
                    };
                    parpadeo8.start();
                }

            case 8:
                for(int i=posANTESX, j = posANTESY; i<=posx_despues; i++,j--){
                    palabra = palabra+sopa.jletra[i][j].getText();
                }
                if(verificar_palabraBoolean(palabra)==true){
                    for(int i=posANTESX, j = posANTESY; i<=posx_despues; i++,j--){
                        sopa.jletra[i][j].setBackground(Color.green);
                    }
                }else{
                    //parpadea
                    Thread parpadeo8 = new Thread(){
                        public void run(){
                               //update the GUI in the event dispatch thread
                            try {
                                int posANTESX_1 =posANTESX, posANTESY_1 = posANTESY;
                                for(int i=posANTESX_1, j = posANTESY_1; i<=posx_despues; i++,j--){
                                    if(sopa.jletra[i][j].getBackground().equals(Color.GREEN) || sopa.jletra[i][j].getBackground().equals(Color.blue)){
                                        sopa.jletra[i][j].setBackground(Color.pink);  
                                    }else{
                                        sopa.jletra[i][j].setBackground(Color.RED);
                                    }
                                }
                                System.out.println("1"); 
                                Thread.sleep(1*500);
                                System.out.println("2"); 
                                for(int i=posANTESX_1, j = posANTESY_1; i<=posx_despues; i++,j--){
                                    if(sopa.jletra[i][j].getBackground().equals(Color.pink)){
                                        sopa.jletra[i][j].setBackground(Color.GREEN);  
                                    }else{
                                        sopa.jletra[i][j].setBackground(color);
                                    }
                                }
                                Thread.sleep(1*500);
                                
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                        }
                    };
                    parpadeo8.start();
                }
                break;
        }
    }

    public void mousePressed(MouseEvent e) {     
    }
    public void mouseReleased(MouseEvent e) {
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {           
    }
}
