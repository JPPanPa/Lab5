package hust.soict.dsai.aims;

import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import java.util.Scanner;

public class Aims {
    private static final Store store = new Store();
    private static final Cart cart = new Cart();
    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }
    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }
    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }
    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void filterMediaInCart() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Filter by:");
        System.out.println("1. ID");
        System.out.println("2. Title");
        int filterOption = scanner.nextInt();
        scanner.nextLine();

        if (filterOption == 1) {
            System.out.print("Enter media ID to filter: ");
            int id = scanner.nextInt();
            Media media = cart.findMediaById(id);
            if (media != null) {
                System.out.println("Found media: " + media.getTitle());
            } else {
                System.out.println("No media found with ID " + id);
            }
        } else if (filterOption == 2) {
            System.out.print("Enter media title to filter: ");
            String title = scanner.nextLine();
            Media media = cart.findMediaByTitle(title);
            if (media != null) {
                System.out.println("Found media: " + media.getTitle());
            } else {
                System.out.println("No media found with title " + title);
            }
        }
    }
    public static void sortMediaInCart() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sort by:");
        System.out.println("1. Title");
        System.out.println("2. Cost");
        int sortOption = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (sortOption == 1) {
            cart.sortByTitle();
            System.out.println("Medias sorted by title.");
        } else if (sortOption == 2) {
            cart.sortByCost();
            System.out.println("Medias sorted by cost.");
        }
    }
    public static void placeOrder() {
        System.out.println("Order created!");
        cart.clearCart(); 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    store.printStore();
                    break;

                case 2:
                    storeMenu();
                    int storeChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (storeChoice) {
                        case 1:
                            System.out.println("Enter media title: ");
                            String title = scanner.nextLine();
                            Media media = store.findMediaByTitle(title);
                            if (media != null) {
                                System.out.println("Title: " + media.getTitle());
                                System.out.println("Category: " + media.getCategory());
                                System.out.println("Cost: " + media.getCost());
                            } else {
                                System.out.println("Media not found.");
                            }
                            break;

                        case 2:
                            System.out.println("Enter media title to add to cart: ");
                            String addTitle = scanner.nextLine();
                            Media addMedia = store.findMediaByTitle(addTitle);
                            if (addMedia != null) {
                                cart.addMedia(addMedia);
                            } else {
                                System.out.println("Media not found.");
                            }
                            break;

                        case 3:
                            System.out.println("Enter media title to play: ");
                            String playTitle = scanner.nextLine();
                            Media playMedia = store.findMediaByTitle(playTitle);
                            if (playMedia != null) {
                                playMedia.play();
                            } else {
                                System.out.println("Media not found.");
                            }
                            break;

                        case 4:
                            cartMenu();
                            int cartChoice = scanner.nextInt();
                            scanner.nextLine(); 

                            switch (cartChoice) {
                                case 1: 
                                    filterMediaInCart();
                                    break;

                                case 2: 
                                    sortMediaInCart();
                                    break;

                                case 3: 
                                    System.out.println("Enter media title to remove: ");
                                    String removeTitle = scanner.nextLine();
                                    Media removeMedia = cart.findMediaByTitle(removeTitle);
                                    if (removeMedia != null) {
                                        cart.removeMedia(removeMedia);
                                    } else {
                                        System.out.println("Media not found in cart.");
                                    }
                                    break;

                                case 4:
                                    System.out.println("Enter media title to play: ");
                                    String playCartTitle = scanner.nextLine();
                                    Media playCartMedia = cart.findMediaByTitle(playCartTitle);
                                    if (playCartMedia != null) {
                                        playCartMedia.play();
                                    } else {
                                        System.out.println("Media not found in cart.");
                                    }
                                    break;

                                case 5:
                                    placeOrder();
                                    break;

                                case 0: 
                                    break;

                                default:
                                    System.out.println("Invalid choice.");
                            }
                            break;

                        case 0:
                            break;

                        default:
                            System.out.println("Invalid choice.");
                    }
                    break;

                case 3: 
                    cartMenu();
                    break;

                case 0: 
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}
