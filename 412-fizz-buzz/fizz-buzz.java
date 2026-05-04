class Solution {
    public List<String> fizzBuzz(int n) {
        //TC-O(N) and SC-O(N)

        // List<String> ans = new ArrayList<>();
        // for (int i = 1; i <= n; i++) {
        //     if (i % 3 == 0 && i % 5 == 0) {//i%15==0
        //         ans.add("FizzBuzz");
        //     } else if (i % 3 == 0) {
        //         ans.add("Fizz");
        //     } else if (i % 5 == 0) {
        //         ans.add("Buzz");
        //     } else {
        //         ans.add("" + i);//String.valueOf() or Integer.parseString()
        //     }
        // }
        // return ans;

        // return IntStream.rangeClosed(1, n)
        //         .mapToObj(i -> {
        //             i % 15 == 0 ? "FizzBuzz" :
        //             i % 3 == 0  ? "Fizz" :
        //             i % 5 == 0  ? "Buzz" :
        //             String.valueOf(i)
        //         })
        //         .collect(Collectors.toList());

        return IntStream.rangeClosed(1, n)
                .parallel()
                .mapToObj(i -> {
                    String s = "";
                    if (i % 3 == 0) {
                        s += "Fizz";
                    }
                    if (i % 5 == 0) {
                        s += "Buzz";
                    }
                    return s.isEmpty() ? String.valueOf(i) : s;
                })
                .collect(Collectors.toList());
    }
}