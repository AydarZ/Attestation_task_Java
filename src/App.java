import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;




public class App {
    public static void main(String[] args) throws Exception {
        
        ArrayList<Toy> listToysAll = new ArrayList<>(); // список всех игрушек магазина
        ArrayList<Toy> listToysForLottery = new ArrayList<>(); // список игрушек для розыгрыша
        ArrayList<String> namesToys = new ArrayList<>(); // список с названиями игрушек для розыгрыша, для дальнейших проверок на наличие
        ArrayList<Toy> ListOfWinners = new ArrayList<>(); // список игрушек для выдачи
        File file = new File("priz.txt");
        file.delete();
        


        Toy toy1 = new Toy("Мишка", 20, 7);
        Toy toy2 = new Toy("Трактор", 3, 15);
        Toy toy3 = new Toy("Лиса", 8, 11);
        Toy toy4 = new Toy("Робот", 30, 15);
        Toy toy5 = new Toy("Машинка", 50, 22);
        Toy toy6 = new Toy("Пазлы", 25, 10);
        Toy toy7 = new Toy("Мяч", 10, 30);
        Toy toy8 = new Toy("Кукла", 13, 18);
        Toy toy9 = new Toy("Вертолет", 5, 3);
        listToysAll.add(toy1);
        listToysAll.add(toy2);
        listToysAll.add(toy3);
        listToysAll.add(toy4);
        listToysAll.add(toy5);
        listToysAll.add(toy6);
        listToysAll.add(toy7);
        listToysAll.add(toy8);
        listToysAll.add(toy9);

        System.out.print("Список игрушек в магазине: ");
        PrintArrayNames(listToysAll);
        

        while (true) {
            System.out.println("Выберите действие:\n 1-Добавить новую игрушку в розыгрыш\n 2-изменить вес игрушки\n 3-провести розыгрыш\n 4-выдать призовую игрушку\n 5-Посмотреть список участников розыгрыша");
            Scanner scan = new Scanner(System.in, "cp866");
            String inputComand = scan.nextLine();
            if (inputComand.equals("1")){
                Methods.AddNewToy(listToysAll, listToysForLottery, namesToys);
            }
            if (inputComand.equals("2")){
                Methods.ChangeQuantity (listToysAll);
            }
            if (inputComand.equals("3")){
                Methods.StartLottery (listToysForLottery, ListOfWinners, listToysForLottery, namesToys);
            }
            if (inputComand.equals("4")){
                Methods.GiveOutAPrize (ListOfWinners, file);
            }
            if (inputComand.equals("5")){
                PrintArrayNames(listToysForLottery);;
            }
        }
    }

    public static void PrintArrayNames (ArrayList<Toy> args){
        for (Toy e : args) {
            System.out.print(e.getName() + " ");
        }
        System.out.println();
    }
}
