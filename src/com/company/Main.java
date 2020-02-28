package com.company;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static DecimalFormat df2 = new DecimalFormat("#.##");

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        //list of car models
        List<String> models = new ArrayList<String>();
        models.add("1.Model X");
        models.add("2.Model S");
        models.add("3.Model 3");

        List<String> answers = new ArrayList<String>();
        answers.add("1.Yes");
        answers.add("2.No");


        // assuming all variables here from online sources for model x s and 3
        int socketVoltage = 480; // 400 volts
        int socketAmps = 300; // 300 amps
        double costOfChargePerKWH = 0.28;// 28 cents
        double averageChargeEfficiencyForAllTeslaModels = 0.85; //85 percent
        double socketOutput = calculateSocketOutput(socketVoltage, socketAmps);
        double chargingIntake = calculatedChargingIntake(socketOutput, averageChargeEfficiencyForAllTeslaModels);
        double batCap = 0;
        double batcapModelXandS = 100;
        double batCpaModelThree = 75;
        double totalChargingCostForAllModel3 = 0;
        double totalChargingCostForAllModelX = 0;
        double totalChargingCostForAllModelS = 0;
        double totalFreeChargingForAllModelX = 0;
        double totalFreeChargingForAllModelS = 0;
        boolean freeCharging = false;
        double totalChargingTimeForModelX=0;
        double totalChargingTimeForModelS=0;
        double totalChargingTimeForModel3=0;
        double totalFreeChargingTimeForModelx=0;
        double totalFreeChargingTimeForModelS=0;

        questionWhichStall();
        double numberOfStalls = keyboard.nextDouble();
        for(double stall = numberOfStalls; stall > 0; stall-- ) {
            double totalStallTime = 0;

            questionHowManyCars();
            double numberOfCars = keyboard.nextDouble();

            for (double cars = numberOfCars; cars > 0; cars--) {
                welcomeMessage();
                questionModel();
                displayModels(models);
                int model = keyboard.nextInt();
                if (model == 1) {
                    batCap = +batcapModelXandS;
                    questionWhatChargeAt();
                    double originalCharge = keyboard.nextDouble();

                    questionWhatChargeWant();
                    double wantsChargeAt = keyboard.nextDouble();

                    double percentNeededToCharge = calculatedPercentNeededToCharge(wantsChargeAt, originalCharge);
                    double chargeCapacityThatNeedsCharge = calculatedCapNeedCharge(batCap, percentNeededToCharge);
                    double chargingTime = calculatedChargingTime(chargeCapacityThatNeedsCharge, chargingIntake);
                    double chargingCost = calculatedChargingCost(costOfChargePerKWH, chargeCapacityThatNeedsCharge,
                            averageChargeEfficiencyForAllTeslaModels);

                    double timeInMinutes = calculatedTimeInMinutes(chargingTime);
                    double timeJustHours = calculatedTimeJustHours(chargingTime);
                    double hoursInMinutes = calculatedHoursInMintues(timeJustHours);
                    double minutes = calculatedMinutes(timeInMinutes, hoursInMinutes);

                    displayChargingTime(timeJustHours, minutes);
                    displayChargingCost(chargingCost);
                    totalChargingCostForAllModelX = +chargingCost;
                    totalChargingTimeForModelX = +chargingTime;
                    totalStallTime =+ totalChargingTimeForModelX;

                    questionFreeCharging();
                    displayAnswerOptions(answers);
                    double answerToFreeCharging = keyboard.nextInt();


                    if (answerToFreeCharging == 1) {
                        freeCharging = true;
                        System.out.println("Enjoy free charging! You are good to go!\n");
                        totalFreeChargingForAllModelX = +chargingCost;
                        totalFreeChargingTimeForModelx = +chargingTime;
                        totalStallTime=+ totalFreeChargingTimeForModelx;
                    } else {
                        System.out.println("Don't forget to pay!\n");
                    }
                } else if (model == 2) {
                    batCap = +batcapModelXandS;
                    questionWhatChargeAt();
                    double originalCharge = keyboard.nextDouble();

                    questionWhatChargeWant();
                    double wantsChargeAt = keyboard.nextDouble();

                    double percentNeededToCharge = calculatedPercentNeededToCharge(wantsChargeAt, originalCharge);
                    double chargeCapacityThatNeedsCharge = calculatedCapNeedCharge(batCap, percentNeededToCharge);
                    double chargingTime = calculatedChargingTime(chargeCapacityThatNeedsCharge, chargingIntake);
                    double chargingCost = calculatedChargingCost(costOfChargePerKWH, chargeCapacityThatNeedsCharge,
                            averageChargeEfficiencyForAllTeslaModels);

                    double timeInMinutes = calculatedTimeInMinutes(chargingTime);
                    double timeJustHours = calculatedTimeJustHours(chargingTime);
                    double hoursInMinutes = calculatedHoursInMintues(timeJustHours);
                    double minutes = calculatedMinutes(timeInMinutes, hoursInMinutes);
                    displayChargingTime(timeJustHours, minutes);
                    displayChargingCost(chargingCost);
                    totalChargingCostForAllModelS = +chargingCost;
                    totalChargingTimeForModelS = +chargingTime;
                    totalStallTime=+ totalChargingTimeForModelS;


                    questionFreeCharging();
                    displayAnswerOptions(answers);
                    double answerToFreeCharging = keyboard.nextInt();
                    if (answerToFreeCharging == 1) {
                        freeCharging = true;
                        System.out.println("Enjoy free charging! You are good to go!\n");
                        totalFreeChargingForAllModelS = +chargingCost;
                        totalFreeChargingTimeForModelS = +chargingTime;
                        totalStallTime=+ totalFreeChargingTimeForModelS;
                    } else {
                        System.out.println("Don't forget to pay!\n");
                    }


                } else if (model == 3) {
                    batCap = +batCpaModelThree;
                    questionWhatChargeAt();
                    double originalCharge = keyboard.nextDouble();

                    questionWhatChargeWant();
                    double wantsChargeAt = keyboard.nextDouble();

                    double percentNeededToCharge = calculatedPercentNeededToCharge(wantsChargeAt, originalCharge);
                    double chargeCapacityThatNeedsCharge = calculatedCapNeedCharge(batCap, percentNeededToCharge);
                    double chargingTime = calculatedChargingTime(chargeCapacityThatNeedsCharge, chargingIntake);
                    double chargingCost = calculatedChargingCost(costOfChargePerKWH, chargeCapacityThatNeedsCharge,
                            averageChargeEfficiencyForAllTeslaModels);

                    double timeInMinutes = calculatedTimeInMinutes(chargingTime);
                    double timeJustHours = calculatedTimeJustHours(chargingTime);
                    double hoursInMinutes = calculatedHoursInMintues(timeJustHours);
                    double minutes = calculatedMinutes(timeInMinutes, hoursInMinutes);
                    displayChargingTime(timeJustHours, minutes);
                    displayChargingCost(chargingCost);
                    totalChargingCostForAllModel3 = +chargingCost;
                    totalChargingTimeForModel3 = +chargingTime;
                    totalStallTime=+ totalChargingTimeForModel3;

                } else {
                    System.out.println("Error please try again");
                }
            }





        }


        double totalChargingCost = calculatedTotalChargingCost(totalChargingCostForAllModelX,
                totalChargingCostForAllModelS,totalChargingCostForAllModel3);
        displayTotalChargingcost(totalChargingCost);

        double totalChargingTime =calculatedTotalTime(totalChargingTimeForModelS,
                totalChargingTimeForModelX,totalChargingTimeForModel3);
        double totalTimeJustHours = calculatedTimeJustHours(totalChargingTime);
        double totalHoursInMinutes = calculatedHoursInMintues(totalTimeJustHours);
        double totalTimeInMintues = calculatedTimeInMinutes(totalChargingTime);
        double totalMintues = calculatedMinutes(totalTimeInMintues,totalHoursInMinutes);
        displayTotalTimeForAllTeslas(totalTimeJustHours,totalMintues);


        double totalFreeTimeChargingForAll = calculatedTotalFreeChargingTimeAtStall(totalFreeChargingTimeForModelS,
                totalFreeChargingTimeForModelx);
        double totalFreeTimeJustHours = calculatedTimeJustHours(totalFreeTimeChargingForAll);
        double totalFreeHoursInMinutes = calculatedHoursInMintues(totalFreeTimeJustHours);
        double totalFreeTimeInMintues = calculatedTimeInMinutes(totalFreeTimeChargingForAll);
        double totalFreeMintues = calculatedMinutes(totalFreeTimeInMintues,totalFreeHoursInMinutes);
        displayTotalFreeTime(totalFreeTimeJustHours,totalFreeMintues);

        double totalFreeCHargingForStation = calculatedTotalFreeChargingTimeAtStation(totalFreeChargingTimeForModelx,
                totalFreeChargingTimeForModelS);
        displayTotalFreeChargingCost(totalFreeCHargingForStation);


    }
    public static void welcomeMessage(){
        System.out.println("\nWelcome to Tesla SuperCharging Station number 3. \n" +
                "We have 4 booths here for Tesla vehicles to charge at.\n" +
                "It cost $0.28 per kwh to charge at this station.Unless you drive a mode X or S Purchased \n" +
                "before September 18,2019. In which case you charge for free.\n");
    }
    public static void displayModels (List models){
        System.out.println(models);
    }
    public static void questionModel (){
        System.out.println("What Kind of Tesla Model do you Drive?");
    }
    public static void questionWhichStall(){
        System.out.println("How many stalls are at this station?");
    }
    public static void questionHowManyCars(){
        System.out.println("How many cars came to charge at any given stall?");
    }
    public static double calculateSocketOutput(double socketVoltage, double socketAmps){
        return (socketVoltage * socketAmps) / 1000;
    }
    public static double calculatedChargingIntake(double socketOutput, double averageChargeEfficiencyForAllTeslaModels){
       return (socketOutput * averageChargeEfficiencyForAllTeslaModels);
    }
    public static void questionWhatChargeAt(){
        System.out.println("What charge is your Tesla at?");
    }
    public static void questionWhatChargeWant(){
        System.out.println("and what charge would you like it to be at?");
    }
    public static double calculatedPercentNeededToCharge(double wantsChargeAt, double originalCharge){
        return (wantsChargeAt - originalCharge) / 100;
    }
    public static double calculatedMinutes(double timeInMintues, double hoursInMinutes){
        return timeInMintues - hoursInMinutes;
    }
    public static double calculatedHoursInMintues(double timeInHours){
        return timeInHours * 60;
    }
    public static double calculatedTimeJustHours(double chargingTime){
        return (int) chargingTime;
    }
    public static double calculatedTimeInMinutes( double chargingTime){
        return chargingTime*60;
    }
    public static double calculatedCapNeedCharge(double batCap,double percentNeededToCharge){
        return batCap * percentNeededToCharge;
    }
    public static double calculatedChargingTime (double chargeCapacityThatNeedsCharge, double chargingIntake){
        return chargeCapacityThatNeedsCharge / chargingIntake;
    }
    public static double calculatedChargingCost(double costOfChargePerKWH, double chargeCapacityThatNeedsCharge,
                                                double averageChargeEfficiencyForAllTeslaModels){
        return (costOfChargePerKWH * chargeCapacityThatNeedsCharge) / averageChargeEfficiencyForAllTeslaModels;
    }
    public static void displayChargingTime(double timeInhours, double mintues){
        System.out.println("Your charging time is " + timeInhours + " hrs and " + (int) (mintues) + " mins.\n");
    }
    public static void displayChargingCost (double chargingCost){
        System.out.println("Your charging cost is $"+ df2.format(chargingCost)+"\n");
    }
    public static void questionFreeCharging(){
        System.out.println("Do you have unlimted free super charging?");
    }
    public static void displayAnswerOptions(List answers){
        System.out.println(answers);
    }
    public static void displayTotalChargingcost(double totalChargingCost){
        System.out.println("The total charging cost at this staion is $"+ df2.format(totalChargingCost)+"\n");
    }
    public static double calculatedTotalChargingCost(double totalChargingCostForAllModelX,double totalChargingCostForAllModelS,
                                                   double totalChargingCostForAllModelThree){
        return  totalChargingCostForAllModelS+totalChargingCostForAllModelThree+totalChargingCostForAllModelX;
    }
    public static double calculatedTotalTime(double totalChargingTimeForModelS,double totalChargingTimeForModelX,
                                             double totalChargingTimeForModel3){
        return totalChargingTimeForModelS+totalChargingTimeForModel3+totalChargingTimeForModelX;
    }
    public static void displayTotalTimeForAllTeslas(double totalTimeInhours,double totalMintues){
        System.out.println("The total time for all vehicles that came to the station is "+ totalTimeInhours +
                " hrs and " + (int) (totalMintues) + " mins.\n");
    }
    public static double calculatedTotalFreeChargingTimeAtStall(double totalFreeChargingForAllModelX,
                                                     double totalFreeChargingForAllModelS){
        return totalFreeChargingForAllModelX + totalFreeChargingForAllModelS;
    }
    public static void displayTotalFreeTime(double totalFreeTimeJustHours, double totalFreeMinutes){
        System.out.println("The total free charging time that came to this station is "+ totalFreeTimeJustHours+" hrs and "
                + (int) totalFreeMinutes+" mins.\n");
    }
    public  static void displayTotalFreeChargingCost(double totalFreeCHargingForStation){
        System.out.println("The total free charging cost that came to this station is $"
                + df2.format(totalFreeCHargingForStation));
    }
    public static double calculatedTotalFreeChargingTimeAtStation(double totalFreeChargingTimeForModelx,
                                                         double totalFreeChargingTimeForModelS){
        return totalFreeChargingTimeForModelS+totalFreeChargingTimeForModelx;

    }


}

