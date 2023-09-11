import java.lang.Math;
import bagel.*;
/* The parent/superclass for NormalNote and HoldNote.
*  */
public class Note {
    // Constant for the stationary notes
    protected final static int IMAGE_NORMAL_Y = 657;
    // NOTE_SPEED is protected to allow subclass access
    protected final static int NOTE_SPEED = 2;
    // Below shared attributes between NormalNote and HoldNote
    private final String noteLane;
    private final int startX;
    protected int startY;
    private final int frameNumber;
    private boolean isScored;
    private final Font messageFont = new Font("res/FSO8BITR.TTF", 40);

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
    public boolean getIsScored() {
        return isScored;
    }

    // Super constructor
    public Note(String noteLane, int startX, int frameNumber) {
        this.noteLane = noteLane;
        this.startX = startX;
        this.frameNumber = frameNumber;
        this.isScored = false;
    }

    public void setNoteY(int noteY) {
        this.startY = noteY;
    }

    public void setIsScored(boolean state) {
        this.isScored = state;
    }

    public void drawNote() {
    }

    public int getNoteDistance() {
        return Math.abs(IMAGE_NORMAL_Y - this.getStartY());
    }

    public void leftNoteScoring(Input input) {
        if(input.wasPressed(Keys.LEFT) && this.getNoteDistance() <= 15) {
            this.setIsScored(true);
            messageFont.drawString("PERFECT",(Window.getWidth()/2.0) - (messageFont.getWidth("PERFECT")/2.0) , 250);

        }
    }
}
