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
  
//  public matrix sortZero(matrix a){
//      boolean found = false;
//      boolean hasZero = false;
//      int zcount = 0;
//      float[] f, l;
//      matrix b = new matrix();
//      b.defineCol(a.returnCol());
//      b.defineRow(a.returnRow());
//      for(int i=0; i<b.returnRow(); i++){
//          for(int j=0; j<b.returnCol(); j++){
//              if(i==0 && j==0 && a.returnValue(i, j)==0){
//                  found = true;
//                  hasZero = true;
//                  f = a.returnMatrixRow(i);
//                  zcount++;
//              } else break;
//              if(i!=0 && j==0 && !found && a.returnValue(i, j)==0){
//                  found = true;
//                  f = a.returnMatrixRow(i);
//                  zcount++;
//              }
//              //swap rows here
//              zcount = 0;
////              if(found && a.returnValue(i, j)!=0){
////                  break;
////              }
//          }
//          
//      }
//      return b;
//  }
  
//  public matrix getAdjugate(matrix b){
//      matrix adj = new matrix();
//      return adj;
//  }
//  
//  public float getDeterminant(matrix b){
//     float det = 0;
//     return det;
//  }
  
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
                }
            }
            //let's zero the other entries on the same column
            //as the leading entry!
            for(int j=0; j<c.returnRow(); j++){
                float[] f = c.returnMatrixRow(i);
                for(int k=0; k<c.returnCol(); k++){
                    if(j!=i && c.returnValue(j, k)!=1){
                        float g = f[k]*c.returnValue(j, k)*-1;
                        c.changeValue(j, k, c.returnValue(j, k)+g);
                    }
                }
                System.out.println("Partial result:");
                c.displayMatrix();
            }
            System.out.println("After Gauss-Jordan:");
            c.displayMatrix();
          }
      }//end else
  }//end getInverse
  
  public void multiplyMatrix(matrix a, matrix b){
      if(a.returnCol()!=b.returnRow()){
          System.out.println("Not conformable for multiplication!");
      } else{
          
      }
  }
}
