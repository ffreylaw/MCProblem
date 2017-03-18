
public class State {
	
	private int mLeft;
	private int cLeft;
	private int mRght;
	private int cRght;
	private boolean boat;
	
	public State(int mLeft, int cLeft, int mRght, int cRght, boolean boat) {
		this.mLeft = mLeft;
		this.cLeft = cLeft;
		this.mRght = mRght;
		this.cRght = cRght;
		this.boat = boat;
	}
	
	public boolean compare(State o) {
		if (this.mLeft == o.getMLeft() && this.cLeft == o.getCLeft() && this.mRght == o.getMRght() && this.cRght == o.getCRght() && this.boat == o.boatOnLeft()) {
			return true;
		} else {
			return false;
		}
		
	}

	public int getMLeft() {
		return mLeft;
	}

	public int getCLeft() {
		return cLeft;
	}

	public int getMRght() {
		return mRght;
	}

	public int getCRght() {
		return cRght;
	}

	public boolean boatOnLeft() {
		return boat;
	}
	
	@Override
	public String toString() {
		String str = "{ State: " + this.mLeft + " " + this.cLeft
				     + " " + this.mRght + " " + this.cRght;
		str += this.boat ? " Left }" : " Right }";
		return str;
	}

}
