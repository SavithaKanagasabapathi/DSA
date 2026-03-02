class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        //TC-O(NlogN+N*grpsize) and SC-O(N), NLOGN for treemap operations, treemap will sort it's keys
        //we need to sort keys to get cards consecutively, so used treemap
        if (hand.length % groupSize != 0) {//if length not mulptiple of grp, return false
            return false;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);//create map with card and freq
        }
        for(int card:map.keySet()){
            int count=map.get(card);
            if(count>0){
                for(int i=0;i<groupSize;i++){
                    int currentCard=card+i;//as it's consecutive, card+0, card+1, card+2
                    if(map.getOrDefault(currentCard, 0)<count){
                        return false;//if next card has less freq than first, return false
                    }
                    map.put(currentCard, map.get(currentCard)-count);//reduce its freq
                }
            }
        }
        return true;

        //Hashmap - need to sort keys 
        //TC-O(NlogN+N*grpsize) and SC-O(N), NLOGN for key sort
        // if (hand.length % groupSize != 0) {//if length not mulptiple of grp, return false
        //     return false;
        // }
        // Map<Integer, Integer> map = new HashMap<>();
        // for (int card : hand) {
        //     map.put(card, map.getOrDefault(card, 0) + 1);//create map with card and freq
        // }
        // int[] keys=new int[map.size()];
        // int index=0;
        // for(int key:map.keySet()){
        //     keys[index++]=key;
        // }
        // Arrays.sort(keys);
        // for (int card : keys) {
        //     int count = map.get(card);
        //     if (count > 0) {
        //         for (int i = 0; i < groupSize; i++) {
        //             int currentCard = card + i;//as it's consecutive, card+0, card+1, card+2
        //             if (map.getOrDefault(currentCard, 0) < count) {
        //                 return false;//if next card has less freq than first, return false
        //             }
        //             map.put(currentCard, map.get(currentCard) - count);//reduce its freq
        //         }
        //     }
        // }
        // return true;
    }
}