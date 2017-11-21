package hinapolina.com.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
