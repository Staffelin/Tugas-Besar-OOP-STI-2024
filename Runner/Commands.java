

// import Player.*;

// import java.util.Scanner;

// import Exception.*;
// import Map.Map;

// public class Commands {
//     Map map = new Map();
//     Deck deck = new Deck();

//     Scanner sc = new Scanner(System.in);
//     public char getCommand(){
//         char choice = sc.next().charAt(0);
//         return choice;
//     }

//     public void Tanam(){
//         System.out.println("Ingin menanam tanaman? (Y/N)");
//         char plantChoice = sc.next().charAt(0);

//         System.out.println("Masukkan indeks tanaman yang ingin ditanam : ");
//         System.out.println("Deck:");
//         deck.displayDeck();
//         int index5 = sc.nextInt();
//         System.out.println("Masukkan koordinat tanaman yang ingin ditanam : ");
//         int row = sc.nextInt();
//         int column = sc.nextInt();
//         if (index5 >= 1 && index5 <= deck.getDeckOfPlants().size() && row >= 0 && row <= 6 && column >= 0 && column <= 9) {
//             map.addPlantToTile(row, column, deck.getDeckOfPlants().get(index5-1));
//             map.viewMap();
//             System.out.println("Current sun: " + Sun.sun);
//         } else {
//             System.out.println("Indeks atau koordinat tidak valid!");
//         }   
//     }

//     public void Gali(){
//         System.out.println("Ingin menggali tanaman? (Y/N)");
//         char digChoice = sc.next().charAt(0);
//         if (digChoice == 'Y') {
//             System.out.println("Masukkan koordinat tanaman yang ingin digali : ");
//             int row2 = sc.nextInt();
//             int column2 = sc.nextInt();
//             if (row2 >= 0 && row2 <= 6 && column2 >= 0 && column2 <= 10) {
//                 map.removePlantFromTile(row2-1, column2);
//                 map.viewMap();
//                 System.out.println("Current sun: " + Sun.sun);                
//             } else {
//                 System.out.println("Koordinat tidak valid!");
//             }
//         }
//     }
// }
