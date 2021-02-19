package net.miracle.community;

import net.miracle.community.models.BoatModel;
import net.miracle.community.models.PeopleModel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {


    public static void main(String[] args) {
        Queue<PeopleModel> queuePeople = new LinkedList<PeopleModel>();

        Queue<BoatModel> boatsList = new LinkedList<BoatModel>();

        for (int i = 0; i < 1000; i++) {
            boatsList.offer(new BoatModel(rnd(1, 10)));
        }
        for (Object item : boatsList) {
            // System.out.println("Boat " + ((BoatModel)item).getId() + " : " + ((BoatModel)item).getCountEmptyPlaces() + " empty places");
            System.out.println(((BoatModel)item).toString());
        }



        Integer intervalBoat = ConsoleController.inputInteger("Введите интервал прихода катеров");
        Integer intervalPeople = ConsoleController.inputInteger("Введите интервал прихода людей");
        Integer countPeopleInQueue = ConsoleController.inputInteger("Введите желаемое колличество людей в очереди");
        boolean isOverBoatStop = false; // TODO: пользователь сам должен вводить тип причала false - транзит


        BoatStop boatStop = new BoatStop(boatsList, queuePeople, intervalPeople, intervalBoat, isOverBoatStop, countPeopleInQueue);
        System.out.println("Среднее время ожидания: " + boatStop.getAverageWaitingTimeForPeople());

    }

    /**
     * Метод получения псевдослучайного целого числа от [min до max]
     */
    public static int rnd(int min, int max)
    {
        max -= min; // Отнимаем от максимального значения минимальное для получения множителя псевдослучайного вещественного числа.
        return (int) ((Math.random() * ++max)) + min;
    }
}
