class Solution {

    public boolean isSorted(int[] arr) {
        return fun(arr, 0);
    }

    public boolean fun(int[] arr, int i) {

        if(i == arr.length - 1) {
            return true;
        }

        if(arr[i] > arr[i + 1]) {
            return false;
        }

        // Check remaining array
        return fun(arr, i + 1);
    }
}