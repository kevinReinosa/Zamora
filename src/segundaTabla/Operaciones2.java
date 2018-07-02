/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segundaTabla;

/**
 *
 * @author kevin
 */
public class Operaciones2 {
double[] rumb,pro;
String[] direc;
int num;
double[] N;
double[] S;
double[] E;
double[] W;
public double[] Rumbos(int n,double[] deflex,double[] rumbo){
     rumb=new double[n];
     
     direc=new String[n];
     num=n;   
//rumbo de 1-2
if (rumbo[0]<90) {
   direc[0]="NE";
    }
if (rumbo[0]>90) {
  rumbo[0]=rumbo[0]-90;      
   direc[0]="ES";    
    }else if(rumbo[0]>180) {
  rumbo[0]=rumbo[0]-180;      
    direc[0]="SW";
    }else if(rumbo[0]>270) {
  rumbo[0]=rumbo[0]-270;      
    direc[0]="WN";
    }
//Encontrado rumbo de 1-2
   rumb[0]=rumbo[0];
   rumb[1]=rumbo[1];
   rumb[2]=rumbo[2];
   
   for (int i = 4; i < num; i=i+4) {
       rumb[i]=rumb[i-4]+deflex[i];
       rumb[i+1]=rumb[i-3]+deflex[i+1];
       rumb[i+2]=rumb[i-2]+deflex[i+2];
       
     //Repartion
     double mi = rumb[i+1];
            double mt;
            double q = mi;
            int o = (int) q;
            mt = q - o;
            rumb[i+1] = o;
            rumb[i+2] = (float) (rumb[i+2] + (mt * 60));

            if (rumb[i+2] >= 60) {
                rumb[i+1] = rumb[i+1] + 1;
                rumb[i+2] = (rumb[i+2] - 60);
            }

            double nv = rumb[i];
            double m;
            double nn = nv;
            int u = (int) nn;
            m = nn - u;
            rumb[i] = u;
            rumb[i+1] = rumb[i+1] + (m * 60);

            if (rumb[i+1] >= 60) {
                rumb[i] = rumb[i] + 1;
                rumb[i+1] = (rumb[i+1] - 60);
            }
            
    if (rumb[i]<90) {
   direc[i]=direc[i-4];
    }else if(rumb[i]>90){
        rumb[i]=rumb[i]-90;
        if (direc[i-4].equalsIgnoreCase("NE")) {
         direc[i]="ES";   
        }else if (direc[i-4].equalsIgnoreCase("ES")) {
         direc[i]="SW";   
        }else if (direc[i-4].equalsIgnoreCase("SW")) {
         direc[i]="WN";   
        }else if (direc[i-4].equalsIgnoreCase("WN")) {
         direc[i]="NE";   
        }       
  rumb[i]=rumb[i]-90;
  
    }else if(rumb[i]>180) {
 if (direc[i-4].equalsIgnoreCase("NE")) {
         direc[i]="SW";   
        }else if (direc[i-4].equalsIgnoreCase("ES")) {
         direc[i]="WN";   
        }else if (direc[i-4].equalsIgnoreCase("SW")) {
         direc[i]="NE";   
        }else if (direc[i-4].equalsIgnoreCase("WN")) {
         direc[i]="ES";   
        }
    rumb[i]=rumb[i]-180;      
    }else if(rumb[i]>270){
  rumb[i]=rumb[i]-270;      
    }
   
   }
 return rumb;   
}
public double[] Proyecciones(int n,double[] rum,String[] dist){
pro=new double[n];
double[] b=new double[n];    
N=new double[n];
     S=new double[n];
     E=new double[n];
     W=new double[n];  

int y=0;
    for (int i = 0; i <n; i=i+4) {
    b[i]=Double.parseDouble(dist[y]);
    y++;    
    }
    for (int i = 0; i <n; i=i+4) {
//    pro[i]=(Math.cos((rum[i]°rum[i+1]°rum[i+2]°)*2.0*Math.PI/360.0))*b[i];
        
    }
   
    
return pro;    
}


    
}
