import bagel.*;
public class NormalNote extends Note {
    // The y-coordinate for the stationary notes
    private final static int IMAGE_NORMAL_Y = 657;
    // Starting y-coordinate of all normal notes
    private final static int  START_NORMAL_Y = 100;

    // Constructor
    public NormalNote(String noteLane, int startX, int frameNumber) {
        this.noteLane = noteLane;
        this.startX = startX;
        this.startY = START_NORMAL_Y;
        this.frameNumber = frameNumber;
    }
}
