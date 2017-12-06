package jiaobantao.data;

public class TestDAO {
    private String name;
    private long id;
    public TestDAO(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
