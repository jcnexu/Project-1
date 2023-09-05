import bagel.*;
/* The parent/superclass for NormalNote and HoldNote.
*  */
public class Note {
    // NOTE_SPEED is protected to allow subclass access
    protected final static int NOTE_SPEED = 2;
    // Below shared attributes between NormalNote and HoldNote
    // All protected to allow subclass access (not creating constructors in parent class)
    protected String noteLane;
    protected int startX;
    protected int startY;
    protected int frameNumber;

    public String getNoteLane() {
        return noteLane;
    }
    public int getStartX() {
        return startX;
    }
    public int getStartY() {
        return startY;
    }
    public int getFrameNumber() {
        return frameNumber;
    }
}
