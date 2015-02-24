import java.util.ArrayList;

/**
 * Created by Kubish on 12.02.2015.
 */
public class Bikv {
    //Obrabotchik oshibok
    public static void error(int err) {
        switch (err) {
            case 1:
                System.out.println("No roots in the set of real numbers.");
                break;
            case 2:
                System.out.println("This is not bikvadrat equation");
                break;
            default:
                System.out.println("Error is not find");

        }
    }

    // Nepolnoe bikvadratnoe uravnenie
    public static void NotFullBikvadrat(double a, double c) {
        double res = 0;
        ArrayList<Double> resolveList = new ArrayList<Double>();
        if (c == 0)    // if 1 root
        {
            res = 0;
            resolveList.add(res);
            System.out.println("x1= " + resolveList.get(0));
        } else {
            res = c / a;
            if (res < 0)  //not root
                error(1);
            else {
                res = Math.sqrt(res);
                resolveList.add(Math.sqrt(res));
                resolveList.add(-(Math.sqrt(res)));
                System.out.println("Resolve");
                System.out.println("x1= " + resolveList.get(0));
                System.out.println("x2= " + resolveList.get(1));
            }
        }
    }


    // Polnoe bikvadratnoe uravnenie
    public static void FullBikvadrat(double a, double b, double c) {
        ArrayList<Double> resolveList = new ArrayList<Double>(); // massive roots
        double diskr = 0; //diskremenant;
        // reshim 4y^2-5y+1=0
        System.out.println("y=x^2 then equation wil type 4y^2-5y+1=0");
        diskr = b * b - 4 * a * c;
        System.out.println("The discriminant = " + diskr);
        if (diskr < 0) {
            error(1);             // No root;
        } else if (diskr == 0)           // 2 kornya
        {
            double y1;
            y1 = (-b) / (2 * a);
            if (y1 > 0) {
                System.out.println("y=" + y1);
                //x^2=y;
                System.out.println("x^2=" + y1);
                System.out.println();
                resolveList.add(Math.sqrt(y1));
                resolveList.add(-(Math.sqrt(y1)));
                System.out.println("Resolve");
                System.out.println("x1= " + resolveList.get(0));
                System.out.println("x2= " + resolveList.get(1));
            } else if (y1 < 0) {
                error(1); //Not root
            }
        } else {       //diskriminant >0
            double y1, y2; // promegut  roots
            y1 = (-b + Math.sqrt(diskr)) / (2 * a);
            System.out.println("y1=" + y1);
            y2 = (-b - Math.sqrt(diskr)) / (2 * a);
            System.out.println("y2=" + y2);
            if ((y1 < 0) && (y2 < 0)) {   // Not roots
                error(1);
            } else             // Find 1st two roots
            {
                if (y1 == 0)      //One root
                {
                    resolveList.add(y1);
                } else if (y1 > 0)   //Two root
                {
                    resolveList.add(Math.sqrt(y1));
                    resolveList.add(-(Math.sqrt(y1)));
                }
                // Find Second two roots
                if (y2 == 0)      //One root
                {
                    resolveList.add(y2);
                } else if (y2 > 0)   //Two root
                {
                    resolveList.add(Math.sqrt(y2));
                    resolveList.add(-(Math.sqrt(y2)));
                }
                // Vivod korney
                for (int i = 0; i < resolveList.size(); i++) {
                    System.out.println("x" + (i + 1) + " =" + resolveList.get(i));
                }
            }
        }
    }


    // ax^4+bx^2+c=0
    public static void main(String argc[]) {
        System.out.println("This program finds the solution of the equation type of ax^4+bx^2+c=0");
        double a = 4;
        double b = -5;
        double c = 1;
        if (a == 0)   //proverka bikvadratnogo uravnenia
        {
            error(2); // uravnenie ne yavlyaetsa bikvadratim
        } else if (b == 0) NotFullBikvadrat(a, c); // NePolnoe bikvadratnoe uravnenie
        else FullBikvadrat(a, b, c);       //  // Polnoe bikvadratnoe uravnenie
    }
}