package com.bride.Comparator;

import com.bride.Groom;
import java.util.Comparator;

public class GroomMultiplComparator implements Comparator<Groom>
{
    private double[] weights;

    public GroomMultiplComparator(double[] weights) {
        this.weights = weights;
    }

    private double getConvolution(Groom groom) {
        double result = Math.pow(groom.getCharacteristics()[0], weights[0]);
        for(int i = 1; i < groom.getCharacteristics().length; i++) {
            result *= Math.pow(groom.getCharacteristics()[i], weights[i]);
        }

        return result;
    }

    public int compare(Groom groom1, Groom groom2) {
        double cGroom1 = getConvolution(groom1), cGroom2 = getConvolution(groom2);

        if (cGroom1 > cGroom2) {
            return 1;
        } else {
            if (cGroom1 < cGroom2) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}

/*
package com.bride.Comparator;

import java.util.Comparator;
import com.bride.Groom;

public class GroomIdComparator implements Comparator<Groom> {
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
 */