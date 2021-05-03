import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;

public class Reader {

    public static double maxLatitud;
    public static double minLatitud;

    public static double maxLongitud;
    public static double minLongitud;

    public static double maxAltura;
    public static double minAltura;

    public static ArrayList<Bee> abejas;

    public static void findBounds() {
       
        double maxLongitud = -342131.00000000;
        double minLongitud = 342131.00000000;

        double maxLatitud = -342131.00000000;
        double minLatitud = 342131.00000000;

        double maxAltura = -342131.00000000;
        double minAltura = 342131.00000000;

        for (int i = 0; i < abejas.size(); i++) {
            if (abejas.get(i).altura < minAltura) {
                minAltura = abejas.get(i).altura;
            }
            if (abejas.get(i).altura > maxAltura) {
                maxAltura = abejas.get(i).altura;
            }
            if (abejas.get(i).latitud < minLatitud) {
                minLatitud = abejas.get(i).latitud;
            }
            if (abejas.get(i).latitud > maxLatitud) {
                maxLatitud = abejas.get(i).latitud;
            }
            if (abejas.get(i).longitud < minLongitud) {
                minLongitud = abejas.get(i).longitud;
            }
            if (abejas.get(i).longitud > maxLongitud) {
                maxLongitud = abejas.get(i).longitud;
            }
        }

        Reader.maxLatitud = maxLatitud;
        Reader.minLatitud = minLatitud;

        Reader.maxLongitud = maxLongitud;
        Reader.minLongitud = minLongitud;

        Reader.maxAltura = maxAltura;
        Reader.minAltura = minAltura;
    }

    public static ArrayList<Bee> Read(String fileName) {

        ArrayList<Bee> listaAbejas = new ArrayList<Bee>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String strCurrentLine;

            while ((strCurrentLine = br.readLine()) != null) {

                String[] line = strCurrentLine.split(",");
                Bee newBee = new Bee(Double.parseDouble(line[0]), Double.parseDouble(line[1]),
                        Double.parseDouble(line[2]));
                listaAbejas.add(newBee);

            }
            Reader.abejas = listaAbejas;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaAbejas;

    }

}