import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.util.Arrays;

/**
 *
 */
public class Main {
    /**
     * Number of examples
     */
    private int N;


    public Main(String[] args){
        String filename = args[0];
        List<Feature.Generator<Integer>> discrete_features = new ArrayList<Feature.Generator<Integer>>();
        List<Feature.Generator<Double>> continuous_features = new ArrayList<Feature.Generator<Double>>();
        List<Record<String>> records;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));

            try {
                String line = null;
                String[] tokens, tokens2;

                line = reader.readLine();
                tokens = line.split(",");

                N = Integer.parseInt(tokens[0]);

                for (int i = 1; i < tokens.length - 1; i++) {

                    tokens2 = tokens[i].split(":");
                    if (Integer.parseInt(tokens2[1]) == 0)
                        discrete_features.add(new Feature.Generator<Integer>(tokens2[0], Feature.Type.DISCRETE));
                    else
                        continuous_features.add(new Feature.Generator<Double>(tokens2[0], Feature.Type.CONTINUOUS));

                }

            }
            catch (IOException e) {
                System.out.println(e);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println(e);
        }

        System.out.println("Discrete features: ");
      for (Feature.Generator<Integer> d : discrete_features) {
        System.out.println(d.getTitle());
      }

      System.out.println("Continuous features: ");
      for (Feature.Generator<Double> c : continuous_features) {
          System.out.println(c.getTitle());
      }
    }

     public static void main(final String[] args) {
        if (args.length < 1)
            System.exit(1);

        new Main(args);
        System.exit(0);
    }

}