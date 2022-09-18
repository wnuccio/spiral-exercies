package exes.removal;

public class Numbers {
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
