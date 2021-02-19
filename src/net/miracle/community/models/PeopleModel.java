package net.miracle.community.models;

public class PeopleModel {
    private static Integer lastId;

    private Integer id;
    private Integer waitingTime;

    static {
        lastId = 0;
    }

    public PeopleModel(Integer waitingTime) {
        setId(++lastId);
        setWaitingTime(waitingTime);
    }

    public Integer getWaitingTime() {
        return waitingTime;
    }

    public static Integer getLastId() {
        return lastId;
    }

    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    public void setWaitingTime(Integer waitingTime) {
        this.waitingTime = waitingTime;
    }

    @Override
    public String toString() {
        return "PeopleModel{" +
                "id=" + id +
                ", waitingTime=" + waitingTime +
                '}';
    }
}
