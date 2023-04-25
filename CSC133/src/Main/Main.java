package Main;

import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

import Data.Animation;
import Data.Click;
import Data.Command;
import Data.Frame;
import Data.RECT;
import FileIO.EZFileRead;
import FileIO.EZFileWrite;
import Input.Mouse;
import logic.Control;

import particles.ParticleSystem;
import particles.Rain;
import particles.Snow;

public class Main{
	// Fields (Static) below...
	//public static boolean isImageDrawn=true;
	public static String trigger = "";
//	public static String mouse = "";
//	public static RECT r;
//	public static RECT r1;
//	public static String s = "";
//	public static String a = "";
//	public static String c = "";
//	public static final int dropShadow = 2;
//	//private static Animation anim;
//	//private static final int screenWidth = 1280;
//	//private static final int step = 12;
//	// End Static fields...
//	private static Command c;
//	private static Command c2;
//	
//	private static String s2 = "";
//	private static int[] buffer;
//	private static RECT disk;
//	private static final int dropShadow = 2;
	//public static Rain rain;
	public static Snow snow;
//	
//	//private static Command[] commands;
//	private static ArrayList<Command> commands;
	
	public static void main(String[] args) {
		Control ctrl = new Control();				// Do NOT remove!
		ctrl.gameLoop();							// Do NOT remove!
	}
	
	/* This is your access to things BEFORE the game loop starts */
	public static void start(Control ctrl){
		// TODO: Code your starting conditions here...NOT DRAW CALLS HERE! (no addSprite or drawString)
		
		snow = new Snow(40, 40, 1200, 900, 250, 800, 1200);
//		r = new RECT(46, 3, 107, 123, "Persephone", new Frame(0, 0, "f1"));
//		r1 = new RECT(1288, 6, 1395, 126, "Chicken");
//		
//		anim = new Animation(120, true);
//		for (int i =0; i<4; i++) {
//			anim.addFrame(new Frame(1280, 0, "c"+i));
//		}
		
//		EZFileRead ezr = new EZFileRead("script.txt");
//		commands = new ArrayList<>();
//		for(int i =0; i<ezr.getNumLines(); i++) {
//			String raw = ezr.getLine(i);
//			raw = raw.trim();
//			if(!raw.equals("")) {
//				boolean b = raw.charAt(0) == '#';
//				if(!b) {
//					commands.add(new Command(raw));
//				}
//			}
//		}
//		
////		String raw = "show_sprite: 100, 100, f0"; 
////		String raw2 = "text: Howdy partner!";
////		c = new Command(raw);
////		c2= new Command(raw2);
//		
//		disk = new RECT(101, 52, 162, 112, "savetag", "Save Game");
//		buffer = new int[40];
//		
//		for(int i=0; i< buffer.length; i++) {
//			int value = (int) (Math.random() *100);
//			buffer[i] = value;
//		}
		
//		anim = new Animation(80, false);
//		int frameCounter = 0;
//		for (int x =-128; x<screenWidth; x+= step) {
//			anim.addFrame(new Frame(x, 0, "c"+ frameCounter));
//			frameCounter++;
//			if(frameCounter >3) {
//				frameCounter = 0;
//			}
//		}
		
	}
	
	/* This is your access to the "game loop" (It is a "callback" method from the Control class (do NOT modify that class!))*/
	public static void update(Control ctrl) {
		// TODO: This is where you can code! (Starting code below is just to show you how it works)
		
		ctrl.addSpriteToFrontBuffer(0,0, "snowbg");
		// Add rain particle stuff here..
		ParticleSystem pm2 = snow.getParticleSystem();
		Iterator<Frame> it2 = pm2.getParticles();
		while(it2.hasNext()) {
			Frame par2 = it2.next();
			ctrl.addSpriteToFrontBuffer(par2.getX(), par2.getY(), par2.getSpriteTag());
		}
//		ctrl.addSpriteToFrontBuffer(100, 50, "save");
//		
//		Point p = Mouse.getMouseCoords();
//		
//		int x = (int) p.getX();
//		int y = (int) p.getY();
//		
//		if(disk.isCollision(x, y)) {
//			s = disk.getHoverLabel();
//		}
//		else {
//			s = "";
//		}
//		ctrl.drawString(x, (y-2), s, Color.BLACK);
//		ctrl.drawString(x-dropShadow, (y-dropShadow)-2, s, Color.YELLOW);
//		
//		if(Control.getMouseInput() != null) {
//			if(disk.isClicked(Control.getMouseInput(), Click.LEFT_BUTTON)) {
//				saveData();
//				s2 = "Game Saved";
//			}
//		}
//		ctrl.drawString(0, 200, s2, Color.WHITE);
//		
//		
//		for(Command c: commands) {
//			if(c.isCommand("show_sprite") && c.getNumParms() == 3) {
//				int x1 = Integer.parseInt(c.getParmByIndex(0));
//				int y1 = Integer.parseInt(c.getParmByIndex(1));
//				String tag = c.getParmByIndex(2);
//				ctrl.addSpriteToFrontBuffer(x1, y1, tag);
//			}else if(c.isCommand("text") && c.getNumParms() ==1) {
//				String display = c.getParmByIndex(0);
//				ctrl.drawString(0, 250, display, Color.WHITE);
//			}
//		}
////		
//		
//		Frame curFrame = anim.getCurrentFrame();
//		if(curFrame != null) {
//			ctrl.addSpriteToFrontBuffer(curFrame.getX(), curFrame.getY(), curFrame.getSpriteTag());
//		}
//		
//		
//		if(r.isCollision(x,y)) {
//			ctrl.addSpriteToFrontBuffer(r.getGraphicalHover().getX(), r.getGraphicalHover().getY(), r.getGraphicalHover().getSpriteTag());
//		}
//		else {
//			c = "";
//		}
//		
//		
//		
//		if(r1.isCollision(x,y)) {
//			a= r1.getTag();
//		}
//		else {
//			a= "";
//		}
//		ctrl.drawString(x, (y-2), a, Color.BLACK);
//		ctrl.drawString(x-dropShadow, ((y-dropShadow)-2), a, Color.YELLOW);
		
//		if(c.isCommand("show_sprite") && c.getNumParms() == 3) { 
//			int x = Integer.parseInt(c.getParmByIndex(0)); 
//			int y = Integer.parseInt(c.getParmByIndex(1)); 
//			String tag = c.getParmByIndex(2); 
//			ctrl.addSpriteToFrontBuffer(x, y, tag);
//		}
//
//		if(c2.isCommand("text") && c2.getNumParms() == 1) {
//			String display = c2.getParmByIndex(0);
//			ctrl.drawString(0, 250, display, Color.WHITE);
//		}
		
		
		
//		if(anim.isFinished()) {
//			ctrl.drawString(0, 150, "Animation is Finished", Color.YELLOW);
//		}
		

	}
	
	// Additional Static methods below...(if needed)
//	public static void saveData() {
//		String out = "";
//		for(int i =0; i<buffer.length; i++)
//			out += buffer[i] + "*";
//		out = out.substring(0, out.length()-1);
//		EZFileWrite ezw = new EZFileWrite("save.txt");
//		ezw.writeLine(out);
//		ezw.saveFile();
//	}
//	
//	public static void loadData() {
//		EZFileRead ezr = new EZFileRead("save.txt");
//		String raw = ezr.getLine(0);
//		StringTokenizer st = new StringTokenizer(raw, "*");
//		if(st.countTokens() != buffer.length)
//			return;
//		for(int i =0; i<buffer.length; i++) {
//			String value = st.nextToken();
//			int val = Integer.parseInt(value);
//			buffer[i] = val;
//		}
//	}
	
	
}
