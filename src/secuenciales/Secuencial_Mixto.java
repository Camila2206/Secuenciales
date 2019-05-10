/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secuenciales;

import javax.swing.JOptionPane;

/**
 *
 * @author camila
 */
public class Secuencial_Mixto {

    public static void main(String[] args) {
        int a, x, k, R, c, primo = 0;
        double m, periodo, d;
        boolean aux;
        int contador = 1;//contabiliza el periodo total 

        d = Double.parseDouble(JOptionPane.showInputDialog(null, "Para poder obtener el modulo 'm =2^d'\n"
                + "Ingrese un valor para 'd'" + "Valor D",
                JOptionPane.INFORMATION_MESSAGE)); // Para obtener m la sacamos de la formula

        m = Math.pow(2, d);// Para obtener m 'm=2^d' se utiliza el valor ingreado de 'd'
        aux = true;//valor booleano para saber si k es un entero
        int num = 0;//esta variable almacenara el valor para k que ingrese el ususario

        while (aux) {//el bucle while se repetira hasta que el usuario ingrese un numero entero
            try {
                num = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de K para calcular a = 1 + (4 * k)", JOptionPane.ERROR_MESSAGE));
                aux = false;
            } catch (NumberFormatException e) {
            }
        }
        k = num;//una vez comprobado que la variable num almacena unicamente un numero entero a la variable K se le asigna este valo
        a = 1 + (4 * k);//para obtener el valor de a se lo hace a partir de este formulo o bien con la sigiente: 1 + (4 * k)

        //El for permite encontrar el primo maximo de todos los numero, se inicia el bucle a partir de la 
        //variable (m-1)
        //la variable 'primo' sera la que almacene al 'primo maximo'
        for (int i = (int) (m - 1); i >= 0; i--) {
            if (esPrimo(i)) {
                primo = i;
                System.out.println("El primo maximo es: " + i);
                break;
            }
        }

        c = primo;//a la variable c le asignamos el valor de primo

        x = Integer.parseInt(JOptionPane.showInputDialog("Ingresar el valor de la semilla=x",
                JOptionPane.INFORMATION_MESSAGE));//se pide ingresar el valor para la semilla

        periodo = x / m;//La variable periodo almacena periodo actual a partir de la 'semilla sobre el modulo' (x/m)

        System.out.println("n" + "     Xn   " + "    Xn+1   ");
        for (int i = 0; i < m; i++) {
            R = (int) (((a * x) + c) % m);//la variable R almacena el resulatdos de aplicar la formula para el secuencial multiplicativo
            System.out.println(i + "      " + x + "        " + R);
            x = R;

            //En el bucle if se comprueba si el valor de la variable 'periodo' es igual a (R/m), resultado sobre modulo
            //Si se cumple se incrementa u contador para poder saber el periodo total
            if (periodo == (R / m)) {
                System.out.println("Va " + contador + " periodo(s)");
                contador++;
            }
        }

    }

    //Este mmetodo perimite saber si un umero ingresado es primo o no. Si lo es se retornara True.
    public static boolean esPrimo(int numero) {
        int contador = 2;
        boolean primo = true;
        while ((primo) && (contador != numero)) {
            if (numero % contador == 0) {
                primo = false;
            }
            contador++;
        }
        return primo;
    }

}
