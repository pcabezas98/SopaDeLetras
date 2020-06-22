package INTERFAZ;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.input.MouseDragEvent;
import OBJ.*;
import java.util.ArrayList;

//SE BORRO "ActionListener" DEL IMPLEMENTS
public class frmSopaLetras extends JFrame implements MouseListener{
    private JLabel botones[][];
    private JMenuItem JMINuevo,JMIAcercaDe,JMICrear,JMIRemove,JMIColorF,JMIColorL,JMIColorC;
    private JCheckBoxMenuItem cuadricula,JMIPinta;
    private Sopaletras2 sopa;
    private Color color,colorf,colorl;
    private JPanel pane;
    private ArrayList<Concepto> conjunto_de_conceptos;

    public frmSopaLetras(Sopaletras2 xSopa, ArrayList<Concepto> xconjunto_de_conceptos){
        super("jSopaLetras");
        color = null;
        colorf = null;
        colorl = null;
        sopa = xSopa;
        conjunto_de_conceptos = xconjunto_de_conceptos;
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
            JMenuItem JMISalir = new JMenuItem("Salir");
            JMISalir.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });
            mnuArchivo.add(JMICrear);
            mnuArchivo.add(JMISalir);
            barraMenu.add(mnuArchivo);

           JMenu mnuVer = new JMenu("Ver");
               JMIPinta = new JCheckBoxMenuItem("Ver Palabras Ocultas");
               JMIPinta.addActionListener(new ActionListener(){
                   public void actionPerformed(ActionEvent e) {
                       if(JMIPinta.getState())
                           VerPalabras(1);
                       else
                           VerPalabras(0);
                   }
               });
               mnuVer.add(JMIPinta);
               
//
           // JMenu mnuEdicion = new JMenu("Edición");
           //     JMenu mnuColor = new JMenu("Color");
           //         JMIColorC = new JMenuItem("Cuadrícula");
           //         JMIColorC.addActionListener(this);
           //         JMIColorF = new JMenuItem("Fondo");
           //         JMIColorF.addActionListener(this);
           //         JMIColorL = new JMenuItem("Letra");
           //         JMIColorL.addActionListener(this);
           //         mnuColor.add(JMIColorC);
           //         mnuColor.add(JMIColorF);
           //         mnuColor.add(JMIColorL);
//
           //     cuadricula = new JCheckBoxMenuItem("Cuadrícula");
           //     cuadricula.setSelected(false);
           //     cuadricula.addActionListener(new ActionListener(){
           //         public void actionPerformed(ActionEvent e) {
           //             if(cuadricula.getState())
           //                 BotonesEnCuadricula(1);
           //             else
           //                 BotonesEnCuadricula(0);
           //         }
           //     });
           //     JMIRemove = new JMenuItem("Eliminar palabra");
           //     JMIRemove.addActionListener(new ActionListener(){
           //         public void actionPerformed(ActionEvent e) {
           //             ShowRemovePalabra();
           //         }
           //     });
           //     JMINuevo = new JMenuItem("Nuevos Caracteres");
           //     JMINuevo.addActionListener(new ActionListener(){
           //         public void actionPerformed(ActionEvent e) {
           //             sopa.New();
           //         }
           //     });
           //     mnuEdicion.add(mnuColor);
           //     mnuEdicion.add(cuadricula);
           //     mnuEdicion.add(JMIRemove);
           //     mnuEdicion.add(JMINuevo);
//
            //JMenu mnuAyuda = new JMenu("Ayuda");
            //    JMIAcercaDe = new JMenuItem("Acerca de jSopaLetras");
            //    JMIAcercaDe.addActionListener(new ActionListener(){
            //        public void actionPerformed(ActionEvent e) {
            //            ShowAcercaDe();
            //        }
            //    });
            //    mnuAyuda.add(JMIAcercaDe);
//
            //barraMenu.add(mnuVer);
            //barraMenu.add(mnuEdicion);
            //barraMenu.add(mnuAyuda);

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
    private void VerPalabras(int decision){
        if(decision == 0) { //Falso
            int i,j;
            for(i = 0; i < sopa.getTotalFilas(); i++)
                for(j = 0; j < sopa.getTotalColumnas(); j++){
                    botones[i][j].setBackground(colorf);
            }
        }else{ //Verdadero
            sopa.PintaAllPalabra(Color.YELLOW);
        }
    }
    //private void ColorFondo(Color xcolor){
    //    int i,j;
    //    for(i = 0; i < sopa.getTotalFilas(); i++){
    //        for(j = 0; j < sopa.getTotalColumnas(); j++)
    //            botones[i][j].setBackground(xcolor);
    //    }
    //}
    //private void ColorCuadricula(Color xcolor){
    //    int i,j;
    //    for(i = 0; i < sopa.getTotalFilas(); i++)
    //        for(j = 0; j < sopa.getTotalColumnas(); j++){
    //            botones[i][j].setBorder(BorderFactory.createLineBorder(xcolor));
    //    }
    //}
    //private void ColorLetra(Color xcolor){
    //    int i,j;
    //    for(i = 0; i < sopa.getTotalFilas(); i++)
    //        for(j = 0; j < sopa.getTotalColumnas(); j++){
    //            botones[i][j].setForeground(xcolor);
    //    }
    //}
    //private void BotonesEnCuadricula(int decision){
    //    int i,j;
    //    if(decision == 1){
    //        for(i = 0; i < sopa.getTotalFilas(); i++){
    //            for(j = 0; j < sopa.getTotalColumnas(); j++)
    //                botones[i][j].setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
    //        }
    //    }else{
    //        for(i = 0; i < sopa.getTotalFilas(); i++){
    //            for(j = 0; j < sopa.getTotalColumnas(); j++)
    //                botones[i][j].setBorder(null);
    //        }
    //    }
    //}
    private void ShowCreaSopaLetra(){
        //DIALOGO PARA CONFIRMAR SI DESEAS RENICIAR, METODO SHOWCONFIRMDIALOG
        if(JOptionPane.showConfirmDialog(rootPane, "Desea cambiar de nivel", "jSopaLetras", 1)==0){
           // frmCreaSopaLetras frm = new frmCreaSopaLetras();
           // frm.setVisible(true);
           // this.dispose();


           System.out.println("NOFUNCIONAELREINICIAR");
        }
    }
    //private void ShowAcercaDe(){
    //    frmAcercaDe frm = new frmAcercaDe();
    //    frm.setLocationRelativeTo(this);
    //    frm.setVisible(true);
    //}
//
    //private void ShowRemovePalabra(){
    //    frmEliminaPalabra frm = new frmEliminaPalabra(sopa, colorf, JMIPinta.getState());
    //    frm.setLocationRelativeTo(this);
    //    frm.setVisible(true);
    //}
    //public void Action_JMICrear(ActionEvent e){
    //    ShowCreaSopaLetra();
    //}
    //public void actionPerformed(ActionEvent e) {
    //    Object obj = e.getSource();
    //    if(obj == JMIColorF){
    //        MostrarColor(1);
    //    }else if(obj == JMIColorL){
    //        MostrarColor(2);
    //    }else if(obj == JMIColorC){
    //        if(cuadricula.getState())
    //            MostrarColor(0);
    //        else
    //            JOptionPane.showMessageDialog(rootPane, "La opción cuadrícula no está activada", "jSopaLetras", 1);
    //    }
    //}
    //private void MostrarColor(int modo){
    //        Color aux = null;
    //        switch(modo){
    //            case 1: aux = colorf; break;
    //            case 2: aux = colorl; break;
    //        }
    //        aux = JColorChooser.showDialog(rootPane,"Seleccione un color", aux);
    //        if(aux != null){
    //            if(modo == 1){
    //                ColorFondo(aux);
    //                if(JMIPinta.getState())
    //                    sopa.PintaAllPalabra(Color.YELLOW);
    //                pane.setBackground(aux);
    //                colorf = aux;
    //            }else if (modo == 2){
    //                ColorLetra(aux);
    //                colorl = aux;
    //            }else
    //                ColorCuadricula(aux);
    //        }
    //}
    public void mouseClicked(MouseEvent e) {
        JLabel label = (JLabel)e.getSource();
        label.setBackground(Color.RED);
        int posX, posY,pose;
        pose = label.getName().indexOf("e");
        posX = Integer.parseInt(label.getName().substring(0,pose));
        posY = Integer.parseInt(label.getName().substring(pose+1));

    }

    public void mousePressed(MouseEvent e) {
        JLabel label = (JLabel)e.getSource();
        label.setBackground(Color.GRAY);
        //CREAR ALGORITMO PARA PINTAR LOS CUADROS QUE SE ESTAN SELECCIONANDO


        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseReleased(MouseEvent e) {
        JLabel label = (JLabel)e.getSource();
        label.setBackground(Color.PINK);
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    //COLOR CASILLA CUANDO PASAS POR ENCIMA DEL TABLERO CON EL MOUSE
    public void mouseEntered(MouseEvent e) {
        JLabel label = (JLabel)e.getSource();
        color = label.getBackground();
        label.setBackground(Color.GREEN);
        //this.setTitle(this.getWidth() + " * " + this.getHeight());
    }

    public void mouseExited(MouseEvent e) {
            JLabel label = (JLabel)e.getSource();
            label.setBackground(color);
            if(JMIPinta.getState()){
                    int posX, posY,pose;
                    pose = label.getName().indexOf("e");
                    posX = Integer.parseInt(label.getName().substring(0,pose));
                    posY = Integer.parseInt(label.getName().substring(pose+1));
                    if(sopa.lockedPosition(posX,posY))
                        label.setBackground(Color.YELLOW);
            }
    }
}
