public class Role {
    private String characterName;
    private Person person;
    private String roleType;

    public Role(String characterName, Person person, String roleType) {
        this.characterName = characterName;
        this.person = person;
        this.roleType = roleType;
    }

    public String getCharacterName() {
        return characterName;
    }

    public Person getPerson() {
        return person;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    @Override
    public String toString() {
        return "Role{" +
                "characterName='" + characterName + '\'' +
                ", person=" + person +
                ", roleType='" + roleType + '\'' +
                '}';
    }
}
