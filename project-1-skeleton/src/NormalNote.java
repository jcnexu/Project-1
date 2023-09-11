import bagel.*;
public class NormalNote extends Note {
    // The y-coordinate for the stationary notes
    private final Image NOTE_LEFT = new Image("res/noteLeft.png");
    private final Image NOTE_RIGHT = new Image("res/noteRight.png");
    private final Image NOTE_UP = new Image("res/noteUp.png");
    private final Image NOTE_DOWN = new Image("res/noteDown.png");
    // Starting y-coordinate of all normal notes
    private final static int  START_NORMAL_Y = 100;

    public NormalNote(String noteLane, int startX, int frameNumber) {
        super(noteLane, startX, frameNumber);
        this.startY = START_NORMAL_Y;
    }

    /* Own drawNote() to override Note's drawNote() due to normal note images
       belonging only to subclass NormalNote.
     */
    public void drawNote() {
        int noteX = this.getStartX();
        int noteY = this.getStartY();

        // perhaps put in func that sees if dist & ispressed
        // is appropriate
        if(!this.getIsScored()) {
            if (this.getNoteLane().equals("Left")) {
                NOTE_LEFT.draw(noteX, noteY);
                this.setNoteY(noteY + NOTE_SPEED);
            }
            if (this.getNoteLane().equals("Up")) {
                NOTE_UP.draw(noteX, noteY);
                this.setNoteY(noteY + NOTE_SPEED);
            }
            if (this.getNoteLane().equals("Down")) {
                NOTE_DOWN.draw(noteX, noteY);
                this.setNoteY(noteY + NOTE_SPEED);
            }
            if (this.getNoteLane().equals("Right")) {
                NOTE_RIGHT.draw(noteX, noteY);
                this.setNoteY(noteY + NOTE_SPEED);
            }
        }
    }

    public void noteScoring() {

    }

}
