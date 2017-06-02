package com.bride.Comparator;

import java.util.Comparator;
import com.bride.Groom;

public class GroomLinearComparator implements Comparator<Groom>
{
    private double[] weights;

    public GroomLinearComparator(double[] weights) {
        this.weights = weights;
    }

    private double getConvolution(Groom groom) {
        double result = 0;
        for(int i = 0; i < groom.getCharacteristics().length; i++) {
            result += weights[i] * groom.getCharacteristics()[i];
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