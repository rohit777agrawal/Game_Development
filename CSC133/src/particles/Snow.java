package particles;

public class Snow {
	
	private ParticleSystem parts;
	private String[] spriteTags;
	
	public Snow(int xpos, int ypos, int xrange, int yrange, int minlife, int maxlife, int numparticles) {
		spriteTags = new String[7];
		spriteTags[0] = "snow";
		spriteTags[1] = "snow1";
		spriteTags[2] = "snow2";
		spriteTags[3] = "snow3";
		spriteTags[4] = "snow4";
		spriteTags[5] = "snow5";
		spriteTags[6] = "snow6";
		int xspeed = 0;
		int yspeed = 2;
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
