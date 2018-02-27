public class meetingTime {

    // Your company built an in-house calendar tool called HiCal. You want to add a feature to see the
    // times in a day when everyone is available.

    // To do this, you’ll need to know when any team is having a meeting. In HiCal, a meeting is stored
    // as an object of a Meeting class with integer variables startTime and endTime. These integers represent
    // the number of 30-minute blocks past 9:00am.

    private int startTime;
    private int endTime;

    public meetingTime(int startTime, int endTime) {
        // number of 30 min blocks past 9:00 am
        this.startTime = startTime;
        this.endTime   = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }


    public static void main(String[] args) {

    }

}
