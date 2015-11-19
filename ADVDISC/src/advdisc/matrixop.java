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
  
//  public void checkMatrix(){ //conforming to multiplication
//      if (a.returnRow()!=b.returnCol()){
//          System.out.println("The matrices you have entered cannot be multiplied.");
//          //print reason
//      } else if(!b.squareCheck()){ //divisor is not a square matrix
//          System.out.println("Your divisor is not a square matrix...");
//      }
//      
//  }
  
  public boolean hasZeroRow(matrix b){
      boolean check = false;
      for(int i=0; i<b.returnRow(); i++){
          for(int j=0; j<b.returnCol(); j++){
              if (b.returnValue(i,j)==0)
                  check = true;
              else check = false;
              
              if(j==b.returnCol()-1 && !check)
                break;
          }
          if (!check)
            break;
      }
      return check;
  }
  
  public void getInverse(matrix b){ //get inverse of B in order to multiply with A
      boolean done = false;
      
      //initializing augemented matrix for inverse
      //c will represent the original matrix, should be identity matrix after
      matrix c = new matrix(b.returnMatrix(), b.returnRow(), b.returnCol());
      //d will represent the identity matrix, should be the inverted matrix after
      matrix d = new matrix();
      d.defineCol(b.returnCol());
      d.defineRow(b.returnRow());
      d.defineMatrix();
      for(int i=0; i<d.returnRow(); i++){
          for(int j=0; j<d.returnCol(); j++){
              if(i==j)
                  d.changeValue(i, j, 1);
              else d.changeValue(i, j, 0);
          }
      }
      
      //preliminary checks
      if(b.returnCol()!=b.returnRow()){
          System.out.println("The matrix does not have an inverse because it is not a square matrix."
                  + "\n A square matrix is a matrix with n rows and n columns.");
      } else if (hasZeroRow(b)){
          System.out.println("Singular matrix! Row of zeroes detected!");  
      } else{
          //convert into inverse here
      }
  }
  
  public void multiplyMatrix(){
      matrix c = new matrix();
      float elem = 0;
      if(a.returnCol()!=b.returnRow()){
          System.out.println("Not conformable for multiplication!");
      } else{
          //initialize product matrix
          c.defineRow(a.returnRow());
          c.defineCol(b.returnCol());
          c.defineMatrix();
          
          //multiply here
          for(int x=0; x<c.returnRow(); x++){
              for(int y=0; y<c.returnCol(); y++){
                  for(int i=0; i<a.returnCol(); i++){
                      System.out.println("Multiplying element of A in row " + x + " and column " + i + 
                              " to element of B in row " + i + " and column " + y + ": " + 
                              a.returnValue(x, i) + "*" + b.returnValue(i, y));
                      System.out.println("Result: " + a.returnValue(x, i) * b.returnValue(i, y));
                      elem += (a.returnValue(x, i) * b.returnValue(i, y));
                  }
                  c.changeValue(x, y, elem);
//                  int i=0;
//                  //for each row in matrix A
//                  while(i<a.returnRow()){
//                      //get one column in matrix B
//                      for(int j=0; j<b.returnCol(); j++){
//                      //sum of multiplying all entries of one row of matrix A
//                      //to one column of matrix B
//                          
//                      }
//                      //initialize result
//                      i++;
//                  }
                  
              }//end col count for product matrix
          }//end row count for product matrix
          
          System.out.printf("Matrix A: ");
          a.displayMatrix();
          System.out.printf("\n Matrix B: ");
          b.displayMatrix();
          System.out.println("\n AB: ");
          c.displayMatrix();
          
      }//end else
      
  }//end multiplyMatrix
  
}//end class
