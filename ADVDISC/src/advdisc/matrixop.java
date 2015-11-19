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
  
  public boolean hasZeroRow(matrix b){
      int zero = 0;
      for(int i=0; i<b.returnRow(); i++){
          for(int j=0; j<b.returnCol(); j++){
              if (b.returnValue(i,j)==0){
                  zero++;
              }
          }
          if(zero==b.returnCol())
            return true;
          zero = 0;
      }
      return false;
  }
  
  public boolean isIdentityMatrix(matrix b){
      boolean identity = false;
      for(int i=0; i<b.returnRow(); i++){
          for(int j=0; j<b.returnCol(); j++){
              if(i==j && b.returnValue(i, j)==1)
                  identity = true;
              else if (i!=j && b.returnValue(i, j)==0)
                  identity = true;
              else identity = false;
          }//end inner for
      }//end outer for
      return identity;
  }
  
  public int getLeadingEntry(float[] b){
     int i;
     System.out.printf("Row entries: ");
     for(int j=0; j<b.length; j++){
         System.out.printf("%.2f ", b[j]);
     }
     for(i=0; i<b.length; i++){
        if(b[i]!=0)
          break;
     }
     return i;
  }
  
  //get inverse of matrix using elementary row operations
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
          //gauss-jordan c & d!
          float lead = 0;
          for(int i=0; i<c.returnRow(); i++){
            //get leading entry
            lead = c.returnValue(i, getLeadingEntry(c.returnMatrixRow(i)));
            System.out.println("Leading entry is " + lead);
            for(int j=0; j<c.returnCol(); j++){
                if(c.returnValue(i, j)!=0){
                   float g = c.returnValue(i, j)/lead;
                   c.changeValue(i, j, g);
                   g = d.returnValue(i, j)/lead;
                   d.changeValue(i, j, g);
                }
                System.out.println("Partial result: \n c:");
                c.displayMatrix();
                System.out.println("\n d:");
                d.displayMatrix();
            }
            //let's zero the other entries on the same column
            //as the leading entry!
            for(int j=0; j<c.returnRow(); j++){
                float[] f = c.returnMatrixRow(i);
                for(int k=0; k<c.returnCol(); k++){
                    if(j!=i && c.returnValue(j, k)!=1){
                        float g = f[k]*c.returnValue(j, k)*-1;
                        c.changeValue(j, k, c.returnValue(j, k)+g);
                        d.changeValue(j, k, d.returnValue(j, k)+g);
                    }
                }
                System.out.println("Partial result: \n c:");
                c.displayMatrix();
                System.out.println("\n d:");
                d.displayMatrix();
            }
            System.out.println("After Gauss-Jordan: \n c:");
                c.displayMatrix();
                System.out.println("\n d:");
                d.displayMatrix();
            if(isIdentityMatrix(c)){
                System.out.println("Your inverse is:");
                d.displayMatrix();
            } else{
                System.out.println("Your matrix is singular!");
            }
          }
      }//end else
  }//end getInverse
  
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
}