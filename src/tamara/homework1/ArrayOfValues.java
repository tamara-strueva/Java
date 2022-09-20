package tamara.homework1;

import java.util.*;

public class ArrayOfValues {
    int[] arrayOfValues, arrayOfWeights;


    public ArrayOfValues(int[] arrayOfValues, int[] arrayOfWeights) {
        this.arrayOfValues = arrayOfValues;
        this.arrayOfWeights = arrayOfWeights;
    }

    public void getElement() {
        ArrayList<Integer> massive = new ArrayList<>();

        for (int i = 0; i < arrayOfValues.length; i++){
//            for (int j = 0; j < arrayOfWeights.length; j++) {
                for (int k = 0; k < arrayOfWeights[i]; k++) {
                    int e = arrayOfValues[i];
                    massive.add(e);
                }
//            }
        }

//        System.out.println(Arrays.toString(new ArrayList[]{massive}));
        Random random = new Random();
        int randomIndex = random.nextInt(massive.size());
        int element = massive.get(randomIndex);
        System.out.println(element);
    }
}
