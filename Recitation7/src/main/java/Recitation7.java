public class Recitation7 {
    /*
     * You may add any private helper method you see necessary,
     * but you may NOT change the signatures of the methods below.
     */
    public static boolean lastItemReachable(int[] hopList) {
        int position = 0;
        boolean isDone = false;
        boolean doYourJob = false;
        while ((position < hopList.length) && (!isDone)) {
            if ((hopList[position] == 0) && (position != (hopList.length - 1))) {
                isDone = true;
            } else if (position >= hopList.length - 1) {
                doYourJob = true;
                isDone = true;
            } else {
                position += hopList[position];
            }
        }
        if (position >= hopList.length){
            doYourJob = true;
        }
        return doYourJob;
    }

    public static int[] slidingWindowMin(int[] numberList, int windowSize){
        if (windowSize <= 0 || windowSize > numberList.length)
            return new int[0];

        int[] result = new int[numberList.length - windowSize + 1];
        int[] window = new int[windowSize];
        int index = 0;

        for (int i = 0; i < windowSize; i++) {
            window[i] = numberList[i];
        }

        for (int i = windowSize; i <= numberList.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int num : window) {
                min = Math.min(min, num);
            }
            result[index++] = min;

            if (i < numberList.length) {
                for (int j = 0; j < windowSize - 1; j++) {
                    window[j] = window[j + 1];
                }
                window[windowSize - 1] = numberList[i];
            }
        }

        return result;
    }
}
