package com.bride.Comparator;

import java.util.Comparator;
import com.bride.Groom;

public class GroomIdComparator implements Comparator<Groom>
{
    public int compare(Groom groom1, Groom groom2) {
        if(groom1.getId() > groom2.getId()){
            return 1;
        } else {
            if(groom1.getId() < groom2.getId()) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}