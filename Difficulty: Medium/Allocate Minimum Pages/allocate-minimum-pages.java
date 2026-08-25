class Solution {
    public int findPages(int[] books, int k) {

        int n = books.length;

        if(n < k){
            return -1;
        }

        long low = 0;
        long high = 0;

        for(int i = 0; i < n; i++){
            low = Math.max(low, books[i]);
            high += books[i];
        }

        long res = -1;

        while(low <= high){

            long guess = low + (high - low) / 2;

            if(minpage(books, n, guess, k)){
                res = guess;
                high = guess - 1;
            }
            else{
                low = guess + 1;
            }
        }

        return (int)res;
    }


    public boolean minpage(int[] books, int n, long limit, int student){

        int students = 1;
        long page = 0;

        for(int i = 0; i < n; i++){

            if(page + books[i] <= limit){
                page += books[i];
            }
            else{
                students++;
                page = books[i];

                if(students > student){
                    return false;
                }
            }
        }

        return true;
    }
}