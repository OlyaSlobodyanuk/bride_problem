package com.bride.Comparator;

import com.bride.Groom;
import java.util.Comparator;

public class GroomMainCriterionComparator implements Comparator<Groom>
{
    private int index;
    private int[] limit;

    public GroomMainCriterionComparator(int index, int[] limit) {
        this.index = index;
        this.limit = limit;
    }

    public int compare(Groom groom1, Groom groom2) {
        if(groom1.getCharacteristics()[index] > groom2.getCharacteristics()[index]){
            return 1;
        } else {
            if(groom1.getCharacteristics()[index] < groom2.getCharacteristics()[index]) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}