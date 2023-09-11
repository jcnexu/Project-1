import bagel.*;

public class Score {
    private static final int PERFECT_DISTANCE = 15;
    private static final int GOOD_DISTANCE = 50;
    private static final int BAD_DISTANCE = 100;
    private static final int MISS_DISTANCE = 200;
    private static final int PERFECT_SCORE = 10;
    private static final int GOOD_SCORE = 5;
    private static final int BAD_SCORE = -1;
    private static final int MISS_SCORE = -5;
    private final Font messageFont = new Font("res/FSO8BITR.TTF", 40);

    /*public void normalNoteScoring(NormalNote givenNote) {
        String givenNoteLane = givenNote.getNoteLane();
        // givenNote is already scored
        if(givenNote.getIsScored()) {
            // do nothing
        }
        else {
            if(givenNoteLane.equals("left")) {
                if(Input.wasPressed(Keys.LEFT)) {
                    if(givenNote.getNoteDistance() <= PERFECT_DISTANCE) {
                        messageFont.drawString("PERFECT",(Window.getWidth()/2.0) - (messageFont.getWidth("PERFECT")/2.0) , 250);
                        givenNote.setIsScored(true);
                    }
                }
            }
        }
    } */


}
