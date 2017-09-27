package com.tonydroberts.datastructuresyou;

import java.util.Random;

/**
 * Created by Tony on 9/15/2017.
 * Stores the question bank for the quiz
 */

public class Questions {

    /*
    bank will store the question in the first column(0), then the
    four possible choices(1-4), then in the final fifth comlumn the number corresponding
    to the correct answer(5)

    Every Row will contain a different set of questions/answers

    This bank will be shuffled by row to add randomness to the quiz
     */
    private String bank [][] = {
            {"What is the worst case time complexity of insertion in a Singly-Linked List?","O(1)", "O(n)", "O(nlogn)","O(n^2)","2"},
            {"Queue deletion time?","O(1)", "O(n)", "O(nlogn)","O(n^2)","1"},
            {"What is the worst case time complexity of searching a stack?","O(1)", "O(n)", "O(nlogn)","O(n^2)","2"},
            {"Array deletion time?","O(1)", "O(n)", "O(nlogn)","O(n^2)","2"},
            {"What is the worst case time complexity of sorting with Bubble Sort?","O(1)", "O(n)", "O(nlogn)","O(n^2)","4"},
            {"Which of these sorting algorithms would you use if space complexity was your main concern?","Merge sort", "Insertion Sort", "Quick sort","Tree sort","2"},
            {"Which of these data structures would you use if your only priority was to access a given element quickly?","Array", "Stack", "Queue","Singly-Linked List","1"},
            {"Which of these algorithms has a non-constant space complexity?","Bubble sort", "Heap sort", "Quick sort","Insertion sort","3"},
            {"What is the worst case time complexity of deleting a node from a linked list if you don't have a reference to the node?","O(1)", "O(n)", "O(nlogn)","O(n/2)","2"},
            {"What is the time complexity of deleting a node from a linked list, given a reference to it?","O(1)", "O(n)", "O(nlogn)","O(n/2)","1"},
    };

//getters, i is referring to the question set that is being requested

    public String getQuestion(int i) {
        return bank[i][0];
    }


    public String getChoice1(int i) {
        return bank[i][1];
    }


    public String getChoice2(int i) {
        return bank[i][2];
    }

    public String getChoice3(int i) {
        return bank[i][3];
    }


    public String getChoice4(int i) {
        return bank[i][4];
    }


    public int getCorrectAnswer(int i) {
        return Integer.valueOf(bank[i][5]);
    }

    public int getBankSize(){ //return how many questions there are in the bank
        return bank.length;
    }

    public void shuffle()
    {
        Random rn = new Random();
        int r;
        String temp [];

        for(int i = 0; i < bank.length-1; i++){
            r = rn.nextInt(bank.length);
            temp = bank[r];
            bank[r] = bank[i];
            bank[i] = temp;
        }
    }
}
