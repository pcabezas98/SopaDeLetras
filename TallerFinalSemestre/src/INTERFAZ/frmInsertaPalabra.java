package INTERFAZ;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Collections;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

import OBJ.*;
import java.util.ArrayList;

public class frmInsertaPalabra extends JDialog implements ActionListener,KeyListener{
    private JTextField texto;
    private JButton JBSalir,JBAceptar;
    private JCheckBox jcbChars;
    private Sopaletras2 sopa;
    private int posX,posY,forma;
    private JRadioButton BotonOpcion1,BotonOpcion2,BotonOpcion3,BotonOpcion4,BotonOpcion5,BotonOpcion6,BotonOpcion7,BotonOpcion8;
    private boolean booResalta;
    private Integer[] intArray = { 1, 2, 3, 4, 5, 6, 7 , 8};
    private ArrayList<Concepto> conjunto_de_conceptos;
    //private Color color;

    public frmInsertaPalabra(Sopaletras2 xsopa, int i, int j, boolean bool,ArrayList<Concepto> xconjunto_de_conceptos){
        super();
        sopa = xsopa;
        posX = i;
        posY = j;
        forma = 1;
        booResalta = bool;
        conjunto_de_conceptos = xconjunto_de_conceptos;
        //color = xcolor;
        Ini();
        this.setTitle("Insertar Palabra"); //Titulo de ventana
        this.setSize(410,325); //Tamaño de ventana
        this.setModal(true); //Establece ventana modal
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    public void Ini(){
        JPanel panePrincipal = new JPanel(new GridLayout(9,1));
        JPanel pane = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel pane2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel pane3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel pane4 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JLabel label = new JLabel("  Palabra:");
        JLabel label2 = new JLabel("  Posición:");
        JLabel label3 = new JLabel("  Letras:");
        jcbChars = new JCheckBox("Solo letras del formulario");
        jcbChars.setSelected(true);
        jcbChars.setFocusable(false);
        texto = new JTextField();
        texto.addKeyListener(this);

        ButtonGroup AgrupaBoton = new ButtonGroup();
            BotonOpcion1 = new JRadioButton("Izquierda");
            BotonOpcion1.setSelected(true);
            BotonOpcion1.setFocusable(false);
            BotonOpcion1.addActionListener(this);
            BotonOpcion2 = new JRadioButton("Derecha");
            BotonOpcion2.addActionListener(this);
            BotonOpcion2.setFocusable(false);
            BotonOpcion3 = new JRadioButton("Arriba");
            BotonOpcion3.addActionListener(this);
            BotonOpcion3.setFocusable(false);
            BotonOpcion4 = new JRadioButton("Abajo");
            BotonOpcion4.addActionListener(this);
            BotonOpcion4.setFocusable(false);
            BotonOpcion5 = new JRadioButton("Diagonal superior izquierda");
            BotonOpcion5.addActionListener(this);
            BotonOpcion5.setFocusable(false);
            BotonOpcion6 = new JRadioButton("Diagonal superior derecha");
            BotonOpcion6.addActionListener(this);
            BotonOpcion6.setFocusable(false);
            BotonOpcion7 = new JRadioButton("Diagonal inferior izquierda");
            BotonOpcion7.addActionListener(this);
            BotonOpcion7.setFocusable(false);
            BotonOpcion8 = new JRadioButton("Diagonal inferior derecha");
            BotonOpcion8.addActionListener(this);
            BotonOpcion8.setFocusable(false);
        AgrupaBoton.add(BotonOpcion1);
        AgrupaBoton.add(BotonOpcion2);
        AgrupaBoton.add(BotonOpcion3);
        AgrupaBoton.add(BotonOpcion4);
        AgrupaBoton.add(BotonOpcion5);
        AgrupaBoton.add(BotonOpcion6);
        AgrupaBoton.add(BotonOpcion7);
        AgrupaBoton.add(BotonOpcion8);
        
        pane.add(BotonOpcion1);
        pane.add(BotonOpcion2);
        pane.add(BotonOpcion3);
        pane.add(BotonOpcion4);
        pane3.add(BotonOpcion5);
        pane3.add(BotonOpcion6);
        pane4.add(BotonOpcion7);
        pane4.add(BotonOpcion8);

        JBSalir = new JButton("Salir");
        JBSalir.addActionListener(this);
        JBAceptar = new JButton("Aceptar");
        JBAceptar.addActionListener(this);

        pane2.add(JBSalir);
        pane2.add(JBAceptar);
        
        panePrincipal.add(label);
        panePrincipal.add(texto);
        panePrincipal.add(label3);
        panePrincipal.add(jcbChars);
        panePrincipal.add(label2);
        panePrincipal.add(pane);
        panePrincipal.add(pane3);
        panePrincipal.add(pane4);
        panePrincipal.add(pane2);
        this.add(panePrincipal);
    }

    private static boolean verifyString(String cadena, String caracteres){
        char c[],x;
        int i,j,k;
        int error = 0;
        String s = caracteres;
        c = s.toCharArray();
        for( i=0 ;  i < cadena.length() && error == 0;i++){
            x = cadena.charAt(i);
            k = 0;
            for(j = 0 ;  j < s.length() && k == 0;j++){
                if(x==c[j])
                    k++;
            }
            if( k == 0)
                error++;
        }
        if(error == 0)
            return true;
        else
            return false;
    }
    public void AgregarPalabra(){
        int aux;
        int contador;
        boolean validador;
        String s = texto.getText().trim();
        //SELECCIONAR LA PALABRA
        for (Palabra palabra :conjunto_de_conceptos.get(0).lista_de_palabras) {
            contador= 0;
            validador= true;
            System.out.println(palabra.palabra);
            s = palabra.palabra;
            //SE ROMPE CUANDO LOGRE ENTRAR INSERTAR LA PALABRA SELECCIONADA, HASTA UN MAXIMO DE 50 INTENTOS "SI NO LO LOGRA SE LO SALTA"
            while(validador == true){
                for(aux = 0; aux< 8 ; aux++){
                        forma = intArray[aux];
                        System.out.println(forma);
                        if(s.length()> 0){
                            int num = sopa.Verify(s, posX, posY, forma);
                            if(num == 0){
                                if(jcbChars.isSelected()){
                                    if(verifyString(s,sopa.getCaracteresPermitidos())){
                                        sopa.setPalabra(s, posX, posY, forma);
                                        //if(booResalta)
                                        sopa.PintaPalabra(sopa.getTotalPalabras()-1, Color.YELLOW);
                                        validador = false;
                                        this.dispose();
                                        break;
                                    }else
                                    continue;
                                    //JOptionPane.showMessageDialog(rootPane, "Palabra no agregada. La palabra contiene letras que no forman parte de la sopa de letras. También se distingue entre mayúsculas y minúsculas.", "jSopaLetras" , 1);
                                }else{
                                sopa.setPalabra(s, posX, posY, forma);
                                if(booResalta)
                                sopa.PintaPalabra(sopa.getTotalPalabras()-1, Color.YELLOW);
                                this.dispose();
                            }
                        }else if (num == 1)
                            continue;
                            //JOptionPane.showMessageDialog(rootPane, "Palabra muy extensa para ser colocada", "jSopaLetras" , 1);
                        else if(num == 2)
                            continue;
                            //JOptionPane.showMessageDialog(rootPane, "Palabra se cruza con otra ya agregada anteriormente", "jSopaLetras" , 1);
                    }else
                    continue;
                    //JOptionPane.showMessageDialog(rootPane, "Palabra no válida", "jSopaLetras" , 1);
                }
                if(validador == true){
                    //JOptionPane.showMessageDialog(rootPane, "NO ENCAJA LA PALABRA EN EL LUGAR INDICADO", "jSopaLetras" , 1);
                    if (contador == 50)
                    break;
                    posX = (int) (Math.random() * 19);
                    posY = (int) (Math.random() * 19);
                    contador++;
                }
            }
        }
        //JOptionPane.showMessageDialog(rootPane, "Palabra no válida", "jSopaLetras" , 1);

    }
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == JBSalir){
            this.dispose();
        }else if(obj == BotonOpcion1){
            forma = 1;
        }else if(obj == BotonOpcion2){
            forma = 2;
        }else if (obj == BotonOpcion3){
            forma = 3;
        }else if(obj == BotonOpcion4){
            forma = 4;
        }else if(obj == BotonOpcion5){
            forma = 5;
        }else if(obj == BotonOpcion6){
            forma = 6;
        }else if(obj == BotonOpcion7){
            forma = 7;
        }else if(obj == BotonOpcion8){
            forma = 8;
        }else if(obj == JBAceptar){
            //ORDENA DE MANERA ALEATORIA LA DIRECCION A SELECCIONAR
		    List<Integer> intList = Arrays.asList(intArray);
		    Collections.shuffle(intList);
		    intList.toArray(intArray);
            System.out.println(Arrays.toString(intArray));
            ///////////////////////////////////////////////////////

            AgregarPalabra();
        
        }  
    }
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == '\n')
            AgregarPalabra();
        if(e.getKeyCode() == 27)
            this.dispose();
        //this.setTitle("" + this.getWidth() + " * " + this.getHeight());
        //this.setTitle("KeyCode = " + e.getKeyCode());
    }
    public void keyReleased(KeyEvent e) {
        // new UnsupportedOperationException("Not supported yet.");
    }

}
