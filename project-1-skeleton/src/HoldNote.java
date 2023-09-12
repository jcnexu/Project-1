import bagel.*;
public class HoldNote extends Note {
    // Starting y-coordinate of all hold notes
    private final static int START_HOLD_Y = 24;
    private final Image HOLD_NOTE_LEFT = new Image("res/holdNoteLeft.png");
    private final Image HOLD_NOTE_UP = new Image("res/holdNoteUp.png");
    private final Image HOLD_NOTE_DOWN = new Image("res/holdNoteDown.png");
    private final Image HOLD_NOTE_RIGHT = new Image("res/holdNoteRight.png");

    // Constructor
    public HoldNote(String noteLane, int startX, int frameNumber) {
        super(noteLane, startX, frameNumber);
        this.startY = START_HOLD_Y;
    }

    protected void drawNote(Input input, Score currScore) {
        int noteX = this.getStartX();
        int noteY = this.getStartY();


        if(!this.getIsScored()) {
            if (this.getNoteLane().equals("Left")) {
                HOLD_NOTE_LEFT.draw(noteX, noteY);
                this.setNoteY(noteY + NOTE_SPEED);
            }
            if (this.getNoteLane().equals("Up")) {
                HOLD_NOTE_UP.draw(noteX, noteY);
                this.setNoteY(noteY + NOTE_SPEED);
            }
            if (this.getNoteLane().equals("Down")) {
                HOLD_NOTE_DOWN.draw(noteX, noteY);
                this.setNoteY(noteY + NOTE_SPEED);
            }
            if (this.getNoteLane().equals("Right")) {
                HOLD_NOTE_RIGHT.draw(noteX, noteY);
                this.setNoteY(noteY + NOTE_SPEED);
            }
        }
    }
}
