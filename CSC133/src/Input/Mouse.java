package Input;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Data.Click;

public class Mouse implements MouseListener {
	
	private boolean isReady;
	private Click lastClick;
	
	public Mouse(){
		isReady = false;
		lastClick = null;
	}
	
	//Methods
	public void mouseClicked(MouseEvent arg0) {
		
	}
	
	public void mouseEntered(MouseEvent arg0) {
		
	}
	
	public void mouseExited(MouseEvent arg0) {
		
	}
	
	public void mousePressed(MouseEvent arg0) {
		
	}
	
	public void mouseReleased(MouseEvent arg0) {
		lastClick = new Click(arg0.getX(), arg0.getY(), arg0.getButton());
		isReady = true;
	}
	
	public Click pollClick() {
		if(!isReady) {
			return null;
		}
		isReady = false;
		return lastClick;
	}
	
	public boolean isReady() {
		return isReady;
	}
	
	public static Point getMouseCoords() {
		return MouseInfo.getPointerInfo().getLocation();
	}

}
