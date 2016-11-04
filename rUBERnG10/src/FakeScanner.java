

import java.util.ArrayList;

public class FakeScanner implements Scanner{

    String[] strings;
    int[] ints;
    long[] longs;

    int intCount = -1;
    int stringCount = -1;
    int longCount = -1;

    public FakeScanner(String[] strings, int[] ints, long[] longs){
        this.strings = strings;
        this.ints = ints;
        this.longs = longs;
    }

    @Override
    public int getInt(String msg) {
        intCount++;
        return ints[intCount];


    }

    @Override
    public long getLong(String msg) {
        longCount++;
        return longs[longCount];
    }

    @Override
    public String getString(String msg) {
        stringCount++;
        return strings[stringCount];
    }

}
