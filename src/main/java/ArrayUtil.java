public class ArrayUtil {
    private ArrayUtil(){
    }
    public static int[] getAfterLastFourDigits(int[] arr){
        int startIndex ;
        for (startIndex = arr.length -1 ;startIndex>=0;startIndex--) {
            if(arr[startIndex] == 4)
                break;
        }
        if (startIndex == -1)
            throw new RuntimeException();
        int[] targetArr = new int[arr.length-startIndex-1];
        for (int i = 0; startIndex + 1  + i  < arr.length; i++) {
            targetArr[i] = arr[startIndex + 1 + i];
        }
        return targetArr;
    }
}
