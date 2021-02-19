package net.miracle.community;

import net.miracle.community.models.BoatModel;
import net.miracle.community.models.PeopleModel;

import java.util.List;
import java.util.Queue;

public class BoatStop {
    private Queue<BoatModel> queueBoats;
    private Queue<PeopleModel> queuePeople;
    private final Integer intervalPeople;
    private final Integer intervalBoat;
    private final Integer countPeopleInQueue;
    private Boolean isOverBoatStop;
    private Double itemForSizeQueue;

    public BoatStop(Queue queueBoats, Queue queuePeople, Integer intervalPeople, Integer intervalBoat, Boolean isOverBoatStop, Integer countPeopleInQueue) {
        this.countPeopleInQueue = countPeopleInQueue;
        this.queueBoats = queueBoats;
        this.queuePeople = queuePeople;
        this.intervalBoat = intervalBoat;
        this.intervalPeople = intervalPeople;
        this.isOverBoatStop = isOverBoatStop;
    }

    public Double getAverageWaitingTimeForPeople(){
        double countPeoplePerOneIntervalBoat = intervalBoat / intervalPeople;
        System.out.println(countPeoplePerOneIntervalBoat);
        Integer countPeople = (int)countPeoplePerOneIntervalBoat;
        System.out.println(countPeople);
        Integer waitTime = intervalBoat;
        double sumOfTime = 0;
        Integer iterator = 0;
        double globalWaitSum = 0;
        Integer globalIteration = 0;
        while (queueBoats.size() != 0) {
            System.out.println("---------------start");

            // System.out.println(queueBoats.size());
            waitTime = intervalBoat;
            // 1
            for (int j = countPeople; j > 0; j--) {
                queuePeople.offer(new PeopleModel(waitTime));
                waitTime = waitTime - intervalPeople;
            }
            System.out.println(queuePeople.toString());
            System.out.println(queuePeople.size());


            // 2
            iterator = 0;
            sumOfTime = 0;
            for (PeopleModel item : queuePeople) {

                if (iterator < countPeople) {
                    // System.out.println(sumOfTime + item.getWaitingTime());
                    sumOfTime = (sumOfTime + item.getWaitingTime());
                    iterator++;
                }
                item.setWaitingTime(item.getWaitingTime() + intervalBoat);
            }
            sumOfTime = sumOfTime / countPeople;
            if (queuePeople.size() == countPeopleInQueue){
                itemForSizeQueue = sumOfTime;
            }
            System.out.println("SUM: " + sumOfTime);
            // 3
            if (isOverBoatStop) {
                System.out.println("свободных мест: " + 8);
                if (queuePeople.size() >= 8) {
                    for (int j = 8; j > 0; j--) {
                        queuePeople.remove();
                        // System.out.println("remove");
                    }
                } else {
                    for (int j = queuePeople.size(); j > 0; j--) {
                        queuePeople.remove();
                        // System.out.println("empty");
                    }
                }
                queueBoats.remove();
                globalWaitSum = globalWaitSum + sumOfTime;
                globalIteration++;
                System.out.println("globalWaitSum: " + globalWaitSum / globalIteration);
            } else {
                System.out.println("свободных мест: " + queueBoats.peek().getCountEmptyPlaces());
                if (queuePeople.size() >= queueBoats.peek().getCountEmptyPlaces()) {

                    for (int j = queueBoats.peek().getCountEmptyPlaces(); j > 0; j--) {
                        queuePeople.remove();
                        // System.out.println("remove");
                    }
                } else {
                    for (int j = queuePeople.size(); j > 0; j--) {
                        queuePeople.remove();
                        // System.out.println("empty");
                    }
                }
                queueBoats.remove();
                globalWaitSum = globalWaitSum + sumOfTime;
                globalIteration++;
                System.out.println("globalWaitSum: " + globalWaitSum / globalIteration);
            }
            System.out.println("----------");
        }
        System.out.println("Рекомендуемый интервал между катерами: " + itemForSizeQueue + " минут");

        return globalWaitSum / globalIteration;
    }




}
