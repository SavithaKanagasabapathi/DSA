class DetectSquares {
    //SC-O(N) and TC-O(1) for add and TC-O(N) for count

    Map<Integer, Map<Integer, Integer>> xMap;//x,y,freq/count
    List<int[]> points;//List of x,y point

    public DetectSquares() {
        xMap = new HashMap<>();
        points = new ArrayList<>();
    }

    public void add(int[] point) {//add in xMap, yMap, add freq and add in points
        int x = point[0], y = point[1];
        xMap.putIfAbsent(x, new HashMap<>());
        Map<Integer, Integer> yMap = xMap.get(x);
        yMap.put(y, yMap.getOrDefault(y, 0) + 1);
        points.add(point);
    }

    //If I/p 11,10, available points = 11,2, 3,10, 3,2
    //check 11,10
    //xMap has 11?, get those points, 11,2 and 11,10
    //yMap keyset - 2, 10, if same Y it will be 11,10 - ignore continue
    //In square, all sides dist are same = 10-2=8
    //From target 11,10, left and right side be 11+8 or 11-8
    //so possibleX be 3,19, here no 19, so count-0
    //count1= 11,2 =1
    //count2= 3,2 =1
    //count3= 3,10 =1
    //1*1*1=1, count=1;
    //add 11,2 and count 11,10
    //Same procedure, 
    //count1= 11,2 =2
    //count2= 3,2 =1
    //count3= 3,10 =1
    //2*1*1=2, count=2;
    //Evrytime count() method, count=0;

    public int count(int[] point) {
        int x = point[0], y = point[1], count = 0;
        if (!xMap.containsKey(x)) {//if no same x point in xMap, there will be no square
            return 0;
        }
        Map<Integer, Integer> yMap = xMap.get(x);
        for (int ys : yMap.keySet()) {
            if (y == ys) {//if same point, continue
                continue;
            }
            int dist = Math.abs(y - ys);//10-2=8
            int[] possibleX = { x + dist, x - dist };
            for (int xs : possibleX) {
                int count1 = yMap.get(ys);//11,2
                int count2 = xMap.getOrDefault(xs, new HashMap<>()).getOrDefault(ys, 0);//3,2 and 19,2 
                int count3 = xMap.getOrDefault(xs, new HashMap<>()).getOrDefault(y, 0);//3,10 and 19,10
                count += count1 * count2 * count3;
                //if freq of any point is 2, we can construct 2 squares 
                //duplicate points allowed
            }
        }
        return count;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */
