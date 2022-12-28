package viewClasses;

public class Calculator {

    private double res = Double.MIN_VALUE;

    public Calculator(String action, int a, int b) {
        this.res = res;

        switch (action) {
            case "mult":
                res = a * b;
                break;
            case "div":
                res = a / (double) b;
                break;
            case "sub":
                res = a - b;
                break;
            case "add":
                res = a + b;
                break;

        }
    }

    public double getRes() {
        return res;
    }
}