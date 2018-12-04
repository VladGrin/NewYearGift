package com.newyeargift.manager;

import com.newyeargift.exception.IncorrectOutputException;
import com.newyeargift.model.Gift;
import com.newyeargift.service.GiftService;
import com.newyeargift.service.SweetService;
import com.newyeargift.service.impl.GiftServiceFileImpl;
import com.newyeargift.service.impl.SweetServiceFileImpl;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class Manager {

    private final static Logger logger = Logger.getLogger(Manager.class);
    private Gift gift = new Initial().getNewGift();
    private Scanner scanner = new Scanner(System.in);
    private GiftService giftService = new GiftServiceFileImpl();
    private SweetService sweetService = new SweetServiceFileImpl();

    public void run() {
        boolean isDone = true;
        int choice = 0;
        String message;
        System.out.println("press < 1 > to determine the weight of the gift");
        System.out.println("press < 2 > to sort by weight");
        System.out.println("press < 3 > to find a sweet by name");
        System.out.println("press < 4 > to find a sweet by weight");
        System.out.println("press < 5 > to save the gift");
        System.out.println("press < 6 > to exit");
        while (isDone) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                logger.error("Incorrect data");
                continue;
            }

            switch (choice) {
                case 1:
                    message = "Total weight : " + giftService.getWeightGift(gift);
                    sweetService.saveResultToFile(message);
                    logger.info(message);
                    break;
                case 2:
                    message = "Sweets sorted in gift : " + giftService.getSweetsSortedByWeight(gift);
                    sweetService.saveResultToFile(message);
                    logger.info(message);
                    break;
                case 3:
                    System.out.println("Input sweet name");
                    try {
                        message = "Found sweet : " + giftService.findSweetsByName(gift, scanner.nextLine());
                        sweetService.saveResultToFile(message);
                        logger.info(message);
                    } catch (IncorrectOutputException e) {
                        logger.error(e.getMessage());
                    }
                    break;
                case 4 :
                    System.out.println("Input start weight");
                    int startWeight = scanner.nextInt();
                    System.out.println("Input end weight");
                    int endWeight = scanner.nextInt();
                    scanner.nextLine();
                    try {
                        message = "Found sweets with weight from " + startWeight + " to " + endWeight +
                                " : " + giftService.findSweetsByWeight(gift, startWeight, endWeight);
                        sweetService.saveResultToFile(message);
                        logger.info(message);
                    } catch (IncorrectOutputException e) {
                        logger.error(e.getMessage());
                    }
                    break;
                case 5 :
                    message = "Object successfully serialized.";
                    giftService.saveGiftObjectSerialization(gift);
                    logger.info(message);
                    break;
                case 6:
                    message = "The application has been stopped.";
                    isDone = false;
                    logger.info(message);
                    break;
                default:
                    System.out.println("Make your choice");
            }
        }
    }
}
