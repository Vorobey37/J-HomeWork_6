import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

/**
 * 1. Подумать над структурой класса Ноутбук для магазина техники — выделить поля и методы. Реализовать в Java.
 * 2. Создать множество ноутбуков.
   3. Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и 
выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
“Введите цифру, соответствующую необходимому критерию:

1 - ОЗУ
2 - Объём ЖД
3 - Операционная система
4 - Цвет …

1. Далее нужно запросить минимальные и максимальные значения для указанных критериев — сохранить 
параметры фильтрации можно также в Map.
2. Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.

 */
public class finalTask {

    public static void main(String[] args) {

        NoteBook n1 = new NoteBook();
        n1.model = "Samsung";
        n1.color = "White";
        n1.hardDiskMemory = 520;
        n1.operatingSystem = "Windows";
        n1.ram = 8;
        n1.price = 120;

        NoteBook n2 = new NoteBook();
        n2.model = "Apple";
        n2.color = "Silver";
        n2.hardDiskMemory = 680;
        n2.operatingSystem = "Mac";
        n2.ram = 10;
        n2.price = 220;

        NoteBook n3 = new NoteBook();
        n3.model = "Lenovo";
        n3.color = "Black";
        n3.hardDiskMemory = 480;
        n3.operatingSystem = "Linux";
        n3.ram = 6;
        n3.price = 80;

        n1.printInfo();
        n2.printInfo();
        n3.printInfo();

        HashSet<NoteBook> noteHashSet = new HashSet<>(Arrays.asList(n1, n2, n3));
        System.out.println(noteHashSet);
        ArrayList<String> componentsList = componentsList ();
        HashMap<Integer, String> componentsMap = componentsMap(componentsList);
        System.out.println(componentsMap);
        Scanner input = new Scanner(System.in);
        System.out.println("Введите актуальный номер критерия: ");
        int number1 = input.nextInt();
        String criterion = criterion(number1, componentsMap);
        System.out.println(criterion);
        System.out.println("Введите минимальные требования: ");
        int numberMin = input.nextInt();
        System.out.println("Введите максимальные требования: ");
        int numberMax = input.nextInt();
        HashMap<NoteBook, Integer> hardDiskMemoryMap = hardDiskMemoryMap(noteHashSet);
        //System.out.println(hardDiskMemoryMap);
        HashMap<NoteBook, Integer> ramMap = ramMap(noteHashSet);
        //System.out.println(ramMap);
        HashMap<NoteBook, Integer> priceMap = priceMap(noteHashSet);
        //System.out.println(priceMap);
        HashSet<NoteBook> sortNoteBooks = sortNoteBooks(ramMap, priceMap, hardDiskMemoryMap, criterion, numberMin, numberMax);
        System.out.println(sortNoteBooks);
        input.close();
    }
    public static ArrayList<String> componentsList () {

        ArrayList<String> componentsList = new ArrayList<>();
        componentsList.add("model");
        componentsList.add("color");
        componentsList.add("hardDiskMemory");
        componentsList.add("operatingSystem");
        componentsList.add("ram");
        componentsList.add("price");
        return componentsList;
    }

    public static HashMap<Integer, String> componentsMap (ArrayList<String> componentsList){
        HashMap<Integer, String> componentsMap = new HashMap<>();
        for (int i = 0; i < componentsList.size(); i++) {
            componentsMap.put(i+1, componentsList.get(i));
        }
        return componentsMap;
    }

    public static HashMap<NoteBook, Integer> ramMap (HashSet<NoteBook> noteHashSet){
        HashMap<NoteBook, Integer> ramMap = new HashMap<>();
       for (NoteBook element : noteHashSet) {
        ramMap.put(element, element.ram);
       }
       return ramMap;
    }

    public static HashMap<NoteBook, Integer> priceMap (HashSet<NoteBook> noteHashSet){
        HashMap<NoteBook, Integer> priceMap = new HashMap<>();
       for (NoteBook element : noteHashSet) {
        priceMap.put(element, element.price);
       }
       return priceMap;
    }


    public static HashMap<NoteBook, Integer> hardDiskMemoryMap (HashSet<NoteBook> noteHashSet){
        HashMap<NoteBook, Integer> hardDiskMemoryMap = new HashMap<>();
       for (NoteBook element : noteHashSet) {
        hardDiskMemoryMap.put(element, element.hardDiskMemory);
       }
       return hardDiskMemoryMap;
    }

    public static String criterion(int number, HashMap<Integer, String> componentsMap) {
        String criterion = componentsMap.get(number);
        return criterion;
    }

    public static HashSet<NoteBook> sortNoteBooks (HashMap<NoteBook, Integer> ramMap, HashMap<NoteBook, Integer> priceMap, HashMap<NoteBook, Integer> hardDiskMemoryMap,  String criterion, int min, int max) {
        HashSet<NoteBook> sortNoteBooks = new HashSet<>();
        if (criterion.equals("hardDiskMemory")) { 
          for (Map.Entry<NoteBook, Integer> element : hardDiskMemoryMap.entrySet()) {
            if (element.getValue()>=min && element.getValue()<=max) sortNoteBooks.add(element.getKey());
          }
        } 
        if (criterion.equals("ram")) { 
            for (Map.Entry<NoteBook, Integer> element : ramMap.entrySet()) {
              if (element.getValue()>=min && element.getValue()<=max) sortNoteBooks.add(element.getKey());
            }
          } 
          if (criterion.equals("price")) { 
            for (Map.Entry<NoteBook, Integer> element : priceMap.entrySet()) {
              if (element.getValue()>=min && element.getValue()<=max) sortNoteBooks.add(element.getKey());
            }
          } 

        return sortNoteBooks;
    }
}

class NoteBook {
    String model;
    Integer ram;
    Integer hardDiskMemory;
    String operatingSystem;
    Integer price;
    String color;

    

  
    

    void printInfo () {
        System.out.println("model = " + model + ", ram = " + ram + ", hardDiskMemory = " + hardDiskMemory + ", operatingSystem = " + operatingSystem + ", price = " + price + ", color = " + color);
    }

    NoteBook(){
    String model;
    Integer ram;
    Integer hardDiskMemory;
    String operatingSystem;
    Integer price;
    String color;
    }
}