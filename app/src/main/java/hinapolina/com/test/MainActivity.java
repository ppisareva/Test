package hinapolina.com.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    static  int maxSubArray(final List<Integer> a) {

        int maxSumm = Integer.MIN_VALUE;


        for(int i = 0; i<a.size();i++){
            int currentSumm = 0;
            for(int j = i;j<a.size(); j++){
                currentSumm+= a.get(j);
                if(currentSumm>=maxSumm){
                    maxSumm=currentSumm;
                }
            }


        }
        return maxSumm;

    }

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

    public ArrayList<ArrayList<Integer>> prettyPrint(int a) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> value = new ArrayList<>();
        for (int d = 0; d < a * 2 - 1; d++) {
            value.add(0);
        }
        for (int g = 0; g < a * 2 - 1; g++) {
            res.add(value);
        }
        int x = a - 1;
        int f = 1;
        for (int i = a - 1; i >= 0; i--) {
            value = new ArrayList<>();
            for (int d = 0; d < a * 2 - 1; d++) {
                value.add(0);
            }
            int k = 1;
            int h = a - 1;
            for (int j = a - 1; j >= 0; j--) {
                int val = k;
                if (f > k) {
                    val = f;
                }

                if (j == h) {
                    value.set(j, val);
                } else {
                    value.set(j, val);
                    value.set(h, val);
                }

                k++;
                h++;
            }
            if (x == i) {
                res.set(i, value);
            } else {
                res.set(i, value);
                res.set(x, value);
            }
            x++;
            f++;

        }
        return res;
    }

    public int kthsmallest(final List<Integer> a, int k) {

        PriorityQueue<Integer> res =
                new PriorityQueue<>();

        for (int i = 0; i < a.size(); i++) {
            res.add(a.get(i));
        }
        for (int j = 0; j < k - 1; j++) {
            res.poll();
        }
        return res.peek();
    }


    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode subtract(ListNode a) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ListNode node = a;

        while (node != null) {
            list.add(node.val);
            node = node.next;
        }

        node = a;
        ListNode res = node;
        for (int i = list.size() - 1; i > (list.size() + 1) / 2 - 1; i--) {
            node.val = list.get(i) - node.val;
            node = node.next;
        }
        return res;
    }

    public int longestConsecutive(final List<Integer> a) {
        TreeSet<Integer> list = new TreeSet<>();
        for(int i = 0; i<a.size(); i++){
            list.add(a.get(i));
        }
        int maxSize = 0;
        ArrayList<Integer> res = new ArrayList<>();
        if(!list.isEmpty()) {
            res.add(list.first());
            maxSize = res.size();
        }
        while (list.size()>1){
            int first = list.first();
            list.remove(first);
            int second = list.first();
            if(second - first==1){
                res.add(second);
                if(res.size()>=maxSize)  maxSize = res.size();
            } else {
                res = new ArrayList();
                res.add(second);
            }
        }

        return maxSize;

    }

}
