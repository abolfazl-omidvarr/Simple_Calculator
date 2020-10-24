package calculator;

public class calculation {

    private double a, b;

    public calculation() {

    }


    public calculation(double a, double b, int op) {


    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double plus() {
        return this.a + this.b;
    }

    public double prod() {
        return this.a * this.b;
    }

    public double devis() {
        return this.a / this.b;
    }

    public double minus() {
        return this.a - this.b;
    }

    public double loop1(double result,double a, String op) {

        switch (op) {
            case "+" -> {
                 result +=a;
            }
            case "-" -> {
                 result -=a;
            }
            case "*" -> {
                result *=a;
            }
            case "/" -> {
                 result /=a;
            }
        }
        return result;
    }
}
