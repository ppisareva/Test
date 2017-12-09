package hinapolina.com.test;

import java.util.HashMap;

/**
 * Created by polina on 12/5/17.
 */

public class LinkedListNodeImp<E> implements LinkedListNode<E> {

   E value;
    LinkedListNodeImp<E> next;
    LinkedListNodeImp<E> head = this;


    @Override
    public E getValue() {
        return value;
    }

    @Override
    public void setValue(E value) {
      this.value = value;
    }

    @Override
    public LinkedListNode<E> getNext() {
        return next;
    }

    @Override
    public void setNext(LinkedListNode<E> next) {
        this.next = (LinkedListNodeImp<E>) next;
    }

    @Override
    public void setValuesFromArray(E[] listValues) {
        LinkedListNodeImp<E> current = head;
        for(int i = 0; i<listValues.length; i++){
            current.setValue(listValues[i]);
            LinkedListNode<E> node = new LinkedListNodeImp<>();
           current.setNext(node);
        }
    }


    public LinkedListNodeImp<Integer> sumOfNod(LinkedListNodeImp<Integer> a, LinkedListNodeImp<Integer> b){

        a = revers(a);
        b = revers(b);
        String sumA = "";
        String sumB = "";
        LinkedListNodeImp<Integer> current = a;
        while (current.next!=null){
            sumA = sumA + current.getValue()+"";
        }
        current = b;
        while (current.next!=null){
            sumB = sumB + current.getValue()+"";
        }

        Integer sum = Integer.parseInt(sumA) + Integer.parseInt(sumB);
        Integer arr [] = new Integer[10];
        int i = 0;
        while (sum>0){
            arr[i] = sum%10;
            sum = sum/10;
            i++;

        }
        LinkedListNodeImp<Integer> res = new LinkedListNodeImp<>();
        res.setValuesFromArray(arr);
        return res;
    }

    LinkedListNodeImp<Integer> revers(LinkedListNodeImp<Integer> head){
        LinkedListNodeImp<Integer> past = null;
        LinkedListNodeImp<Integer> current = head;
        LinkedListNodeImp<Integer> head1 = head;
        while (current!=null){
            LinkedListNodeImp<Integer> next = (LinkedListNodeImp<Integer>) head.getNext();
            current.next = past;
            past = current;
            current = next;
        }

        return head1.next;

    }


    public HashMap<String, Integer> countWords(String string){
        String [] arr = string.split(" ");
        HashMap<String, Integer> res = new HashMap<>();

        for(int i = 1; i<arr.length; i++){
            if(res.containsKey(arr[i])){
               int val =  res.get(arr[i]);
                val ++;
                res.put(arr[i], val);
            } else {
                res.put(arr[i], 1);
            }

        }
        return res;
    }



    public LinkedListNode add(LinkedListNodeImp node1, LinkedListNodeImp node2){
        LinkedListNodeImp current = new LinkedListNodeImp();
        LinkedListNodeImp head = current;
        int carry = 0;
        int val1 = 0;

        int val2 = 0;
        while (node1!=null || node2!=null){
            if(node1!=null){
               val1 =  (Integer) node1.getValue();
            }
            if(node2!=null){
                val2 = (Integer) node2.getValue();
            }

            int sum = val1+val2+carry;

            if(sum>=10){
                carry = 1;
                current.setValue(val1+val2%10);
                current = current.next;
            }

        }


        return head;
    }


}
