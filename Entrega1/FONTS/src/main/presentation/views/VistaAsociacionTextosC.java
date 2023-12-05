package main.presentation.views;

import main.presentation.controllers.CtrlPresentacion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaAsociacionTextosC extends JFrame {

    //BOTONES
    /** Panel donde se incluyen los elementos de la ventana */
    private final JPanel lamina = new JPanel();
    /** Título de media ventana superior */
    private final JLabel tituloVistaATC = new JLabel("Consultar asociación de textos");
    /** Título de media ventana */
    private final JLabel tituloVistaATC2 = new JLabel("Consultar lista de asociaciones de textos");
    /** Botón para consultar una asociación */
    private final JButton bConsultarAsociacion = new JButton("Consultar asociación de textos");
    /** Botón para consultar la lista de asociaciones */
    private final JButton bConsultarListaAsociaciones = new JButton("Consultar lista de asociaciones de textos");
    /** Botó de tornar a la pantalla del menú principal */
    private final JButton bsalir = new JButton("Atrás");


    //TEXTOS Y AREAS DE TEXTO
    //VENTANA SUPERIOR
    /** Texto indicando que la barra de texto de al lado es para introducir el nombre de la asociación a consultar*/
    private final JLabel txtNombreATC = new JLabel("NOMBRE:");
    /** Área de texto para introducir el nombre de la asociación que se quiere consultar */
    private final JTextArea areanomATC = new JTextArea();

    //MENSAJES DE ERROR
    /** Pantalla de error que aparece cuando se quiere consultar/modificar una asociación sin nombre */
    private final JFrame Nomframe = new JFrame ("JFrame");



    public VistaAsociacionTextosC(){

        setBounds(250, 150, 1000, 600);
        //setExtendedState(Frame.MAXIMIZED_BOTH);
        //setResizable(true);

        // Título ventana superior
        tituloVistaATC.setBounds(10, 5, 200, 30);
        add(tituloVistaATC);

        // Título media ventana
        tituloVistaATC2.setBounds(10, 205, 200, 30);
        add(tituloVistaATC2);

        //VENTANA SUPERIOR
        // Texto Nombre
        txtNombreATC.setBounds(50, 35, 200, 20);
        add(txtNombreATC);

        // Área texto Nombre
        areanomATC.setBounds(250,35, 200,20);
        add(areanomATC);

        // Botón consultar Alfabeto
        bConsultarAsociacion.setBounds(700, 150, 200, 20);
        add(bConsultarAsociacion);

        // Botón consultar lista de Alfabetos
        bConsultarListaAsociaciones.setBounds(700, 250, 200, 20);
        add(bConsultarListaAsociaciones);

        // Botón salir para ir a la pantalla principal
        bsalir.setBounds(800, 500, 100, 20);
        add(bsalir);

        add(lamina);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener lConsultarA = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //CtrlPresentacion.getNombresAlfabetos();

                if (areanomATC.getText().isEmpty()){
                    JDialog sinNombre2 =  new JDialog(Nomframe, "Error: No Nombre");
                    sinNombre2.setBounds(800, 300, 400, 200);
                    sinNombre2.setLayout(null);

                    JLabel txtErrorNombre2 = new JLabel("Hay que entrar el nombre de una asociación de textos de la lista de asociaciones de textos");
                    txtErrorNombre2.setBounds(10, 20, 400, 40);
                    JButton bSalirErrorNombre2 = new JButton("Salir");
                    bSalirErrorNombre2.setVisible(true);
                    bSalirErrorNombre2.setBounds(150, 110, 100, 30);
                    sinNombre2.add(txtErrorNombre2);
                    sinNombre2.add(bSalirErrorNombre2);
                    sinNombre2.setVisible(true);

                    ActionListener lSalirErrorNombre = new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            sinNombre2.dispose();
                            sinNombre2.setVisible(false);
                        }
                    };
                    bSalirErrorNombre2.addActionListener(lSalirErrorNombre);

                }else { //se han llenado todos los campos
                    CtrlPresentacion.consultarContenidoAlfabeto(areanomATC.getText());
                    setVisible(false);
                }

            }
        };

        ActionListener lConsultarListaA = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };

        ActionListener lSalir = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CtrlPresentacion.iniPresentacion();
                setVisible(false);
            }
        };

        bConsultarAsociacion.addActionListener(lConsultarA);
        bConsultarListaAsociaciones.addActionListener(lConsultarListaA);
        bsalir.addActionListener(lSalir);

    }

}
