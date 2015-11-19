/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package advdisc;

import java.util.Scanner;

/**
 *
 * @author Marienne Lopez
 */
public class ADVDISC {

    /**
     * @param args the command line arguments
     */
    
    public static matrix inputMatrix(){
        matrix m = new matrix();
        Scanner sc = new Scanner(System.in);
        String in = "";
        int input;
        float elem;
        System.out.println("Welcome! Enter number of rows of matrix: ");
        while(true){
            in = sc.next();
            try{
                do{
                  input = Integer.parseInt(in);
                  if(input>0)
                      break;
                  else System.out.println("Please enter a valid integer.");
                }while(input<=0);
                break;
            } catch(IllegalArgumentException e){
                System.out.println("Please enter a valid integer.");
                e.printStackTrace();
            }
        }
        m.defineRow(input);
        System.out.println("Welcome! Enter number of columns of matrix: ");
        while(true){
            in = sc.next();
            try{
                do{
                  input = Integer.parseInt(in);
                  if(input>0)
                      break;
                  else System.out.println("Please enter a valid integer.");
                }while(input<=0);
                break;
            } catch(IllegalArgumentException e){
                System.out.println("Please enter a valid integer.");
                e.printStackTrace();
            }
        }
        m.defineCol(input);
        m.defineMatrix();
        for(int i=0; i<m.returnRow(); i++){
            for(int j=0; j<m.returnCol(); j++){
                System.out.println("Enter value of element in row " + i + " in column " + j + ": ");
                while(true){
                    in = sc.next();
                    try{
                        elem = Float.parseFloat(in);
//                        System.out.println("Entered - " + elem);
                        m.changeValue(i, j, elem);
                        break;
                    } catch(IllegalArgumentException e){
                        System.out.println("Please enter a valid element.");
                        e.printStackTrace();
                    }
                }
            }//end inner
        }//end outer
        
        System.out.println("Your matrix: ");
        m.displayMatrix();
        return m;
        
    }//end inputMatrix
    
    public static void main(String[] args) {
        // TODO code application logic here
        matrixop op = new matrixop();
        op.defineFirstMatrix(inputMatrix());
        op.defineSecondMatrix(inputMatrix());
        op.multiplyMatrix();
    }//end main

}//end test class
