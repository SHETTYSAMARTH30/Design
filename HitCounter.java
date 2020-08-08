class HitCounter {

        private int time[];
        private int hits[];
    
    /** Initialize your data structure here. */
    public HitCounter() {
        
        //It saves the timestamp for each hit, and since we only need number of hits in last 5 mins. We keep record of the hits only for 300 seconds
        time = new int[300];
        hits = new int[300];
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        
        int index = timestamp % 300;
        
        if(time[index] != timestamp){
            
            time[index] = timestamp;
            hits[index] = 1;
        }
        else{
            
            hits[index] += 1;
        }
        
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        
        int total = 0;
        
        for(int i = 0; i < 300; i++){
            
            if(timestamp - time[i] < 300){
                
                total += hits[i];
            }
        }
        
        return total;
        
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
