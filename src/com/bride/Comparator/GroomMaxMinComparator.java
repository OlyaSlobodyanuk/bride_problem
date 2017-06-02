package com.bride.Comparator;

import com.bride.Groom;
import java.util.Comparator;

public class GroomMaxMinComparator implements Comparator<Groom>
{
    public int compare(Groom groom1, Groom groom2) {
        int mGroom1 = groom1.getCharacteristics()[0], mGroom2 = groom2.getCharacteristics()[0];

        for (int i = 1; i < groom1.getCharacteristics().length; i++) {
            if (mGroom1 > groom1.getCharacteristics()[i]) {
                mGroom1 = groom1.getCharacteristics()[i];
            }
            if (mGroom2 > groom2.getCharacteristics()[i]) {
                mGroom2 = groom2.getCharacteristics()[i];
            }
        }

        if (mGroom1 > mGroom2) {
            return 1;
        } else {
            if (mGroom1 < mGroom2) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}