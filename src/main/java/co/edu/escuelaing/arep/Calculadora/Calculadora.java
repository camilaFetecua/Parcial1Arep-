package co.edu.escuelaing.arep.Calculadora;

public class Calculadora {
    public static String getCos(Double n) {
        try {
            Double rta = Math.cos(Double.parseDouble(String.valueOf(n)));
            return rta .toString();
        } catch (Exception e) {
            return "Error al sacar el coseno";
        }
    }
    public static String getTan(Double n) {
        try {
            Double rta  = Math.tan(Double.parseDouble(String.valueOf(n)));
            return rta .toString();
        } catch (Exception e) {
            return "Error al sacar la tangente";
        }
    }
    public static String getSen(Double n) {
        try {
            Double rta  = Math.sin(Double.parseDouble(String.valueOf(n)));
            return rta .toString();
        } catch (Exception e) {
            return "Error al sacar el seno";
        }
    }


    public  static String getRespuesta(String calcular,String n) {
        try {
            switch(calcular){
                case "/sin":
                    return '{'+"'data':"+getCos(Double.parseDouble(n))+'}';
                case "/cos":
                    return '{'+"'data}':"+getTan(Double.parseDouble(n))+'}';
                case "/tan":
                    return '{'+"'data':"+getSen(Double.parseDouble(n))+'}';

                case "/error":
                    return '{'+"'no se encuentra'"+'}';

                default:
                    return '{'+"'calcular':'no se encuentra'"+'}';
            }
        }catch(NumberFormatException e){
            return '{'+"'calcular':'no se encuentra'"+'}';
        }
    }


}

