package grade;

public class GradeDTO {
	
	private int korScore;
	private int mathScore;
	private int engScore;
	private int scienceScore;
	
	public GradeDTO() {}

	public GradeDTO(int korScore, int mathScore, int engScore, int scienceScore) {
		this.korScore = korScore;
		this.mathScore = mathScore;
		this.engScore = engScore;
		this.scienceScore = scienceScore;
	}

	public int getKorScore() {
		return korScore;
	}

	public void setKorScore(int korScore) {
		this.korScore = korScore;
	}

	public int getMathScore() {
		return mathScore;
	}

	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}

	public int getEngScore() {
		return engScore;
	}

	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}

	public int getScienceScore() {
		return scienceScore;
	}

	public void setScienceScore(int scienceScore) {
		this.scienceScore = scienceScore;
	}

}
