package netconf.operations;

import netconf.operations.Adder;

public class AdderImpl implements Adder {
    public int add(int pNum1, int pNum2) {
        return pNum1 + pNum2;
    }
}