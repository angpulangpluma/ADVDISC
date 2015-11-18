/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advdisc;

/*
* Created on: 11-17-2015
* Desc: program that defines and does operations on a defined matrix;
*   school requirement for ADVDISC for SY 2015-2016 T1
* Authors: Marienne Lopez & Arces Talavera
*/

class matrix{
    float[][] m;
    int row, col;
    
    //define matrix
    public matrix(float[][] a, int row, int col){
        m = a;
        this.row = row;
        this.col = col;
    }
    
    public matrix(){
        
    }
    
    public void defineRow(int row){
       this.row = row;
    }
    
    public void defineCol(int col){
        this.col = col;
    }
    
    public int returnRow(){
        return this.row;
    }
    
    public int returnCol(){
        return this.col;
    }
    
    public void defineMatrix(){
        m = new float[row][col];
    }
    
    //check if matrix is square
    public boolean squareCheck(){
        boolean accept = true;
        if (this.row != this.col)
            accept = false;
        return accept;
    }
    
    public float[][] returnMatrix(){
        return this.m;
    }
    
    public void changeValue(int row, int col, float value){
        m[row][col] = value;
//        System.out.println("Value entered - " + m[row][col]);
    }
    
    public void displayMatrix(){
        for(int i=0; i<returnRow(); i++){
            System.out.println("[");
            for(int j=0; j<returnCol(); j++){
                System.out.println(m[i][j] + " ");
            }
            System.out.println("]");
        }
    }

}
