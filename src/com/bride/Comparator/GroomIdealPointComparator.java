package com.bride.Comparator;

import java.util.Comparator;
import com.bride.Groom;

public class GroomIdealPointComparator implements Comparator<Groom>
{
    private int[] bestPoint;
    public GroomIdealPointComparator(Groom[] grooms) {
        bestPoint = new int[grooms[0].getCharacteristics().length];
        for(int i = 0; i < grooms.length; i++) {
            for(int f = 0; f < bestPoint.length; f++) {
                if(grooms[i].getCharacteristics()[f] > bestPoint[f]) {
                    bestPoint[f] = grooms[i].getCharacteristics()[f];
                }
            }
        }
    }

    private double distance(Groom groom) {
        double result = 0;
        for(int i = 0; i < bestPoint.length; i++) {
            result += Math.pow(bestPoint[i] - groom.getCharacteristics()[i], 2);
        }

        return Math.sqrt(result);
    }

    public int compare(Groom groom1, Groom groom2) {
        double dGroom1 = distance(groom1), dGroom2 = distance(groom2);

        if(dGroom1 < dGroom2){
            return 1;
        } else {
            if(dGroom1 > dGroom2) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}