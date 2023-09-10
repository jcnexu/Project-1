import bagel.*;
/* The parent/superclass for NormalNote and HoldNote.
*  */
public class Note {
    // NOTE_SPEED is protected to allow subclass access
    protected final static int NOTE_SPEED = 2;
    // Below shared attributes between NormalNote and HoldNote
    private String noteLane;
    private int startX;
    protected int startY;
    private int frameNumber;
    private String noteClass;
    private boolean isDrawn;

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
    // Super constructor
    public Note(String noteLane, int startX, int frameNumber, String noteClass) {
        this.noteLane = noteLane;
        this.startX = startX;
        this.frameNumber = frameNumber;
        this.noteClass = noteClass;
        this.isDrawn = false;
    }
    public String getNoteClass() {
        return noteClass;
    }

    public void setNoteY(int noteY) {
        this.startY = noteY;
    }

    public void moveNote() {
    }

    public void drawNote() {
    }

}
