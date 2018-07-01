/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import javax.swing.JOptionPane;

/**
 *
 * @author Familia_Ruiz
 */
public class Operaciones {

    int vv;
    int rd = vv / 2;
    double[] grados;
    double[] minutos;
    double[] segundos;

    double[] resultado;
    String[] auxiliar;
    double[] r1;
    double[] r2;
    double[] r3;
    double[] r4;
    double[] r5;
    double[] r6;

    double[] ax1;
    double[] ax2;
    double[] ax3;

    public void Rtamaño(int n) {
        vv = n * 4;
        grados = new double[vv];
        minutos = new double[vv];
        segundos = new double[vv];

        resultado = new double[vv];
        auxiliar = new String[vv];
        r1 = new double[vv];
        r2 = new double[vv];
        r3 = new double[vv];
        r4 = new double[vv];
        r5 = new double[vv];
        r6 = new double[vv];

        ax1 = new double[vv];
        ax2 = new double[vv];
        ax3 = new double[vv];
    }

    public void Recibir(String[] gr, String[] mi, String[] se) {
        for (int i = 0; i < vv; i++) {
            grados[i] = Double.parseDouble(gr[i]);
            minutos[i] = Double.parseDouble(mi[i]);
            segundos[i] = Double.parseDouble(se[i]);
        }

    }

    public String[] sumar() {
        String[] A = new String[vv];
        double[] lk = new double[vv];

        return A;
    }

    public void Aprox() {

        // String[] resul=new String[vv];
        for (int i = 0; i < vv; i++) {

            double mi = minutos[i];
            double mt;
            double q = mi;
            int o = (int) q;
            mt = q - o;
            minutos[i] = o;
            segundos[i] = (float) (segundos[i] + (mt * 60));

            if (segundos[i] >= 60) {
                minutos[i] = minutos[i] + 1;
                segundos[i] = (segundos[i] - 60);
            }

            double n = grados[i];
            double m;
            double nn = n;
            int u = (int) nn;
            m = nn - u;
            grados[i] = u;
            minutos[i] = minutos[i] + (m * 60);

            if (minutos[i] >= 60) {
                grados[i] = grados[i] + 1;
                minutos[i] = (minutos[i] - 60);
            }
        }

    }

    public void Aproximar() {

        for (int i = 0; i < vv; i = i + 4) {

            r6[i] = r6[i] / 2;
            double mi = r5[i];
            double mt;
            double q = mi / 2;
            int o = (int) q;
            mt = q - o;
            r5[i] = o;
            r6[i] = (float) (r6[i] + (mt * 60));

            if (r6[i] >= 60) {
                r5[i] = r5[i] + 1;
                r6[i] = (r6[i] - 60);
            }

            double n = r4[i];
            double m;
            double nn = n / 2;
            int u = (int) nn;
            m = nn - u;
            r4[i] = u;
            r5[i] = r5[i] + (m * 60);

            if (r5[i] >= 60) {
                r4[i] = r4[i] + 1;
                r5[i] = (r5[i] - 60);
            }
        }

    }

    public void Calculo1() {

        //CALCULO PARA UNA DEFELXIONES  
        for (int i = 0; i < vv; i = i + 4) {

            if ((r3[i] + r3[i + 2]) < 60) {
                r6[i] = (r3[i] + r3[i + 2]);
                r6[i + 1] = 0;
            }
            if ((r3[i] + r3[i + 2]) >= 60) {
                r2[i] = r2[i] + 1;
                // segundos[i]=segundos[i]+60;
                r6[i] = (r3[i] + r3[i + 2]) - 60;
                r6[i + 1] = 0;
            }

            if ((r2[i] + r2[i + 2]) < 60) {
                r5[i] = r2[i] + r2[i + 2];
            }
            if ((r2[i] + r2[i + 2]) >= 60) {
                r1[i] = r1[i] + 1;
                // minutos[i]=minutos[i]+60;
                r5[i] = (r2[i] + r2[i + 2]) - 60;
            }

            r4[i] = r1[i] + r1[i + 2];
        }

    }

    public void Calculo2() {
        //CALCULO PARA DOS DEFELXIONES
        for (int i = 0; i < vv; i = i + 2) {

            if (segundos[i] == segundos[i + 1]) {
                r3[i] = segundos[i] - segundos[i + 1];
                r3[i + 1] = 0;
            }
            if (segundos[i] > segundos[i + 1]) {
                r3[i] = segundos[i] - segundos[i + 1];
                r3[i + 1] = 0;
            }
            if (segundos[i] < segundos[i + 1]) {
                minutos[i] = minutos[i] - 1;
                //segundos[i]=segundos[i]+60;
                segundos[i] = segundos[i] + 60;
                r3[i] = segundos[i] - segundos[i + 1];
                r3[i + 1] = 0;
            }

            if (minutos[i] > minutos[i + 1]) {
                r2[i] = minutos[i] - minutos[i + 1];
                r2[i + 1] = 0;

            }
            if (minutos[i] < minutos[i + 1]) {
                grados[i] = grados[i] - 1;
                //  minutos[i]=minutos[i]+60;
                r2[i] = (minutos[i] + 60) - minutos[i + 1];
                r2[i + 1] = 0;
            }

            if (minutos[i] == minutos[i + 1]) {
                r2[i] = minutos[i] - minutos[i + 1];
                r2[i + 1] = 0;
            }

            r1[i] = grados[i] - grados[i + 1];
            r1[i + 1] = 0;
        }
    }

    public String[] Calculo(int tamaño, String[] gr, String[] mi, String[] se) {
        Rtamaño(tamaño);
        Recibir(gr, mi, se);
        Aprox();
        Calculo2();
        Calculo1();
        Aproximar();
//Error();
        String[] resul = new String[vv];
        //llenar el vector que regresara 
        for (int i = 0; i < vv; i = i + 4) {
            resul[i] = r4[i] + "°" + r5[i] + "´´" + r6[i] + "´";
        }
        return resul;
    }

    public String[] Compensacion(int tamaño, String[] gr, String[] mi, String[] se) {
        Rtamaño(tamaño);
        Recibir(gr, mi, se);
        Aprox();
        Calculo2();
        Calculo1();
        Aproximar();
        Error();
        String[] resul = new String[vv];
        //llenar el vector que regresara 
        for (int i = 0; i < vv; i = i + 4) {
            resul[i] = r4[i] + "°" + r5[i] + "´´" + r6[i] + "´";
        }
        return resul;
    }

    int tan;

    public String[] CalculoDP2(int tamaño, String[] gr, String[] mi, String[] se) {
        tan = tamaño;
        Rtamaño(tamaño);
        Recibir(gr, mi, se);
        Aprox();
        Calculo2();
//.String[] m=Aproximar(r1,r2,r3);
        for (int i = 0; i < vv; i = i + 2) {
            auxiliar[i] = r1[i] + " ° " + r2[i] + " ´´ " + r3[i] + " ´ ";
            auxiliar[i + 1] = "0";
        }
        return auxiliar;
    }

    private void Error() {

        double s, segundo = 0, minuto = 0, grado = 0, st, mt, gt, xm, xs, xg;
        double m, g;

        for (int i = 0; i < vv; i = i + 4) {
            segundo = segundo + r6[i];
            minuto = minuto + r5[i];
            grado = grado + r4[i];
        }
//sumatoria de grados,minutos,segundos
        st = segundo / 60;
        minuto = minuto + ((int) st);
        s = (float) segundo % 60;

        g = (int) grado;
        gt = grado - g;
        minuto = minuto + (gt * 60);
        mt = minuto / 60;
        g = g + ((int) mt);
        xm = minuto % 60;
        m = (int) xm;
        double xmx = xm - m;
        s = s + (xmx * 60);
        xs = s / 60;
        m = m + ((int) xs);
        s = (float) s % 60;

// Error angular
        double s1, s2, s3;
        s1 = 360 - g;
        s2 = 0 - m;
        s3 = 0 - s;

        JOptionPane.showMessageDialog(null, s1 + "g" + s2 + "m" + s3 + "s");
//calculo de tolerancia
        double ra = Math.sqrt(tan);
        double Ts, Tm, Tg, a, b, c, d, e, f, t1, t2, t3, tg, ts, T1, T2, T3;
        Tg = 1 * ra;
        a = Tg - ((int) Tg);
        Tm = 30 * ra + (a * 60);
        b = Tm - (int) Tm;
        Ts = 0 + b * 60;

        t1 = Tm / 60;
        tg = (int) t1;
        T1 = (int) Tg + tg;
        d = (Tm % 60) - ((int) Tm % 60);

        t2 = Ts + (d * 60);
        ts = (int) t2 / 60;
        T2 = (int) Tm % 60 + ts;
        t2 = t2 % 60;
//Validacion para ña compensacion
        if (T1 >= s1) {
            if (T2 >= s2) {
                if (t2 > s3) {
                    grado = s1 / tan;
                    minuto = s2 / tan;
                    segundo = s3 / tan;
                    for (int i = 0; i < vv; i = i + 4) {

                        if (segundo < 0 && -segundo > r6[i]) {
                            r5[i] = r5[i] - 1;
                            r6[i] = (r6[i] + 60) + segundo;

                            if (minuto < 0 && -minuto > r5[i]) {
                                r4[i] = r4[i] - 1;
                                r5[i] = (r5[i] + 60) + minuto;
                                r4[i] = r4[i] + grado;

                            } else {
                                r4[i] = r4[i] + grado;
                                r5[i] = r5[i] + minuto;
                            }

                        } else {
                            r6[i] = r6[i] + segundo;
                            if (minuto < 0 && -minuto > r5[i]) {
                                r4[i] = r4[i] - 1;
                                r5[i] = (r5[i] + 60) + minuto;
                                r4[i] = r4[i] + grado;

                            } else {
                                r4[i] = r4[i] + grado;
                                r5[i] = r5[i] + minuto;
                            }

                        }

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Error en la toma de deflexiones");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Error en la toma de deflexiones");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Error en la toma de deflexiones");
        }
    }
}
