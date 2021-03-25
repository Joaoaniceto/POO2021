package com.company;

import com.sun.source.util.SourcePositions;

import java.net.SocketOption;

public class Ficha2Ex1 {
    //EXERCICIO 1.a
    public int minimo(int[] a){
        int min = a[0], elem;
        for(int i=1; i<a.length; i++) {
            elem = a[i];
            if (elem<min){
                min=elem;
            }
        }
        return min;
    }
    //EXERCICIO 1.b
    public int[] subArray(int[] a,int i,int j ){
        if(i>j || j>a.length || i<0 || j<0)
            return null;
        int tam = j-i+1;
        int[] res = new int[tam];

        System.arraycopy(a,i,res,0,tam);
        return res;
    }
    //EXERCICIO 1.c
    private boolean existe(int[] r, int N, int e){
        boolean bool = false;
        for(int k=0; k<N && !bool; k++){
            bool = (r[k]==e);
        }
        return bool;
    }
    public int[] comuns(int[] a, int[] b){
        int[] temp = new int[a.length];
        int cont = 0;
        for(int elem: a){
            boolean enc = this.existe(temp,cont,elem);
            for (int j=0;j<b.length && !enc;j++){
                if(elem == b[j]) {
                    temp[cont++]=elem;
                    enc=true;
                }
            }
        }
        int[] res = new int[cont];
        System.arraycopy(temp,0,res,0,cont);
        return res;
    }
}
