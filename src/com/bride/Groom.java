package com.bride;

public class Groom
{
    private int id;
    private int[] characteristics;
    private static int numChar;

    public int getId() {
        return id;
    }

    public int[] getCharacteristics() {
        return characteristics;
    }

    public Groom(int id, int[] characteristics) {
        this.id = id;
        this.characteristics = characteristics;
        numChar = characteristics.length;
    }

    public Groom(int id) {
        this.id = id;
        characteristics = new int[numChar];
    }

    @Override
    public String toString() {
        return "id = " + id + " : " + characteristics[0] + " : " + characteristics[1];
    }
}
