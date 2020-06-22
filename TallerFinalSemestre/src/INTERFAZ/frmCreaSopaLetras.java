
package INTERFAZ;
import OBJ.*;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;







public class frmCreaSopaLetras extends JDialog implements ActionListener,KeyListener{
    private JButton JBAceptar;
    private JTextField txtFilas,txtColumnas,txtLetras;
    private ArrayList<Concepto> conjunto_de_conceptos;
    private int posX,posY,forma;
    private boolean booResalta;
    private Integer[] intArray = { 1, 2, 3, 4, 5, 6, 7 , 8};
    private Sopaletras2 sopa;

    public frmCreaSopaLetras(ArrayList<Concepto> xconjunto_de_conceptos){
        super();
        conjunto_de_conceptos = xconjunto_de_conceptos;
        forma = 1;
        posX = (int) (Math.random() * 19);
        posY = (int) (Math.random() * 19);
        IniciaGUI();
        this.setTitle("jSopaLetras");
        this.setSize(320,240);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }
    
    public void IniciaGUI(){
        JPanel panePrincipal = new JPanel(new GridLayout(4,1));
        JLabel label0 = new JLabel("  Crear Sopa de letras: ");
        JPanel pane1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel label1 = new JLabel("Filas: ");
            txtFilas = new JTextField("20",4);
            txtFilas.setHorizontalAlignment(JTextField.CENTER);
            txtFilas.addKeyListener(this);
            pane1.add(label1);
            pane1.add(txtFilas);
        JPanel pane2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel label2 = new JLabel("Columnas: ");
            txtColumnas = new JTextField("20",4);
            txtColumnas.setHorizontalAlignment(JTextField.CENTER);
            txtColumnas.addKeyListener(this);
            pane2.add(label2);
            pane2.add(txtColumnas);
        JPanel pane21 = new JPanel(new GridLayout(1,2));
            pane21.add(pane1);
            pane21.add(pane2);
        JPanel pane3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel label3 = new JLabel("Letras: ");
            txtLetras = new JTextField("ABCDEFGHIJKLMNOPQRSTUVWXYZ",22);
            txtLetras.addKeyListener(this);
            pane3.add(label3);
            pane3.add(txtLetras);

        JPanel pane4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            JBAceptar = new JButton("Aceptar");
            JBAceptar.addActionListener(this);
            pane4.add(JBAceptar);
        panePrincipal.add(label0);
        panePrincipal.add(pane21);
        panePrincipal.add(pane3);
        panePrincipal.add(pane4);
        this.add(panePrincipal);
    }
    private int verifyFilas(){
        try{
            int a = Integer.parseInt(txtFilas.getText());
            int b = Integer.parseInt(txtColumnas.getText());
            int i = 0;
            if(a < 2 || a > 50)
               i = 2;
            if (b < 2 || b > 50)
               i = 2;
            return i;
        }catch(Exception e){
            return 1;
        }
    }

    private void crearSopaLetras(){
        int num = verifyFilas();
        if(num == 0){
            if(txtLetras.getText().length()>0){
                Sopaletras2 xsopa = new Sopaletras2(Integer.parseInt(txtFilas.getText()),Integer.parseInt(txtColumnas.getText()),txtLetras.getText());
                sopa = xsopa;
                AgregarPalabra();
                frmSopaLetras frm = new frmSopaLetras(sopa, conjunto_de_conceptos);
                frm.setVisible(true);
                frm.setLocationRelativeTo(this);
                this.dispose();
            }else
                JOptionPane.showMessageDialog(rootPane, "Al menos debe haber un carácter", "jSopaLetras", 1);
        }else if(num == 1)
            JOptionPane.showMessageDialog(rootPane, "Datos no válidos", "jSopaLetras", 1);
        else
            JOptionPane.showMessageDialog(rootPane, "Número máximo para filas y columnas es 50 y mínimo 2", "jSopaLetras", 1);
    }

    public void AgregarPalabra(){
        //ORDENA DE MANERA ALEATORIA LA DIRECCION A SELECCIONAR
		List<Integer> intList = Arrays.asList(intArray);
		Collections.shuffle(intList);
		intList.toArray(intArray);
        ///////////////////////////////////////////////////////
        int aux;
        int contador;
        boolean validador;
        String s;
        int numero_random = (int) (Math.random() * 9);
        //SELECCIONAR LA PALABRA
        JOptionPane.showMessageDialog(rootPane, "El concepto a buscar es: ".concat(conjunto_de_conceptos.get(numero_random).nombre) , "Concepto" , 1);
        for (Palabra palabra :conjunto_de_conceptos.get(numero_random).lista_de_palabras) {
            contador= 0;
            validador= true;
            s = palabra.palabra;
            //SE ROMPE CUANDO LOGRE ENTRAR INSERTAR LA PALABRA SELECCIONADA, HASTA UN MAXIMO DE 50 INTENTOS "SI NO LO LOGRA SE LO SALTA"
            while(validador == true){
                for(aux = 0; aux< 8 ; aux++){
                    forma = intArray[aux];
                    if(s.length()> 0){
                        int num = sopa.Verify(s, posX, posY, forma);
                        System.out.println(num);
                        if(num == 0){
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
                    if (contador == 100){
                        JOptionPane.showMessageDialog(rootPane, "No se logro poscionar la palabra ".concat(s), "jSopaLetras" , 1);
                        break;
                    }
                    posX = (int) (Math.random() * 19);
                    posY = (int) (Math.random() * 19);
                    contador++;
                }
            }
        }
        //JOptionPane.showMessageDialog(rootPane, "Palabra no válida", "jSopaLetras" , 1);

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





    public void actionPerformed(ActionEvent e) {
        crearSopaLetras();
    }

    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar() == '\n')
            crearSopaLetras();
    }
    public void keyPressed(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
}
