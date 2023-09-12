import bagel.*;
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
    private final Image LEFT_LANE = new Image("res/laneLeft.png");
    private final Image RIGHT_LANE = new Image("res/laneRight.png");
    private final Image DOWN_LANE = new Image("res/laneDown.png");
    private final Image UP_LANE = new Image("res/laneUp.png");
   // To keep count of how many frames have been passed/drawn
    private int frameCounter;
    private Score currScore = new Score(0);
    public ShadowDance(){
        super(WINDOW_WIDTH, WINDOW_HEIGHT, GAME_TITLE);
    }

    // ArrayLists for each lane
    ArrayList<Note> leftNotesArray = new ArrayList<>();
    ArrayList<Note> upNotesArray = new ArrayList<>();
    ArrayList<Note> downNotesArray = new ArrayList<>();
    ArrayList<Note> rightNotesArray = new ArrayList<>();
    ArrayList<Lane> lanesArray = new ArrayList<Lane>();

    // readCSV() method to parse through CSV file
    private void readCSV() {
        try(BufferedReader br = new BufferedReader(new FileReader("res/level1.csv"))) {
            String csvLine;
            while((csvLine = br.readLine()) != null) {
                String fields[] = csvLine.split(",");
                // Read in the lane coordinates
                if(fields[0].equals("Lane")) {
                    //System.out.println("LANE!!!!!!");
                    String laneType = fields[1];
                    int laneXCoord = Integer.parseInt(fields[2]);
                    // Create the lane to add into lanes ArrayList
                    Lane currLane = new Lane(laneType, laneXCoord);
                   // System.out.println(laneType);
                    lanesArray.add(currLane);
                }
                // Else it'll be for the note(s)
                int noteFrameNumber = Integer.parseInt(fields[2]);
                createNote(fields[0], fields[1], noteFrameNumber, lanesArray);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    // Function that creates notes and adds into allNotesArray
   private void createNote(String laneType, String noteType, int frameNumber, ArrayList<Lane> laneArrList) {
        int startX;
        Note currNote;
        // It's a normal note
        if(noteType.equals("Normal")) {
            if(laneType.equals("Left")) {
                startX = laneArrList.get(0).getLaneX();
                currNote = new NormalNote(laneType, startX, frameNumber);
                leftNotesArray.add(currNote);
            }
            if(laneType.equals("Up")) {
                startX = laneArrList.get(2).getLaneX();
                currNote = new NormalNote(laneType, startX, frameNumber);
                upNotesArray.add(currNote);
            }
            if(laneType.equals("Down")) {
                startX = laneArrList.get(3).getLaneX();
                currNote = new NormalNote(laneType, startX, frameNumber);
                downNotesArray.add(currNote);
            }
            if(laneType.equals("Right")) {
                startX = laneArrList.get(1).getLaneX();
                currNote = new NormalNote(laneType, startX, frameNumber);
                rightNotesArray.add(currNote);
            }
        }
        // It's a hold note
       if(noteType.equals("Hold")) {
           if(laneType.equals("Left")) {
               startX = laneArrList.get(0).getLaneX();
               currNote = new HoldNote(laneType, startX, frameNumber);
               leftNotesArray.add(currNote);
           }
           if(laneType.equals("Up")) {
               startX = laneArrList.get(2).getLaneX();
               currNote = new HoldNote(laneType, startX, frameNumber);
               upNotesArray.add(currNote);
           }
           if(laneType.equals("Down")) {
               startX = laneArrList.get(3).getLaneX();
               currNote = new HoldNote(laneType, startX, frameNumber);
               downNotesArray.add(currNote);
           }
           if(laneType.equals("Right")) {
               startX = laneArrList.get(1).getLaneX();
               currNote = new HoldNote(laneType, startX, frameNumber);
               rightNotesArray.add(currNote);
           }
       }
    }

    /**
     * The entry point for the program.
     */
    public static void main(String[] args) {
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
        // Game hasn't started yet
        if(!startedGame) {
            // Draw the starting message/window of the game
            defaultFont.drawString(GAME_TITLE, GAME_TITLE_X, GAME_TITLE_Y);
            //System.out.println("Hello" + defaultFont.getWidth(GAME_TITLE)/2.0);
            startFont.drawString(GAME_START_MESS1, GAME_TITLE_X + 100, GAME_TITLE_Y + 190);
            startFont.drawString(GAME_START_MESS2, GAME_TITLE_X + 100, GAME_TITLE_Y + 220);

            // Sets it to 0
            frameCounter = -1;

            if(input.wasPressed(Keys.SPACE)) {
                startedGame = true;
            }
        }
        // Game has started!
        if(startedGame) {
            // Draw the lanes
            Lane leftLane = new Lane(lanesArray.get(0).getLaneType(), lanesArray.get(0).getLaneX());
            Lane upLane = new Lane(lanesArray.get(2).getLaneType(), lanesArray.get(2).getLaneX());
            Lane downLane = new Lane(lanesArray.get(3).getLaneType(), lanesArray.get(3).getLaneX());
            Lane rightLane = new Lane(lanesArray.get(1).getLaneType(), lanesArray.get(1).getLaneX());

            LEFT_LANE.draw(leftLane.getLaneX(), leftLane.getLaneY());
            UP_LANE.draw(upLane.getLaneX(), upLane.getLaneY());
            DOWN_LANE.draw(downLane.getLaneX(), downLane.getLaneY());
            RIGHT_LANE.draw(rightLane.getLaneX(), rightLane.getLaneY());

            // Start putting notes into game
            leftLane.laneDraw(leftNotesArray, frameCounter, input, currScore);
            upLane.laneDraw(upNotesArray, frameCounter, input, currScore);
            downLane.laneDraw(downNotesArray, frameCounter, input, currScore);
            rightLane.laneDraw(rightNotesArray, frameCounter, input, currScore);

            // Drawing and keeping track of the current game's score
            currScore.getScoreFont().drawString("SCORE " + currScore.getTheScore(), 35, 35);

            // Update frameCounter each time update() is called
            frameCounter++;
        }

        if (input.wasPressed(Keys.ESCAPE)) {
            Window.close();
        }
    }


}