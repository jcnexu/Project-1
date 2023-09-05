import bagel.*;
import java.io.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Skeleton Code for SWEN20003 Project 1, Semester 2, 2023
 * Please enter your name below
 * @JaneXu
 */
public class ShadowDance extends AbstractGame  {
    private final static int WINDOW_WIDTH = 1024;
    private final static int WINDOW_HEIGHT = 768;
    private final static String GAME_TITLE = "SHADOW DANCE";
    private final static int GAME_TITLE_X = 220;
    private final static int GAME_TITLE_Y = 250;
    private final Image BACKGROUND_IMAGE = new Image("res/background.png");
    private final Font defaultFont = new Font("res/FSO8BITR.TTF", 64);
    // Font and size for starting message
    private final Font startFont = new Font("res/FSO8BITR.TTF", 24);
    private static final String GAME_START_MESS1 = "PRESS SPACE TO START";
    private static final String GAME_START_MESS2 = "USE ARROW KEYS TO PLAY";
    // Boolean variable to help determine if game has started or not
    private boolean startedGame = false;

    public ShadowDance(){
        super(WINDOW_WIDTH, WINDOW_HEIGHT, GAME_TITLE);
    }

    ArrayList<Note> allNotesArray = new ArrayList<Note>();
    ArrayList<Lane> lanesArray = new ArrayList<Lane>();

    // readCSV() method to parse through CSV file
    private void readCSV() {
        try(BufferedReader br = new BufferedReader(new FileReader("res/level1-60.csv"))) {
            String csvLine;
            while((csvLine = br.readLine()) != null) {
                String fields[] = csvLine.split(",");
                // Read in the lane coordinates
                if(fields[0].equals("Lane") == true) {
                    //System.out.println("LANE!!!!!!");
                    String laneType = fields[1];
                    int laneXCoord = Integer.parseInt(fields[2]);
                    // Create the lane to add into lanes ArrayList
                    Lane currLane = new Lane(laneType, laneXCoord);
                   // System.out.println(laneType);
                    lanesArray.add(currLane);
                }
                // Else it'll be for the note(s)
                //System.out.println(csvLine);
                int noteFrameNumber = Integer.parseInt(fields[2]);
                createNote(fields[0], fields[1], noteFrameNumber, lanesArray);

            }
            /* System.out.println(lanesArray.size());
            System.out.println(allNotesArray.size());
            for(int i = 0; i < allNotesArray.size(); i++) {
                System.out.format("ANA: laneType: %s, frameNumber: %d\n",
                        allNotesArray.get(i).getNoteLane(), allNotesArray.get(i).getFrameNumber());
            } */
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    // Function that creates notes and adds into allNotesArray
   private void createNote(String laneType, String noteType, int frameNumber, ArrayList<Lane> laneArrList) {
        int startX;
        Note currNote;
        if(noteType.equals("Normal") == true) {
            if(laneType.equals("Left") == true) {
                startX = laneArrList.get(0).getLaneX();
                currNote = new NormalNote(laneType, startX, frameNumber);
                allNotesArray.add(currNote);
            }
            if(laneType.equals("Right") == true) {
                startX = laneArrList.get(1).getLaneX();
                currNote = new NormalNote(laneType, startX, frameNumber);
                allNotesArray.add(currNote);
            }
            if(laneType.equals("Up") == true) {
                startX = laneArrList.get(2).getLaneX();
                currNote = new NormalNote(laneType, startX, frameNumber);
                allNotesArray.add(currNote);
            }
            if(laneType.equals("Down") == true) {
                startX = laneArrList.get(3).getLaneX();
                currNote = new NormalNote(laneType, startX, frameNumber);
                allNotesArray.add(currNote);
            }
        }
        // It's a hold note
       if(noteType.equals("Hold") == true) {
       }
    }

    /**
     * The entry point for the program.
     */
    public static void main(String[] args) {
        //Font mainFont = new Font("res/FSO8BITR.TTF", 24);
        //mainFont.drawString("PRES SPACE TO START", 0, 0);
        ShadowDance game = new ShadowDance();
        game.readCSV();
        game.run();
    }

    /**
     * Performs a state update.
     * Allows the game to exit when the escape key is pressed.
     */
    @Override
    protected void update(Input input) {
        BACKGROUND_IMAGE.draw(Window.getWidth()/2.0, Window.getHeight()/2.0);
        //defaultFont.drawString(GAME_TITLE, (Window.getWidth()/2.0) - (defaultFont.getWidth(GAME_TITLE)/2.0) , 250);
        //readCSV();
        if(startedGame == false) {
            // Draw the starting message/window of the game
            defaultFont.drawString(GAME_TITLE, GAME_TITLE_X, GAME_TITLE_Y);
            //System.out.println("Hello" + defaultFont.getWidth(GAME_TITLE)/2.0);
            startFont.drawString(GAME_START_MESS1, GAME_TITLE_X + 100, GAME_TITLE_Y + 190);
            startFont.drawString(GAME_START_MESS2, GAME_TITLE_X + 100, GAME_TITLE_Y + 220);

            if(input.wasPressed(Keys.SPACE)) {
                startedGame = true;
            }
        }
        // Game has started!
        // code

        if (input.wasPressed(Keys.ESCAPE)) {
            Window.close();
        }
    }
}
