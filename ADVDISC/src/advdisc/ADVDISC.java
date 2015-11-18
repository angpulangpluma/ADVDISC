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
    public static void main(String[] args) {
        // TODO code application logic here
        matrixop r = new matrixop();
        matrix m = new matrix();
        Scanner sc = new Scanner(System.in);
        String in = "";
        int input;
        System.out.println("Welcome! Enter number of rows of first matrix: ");
        while(true){
            in = sc.next();
            try{
                input = Integer.parseInt(in);
                if (input>0)
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
                input = Integer.parseInt(in);
                if (input>0)
                    break;
            } catch(IllegalArgumentException e){
                System.out.println("Please enter a valid integer.");
                e.printStackTrace();
            }
        }
        m.defineCol(input);
        if(!m.matrixCheck()){
            System.out.println("We will not continue this. Your matrix must have" +
                    "the same number of columns and rows.");
        } else{
            //insert operation here
        }
    }

}
