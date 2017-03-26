/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package detectionofimage.binmodel;

/**
 *
 * @author linuxraju
 */
public class BinValue {
     public static double bin1=0.0;
     public static double bin2=0.0;
     public static double bin3=0.0;
     public static double bin4=0.0;
     public static double bin5=0.0;
     public static double bin6=0.0;
     public static double bin7=0.0;
     public static double bin8=0.0;
     public static int actual_total=0;
    public double getBin1() {
        return bin1;
    }

    public void setBin1(double bin1) {
        this.bin1 = bin1;
        
    }

    public double getBin2() {
        return bin2;
    }

    public void setBin2(double bin2) {
        this.bin2 = bin2;
    }

    public double getBin3() {
        System.out.println("hi"+this.bin3);
        return bin3;
        
        
    }

    public void setBin3(double bin3) {
        this.bin3 = bin3;
        System.out.println(bin3);
    }

    public double getBin4() {
        return bin4;
    }

    public void setBin4(double bin4) {
        this.bin4 = bin4;
    }

    public double getBin5() {
        return bin5;
    }

    public void setBin5(double bin5) {
        this.bin5 = bin5;
    }

    public double getBin6() {
        return bin6;
    }

    public void setBin6(double bin6) {
        this.bin6 = bin6;
    }

    public double getBin7() {
        return bin7;
    }

    public void setBin7(double bin7) {
        this.bin7 = bin7;
    }

    public double getBin8() {
        return bin8;
    }

    public void setBin8(double bin8) {
        this.bin8 = bin8;
    }

    public void setTotalPixel(int actual_total) {
        this.actual_total=actual_total;
    }
public int getTotalPixel(){
return actual_total;
}
   


    
     
     
     
          
     
    
}
