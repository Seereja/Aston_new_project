package hw4_smale_project.DTO;

public class ChildSectionDTO {
    private int id;
    private String name;
    private String surname;
    private int age;
    private String categoryInSports;
    private String sectionName;

    public ChildSectionDTO(int id, String name, String surname, int age, String categoryInSports, String sectionName) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.categoryInSports = categoryInSports;
        this.sectionName = sectionName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCategoryInSports() {
        return categoryInSports;
    }

    public void setCategoryInSports(String categoryInSports) {
        this.categoryInSports = categoryInSports;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }
}
