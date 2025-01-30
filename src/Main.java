import javax.swing.*;
import java.text.DecimalFormat;
import java.util.Scanner;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {

        Raices raiz = new Raices("Raíces N-ésimas");
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(raiz);
        }catch(Exception e){
            //Error
        }
        raiz.setVisible(true);

/*
        DecimalFormat df = new DecimalFormat("#.######");

        double pi = PI;

        Scanner input = new Scanner(System.in);
        System.out.print("Ingrese la parte real del número: ");
        double a = input.nextDouble();

        Scanner input2 = new Scanner(System.in);
        System.out.print("Ingrese la parte imaginaria del número: ");
        float b = input2.nextFloat();

        double r = 0;
        r = Double.parseDouble(df.format(sqrt(pow(a,2)+pow(b,2))));
        System.out.println("El múdulo es: " + r);

        //double divisionImaReal = b/a;
        double theta = 0;
        //double theta_0 = atan(divisionImaReal);
        double theta_0 = atan(b/a);

        if(a>0 && b>0){
            theta = Double.parseDouble(df.format(toDegrees(theta_0)));
            System.out.println("El ángulo es: "+String.format("%.5f",theta));
        } else if (a>0 && b<0) {
            theta = 360 - Double.parseDouble(df.format(toDegrees(abs(theta_0))));
            System.out.println("El ángulo es: "+String.format("%.5f",theta));
        } else if (a<0 && b>0) {
            theta = 180 - Double.parseDouble(df.format(toDegrees(abs(theta_0))));
            System.out.println("El ángulo es: "+String.format("%.5f",theta));
        } else if (a<0 && b<0) {
            theta = 180 + Double.parseDouble(df.format(toDegrees(abs(theta_0))));
            System.out.println("El ángulo es: "+String.format("%.5f",theta));
        } else if (a==0) {
            if(b>0){
                theta = 90;
                System.out.println("El ángulo es: "+theta);
            }else {
                theta = 270;
                System.out.println("El ángulo es: "+theta);
            }
        }else if (a<0 && b==0) {
            theta = 180;
            System.out.println("El ángulo es: "+theta);
        } else {
            theta = 0;
            System.out.println("El ángulo es: "+theta);
        }

        Scanner input3 = new Scanner(System.in);
        System.out.print("Qué raíz desea calcular: ");
        int n = input3.nextInt();

        double w_k_real = 0;
        double w_k_imaginario = 0;

        System.out.println("Las "+n+" raíces son:");

        for(int i=0;i<n;i++){
            w_k_real = Double.parseDouble(String.valueOf((pow(r, (1.0 / n)) * (cos((toRadians(theta) + 2 * i * pi) / n)))));
            //w_k_real = Double.parseDouble(df.format((pow(r, (1.0 / n)) * (cos((toRadians(theta) + 2 * i * pi) / n)))));
            w_k_imaginario = Double.parseDouble(String.valueOf((pow(r, (1.0 / n)) * (sin((toRadians(theta) + 2 * i * pi) / n)))));
            //w_k_imaginario = Double.parseDouble(df.format((pow(r, (1.0 / n)) * (sin((toRadians(theta) + 2 * i * pi) / n)))));

            if (w_k_imaginario>0) {
                //System.out.println(w_k_real + " + " + w_k_imaginario+" i");
                System.out.println(String.format("%.5f",w_k_real) + " + " + String.format("%.6f",w_k_imaginario)+" i");
            } else if (w_k_imaginario<0) {
                System.out.println(String.format("%.5f",w_k_real) + " " + String.format("%.6f",w_k_imaginario)+" i");
            } else {
                System.out.println(String.format("%.5f",w_k_real) + " + " + String.format("%.6f",w_k_imaginario)+" i");
            }
        }

 */
    }

}
/*
        for(int i=0;i<n;i++){
            w_k_real = Double.parseDouble(df.format((pow(r, (1.0 / n)) * (cos((toRadians(theta) + 2 * i * pi) / n)))));
            w_k_imaginario = Double.parseDouble(df.format((pow(r, (1.0 / n)) * (sin((toRadians(theta) + 2 * i * pi) / n)))));
            if (b>0) {
                if (a>0){
                    System.out.println(w_k_real + " + " + w_k_imaginario+" i");
                }else if(a==0){
                    System.out.println(w_k_real + " + " + w_k_imaginario+" i");
                }else if(w_k_imaginario<0){
                    System.out.println(w_k_real + "  " + w_k_imaginario+" i");
                }else {
                    System.out.println(w_k_real + " + " + w_k_imaginario+" i");
                }
            } else if (b<0) {
                if (a>0){
                    System.out.println(w_k_real + " " + w_k_imaginario+" i");
                } else if (a==0) {
                    System.out.println(w_k_real + " " + w_k_imaginario+" i");
                }else {
                    System.out.println(w_k_real + " " + w_k_imaginario+" i");
                }
            }else if (b==0){
                if(a<0) {
                    System.out.println(w_k_real + " i");
                }else {
                    System.out.println(w_k_real);
                }
            }
        }

 */