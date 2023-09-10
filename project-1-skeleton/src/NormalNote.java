import bagel.*;
public class NormalNote extends Note {
    // The y-coordinate for the stationary notes
    private final Image NOTE_LEFT = new Image("res/noteLeft.png");
    private final Image NOTE_RIGHT = new Image("res/noteRight.png");
    private final Image NOTE_UP = new Image("res/noteUp.png");
    private final Image NOTE_DOWN = new Image("res/noteDown.png");
    private final static int IMAGE_NORMAL_Y = 657;
    // Starting y-coordinate of all normal notes
    private final static int  START_NORMAL_Y = 100;

    // Constructor
    public NormalNote(String noteLane, int startX, int frameNumber, String noteClass) {
        super(noteLane, startX, frameNumber, noteClass);
        this.startY = START_NORMAL_Y;
    }
    public void moveNote() {
        String laneNote = this.getNoteLane();
        int noteX = this.getStartX();
        int noteY = this.getStartY();

        if(laneNote.equals("Left") == true) {
            NOTE_LEFT.draw(noteX, noteY);
            noteY = noteY - NOTE_SPEED;
        }
        if(laneNote.equals("Right") == true) {
            NOTE_RIGHT.draw(noteX, noteY);
            noteY = noteY - NOTE_SPEED;
        }
        if(laneNote.equals("Up") == true) {
            NOTE_UP.draw(noteX, noteY);
            noteY = noteY - NOTE_SPEED;
        }
        if(laneNote.equals("Down") == true) {
            NOTE_DOWN.draw(noteX, noteY);
            noteY = noteY - NOTE_SPEED;
        }
    }


    public void drawNote() {
        int noteX = this.getStartX();
        int noteY = this.getStartY();
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
