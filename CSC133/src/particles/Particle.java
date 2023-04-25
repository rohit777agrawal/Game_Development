package particles;

import Data.Frame;
import timer.stopWatchX;

public class Particle {
	private int x,y;
	private String particleSpriteTag;
	private int lifecycle;
	private int age;
	private int xMove, yMove;
	private stopWatchX timer;
	private int rootX, rootY;
	private boolean isReset;
	
	public Particle(int minX, int maxY, int minY, int maxX, String particleSpriteTag, 
			int minlife, int maxLife, int xMove, int yMove, int mindelay, int maxdelay) {
		// Initialize all of the needed data for a single particle

		this.particleSpriteTag = particleSpriteTag;
		this.x = getRandomInt(minX, maxX); 
		this.y = getRandomInt(minY, maxY);
		lifecycle = getRandomInt (minlife, maxLife);
		this.xMove = xMove;
		this.yMove = yMove;
		int delay = getRandomInt(mindelay, maxdelay); 
		timer = new stopWatchX(delay);
		rootX = x;
		rootY = y;
	}

	public boolean hasBeenReset() {
		return isReset;
	}
	
	public void changeX(int newX) {
		x = newX;
	}
	
	public int getX() {
		return x;
	}

	public int getLifecycle() {
		return lifecycle;
	}

	public int getAge() {
		return age;
	}
	
	public void changeSprite(String newSpriteTag) {
		particleSpriteTag = newSpriteTag;
	}
	
	public boolean isParticleDead(){ 
		if(age >= lifecycle) {
			return true;
		}
		if(y > 720 || x > 1279) {
			return true;
		}
		return false;
	}

	public void simulateAge(){

		age++;
		x += xMove; 
		y += yMove;
		if(isParticleDead()) { // Reset x= rootX; isReset = true;
			x= rootX;
			y= rootY; 
			age= 0;
			isReset = true;
		}
	}

	public Frame getCurrentFrame(){
	// Update the particle and return results
		if(timer.isTimeUp()) {
			age++; 
			x += xMove;
			y += yMove; 
			if(isParticleDead()){
				// Reset
				x = rootX;	
				y = rootY; 
				age = 0;
				isReset = true;
			}
			timer.resetWatch();
		}
		return new Frame(x, y, particleSpriteTag);
	}
	
	public static int getRandomInt(int first, int last) {
		int diff = last - first;
		double num = Math.random() * diff;
		int intNum = (int)num;
		return first + intNum;
	}
	
	public static int rollDie(int dieSlides) {
		double results = Math.random() * dieSlides;
		int res = (int) results;
		res++;
		return res;
	}
	
	
}
