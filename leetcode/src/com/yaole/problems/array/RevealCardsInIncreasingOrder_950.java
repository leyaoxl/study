package com.yaole.problems.array;

import java.util.*;

public class RevealCardsInIncreasingOrder_950 {
    public static int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Deque<Integer> deque = new LinkedList<>();
        deque.offerFirst(deck[deck.length - 1]);
        for (int i = deck.length - 2; i >= 0; i--) {
            deque.offerFirst(deque.pollLast());
            deque.offerFirst(deck[i]);
        }
        System.out.println(deque);
        for (int j = 0; j < deck.length; j++) {
            deck[j] = deque.pollFirst();
        }
        return deck;
    }

    public static void main(String[] args) {
        int[] deck = new int[] {17,13,11,2,3,5,7};
        System.out.println(Arrays.toString(deckRevealedIncreasing(deck)));
    }
}
