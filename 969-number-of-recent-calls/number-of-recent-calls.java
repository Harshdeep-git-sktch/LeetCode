class RecentCounter {
    private int[] records;
    private int start;
    private int end;

    public RecentCounter() {
        // The problem constraints state at most 10,000 calls will be made
        records = new int[10000]; 
        start = 0;
        end = 0;
    }
    
    public int ping(int t) {
        // Store the current timestamp and move the end pointer forward
        records[end++] = t;
        
        // Move the start pointer forward past any timestamps older than t - 3000
        while (records[start] < t - 3000) {
            start++;
        }
        
        // The difference between end and start is the number of valid calls
        return end - start;
    }
}