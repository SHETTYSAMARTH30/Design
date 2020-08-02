class Logger {
    
    HashMap<String, Integer> msgDict;

    /** Initialize your data structure here. */
    public Logger() {
        
        msgDict = new HashMap<String, Integer>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        
        //If we are seeing the message for the first time then return true
        if(!msgDict.containsKey(message)){
            
            msgDict.put(message, timestamp);
            return true;
        }
        
        Integer oldTimestamp = msgDict.get(message);
        
        //If the message is repeated but is after 10 seconds window
        if(timestamp - oldTimestamp >= 10){
            
            //We update the timestamp of new message
            msgDict.put(message, timestamp);
            return true;
        }
        else
            //We have got the repeated message within the 10 sec window
            return false;
        
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
