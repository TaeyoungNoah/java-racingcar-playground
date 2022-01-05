package game;

import domain.Car;
import domain.Garage;
import utils.ValidationUtils;

import java.util.Scanner;

public class Game {
    private Scanner scanner = new Scanner(System.in);
    private Garage garage = new Garage();

    public void initialize() {
        getUserInputCarName();
        getUserInputTryTimes();
        progressGame();
    }

    private void getUserInputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String userInput = scanner.nextLine();
        String[] userInputArr = userInput.split(",");
        if(ValidationUtils.checkValidCarName(userInputArr)){
            buildGarage(userInputArr);
            return;
        }
        getUserInputCarName();
    }

    private void buildGarage(String[] userInputArr) {
        for (String carName : userInputArr) {
            garage.addCar(new Car(carName));
        }
    }

    private void getUserInputTryTimes() {
        System.out.println("시도할 회수는 몇회인가요?");
        String userInput = scanner.nextLine();
        try{
            garage.setTryTimes(ValidationUtils.checkValidTryTimes(userInput));
            return;
        } catch (IllegalStateException e){
            System.out.println(e.getMessage());
            getUserInputTryTimes();
        }
    }

    private void progressGame() {
        System.out.println(garage.getCars());
        System.out.println(garage.getTryTimes());
    }

}
