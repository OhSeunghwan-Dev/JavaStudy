package validation.member;

public class PositiveCheck {

	public boolean isPositive(int cash) {
		// 입력받은 액수가 0 이상인지 확인
		if (cash < 0) return false;
		
		return true;
	}

}
