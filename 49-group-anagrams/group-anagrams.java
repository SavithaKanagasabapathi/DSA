class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //TC-O(n.klogk) and SC-O(n.k) k is the length of the string, loop n times, sort klogk
        // Map<String, List<String>> map = new HashMap<>();
        // for (String str : strs) {
        //     char[] charArray = str.toCharArray();
        //     Arrays.sort(charArray);
        //     map.computeIfAbsent(String.valueOf(charArray), value -> new ArrayList<>()).add(str);
        // }
        // return new ArrayList<>(map.values());

        //Same complexity but taking time as Stream Overhead
        // return new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(str -> {
        //     char[] array = str.toCharArray();
        //     Arrays.sort(array);
        //     return String.valueOf(array);
        // })).values());

        //TC-O(NK) and SC-O(NK)
        //Using ASCII
        // The first 26 prime numbers
        // Map<Double, List<String>> map = new HashMap<>();
        // int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41,
        //         43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101 };
        // for (String str : strs) {
        //     double product = 1;
        //     for (char s : str.toCharArray()) {
        //         product *= primes[s - 'a'];
        //     }
        //     map.computeIfAbsent(product, value -> new ArrayList<>()).add(str);
        // }
        // return new ArrayList(map.values());

        //Above will give integer overflow so giving it as double, 
        //But after double also ["xyzzzzzzzzzzzz","zzzzzzzzzzzzyx"] willn't work
        //many z's(101) so greater the value hash value will round off last digits
        //Store ASCII in StringBuilder as another approach or as List<count> 
        Map<List<Integer>, List<String>> map = new HashMap<>();
        for (String str : strs) {
            Integer[] count = new Integer[26];
            Arrays.fill(count, 0);
            for (char s : str.toCharArray()) {
                count[s - 'a']++;
            }
            map.computeIfAbsent(Arrays.asList(count), value -> new ArrayList<>()).add(str);
        }
        return new ArrayList(map.values());
    }
}