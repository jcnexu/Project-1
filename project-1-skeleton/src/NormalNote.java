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
    protected void drawNote(Input input, Score currScore) {
        int noteX = this.getStartX();
        int noteY = this.getStartY();

        if(!this.getIsScored()) {
            if (this.getNoteLane().equals("Left")) {
                // Simultaneously check if the note has been scored
                currScore.leftNormalNoteScoring(this, input);
                NOTE_LEFT.draw(noteX, noteY);
                this.setNoteY(noteY + NOTE_SPEED);

            }
            if (this.getNoteLane().equals("Up")) {
                currScore.upNormalNoteScoring(this, input);
                NOTE_UP.draw(noteX, noteY);
                this.setNoteY(noteY + NOTE_SPEED);
            }
            if (this.getNoteLane().equals("Down")) {
                currScore.downNormalNoteScoring(this, input);
                NOTE_DOWN.draw(noteX, noteY);
                this.setNoteY(noteY + NOTE_SPEED);
            }
            if (this.getNoteLane().equals("Right")) {
                currScore.rightNormalNoteScoring(this, input);
                NOTE_RIGHT.draw(noteX, noteY);
                this.setNoteY(noteY + NOTE_SPEED);
            }
        }
    }


}
