package ru.yandex.incoming34.SpringHomeWork7.entities;
import java.io.Serializable;
	import java.util.Objects;
	import java.util.Set;
	 
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

	@Entity
	@Table(name = "roles")
	public class Role implements Serializable {
	    private static final long serialVersionUID = 1L;
	    public static final String USER = "USER";
	    public static final String ADMIN = "ADMIN";
	    public static final String ROLE_USER = "ROLE_USER";
	    public static final String ROLE_ADMIN = "ROLE_ADMIN";
	 
	    @Id
	    @Column(name = "role_id")
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int roleId;
	 
	    private String name;
	 
	    
	    public Role(int roleId, String name, Set<User> users) {
			super();
			this.roleId = roleId;
			this.name = name;
			this.users = users;
		}

		// bi-directional many-to-many association to User
	    @ManyToMany
		@JoinTable(name = "user_role", 
		joinColumns = { @JoinColumn(name = "role_id") }, 
		inverseJoinColumns = { @JoinColumn(name = "user_id") })
	    private Set<User> users;
	 
	    public int getRoleId() {
			return roleId;
		}

		public void setRoleId(int roleId) {
			this.roleId = roleId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Set<User> getUsers() {
			return users;
		}

		public void setUsers(Set<User> users) {
			this.users = users;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		public static String getUser() {
			return USER;
		}

		public static String getAdmin() {
			return ADMIN;
		}

		public static String getRoleUser() {
			return ROLE_USER;
		}

		public static String getRoleAdmin() {
			return ROLE_ADMIN;
		}

		public Role(String name) {
	        this.name = name;
	    }
	 
	    @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + ((name == null) ? 0 : name.hashCode());
	        return result;
	    }
	 
	    @Override
	    public boolean equals(final Object obj) {
	        if (this == obj) {
	            return true;
	        }
	        if (obj == null) {
	            return false;
	        }
	        if (getClass() != obj.getClass()) {
	            return false;
	        }
	        return Objects.equals(name, ((Role) obj).getName());
	    }
	 
	    @Override
	    public String toString() {
	        final StringBuilder builder = new StringBuilder();
	        builder.append("Role [name=").append(name).append("]").append("[id=").append(roleId).append("]");
	        return builder.toString();
	    }
}
