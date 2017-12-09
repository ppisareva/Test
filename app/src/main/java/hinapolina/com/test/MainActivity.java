package hinapolina.com.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    static boolean isValidSudoku(char[][] board) {

        String s = ".";



        for(int i = 0 ; i<9; i++){
            Set<Character> vertical = new HashSet<Character>();
            Set<Character> horisontal = new HashSet<Character>();
            for(int j = 0; j<9; j++){
                if (board[j][i]==s.charAt(0)) break;
                if(vertical.contains(board[j][i])) return false;
                else vertical.add(board[j][i]);
                if(horisontal.contains(board[i][j])) return false;
                else horisontal.add(board[i][j]);
            }
        }

        for(int t = 0; t<6; t+=3){
            for(int h = 0; h<6; h+=3){
                if(!isVal(t, h, board)) return false;
            }
        }


        return true;


    }

    static boolean isVal(int i, int j, char [][] board){

        String s = ".";
        Set<Character> set = new HashSet<Character>();
        for(int k = i ; k<i+3; k++){
            for(int l = j; l<j+3; l++){
                if (board[k][l]==s.charAt(0)) break;
                if(set.contains(board[k][l])) return false;
                else set.add(board[k][l]);

            }
        }
        return true;
    }
    static ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Set<Integer> check = new HashSet<Integer>();



        for(int i = 0; i<a.size(); i++){
            ArrayList<Integer> val = new ArrayList<>();
            if(!check.contains(i)) {
                val.add(i+1);
            }

            for(int j = i+1; j<a.size(); j++){
                if(!(check.contains(i)&&check.contains(j))){
                    if(isAnagram(a.get(i), a.get(j))) {
                        val.add(j+1);
                        check.add(i);
                        check.add(j);
                    }
                }
            }


            if(!val.isEmpty()) res.add(val);


        }

        return res;
    }



    static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        if(s.length() == t.length() && t.length()==0) return true;


        char [] arrS = s.toCharArray();
        char [] arrT = t.toCharArray();

        Arrays.sort(arrS);
        Arrays.sort(arrT);

        for(int i = 0; i<arrS.length; i++){
            if(((int)arrS[i]^arrT[i])!=0) return false;
        }

        return true;

    }


    public static int colorful(int a) {
        String temp = a+"";
        ArrayList<Integer> arr = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < temp.length(); i++)
        {
            arr.add(temp.charAt(i) - '0');
            if (set.contains(temp.charAt(i) - '0')) return 0;
            set.add(temp.charAt(i) - '0');
        }
        int step = 1;
        while (step<=arr.size()-1) {
            for (int i = 0; i < arr.size() - step; i++) {
                int sum = 1;
                for (int j = i; j <= i+step; j++) {
                    sum *= arr.get(j);
                }
                if (set.contains(sum)) return 0;
                set.add(sum);
            }
            step++;
        }



        return 1;
    }


    public static int nobleInteger(ArrayList<Integer> a){
        Collections.sort(a);

        for(int i = 0; i<a.size(); i++){
            if((i == a.size() -1 || a.get(i) != a.get(i+1)) && a.get(i)==a.size()-1-i){
                return 1;
            }
        }

        return  -1;
    }

    static ArrayList<Integer> maxset(ArrayList<Integer> a) {
        ArrayList<Integer> res = new ArrayList<>();
        long sum = 0;
        ArrayList<Integer> val = new ArrayList<>();
        long curSum = 0;

        for(int i = 0; i<a.size(); i++){
            if(a.get(i)>=0){
                val.add(a.get(i));
                curSum +=(long)a.get(i);
            } else{
                if(sum<curSum)  {
                    res = new ArrayList<>(val);
                    curSum = 0;

                    val = new ArrayList<>();
                } else {
                    if (sum == curSum) {
                        if (val.size() > res.size()) {
                            res = new ArrayList<>(val);
                            curSum = 0;
                            val = new ArrayList<>();
                        }

                    }
                }
            }
        }

        return res;
    }


    static String longestPalindrome(String s) {

        char [] arr = s.toCharArray();
        if(s.length()==0) return s;
        String odd = polindrom(arr, 0,0);
        String even = polindrom(arr, 0, 1);

        return odd.length()>even.length()?odd:even;




    }

    static String polindrom(char[] arr, int l, int r ){
        int start = 0;
        int end = 0;
        int max = 0;
        for(int i=0; i<arr.length; i++){

            int left = i+l;
            int right = i+r;
            int length = 0;
            for( int k = 0; k<arr.length;k++){
                if(left>=0&&right<arr.length){
                    if(arr[left]==arr[right]) {
                        length++;
                        if(max<=length){
                            start = left;
                            end= right;
                            max = length;
                        }
                        right++; left--;
                    } else{
                        break;
                    }
                }
            }


        }

        StringBuffer str = new StringBuffer();
        for(int d = start; d<=end; d++){
            str.append(arr[d]);
        }

        return str.toString();

    }


    static int countPrimes(int n) {

        ArrayList<Integer> res = new ArrayList<Integer>();
        if(n<1)return 0;

        for(int i = 2; i<=n; i++){
            int squer = (int)Math.sqrt(i);
            if(squer<2){
                res.add(i);
            } else{
                int j = 0;
                boolean isPrime = true;
                while(res.get(j)<=squer){
                    int dev =  res.get(j);
                    if(i%dev==0) isPrime=false;
                    j++;
                }
                if(isPrime) res.add(i);



            }
        }

        return res.size();
    }

    static boolean isPalindrome(String s) {
        s =  s.replaceAll("[^a-zA-Z ]", "");
        s.toLowerCase();
        char [] arr = s.toCharArray();
        if(arr.length<=1)return true;
        for(int i = 0; i<=arr.length/2; i++){
            if(arr[i]-arr[arr.length-1-i]!=0) return false;
        }
        return true;
    }



    static int removeDuplicates(int[] nums) {

        int a = 1;
        int arr [] = new int [nums.length];

        if(nums.length==0) return 0;

        for(int i = 0; i<nums.length-1; i++) {
            if(nums[i]<nums[i+1]) {
                arr[i+1] = arr[i];
                a++;
            } else {
                arr[i+1] = arr[i]+1;
            }
        }
        for(int j = 0; j<nums.length; j++){
            nums[j-arr[j]]= nums[j];
        }

        return a;

    }


    static ArrayList<String> textJustification(String val, int length){

        String [] arr = val.split(" ");
        ArrayList<String> res = new ArrayList<>();
        int left=0;
        int right=0;
        int count = 0;

        for(int i = 0; i<arr.length; i++){
            int lengthOfCurrentWowd =0;
            if(count==0) {
                count= arr[i].length();
            } else{
                count+=arr[i].length()+1;
            }

            if(count>=length) {
                int spaces=0;
                if (count > length) {
                    right = i - 1;
                    spaces = length -(count - arr[i].length()+1);
                }
                if (count == length) {
                    right = i;
                }

                while (spaces>=0){
                    for(int k = left; k<right&&spaces>=0; k++){
                        arr[k] = arr[k]+" ";
                        spaces--;
                    }
                }

                StringBuffer line  = new StringBuffer();
                for(int r = left; r<right; r++){
                    line.append(arr[r] + " ");
                }
                line.append(arr[right]);
                res.add(line.toString());
                left = right+1;
                count = 0;

            }

            if(i==arr.length-1){
                StringBuffer sp = new StringBuffer();
                for(int f = 0; f<=length-count; f++){
                    sp.append(" ");
                }
                StringBuffer line  = new StringBuffer();
                for(int s = left; s<arr.length; s++){
                    line.append(arr[s]);
                }
                line.append(sp);

                res.add(line.toString());
            }



        }

        return  res;
    }




//
//    static  int maxSubArray(final List<Integer> a) {
//
//        int maxSumm = Integer.MIN_VALUE;
//
//
//        for(int i = 0; i<a.size();i++){
//            int currentSumm = 0;
//            for(int j = i;j<a.size(); j++){
//                currentSumm+= a.get(j);
//                if(currentSumm>=maxSumm){
//                    maxSumm=currentSumm;
//                }
//            }
//
//
//        }
//        return maxSumm;
//
//    }

    static String longestCommonPrefix(ArrayList<String> a) {
        StringBuffer res = new StringBuffer();
        char[] pref = a.get(0).toCharArray();

        for (int j = 0; j < pref.length; j++) {
            char currant = pref[j];
            for (int i = 1; i < a.size(); i++) {
                char[] w = a.get(i).toCharArray();


                if (w.length<=j||w[j] != currant) {
                    return res.toString();
                }
            }
            res.append(currant);

        }
        return res.toString();
    }

    static int strStr(String haystack, String needle) {
        int res =  haystack.indexOf(needle);
        return res;

    }
    //[3, 30, 34, 5, 9], the largest formed number is 9534330.

    public String largestNumber(ArrayList<Integer> nums) {

        Map<Integer, ArrayList<Integer>> val = new HashMap<>();


        for(Integer integer :nums){
            ArrayList<Integer> v = new ArrayList<>();
            int key;
            if(integer/10<0){
                key = integer;

            } else {
                String str = integer+"";
                key = Integer.getInteger(str.substring(0,1));
            }

            if(val.containsKey(key)){
                v = val.get(key);
            }
            v.add(integer);
            val.put(key, v);
        }

        String res ="";
        for(int i = 9; i<=0; i--){
            ArrayList<Integer> arr = val.get(i);
        }

        return res;

    }

    static ArrayList<Integer> maxSubArray(ArrayList<Integer> a) {

        Collections.sort(a);

        for (int i = 1; i < a.size(); i += 2) {
            int first = a.get(i - 1);
            int second = a.get(i);
            a.set(i, first);
            a.set(i - 1, second);
        }
        return a;
    }


    static  int a(ArrayList<Integer> arr){

        Collections.sort(arr);
        for(int i = 0; i<arr.size()-1; i++){
            if(arr.get(i)==arr.get(i+1)) {
                arr.remove(i+1);
                i--;

            }
        }
        return arr.size();
    }

    static int degreeOfArray(int[] arr) {
        Map<Integer, List<Integer>> res = new HashMap<>();
        int lastIndex = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            ArrayList<Integer> val = new ArrayList<>();
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    lastIndex = j;
                }
            }


            if (!res.containsKey(arr[i])) {
                if (arr[i] == arr[lastIndex]) {
                    for (int f = i; f <= lastIndex; f++) {
                        val.add(arr[f]);
                    }

                    res.put(arr[i], val);
                }

            }
        }



        int value = 100000;
        Iterator it = res.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            ArrayList<Integer> v = (ArrayList<Integer>) pair.getValue();
            if (v.size() < value && v.size() > 1) {
                value = v.size();
            }


            it.remove();
        }


        return value;


    }
}
