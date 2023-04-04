package ru.job4j.queue;

import java.util.Deque;
import java.util.Iterator;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder rslt = new StringBuilder();
        int size = evenElements.size();
        for (int i = 0; i < size; i++) {
            if ((i % 2) == 0) {
                rslt.append(evenElements.pollFirst());
            } else {
                evenElements.pollFirst();
            }
        }
        return rslt.toString();
    }

    private String getDescendingElements() {
        StringBuilder rslt = new StringBuilder();
        int size = descendingElements.size();
        for (int i = 0; i < size; i++) {
            rslt.append(descendingElements.pollLast());
        }
        return rslt.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}