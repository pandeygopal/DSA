class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] item : items1) {
            map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);
        }

        for (int[] item : items2) {
            map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int key : map.keySet()) {
            res.add(Arrays.asList(key, map.get(key)));
        }

        res.sort((a, b) -> a.get(0) - b.get(0));

        return res;
    }
}
