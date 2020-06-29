
package INTERFAZ;
import OBJ.*;
import javax.swing.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class frmCreaSopaLetras extends JDialog {
    private int columnas=20, filas=20;
    private String txt = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private ArrayList<Concepto> conjunto_de_conceptos;
    private Integer[] intArray = { 1, 2, 3, 4, 5, 6, 7 , 8};
    private Sopaletras sopa;
    private int posX,posY,forma,numero_random = (int) (Math.random() * 9);
    private JButton jButton1,jButton2,jButton3;
    private JLabel jLabel1, jLabel2, jLabel3;

    public frmCreaSopaLetras(ArrayList<Concepto> xconjunto_de_conceptos){
        super();
        conjunto_de_conceptos = xconjunto_de_conceptos;
        forma = 1;
        posX = (int) (Math.random() * filas-1);
        posY = (int) (Math.random() * filas-1);
        IniciaGUI();
        this.setTitle("jSopaLetras");
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }
    public void IniciaGUI(){
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setText("BIENVENIDO A SOPA DE LETRAS");

        jButton1.setBackground(new java.awt.Color(5, 240, 5));
        jButton1.setText("FACIL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(240, 240, 5));
        jButton2.setText("MEDIO");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(240, 5, 5));
        jButton3.setText("DIFICIL");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setText("Seleccione Dificultad");

        jLabel3.setForeground(new java.awt.Color(150, 150, 150));
        jLabel3.setText("© Roberto A. - Pablo C. - Sergio M. - Modelado de Programación 2020");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel3)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(22, 22, 22)
                .addComponent(jButton1)
                .addGap(28, 28, 28)
                .addComponent(jButton2)
                .addGap(31, 31, 31)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(jLabel3)));
                
        
        


    }   
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        columnas = 20 ;
        filas = 20;
        crearSopaLetras();
        
    }                                        
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        columnas = 30;
        filas = 30;
        crearSopaLetras();
        
    } 
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        columnas = 50;
        filas = 50;
        crearSopaLetras();
    }                                        
    private void crearSopaLetras(){
        if(txt.length()>0){
            Sopaletras xsopa = new Sopaletras(filas,columnas,txt);
            sopa = xsopa;
            AgregarPalabra();
            frmSopaLetras frm = new frmSopaLetras(sopa, conjunto_de_conceptos.get(numero_random), filas);
            frm.setVisible(true);
            frm.setLocationRelativeTo(this);
            this.dispose();
        }else
            JOptionPane.showMessageDialog(rootPane, "Al menos debe haber un carácter", "jSopaLetras", 1);
        
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
        //SELECCIONAR LA PALABRA
        JOptionPane.showMessageDialog(rootPane, "El concepto a buscar es: ".concat(conjunto_de_conceptos.get(numero_random).nombre) , "Concepto" , 1);
        for (Palabra palabra :conjunto_de_conceptos.get(numero_random).lista_de_palabras) {
            contador= 0;
            validador= true;
            s = palabra.palabra;
            //SE ROMPE CUANDO LOGRE ENTRAR INSERTAR LA PALABRA SELECCIONADA, HASTA UN MAXIMO DE 100 INTENTOS "SI NO LO LOGRA SE LO SALTA"
            while(validador == true){
                for(aux = 0; aux< 8 ; aux++){
                    forma = intArray[aux];
                    if(s.length()> 0){
                        int num = sopa.Verify(s, posX, posY, forma);
                        if(num == 0){
                            if(verifyString(s,sopa.getCaracteresPermitidos())){
                                sopa.setPalabra(s, posX, posY, forma);
                                sopa.PintaPalabra(sopa.getTotalPalabras()-1, Color.YELLOW);
                                validador = false;
                                this.dispose();
                                break;
                            }else
                            continue;
                            //Palabra no agregada. La palabra contiene letras que no forman parte de la sopa de letras. También se distingue entre mayúsculas y minúsculas.
                            
                        }else if (num == 1)
                            continue;
                            //Palabra muy extensa para ser colocada
                        else if(num == 2)
                            continue;
                            //Palabra se cruza con otra ya agregada anteriormente
                    }else
                    continue;
                    //Palabra no válida
                }
                if(validador == true){
                    //NO ENCAJA LA PALABRA EN EL LUGAR INDICADO
                    if (contador == 100){
                        JOptionPane.showMessageDialog(rootPane, "No se logro poscionar la palabra ".concat(s), "jSopaLetras" , 1);
                        break;
                    }
                    posX = (int) (Math.random() * filas-1);
                    posY = (int) (Math.random() * filas-1);
                    contador++;
                }
            }
        }
        //Palabra no válida

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

}
