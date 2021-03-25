package com.company;

public class Ficha2Ex2 {

    private int[][] notasTurma;

    //Construtor Vazio
    public Ficha2Ex2() {
        this.notasTurma = new int [3][3];
    }

    public void setNotasTurma(int[][] notas){
        for(int i=0; i<notasTurma.length; i++)
            for(int j=0; j<notasTurma.length; j++)
                notasTurma[i][j]=notas[i][j];
    }

    public int[][] getNotasTurma(){
        return this.notasTurma;
    }

    public float mediaAluno(int nmrAl) {
        int soma = 0;
        for (int i = 0; i < this.notasTurma.length; i++) {
            soma += notasTurma[nmrAl][i];
        }
        return soma/(float)notasTurma.length;
    }

}

