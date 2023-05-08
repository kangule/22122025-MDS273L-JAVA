import java.io.File;
import java.util.Scanner;

class lab7 {

    static float mean(String[] arr) {
        float sum = 0;
        for(int i=0;i< arr.length;i++){
            sum += Float.parseFloat(arr[i]);
        }
        return sum/arr.length;
    }

    public static void main(String[] args) {

        try {
            File iris = new File("Iris.csv");
            Scanner scan = new Scanner(iris);

            String[] header = new String[6];
            String[][] irisData = new String[150][6];
            int counter = 0;

            while (scan.hasNextLine()) {
                // System.out.println(scan.nextLine());
                if (counter == 0) {
                    header = scan.nextLine().split(",");
                } else {
                    irisData[counter - 1] = scan.nextLine().split(",");
                }
                counter += 1;
            }

            for (int row = 0; row < irisData.length; row++) {
                for (int col = 0; col < irisData[row].length; col++) {
                    System.out.print("\t" + irisData[row][col]);
                }
                System.out.println();
            }

            for (int i = 1; i <= 4; i++) {
                System.out.print(header[i] + "\t : \t");
                String[] temp = new String[150];
                for (int row = 0; row < irisData.length; row++) {
                       temp[row] =  irisData[row][i];               
                }
                System.out.print(mean(temp));
                System.out.println("");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
