package removal;

public class Numbers {
    /*
            [2, 3, 3, 3, 3, 3, 4]

            toRemove: 3
           [2, 3, 4, 3, 2, 4]
           [2, 4, 3, 4], length: 4

           indexToModify: 0;
           i

           if (current number matches toRemove)
            increment currentIndex
           else if (is there any free positions i.e. indexToModify < numbers.length)
            insert current value into first free position: indexToModify
            increment indexToModify
     */

    public static int remove(int[] numbers, int toRemove) {
        int indexToModify = 0;
        for (int i=0; i<numbers.length; i++) {
            int current = numbers[i];
            if (current != toRemove){
                numbers[indexToModify] = current;
                indexToModify++;
            }
        }
        return indexToModify;
    }
}
