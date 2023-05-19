package CameraRentalApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Camera {
    private String brand;
    private String model;
    private double rentalAmount;

    public Camera(String brand, String model, double rentalAmount) {
        this.brand = brand;
        this.model = model;
        this.rentalAmount = rentalAmount;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getRentalAmount() {
        return rentalAmount;
    }
}

public class CameraRentalApplication {
    private List<Camera> cameraList;
    private List<Camera> myCameraList;
    private double walletAmount;

    public CameraRentalApplication() {
        cameraList = new ArrayList<>();
        myCameraList = new ArrayList<>();
        walletAmount = 0.0;
    }

    public void addCamera(Camera camera) {
        cameraList.add(camera);
    }

    public void listCameras() {
        if (cameraList.isEmpty()) {
            System.out.println("No Data Present at This Moment");
        } else {
            System.out.println("Camera Listing:");
            for (int i = 0; i < cameraList.size(); i++) {
                Camera camera = cameraList.get(i);
                System.out.println("[" + i + "] Brand: " + camera.getBrand() + " | Model: " + camera.getModel() +
                        " | Rental Amount per day: $" + camera.getRentalAmount());
            }
        }
    }

    public void rentCamera(int index) {
        if (index >= 0 && index < cameraList.size()) {
            Camera camera = cameraList.get(index);
            if (walletAmount >= camera.getRentalAmount()) {
                walletAmount -= camera.getRentalAmount();
                myCameraList.add(camera);
                System.out.println("You rented the following camera:");
                System.out.println("Brand: " + camera.getBrand() + " | Model: " + camera.getModel() +
                        " | Rental Amount per day: $" + camera.getRentalAmount());
            } else {
                System.out.println("Insufficient balance in your wallet. Please add funds to rent this camera.");
            }
        } else {
            System.out.println("Invalid camera selection.");
        }
    }

    public void addToWallet(double amount) {
        walletAmount += amount;
        System.out.println("Wallet amount updated. Current balance: $" + walletAmount);
    }

    public void viewWalletAmount() {
        System.out.println("Current wallet amount: $" + walletAmount);
    }

    public void listMyCameras() {
        if (myCameraList.isEmpty()) {
            System.out.println("No cameras rented at the moment.");
        } else {
            System.out.println("My Cameras:");
            for (int i = 0; i < myCameraList.size(); i++) {
                Camera camera = myCameraList.get(i);
                System.out.println("[" + i + "] Brand: " + camera.getBrand() + " | Model: " + camera.getModel() +
                        " | Rental Amount per day: $" + camera.getRentalAmount());
            }
        }
    }

    public void removeCamera(int index) {
        if (index >= 0 && index < myCameraList.size()) {
            Camera camera = myCameraList.get(index);
            myCameraList.remove(index);
            System.out.println("Camera removed:");
            System.out.println("Brand: " + camera.getBrand() + " | Model: " + camera.getModel() +
                    " | Rental Amount per day: $" + camera.getRentalAmount());
        } else {
            System.out.println("Invalid camera selection.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = "arpit";
        String password = "sachuarpit1999";

        System.out.println("Welcome to Camera Rental Application");
        System.out.println("Please login to continue.");

        System.out.print("Username: ");
        String enteredUsername = scanner.nextLine();

        System.out.print("Password: ");
        String enteredPassword = scanner.nextLine();

        if (enteredUsername.equals(username) && enteredPassword.equals(password)) {
            CameraRentalApplication application = new CameraRentalApplication();
            application.addCamera(new Camera("Canon", "EOS 5D Mark IV", 25.0));
            application.addCamera(new Camera("Nikon", "D850", 30.0));
            application.addCamera(new Camera("Sony", "Alpha A7R IV", 35.0));
            application.addCamera(new Camera("Canon", "C500 MKII", 55.0));
            application.addCamera(new Camera("Sony", "Cyber-Shot", 15.0));
            application.addCamera(new Camera("Nikon", "D200", 40.0));
            int choice;

            while (true) {
                System.out.println();
                System.out.println("1. List Cameras");
                System.out.println("2. Rent a Camera");
                System.out.println("3. Add to Wallet");
                System.out.println("4. View Wallet Amount");
                System.out.println("5. My Camera");
                System.out.println("6. Close Application");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        application.listCameras();
                        break;
                    case 2:
                        System.out.print("Enter the index of the camera you want to rent: ");
                        int index = scanner.nextInt();
                        application.rentCamera(index);
                        break;
                    case 3:
                        System.out.print("Enter the amount to add to your wallet: $");
                        double amount = scanner.nextDouble();
                        application.addToWallet(amount);
                        break;
                    case 4:
                        application.viewWalletAmount();
                        break;
                    case 5:
                        int subChoice;
                        while (true) {
                            System.out.println();
                            System.out.println("My Camera:");
                            System.out.println("1. List My Cameras");
                            System.out.println("2. Remove a Camera");
                            System.out.println("3. Go back to the previous menu");
                            System.out.print("Enter your choice: ");
                            subChoice = scanner.nextInt();

                            switch (subChoice) {
                                case 1:
                                    application.listMyCameras();
                                    break;
                                case 2:
                                    System.out.print("Enter the index of the camera to remove: ");
                                    int removeIndex = scanner.nextInt();
                                    application.removeCamera(removeIndex);
                                    break;
                                case 3:
                                    break;
                                default:
                                    System.out.println("Invalid choice. Please try again.");
                            }

                            if (subChoice == 3) {
                                break;
                            }
                        }
                        break;
                    case 6:
                        System.out.println("Closing the application...");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Invalid username or password. Exiting the application...");
            scanner.close();
            System.exit(0);
        }
    }
}
