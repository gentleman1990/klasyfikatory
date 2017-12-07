import type.Iris;
import type.TTOM;
import type.TTOMGrafana;
import type.Wine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.NoSuchObjectException;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Jakub on 2016-06-13.
 */
public class ImportData {

    public Collection<Object> importToCollection(String csvFile,String csvName) {

        //String csvFile = "C:\\Users\\socha\\Documents\\DaneTestowe\\";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        Collection<Object> importSet = new HashSet<>();

        try {

            br = new BufferedReader(new FileReader(csvFile+csvName));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                line = line.replace(",",".");
                String[] word = line.split(cvsSplitBy);

                checkCompletnessOfData(word);
                if(!checkCompletnessOfData(word))
                    System.out.println("Not enough data to run AI system!");
                else if(csvName.equals("iris_data.csv"))
                    importSet.add(new Iris(Double.parseDouble(word[0]),Double.parseDouble(word[1]),Double.parseDouble(word[2]),Double.parseDouble(word[3]),word[4]));
                else if (csvName.equals("wine_data.csv"))
                    importSet.add(new Wine(Double.parseDouble(word[1]),Double.parseDouble(word[2]),Double.parseDouble(word[3]),Double.parseDouble(word[4]),Double.parseDouble(word[5]),Double.parseDouble(word[6]),Double.parseDouble(word[7]),Double.parseDouble(word[8]),Double.parseDouble(word[9]),Double.parseDouble(word[10]),Double.parseDouble(word[11]),Double.parseDouble(word[12]),Double.parseDouble(word[13]),word[0]));
                else if (csvName.equals("ttom_data.csv"))
                    importSet.add(new TTOM(Integer.parseInt(word[2]),Integer.parseInt(word[3]),Integer.parseInt(word[4]),Integer.parseInt(word[5]),Integer.parseInt(word[6]),Integer.parseInt(word[7]),word[8]));
                else if (csvName.equals("ttom_data_grafana.csv")||csvName.equals("grafanaData15Minutes.csv"))
                    importSet.add(new TTOMGrafana(Double.parseDouble(word[2]),Double.parseDouble(word[3]),Double.parseDouble(word[4]),Double.parseDouble(word[5]),Double.parseDouble(word[6]),Double.parseDouble(word[7]),Double.parseDouble(word[8]),Double.parseDouble(word[9]),Double.parseDouble(word[10]),Double.parseDouble(word[11]),Double.parseDouble(word[12]),Double.parseDouble(word[13]),Double.parseDouble(word[14]),Double.parseDouble(word[15]),Double.parseDouble(word[16]),Double.parseDouble(word[17]),Double.parseDouble(word[18]),Double.parseDouble(word[19]),Double.parseDouble(word[20]),Double.parseDouble(word[21]),word[0]));
                else
                    throw new NoSuchObjectException("We don't support that type of object !\n Please implement missing functionality for file: " + csvName);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Import Done");
        return importSet;
    }

    private boolean checkCompletnessOfData(final String[] word) {
        for (String w:word)
        {
            if(w.equals("") || w.equals(null)){
                return false;
            }
        }
        return true;
    }
}
