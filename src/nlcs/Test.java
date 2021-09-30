/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nlcs;

/**
 *
 * @author nguyen
 */
public class Test {

    public static void main(String[] args) {
        String strNumber1 = "9090001";
        String strNumber2 = "101";

        BigInt num1 = new BigInt(strNumber1);
        BigInt num2 = new BigInt(strNumber2);

//        num1.sub(num2);
//        num1.sub(num2);
//        num1.add(num2);
//        num1.mul(num2);
          num1.div(num2);
//        num1.print();
//          num1.div(num2);
          num1.print();
//           System.out.println(num1.);
    }
}
