import java.util.ArrayList;

public class Trial {
    private String cadenaParaComprimir;
    private ArrayList<Tupla> reduccion;
    private int frecuenciaRevision;

    public Trial(String cadena) {
        this.cadenaParaComprimir = cadena;
        this.reduccion = new ArrayList<>();
        this.frecuenciaRevision = 4;
    }

    public void reducirTamaño() {
        char numeroActual;
        String prefix = "";
        boolean finalizar = false, empezar = false;
        int indexFinal, moverseAtras;
        for (int i = 0; i < this.cadenaParaComprimir.length(); i++) {
            String cadenaActual = this.cadenaParaComprimir.substring(i, i + 4);
            numeroActual = this.cadenaParaComprimir.charAt(i);
            if (!prefix.contains(cadenaActual)) {
                prefix += "" + numeroActual;
                this.reduccion.add(new Tupla(0, 0, numeroActual));
            } else {
                String maxSubString = "";
                int actual = 0, indexActual = 0;
                boolean start = false,;
                String subString = "";
                for (int j = 0; j < prefix.length()&&(indexActual<cadenaActual.length()); ++j) {
                    if (prefix.charAt(j) == numeroActual && !start) {
                        start = true;
                        indexActual++;
                    } else if (prefix.charAt(j) == cadenaActual.charAt(indexActual)) {
                        subString += prefix.charAt(j);
                        indexActual++;
                    } else if (prefix.charAt(j) != cadenaActual.charAt(indexActual) && start) {
                        start = false;
                        indexActual=0;
                        if(subString.length()>maxSubString.length()){
                            maxSubString = subString;
                        }
                        subString = "";
                    }
                }
                if(subString.length()>maxSubString.length()){
                    maxSubString = subString;
                }
                
            }
        }
    }

}