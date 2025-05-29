package member.model;

import java.text.SimpleDateFormat;
import java.util.Objects;

public class User {
	
	private String id;
	private String pwd;
	private String name;
	private String email;
	private String address;
	final private SimpleDateFormat date;
	
	// 생성자
	public User(String id, String pwd, String name, String email, String address) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.address = address;
		this.date = new SimpleDateFormat("yyyy/MM/dd");
	}
		
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public SimpleDateFormat getDate() {
		return date;
	}


	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id); // id 필드의 해시코드를 반환한다.
    }
}
