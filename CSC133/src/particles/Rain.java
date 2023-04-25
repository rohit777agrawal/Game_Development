package particles;

public class Rain {
	
	private ParticleSystem parts;
	private String[] spriteTags;
	
	public Rain(int xpos, int ypos, int xrange, int yrange, int minlife, int maxlife, int numparticles) {
		spriteTags = new String[5];
		spriteTags[0] = "raindrop1";
		spriteTags[1] = "raindrop2";
		spriteTags[2] = "raindrop3";
		spriteTags[3] = "raindrop4";
		spriteTags[4] = "raindrop5";
		int xspeed = 6;
		int yspeed = 16;
		parts = new ParticleSystem(numparticles, xpos, ypos, xrange, yrange, minlife, maxlife, xspeed, yspeed, 16, 18, spriteTags);	
	}
	
	private void updateParticleSprite() {
		Particle[] pa = parts.getParticleArray();
		for(int i =0; i<pa.length; i++) {
			int stages = spriteTags.length;
			int life = pa[i].getLifecycle();
			int range = life/stages;
			int age = pa[i].getAge();
			for(int j=0; j<stages; j++) {
				if(age >= (range*j) && age <(range*(j+1))) {
					pa[i].changeSprite(spriteTags[j]);
					break;
				}
			}
		}
	}
	
	public ParticleSystem getParticleSystem() {
		updateParticleSprite();
		return parts;
	}

}
