class Fancy {

    private static final long MOD = 1_000_000_007;

    private List<Long> list;
    private long mul;   // a
    private long add;   // b

    public Fancy() {
        list = new ArrayList<>();
        mul = 1;
        add = 0;
    }

    public void append(int val) {
        long x = (val - add + MOD) % MOD;
        x = x * modInverse(mul) % MOD;
        list.add(x);
    }

    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }

    public void multAll(int m) {
        mul = (mul * m) % MOD;
        add = (add * m) % MOD;
    }

    public int getIndex(int idx) {
        if (idx >= list.size()) return -1;
        return (int)((list.get(idx) * mul + add) % MOD);
    }

    private long modInverse(long x) {
        return modPow(x, MOD - 2);
    }

    private long modPow(long x, long n) {
        long res = 1;
        x %= MOD;

        while (n > 0) {
            if ((n & 1) == 1)
                res = (res * x) % MOD;

            x = (x * x) % MOD;
            n >>= 1;
        }

        return res;
    }
}