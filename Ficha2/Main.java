package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
    /*
    //formas de declarar arrays
	int[] colecao = new int[100];
	int[] temperaturas = {12,26,43,54,67,23};
	double[] notas = {12.5,10.1,9.5,16.1};
	short matriz [][] = new short [10][50];
    int len = temperaturas.length;
    for ( int i =0; i < notas.length ; i ++)
		System.out.println( notas[ i ] ) ;
	}
	*/




	/*	EXERCICIO 1.a
	Ficha2Ex1 f = new Ficha2Ex1();

	Scanner sc = new Scanner(System.in);
	int valor = 0;
	System.out.print(" Número de inteiros a ler ?: ");
	int n = sc.nextInt();
	int[] valores = new int[n];
	for (int i = 0; i < n; i++) {
		valor = sc.nextInt();
		valores[i] = valor;
		}
	System.out.println("O mínimo é: "+f.minimo(valores));
	 */



	/* EXERCICIO 1.b
	Ficha2Ex1 f = new Ficha2Ex1();
	int[] a ={1,2,3,4,5,6,7,8,9,10};
	int[] res = f.subArray(a,3,5);
	for(int i=0; i<res.length; i++){System.out.println(res[i]);}
	*/



	/* EXERCICIO 1.c
	Ficha2Ex1 f = new Ficha2Ex1();
	int[] a = {2,4,6,8};
	int[] b = {3,4,5,8};
	int[] res = f.comuns(a,b);
	for(int i=0; i<res.length; i++){System.out.println(res[i]);}




	/* EXERCICIO 2.a
	Ficha2Ex2 t = new Ficha2Ex2();
	int[][] p = new int[3][3];
	Scanner is = new Scanner(System.in);
	for(int i=0; i<(p.length); i++) {
		for(int j=0; j<(p[i].length); j++){
			System.out.print("Aluno "+i+" UC: "+j+": ");
			p[i][j] = is.nextInt();
		}
	}
	t.setNotasTurma(p);
	System.out.println(Arrays.deepToString(p));
	System.out.println(Arrays.deepToString(t.getNotasTurma()));
	*/

	}
}
