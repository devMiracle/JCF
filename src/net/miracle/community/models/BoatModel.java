package net.miracle.community.models;

public class BoatModel {
    private static Integer lastId;

    private Integer id;
    private Integer countEmptyPlaces;

    static {
        lastId = 0;
    }

    public BoatModel() {
        setId(++lastId);
        setCountEmptyPlaces(10);
    }

    public BoatModel(Integer countEmptyPlaces) {
        setId(++lastId);
        setCountEmptyPlaces(countEmptyPlaces);
    }

    public Integer getId() {
        return id;
    }

    public Integer getCountEmptyPlaces() {
        return countEmptyPlaces;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    public void setCountEmptyPlaces(Integer countEmptyPlaces) {
        this.countEmptyPlaces = countEmptyPlaces;
    }

    @Override
    public String toString() {
        return "BoatModel{" +
                "id=" + id +
                ", countEmptyPlaces=" + countEmptyPlaces +
                '}';
    }
}
