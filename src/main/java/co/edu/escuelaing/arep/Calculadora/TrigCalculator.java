package co.edu.escuelaing.arep.Calculadora;

public class TrigCalculator {
    public double n;
    public String calcular;


    public TrigCalculator(double n, String calcular) {
        this.n = n;
        this.calcular = calcular;
    }

    public double getRta(){
        double rta=0;
        if(calcular.equals("sin")){
            rta = Math.sin(n);
        }else if (calcular.equals("cos")){
            rta = Math.cos(n);
        }else if (calcular.equals("tan")){
            rta = Math.tan(n);
        }
        return rta;
    }
}
