package member;

import java.util.Objects;

public class MemberDTO {
	
	private String name;
	private String id;
	private String pw;
	
	public MemberDTO() {}

	public MemberDTO(String name, String id, String pw) {
		this.name = name;
		this.id = id;
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberDTO memberDTO = (MemberDTO) o;
        return Objects.equals(id, memberDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
