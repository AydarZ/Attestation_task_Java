import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import java.util.Scanner;

public class Methods {
    public static void AddNewToy(ArrayList<Toy> listToysAll, ArrayList<Toy> listToysForLottery,
            ArrayList<String> names) {
        System.out.println("Выберите игрушку для розыгрыша");
        Scanner scan = new Scanner(System.in, "cp866");
        String name = scan.nextLine();
        
        if (containsCaseInsensitive(name, names)) {
            System.out.println("Данная игрушка уже учавствует в розыгрыше");
        } else {
            for (Toy toy : listToysAll) {
                if (name.equalsIgnoreCase(toy.getName()) && toy.getQuantity() > 0) {
                    listToysForLottery.add(toy);
                    names.add(toy.getName());
                    System.out.println("Готово!");
                    return;
                }
            }
            System.out.println("Игрушки с таким именем в магазине нет");
        }
    }

    public static void ChangeQuantity(ArrayList<Toy> listToysAll) {
        System.out.println("Выедите название игрушки для изменения вероятности: ");
        Scanner scan = new Scanner(System.in, "cp866");
        String name = scan.nextLine();
        for (Toy toy : listToysAll) {
            if (name.equalsIgnoreCase(toy.getName())) {
                System.out.println("Введите новую вероятность для игрушки: ");
                try {
                    int chance = scan.nextInt();
                    if (chance < 0 || chance > 100)
                        throw new RuntimeException();
                    toy.setChance(chance);
                    System.out.println("Готово!");
                    return;
                } catch (RuntimeException e) {
                    System.out.println("Вы ввели некорректное значение");
                    return;
                }
            } 
        }
        System.out.println("Игрушки с таким именем в магазине нет");
    }

    public static void StartLottery(ArrayList<Toy> list, ArrayList<Toy> listOfWinners, ArrayList<Toy> listToysForLottery,  ArrayList<String> namesToys) {
        for (Toy toy : list) {
            double random = Math.random() * 100;
            if (toy.getChance() > random) {
                listOfWinners.add(toy);
            }
        }
        if (listOfWinners.isEmpty()){
            System.out.println("Ни одна игрушка не выйграла((");
        } else{
        System.out.print("Список выпавших игрушек: ");
        App.PrintArrayNames(listOfWinners);
        App.PrintArrayNames(listToysForLottery);
        System.out.println(namesToys);
        listToysForLottery.clear();
        namesToys.clear();
        }
    }

    public static void GiveOutAPrize(ArrayList<Toy> listOfWinners, File file) {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file.getPath(), true), "UTF-8"))) {
        
            Toy prize = listOfWinners.remove(0);
            bw.append(prize.getName());
            bw.append('\n');
            prize.setQuantity(prize.getQuantity() - 1);

        } catch (IOException | IndexOutOfBoundsException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static boolean containsCaseInsensitive(String s, ArrayList<String> l){ //Метод для проверки на наличие имени
        for (String string : l){
           if (string.equalsIgnoreCase(s)){
               return true;
            }
        }
       return false;
     }
}
