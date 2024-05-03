package Lectura;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    // Definimos la ruta del archivo CSV a leer
    private String filePath;

    // Constructor que recibe la ruta del archivo CSV
    public CSVReader(String filePath) {
        this.filePath = filePath;
    }

    // Método para leer el archivo CSV y almacenar sus registros en una lista de arreglos de cadenas
    public List<String[]> readCSV() throws IOException {
        // Lista para almacenar los registros del archivo CSV
        List<String[]> records = new ArrayList<>();
        // Utilizamos un try-with-resources para garantizar que el recurso BufferedReader se cierre correctamente al finalizar
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Iteramos sobre cada línea del archivo CSV
            while ((line = br.readLine()) != null) {
                // Dividimos la línea en valores utilizando una expresión regular para manejar correctamente las comillas
                String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                // Agregamos los valores a la lista de registros
                records.add(values);
            }
        }
        // Devolvemos la lista de registros del archivo CSV
        return records;
    }
}
