package Data;

public class RECT {
	
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private String tag;
	private String hoverLabel;
	private Frame gHover;
	
	public RECT(int x1, int y1, int x2, int y2, String tag) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.tag = tag;
		hoverLabel = "";
		gHover = null;
	}
	
	public RECT(int x1, int y1, int x2, int y2, String tag, String hoverLabel) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.tag = tag;
		this.hoverLabel = hoverLabel;
		gHover = null;
	}
	
	public RECT(int x1, int y1, int x2, int y2, String tag, Frame gHover) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.tag = tag;
		hoverLabel = "";
		this.gHover = gHover;
	}
	
	public RECT(int x1, int y1, int x2, int y2, String tag, String hoverLabel, Frame gHover) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.tag = tag;
		this.hoverLabel = hoverLabel;
		this.gHover = gHover;
	}
	
	
	public String getTag() {
		return tag;
	}
	
	public boolean isCollision(int x, int y) {
		if(x >= x1 && x<= x2) {
			if(y >= y1 && y<= y2) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isClicked(Click c, int buttonComparator) {
		if(c.getButton() != buttonComparator) {
			return false;
		}
		return isCollision(c.getX(), c.getY());
	}
	
	public String getHoverLabel(){
		return hoverLabel;
	}
	
	public Frame getGraphicalHover() {
		return gHover;
	}

}
