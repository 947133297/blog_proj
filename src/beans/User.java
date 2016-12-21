package beans;

public class User {
	private int uid;

	private String name="";
    private String password="";
	private String nick="";
	private int role=0;

	public User(String name,String password){
		this.name = name;
	}
	public User(int uid,String username,String nick,int role){
		this.uid=uid;
		this.name=username;
		this.nick=nick;
		this.role=role;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getRole() {
		return role;
	}

	public int getUid() {
		return uid;
	}

	public String getNick() {
		return nick;
	}

    public String getPassword() {
        return password;
    }

    public void setNick(String nick) {
		this.nick = nick;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

    public void setPassword(String password) {
        this.password = password;
    }
}
