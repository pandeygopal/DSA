class NumberContainers {

    Map<Integer, Integer> indexToNumber;
    Map<Integer, TreeSet<Integer>> numberToIndices;

    public NumberContainers() {
        indexToNumber = new HashMap<>();
        numberToIndices = new HashMap<>();
    }

    public void change(int index, int number) {

        if (indexToNumber.containsKey(index)) {

            int oldNumber = indexToNumber.get(index);
            TreeSet<Integer> set = numberToIndices.get(oldNumber);
            set.remove(index);

            if (set.isEmpty()) {
                numberToIndices.remove(oldNumber);
            }
        }

        indexToNumber.put(index, number);

        numberToIndices.putIfAbsent(number, new TreeSet<>());
        numberToIndices.get(number).add(index);
    }

    public int find(int number) {

        if (!numberToIndices.containsKey(number))
            return -1;

        return numberToIndices.get(number).first();
    }
}
