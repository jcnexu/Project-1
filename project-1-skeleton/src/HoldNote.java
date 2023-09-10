import bagel.*;
public class HoldNote extends Note {
    // Starting y-coordinate of all hold notes
    private final static int START_HOLD_Y = 24;

    // Constructor
    public HoldNote(String noteLane, int startX, int frameNumber, String noteClass) {
        super(noteLane, startX, frameNumber, noteClass);
        this.startY = START_HOLD_Y;
    }
}
