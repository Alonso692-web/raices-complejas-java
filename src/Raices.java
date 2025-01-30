import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;

import static java.lang.Math.*;

public class Raices extends JFrame implements ActionListener, KeyListener {
    private JLabel jlbParteReal,jlbParteImaginaria,jlbNumeroRaiz,jlbModulo,jlbArgumento,jlbResultadoRaiz;
    private JLabel jlbResultadoModulo,jlbResultadoArgumento,jlbTitulo;
    private JTextField jtfParteReal,jtfParteImaginaria,jtfNumeroRaiz;
    private JButton jbtnCalcular;
    private JTextArea resRaices;

    public Raices(String titulo){
        setTitle(titulo);
        setSize(700,500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        jlbParteReal =  new JLabel("Ingrese la parte real del número:");
        jlbParteImaginaria = new JLabel("Ingrese la parte imaginaria del número:");
        jlbResultadoRaiz = new JLabel("Las raíces son: ");
        jlbNumeroRaiz = new JLabel("Cuál raíz desea calcular: ");
        jtfParteReal = new JTextField("");
        jtfParteImaginaria = new JTextField("");
        jlbNumeroRaiz = new JLabel("Qué número de raíz desea calcular: ");
        jtfNumeroRaiz = new JTextField("");
        jbtnCalcular = new JButton("Calcular");
        jlbModulo = new JLabel("Módulo:");
        jlbArgumento = new JLabel("Argumento:");
        jlbResultadoArgumento = new JLabel("");
        jlbResultadoModulo = new JLabel("");
        jlbResultadoRaiz = new JLabel("Las raíces son:");
        jlbTitulo = new JLabel("Raíces de un número complejo");

        resRaices = new JTextArea();
        //JScrollPane scroll = new JScrollPane();

        getContentPane().setLayout(null);

        getContentPane().setBackground(Color.orange);
        Font nuevaFuente = new Font("Tahoma", Font.PLAIN, 14);

        getContentPane().add(jlbParteReal);
        jlbParteReal.setBounds(20,100,250,45);
        getContentPane().add(jlbParteImaginaria);
        jlbParteImaginaria.setBounds(330,100,250,45);
        getContentPane().add(jtfParteReal);
        jtfParteReal.setBounds(235,105,60,30);
        getContentPane().add(jtfParteImaginaria);
        jtfParteImaginaria.setBounds(585,105,60,30);
        getContentPane().add(jlbNumeroRaiz);
        jlbNumeroRaiz.setBounds(180,150,270,30);
        getContentPane().add(jtfNumeroRaiz);
        jtfNumeroRaiz.setBounds(410,150,60,30);
        getContentPane().add(jbtnCalcular);
        jbtnCalcular.setFont(nuevaFuente);
        jbtnCalcular.setBounds(285,190,100,50);
        getContentPane().add(jlbModulo);
        jlbModulo.setBounds(90,190,100,40);
        getContentPane().add(jlbArgumento);
        jlbArgumento.setBounds(470,190,100,40);

        getContentPane().add(jlbResultadoRaiz);
        jlbResultadoRaiz.setBounds(100,240,100,30);

        getContentPane().add(resRaices);
        resRaices.setBounds(100,280,500,170);

        //Cambiar la fuente a las etiquetas y a los campos de texto
        Component[] componentes = getContentPane().getComponents();
        Component componente;
        for (int i = 0; i < componentes.length; i++) {
            componente = componentes[i];
            if (componente instanceof JLabel) {
                ((JLabel) componente).setFont(nuevaFuente);
            } else if (componente instanceof JTextField) {
                ((JTextField) componente).setFont(nuevaFuente);
            }
        }
        getContentPane().add(jlbResultadoModulo);
        jlbResultadoModulo.setFont(new Font("Tahoma",Font.BOLD,14));
        jlbResultadoModulo.setBounds(150,195,100,30);
        getContentPane().add(jlbResultadoArgumento);
        jlbResultadoArgumento.setFont(new Font("Tahoma",Font.BOLD,14));
        jlbResultadoArgumento.setBounds(555,195,100,30);
        getContentPane().add(jlbTitulo);
        jlbTitulo.setFont(new Font("Tahoma",Font.BOLD,22));
        jlbTitulo.setBounds(170,10,400,50);
        jbtnCalcular.setFont(new Font("Tahoma",Font.BOLD,16));
/*
        resRaices.setSize(400,400);

        resRaices.setLineWrap(true);
        resRaices.setEditable(false);
        resRaices.setVisible(true);

        JScrollPane scroll = new JScrollPane (resRaices);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        getContentPane().add(scroll);

 */
        jbtnCalcular.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == jbtnCalcular) {
                System.out.println("Resultado");
                raicesComplejas();
            }
        }catch (NumberFormatException error){
            JOptionPane.showMessageDialog(this,"Solo ingrese números","Error",JOptionPane.ERROR_MESSAGE);
            jtfParteReal.setText("");
            jtfParteImaginaria.setText("");
            jtfNumeroRaiz.setText("");
            jtfParteReal.requestFocus();
        }
    }

    private void raicesComplejas() {
        resRaices.setFont(new Font("Tahoma", Font.PLAIN, 18));
        DecimalFormat df = new DecimalFormat("#.#####");
        double pi = PI;
        double a = Double.parseDouble(jtfParteReal.getText());
        float b = Float.parseFloat(jtfParteImaginaria.getText());
        double r = 0;
        r = Double.parseDouble(df.format(sqrt(pow(a,2)+pow(b,2))));

        jlbResultadoModulo.setText(String.valueOf(df.format(r)));

        double theta = 0;

        double theta_0 = atan(b/a);

        if(a>0 && b>0){
            theta = Double.parseDouble(df.format(toDegrees(theta_0)));
            jlbResultadoArgumento.setText(String.valueOf(df.format(theta))+"°");
        } else if (a>0 && b<0) {
            theta = 360 - Double.parseDouble(df.format(toDegrees(abs(theta_0))));
            jlbResultadoArgumento.setText(String.valueOf(df.format(theta))+"°");
        } else if (a<0 && b>0) {
            theta = 180 - Double.parseDouble(df.format(toDegrees(abs(theta_0))));
            jlbResultadoArgumento.setText(String.valueOf(df.format(theta))+"°");
        } else if (a<0 && b<0) {
            theta = 180 + Double.parseDouble(df.format(toDegrees(abs(theta_0))));
            jlbResultadoArgumento.setText(String.valueOf(df.format(theta))+"°");
        } else if (a==0) {
            if(b>0){
                theta = 90;
                jlbResultadoArgumento.setText(String.valueOf(df.format(theta))+"°");
            }else {
                theta = 270;
                jlbResultadoArgumento.setText(String.valueOf(df.format(theta))+"°");
            }
        } else if (a<0 && b==0) {
            theta = 180;
            jlbResultadoArgumento.setText(String.valueOf(df.format(theta))+"°");
        } else {
            theta = 0;
            jlbResultadoArgumento.setText(String.valueOf(df.format(theta))+"°");
        }

        int n = Integer.parseInt(jtfNumeroRaiz.getText());

        double w_k_real = 0;
        double w_k_imaginario = 0;

        resRaices.setText("");
        for(int i=0;i<n;i++){
            w_k_real = Double.parseDouble(df.format((pow(r, (1.0 / n)) * (cos((toRadians(theta) + 2 * i * pi) / n)))));
            w_k_imaginario = Double.parseDouble(df.format((pow(r, (1.0 / n)) * (sin((toRadians(theta) + 2 * i * pi) / n)))));
            if (w_k_imaginario>0) {
                resRaices.append("W"+i+"= "+String.format("%.5f",w_k_real) + " + " + String.format("%.5f",w_k_imaginario)+" i"+"\n");
            } else if (w_k_imaginario<0) {
                resRaices.append("W"+i+"= "+String.format("%.5f",w_k_real) + " " + String.format("%.5f",w_k_imaginario)+" i"+"\n");
            }else {
                resRaices.append("W"+i+"= "+String.format("%.5f",w_k_real) + " + " + String.format("%.5f",w_k_imaginario)+" i"+"\n");
            }
        }
        jtfParteReal.requestFocus();

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
