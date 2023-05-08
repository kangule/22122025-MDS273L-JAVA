import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Lab7 {

    public static void main(String[] args) {
        // Load the iris dataset
        ArrayList<Double> sepalLengthList = new ArrayList<Double>();
        ArrayList<Double> sepalWidthList = new ArrayList<Double>();
        ArrayList<Double> petalLengthList = new ArrayList<Double>();
        ArrayList<Double> petalWidthList = new ArrayList<Double>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("iris.data"));
            String line = reader.readLine();
            while (line != null) {
                String[] values = line.split(",");
                sepalLengthList.add(Double.parseDouble(values[0]));
                sepalWidthList.add(Double.parseDouble(values[1]));
                petalLengthList.add(Double.parseDouble(values[2]));
                petalWidthList.add(Double.parseDouble(values[3]));
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Calculate the overall 5-point summary for the four attributes
        ArrayList<Double> sepalLengthSorted = new ArrayList<Double>(sepalLengthList);
        Collections.sort(sepalLengthSorted);
        ArrayList<Double> sepalWidthSorted = new ArrayList<Double>(sepalWidthList);
        Collections.sort(sepalWidthSorted);
        ArrayList<Double> petalLengthSorted = new ArrayList<Double>(petalLengthList);
        Collections.sort(petalLengthSorted);
        ArrayList<Double> petalWidthSorted = new ArrayList<Double>(petalWidthList);
        Collections.sort(petalWidthSorted);

        double sepalLengthMean = calculateMean(sepalLengthList);
        double sepalLengthMedian = calculateMedian(sepalLengthSorted);
        double sepalLengthMin = sepalLengthSorted.get(0);
        double sepalLengthMax = sepalLengthSorted.get(sepalLengthSorted.size() - 1);

        double sepalWidthMean = calculateMean(sepalWidthList);
        double sepalWidthMedian = calculateMedian(sepalWidthSorted);
        double sepalWidthMin = sepalWidthSorted.get(0);
        double sepalWidthMax = sepalWidthSorted.get(sepalWidthSorted.size() - 1);

        double petalLengthMean = calculateMean(petalLengthList);
        double petalLengthMedian = calculateMedian(petalLengthSorted);
        double petalLengthMin = petalLengthSorted.get(0);
