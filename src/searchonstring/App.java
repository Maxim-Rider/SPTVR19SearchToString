/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchonstring;

import java.util.Scanner;

/**
 *
 * @author Comp
 */
class App {
    public void run(){
        System.out.println("--- Поиск в строке ---");
        System.out.println("--------------------------------");
        System.out.print("Введите исходный текст: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println("--------------------------------");
        
        System.out.print("Введите строку: ");
        String searchStr = scanner.nextLine();
        System.out.println("--------------------------------");
        
        int i = str.indexOf(searchStr);
        StringBuilder sbStr = new StringBuilder(str);
        if(i>0){
            System.out.printf("Искомая строка есть и  начинается на %d позиции%n", i);
        }else{
            System.out.println("Искомая строка не найдена.");
            System.out.println("--- конец программы --- ");
            System.exit(0);
        }
        System.out.println("Задачи:");
        System.out.println("0. Выйти из программы");
        System.out.println("1. Удалить искомую строку из исходной строки");
        System.out.println("2. Заменить искомую строку на другую");
        System.out.println("3. Удалить все теги из html документа");
        System.out.println("4. Удалить конкретный тег из html документа");
        System.out.println("Выберите задачу");
        String task =  scanner.nextLine();
        //находим индех вхождения строки.
        int startIndex = str.indexOf(searchStr);
        // находим index окончания строки
        int endIndex = startIndex + searchStr.length();
        switch (task) {
            case "0":
                System.out.println("Выбрана задача 0");
                break;
            case "1":
                System.out.println("Выбрана задача 1. Удалить искомую строку из исходной строки");
                sbStr.delete(startIndex, endIndex);
                System.out.println("Результат: ");
                System.out.println(sbStr.toString());
                break;
            case "2":
                System.out.println("Выбрана задача 2");
                System.out.println("--------------------------------");
                System.out.print("Введите на что заменить: ");
                String replaseText = scanner.nextLine();
                System.out.println("--------------------------------");
                sbStr.replace(startIndex, endIndex, replaseText);
                System.out.println("Результат: ");
                System.out.println(sbStr.toString());
                break;
            case "3":
                System.out.println("Выбрана задача 3");
                
                break;
            case "4":
                System.out.println("Выбрана задача 4");
                
                break;
            
                
        }
        System.out.println("--- конец программы ---");
    }
    
}