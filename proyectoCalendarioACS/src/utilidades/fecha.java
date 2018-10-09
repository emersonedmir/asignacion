/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;



/**
 *
 * @author Emerson
 */
public class fecha {
    
    private int year;
    private int month;
    private int day;
    private fecha Fecha;
        
    public fecha() 
    {
        this.year=0;
        this.month=0;
        this.day=0;
    }
     
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
    
    
    /**
     * función que inicializa una instancia del tipo fecha, si la fecha
     * no se puede crear devuelve un false
     * @param y variable tipo int que representa un año
     * @param m variable tipo int que representa un mes
     * @param d variable tipo int que representa un día
     * @return true o false
     */
    public boolean fecha_es_tupla(int y, int m, int d)
    {
        try
        {
            if(y<1852)
            {
                return false;
            }
            if(m<0 && m>12)
            {
                return false;
            }
            
            Fecha = new fecha();
            Fecha.setYear(y);
            Fecha.setMonth(m);
            Fecha.setDay(d);
            
            
            if(!fecha_es_valida(Fecha))
            {
                return false;
            }
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
     /**
     * funcion booleana que calcula si un año es bisiesto
     *@param Fecha parámetro de tipo fecha
     * @return true o false
     */
    public boolean bisiesto(fecha Fecha)
    {
        return (Fecha.getYear() % 4 == 0 &&  Fecha.getYear()% 100 != 0 || Fecha.getYear() % 400 == 0);
    }
    
    /**
     * funcion booleana que calcula si una fecha es valida
     *@param Fecha parámetro de tipo fecha
     * @return true o false
     */
    public boolean fecha_es_valida(fecha Fecha)
    {  
        
       if((Fecha.getMonth()==1 || Fecha.getMonth()==3 || Fecha.getMonth()==5 || Fecha.getMonth()==7 || Fecha.getMonth()==8 || Fecha.getMonth()==10 || Fecha.getMonth()==12)&& Fecha.getDay()>0 && Fecha.getDay()<32)
       {
           return true;
       }
       if((Fecha.getMonth()==4 || Fecha.getMonth()==6 || Fecha.getMonth()==9 || Fecha.getMonth()==11)&& Fecha.getDay()>0 && Fecha.getDay()<31)
       {
           return true;
       }
       if((Fecha.getMonth()==2)&& (bisiesto(Fecha)==true)&& Fecha.getDay()>0 && Fecha.getDay()<30)
       {
           return true;
       }
       if((Fecha.getMonth()==2)&& (bisiesto(Fecha)==false)&& Fecha.getDay()>0 && Fecha.getDay()<29)
       {
           return true;
       }
       return false;
    }
    
    /**
     * función que calcula el día siguiente a una fecha dada
     * @param f variable de tipo fecha
     * @return objeto del tipo fecha, 
     */
    public fecha dia_siguiente(fecha f)
    {
            if(f.getMonth()==2)
            {
                if(bisiesto(f))
                {
                    if(f.getDay()==29)
                    {
                        f.setDay(1);
                        f.setMonth(f.getMonth()+1);
                    }
                    else
                    {
                        f.setDay(f.getDay()+1);
                    }
                }
                else
                {
                    if(f.getDay()==28)
                    {
                        f.setDay(1);
                        f.setMonth(f.getMonth()+1);
                    }
                    else
                    {
                        f.setDay(f.getDay()+1);
                    }
                }
                
            }
            else if (f.getMonth()==4 || f.getMonth()==6 || f.getMonth()==9 || f.getMonth()==11)
            {
                if(f.getDay()==30)
                {
                    f.setDay(1);
                    f.setMonth(f.getMonth()+1);
                }
                else
                {
                    f.setDay(f.getDay()+1);
                }
            }
            else if (f.getMonth()==1 || f.getMonth()==3 || f.getMonth()==5 || f.getMonth()==7 || f.getMonth()==8 || f.getMonth()==10)
            {
                if(f.getDay()==31)
                {
                    f.setDay(1);
                    f.setMonth(f.getMonth()+1);
                }
                else
                {
                    f.setDay(f.getDay()+1);
                }
            }
            else
            {
                if(f.getDay()==31)
                {
                    f.setDay(1);
                    f.setMonth(1);
                    f.setYear(f.getYear()+1);
                }
                else
                {
                    f.setDay(f.getDay()+1);
                }
            }
            
        
        
        
        return f;
    }
   
    public int días_desde_primero_enero(fecha f)
    {
        int m2=0;
        if(bisiesto(f))
        {
            m2=29;
        }
        else
        {
            m2=28;
        }
        switch (f.getMonth()) {
            case 1:
                if(f.getDay()==1)
                {
                    return 0;
                }
                else
                {
                    return (f.getDay());
                }
                
            case 2:
                return (31 + f.getDay());
            case 3:
                return (31+m2+f.getDay());
            case 4:
                return (31*2+m2+f.getDay());
            case 5:
                return (31*2+m2+30+f.getDay());
            case 6:
                return (31*3+m2+30+f.getDay());
            case 7:
                return (31*3+m2+30*2+f.getDay());
            case 8:
                return (31*4+m2+30*2+f.getDay());
            case 9:
                return (31*5+m2+30*2+f.getDay());
            case 10:
                return (31*5+m2+30*3+f.getDay());
            case 11:
                return (31*6+m2+30*2+f.getDay());
            case  12:
                return (31*5+m2+30*3+f.getDay());
            default:
                break;
        }
        
        return 0;
    }
    /**
     * Fución basada en el algoritmo de zeller que calcula el día del primero de enero de una año dado
     * codificación: 0 = domingo, 1 = lunes, 2 = martes, 3 = miércoles, 4 = jueves, 5 = viernes, 6 = sábado
     * @param year año a calcular
     * @return  valor entero correspondiente al número del día de la semana según codificación
     */
    public int dia_primero_enero(int year) 
    {
        return   (1 + (year -((13) / 12)) + ((year -((13) / 12))/4) - ((year -((13) / 12))/100) + ((year -((13) / 12))/400) + (31*(1 + (12*((13) / 12)) - 2)) / 12) % 7;
    }
    
    public int dia_primero_enero(fecha f)
    {
        int d, m, y;
 
        d = (14-f.getMonth()) / 12;
        y = f.getYear() - d;
        m = f.getMonth() + (12*d) - 2;
        int dia1 = (f.getDay() + y + (y/4) - (y/100) + (y/400) + (31*m) / 12) % 7;
        
  
 
  return dia1;
    }

    public void imprimir_4x3 (int year)
    {
        int[][] enero = new int[6][7];
        int[][] febrero = new int[6][7];
        int[][] marzo = new int[6][7];
        int[][] abril = new int[6][7];
        int[][] mayo = new int[6][7];
        int[][] junio = new int[6][7];
        int[][] julio = new int[6][7];
        int[][] agosto = new int[6][7];
        int[][] septiembre = new int[6][7];
        int[][] octubre = new int[6][7];
        int[][] noviembre = new int[6][7];
        int[][] diciembre = new int[6][7];
        
        enero = generarMes(year,1);
        febrero=generarMes(year,2);
        marzo = generarMes(year,3);
        abril = generarMes(year,4);
        mayo = generarMes(year,5);
        junio= generarMes(year,6);
        julio= generarMes(year,7);
        agosto= generarMes(year,8);
        septiembre =generarMes(year,9);
        octubre= generarMes(year,10);
        noviembre= generarMes(year,11);
        diciembre= generarMes(year,12);
                
        
        int f;
        int c;
        
        for(f=0;f<6;f++)
        {
            for(c=0;c<21;c++)
            {
               if(c<7)
               {
                   if(f==0 &&c==0)
                   {
                       System.out.println("\tAño: "+year);
                       System.out.print("\t\t\tENERO");
                       System.out.print("\t\t\t\t\t\t\t\t\t\tFEBRERO");
                       System.out.println("\t\t\t\t\t\t\t\t\t\tMARZO");
                       System.out.print("\tD");
                        System.out.print("\tL");
                        System.out.print("\tK");
                        System.out.print("\tM");
                        System.out.print("\tJ");
                        System.out.print("\tV");
                        System.out.print("\tS");
                        System.out.print("\t\t|\t");
                        System.out.print("\tD");
                        System.out.print("\tL");
                        System.out.print("\tK");
                        System.out.print("\tM");
                        System.out.print("\tJ");
                        System.out.print("\tV");
                        System.out.print("\tS");
                        System.out.print("\t\t|\t");
                        System.out.print("\tD");
                        System.out.print("\tL");
                        System.out.print("\tK");
                        System.out.print("\tM");
                        System.out.print("\tJ");
                        System.out.print("\tV");
                        System.out.print("\tS");
                        System.out.print("\t\t|");
                        System.out.println();
                   }
                   System.out.print("\t"+enero[f][c]);
               }
               else if (c<14)
               {
                   if(c==7)
                   {
                      System.out.print("\t\t\t"); 
                   }
                   System.out.print("\t"+febrero[f][c-7]);
               }
               else
               {
                   if(c==14)
                   {
                      System.out.print("\t\t\t");  
                   }
                   System.out.print("\t"+marzo[f][c-14]);
               }
            }
            System.out.println();
        }
        
        for(f=0;f<6;f++)
        {
            for(c=0;c<21;c++)
            {
               if(c<7)
               {
                   if(f==0 &&c==0)
                   {
                       System.out.println();
                       System.out.print("\t\t\tABRIL");
                       System.out.print("\t\t\t\t\t\t\t\t\t\tMAYO");
                       System.out.println("\t\t\t\t\t\t\t\t\t\tJUNIO");
                       System.out.print("\tD");
                        System.out.print("\tL");
                        System.out.print("\tK");
                        System.out.print("\tM");
                        System.out.print("\tJ");
                        System.out.print("\tV");
                        System.out.print("\tS");
                        System.out.print("\t\t|\t");
                        System.out.print("\tD");
                        System.out.print("\tL");
                        System.out.print("\tK");
                        System.out.print("\tM");
                        System.out.print("\tJ");
                        System.out.print("\tV");
                        System.out.print("\tS");
                        System.out.print("\t\t|\t");
                        System.out.print("\tD");
                        System.out.print("\tL");
                        System.out.print("\tK");
                        System.out.print("\tM");
                        System.out.print("\tJ");
                        System.out.print("\tV");
                        System.out.print("\tS");
                        System.out.print("\t\t|");
                        System.out.println();
                   }
                   System.out.print("\t"+abril[f][c]);
               }
               else if (c<14)
               {
                   if(c==7)
                   {
                      System.out.print("\t\t\t"); 
                   }
                   System.out.print("\t"+mayo[f][c-7]);
               }
               else
               {
                   if(c==14)
                   {
                      System.out.print("\t\t\t");  
                   }
                   System.out.print("\t"+junio[f][c-14]);
               }
            }
            System.out.println();
        }
        
        for(f=0;f<6;f++)
        {
            for(c=0;c<21;c++)
            {
               if(c<7)
               {
                   if(f==0 &&c==0)
                   {
                       System.out.println("\tAño: "+year);
                       System.out.print("\t\t\tJULIO");
                       System.out.print("\t\t\t\t\t\t\t\t\t\tAGOSTO");
                       System.out.println("\t\t\t\t\t\t\t\t\t\tSEPTIEMBRE");
                       System.out.print("\tD");
                        System.out.print("\tL");
                        System.out.print("\tK");
                        System.out.print("\tM");
                        System.out.print("\tJ");
                        System.out.print("\tV");
                        System.out.print("\tS");
                        System.out.print("\t\t|\t");
                        System.out.print("\tD");
                        System.out.print("\tL");
                        System.out.print("\tK");
                        System.out.print("\tM");
                        System.out.print("\tJ");
                        System.out.print("\tV");
                        System.out.print("\tS");
                        System.out.print("\t\t|\t");
                        System.out.print("\tD");
                        System.out.print("\tL");
                        System.out.print("\tK");
                        System.out.print("\tM");
                        System.out.print("\tJ");
                        System.out.print("\tV");
                        System.out.print("\tS");
                        System.out.print("\t\t|");
                        System.out.println();
                   }
                   System.out.print("\t"+julio[f][c]);
               }
               else if (c<14)
               {
                   if(c==7)
                   {
                      System.out.print("\t\t\t"); 
                   }
                   System.out.print("\t"+agosto[f][c-7]);
               }
               else
               {
                   if(c==14)
                   {
                      System.out.print("\t\t\t");  
                   }
                   System.out.print("\t"+septiembre[f][c-14]);
               }
            }
            System.out.println();
        }
        
        for(f=0;f<6;f++)
        {
            for(c=0;c<21;c++)
            {
               if(c<7)
               {
                   if(f==0 &&c==0)
                   {
                       System.out.println("\tAño: "+year);
                       System.out.print("\t\t\tOCTUBRE");
                       System.out.print("\t\t\t\t\t\t\t\t\t\tNOVIEMBRE");
                       System.out.println("\t\t\t\t\t\t\t\t\t\tDICIEMBRE");
                       System.out.print("\tD");
                        System.out.print("\tL");
                        System.out.print("\tK");
                        System.out.print("\tM");
                        System.out.print("\tJ");
                        System.out.print("\tV");
                        System.out.print("\tS");
                        System.out.print("\t\t|\t");
                        System.out.print("\tD");
                        System.out.print("\tL");
                        System.out.print("\tK");
                        System.out.print("\tM");
                        System.out.print("\tJ");
                        System.out.print("\tV");
                        System.out.print("\tS");
                        System.out.print("\t\t|\t");
                        System.out.print("\tD");
                        System.out.print("\tL");
                        System.out.print("\tK");
                        System.out.print("\tM");
                        System.out.print("\tJ");
                        System.out.print("\tV");
                        System.out.print("\tS");
                        System.out.print("\t\t|");
                        System.out.println();
                   }
                   System.out.print("\t"+octubre[f][c]);
               }
               else if (c<14)
               {
                   if(c==7)
                   {
                      System.out.print("\t\t\t"); 
                   }
                   System.out.print("\t"+noviembre[f][c-7]);
               }
               else
               {
                   if(c==14)
                   {
                      System.out.print("\t\t\t");  
                   }
                   System.out.print("\t"+diciembre[f][c-14]);
               }
            }
            System.out.println();
        }
        
    }               
    int[][] generarMes(int year, int m)
    {
        int dia, cont;
        cont=1;
        fecha newFecha = new fecha();
        newFecha.setDay(1);
        newFecha.setMonth(m);
        newFecha.setYear(year);
       
        dia = newFecha.dia_primero_enero(newFecha);
        
        int limiteMes=0;
        if(m==2)
        {
            if(bisiesto(newFecha))
            {
                limiteMes=29;
                
               
            }
            else
            {
                limiteMes=28;
            }
        }
        if(m == 1 || m==3 || m==5 || m==7 || m==8 || m==10 || m==12)
        {
            limiteMes=31;
        }
        if(m == 4 || m==6 || m==9 || m==11)
        {
            limiteMes=30;
        }
        int[][] mes = new int[6][7];
        int pasada=0;
        for(int f=0;f<6;f++)
        {
            for(int k=0; k<7;k++)
            {
                
                if(k>=dia && cont<=limiteMes)
                {
                    mes[f][k]=cont;
                    cont++;
                    
                }
                else if(pasada>0 && cont<=limiteMes)
                {
                    mes[f][k]=cont;
                    cont++;
  
                }
                else
                {
                          mes[f][k]=0;  
                }
                    
            }
            pasada++;
        }
        
        
        return mes;
    }
}
