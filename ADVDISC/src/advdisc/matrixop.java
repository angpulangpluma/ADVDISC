/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advdisc;

/**
 *
 * Created on: 11-17-2015
 * Desc: program that defines and does operations on a defined matrix;
 *   school requirement for ADVDISC for SY 2015-2016 T1
 * Authors: Marienne Lopez & Arces Talavera
 */
public class matrixop {
  matrix a, b;
  matrix result;
  
  public void defineFirstMatrix(matrix a){
      this.a = a;
  }
  
  public void defineSecondMatrix(matrix b){
      this.b = b;
  }
  
  public void checkMatrix(){ //conforming to multiplication
      if (a.returnRow()!=b.returnCol()){
          System.out.println("The matrices you have entered cannot be multiplied.");
          //print reason
      }
      
  }
  
  public void getInverse(){ //get inverse of B in order to multiply with A
      
  }
}
