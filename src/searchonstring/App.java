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
    private Scanner scanner = new Scanner(System.in);
    public void run(){
        System.out.println("--- Поиск в строке ---");
        System.out.println("--------------------------------");
        System.out.print("Введите исходный текст: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println("--------------------------------");
        System.out.println("Задачи:");
        System.out.println("0. Выйти из программы");
        System.out.println("1. Удалить искомую строку из исходной строки");
        System.out.println("2. Заменить искомую строку на другую");
        System.out.println("3. Удалить все теги из html документа");
        System.out.println("4. Удалить конкретный тег из html документа");
        System.out.println("Выберите задачу");
        String task =  scanner.nextLine();
        switch (task) {
            case "0":
                System.out.println("Выбрана задача 0");
                break;
            case "1":
                System.out.println("Выбрана задача 1. Удалить искомую строку из исходной строки");
                System.out.println("--------------------------------");
                System.out.print("Введите удаляемую строку: ");
                String searchStr = scanner.nextLine();
                System.out.println("Результат: ");
                System.out.println(deleteString(str, searchStr));
                break;
            case "2":
                System.out.println("Выбрана задача 2");
                System.out.println("--------------------------------");
                System.out.print("Введите заменяемую строку: ");
                searchStr = scanner.nextLine();
                System.out.println("--------------------------------");
                System.out.print("Введите на что заменить: ");
                String replaseText = scanner.nextLine();
                System.out.println("--------------------------------");
                System.out.println("Результат: ");
                System.out.println(replaceText(str,searchStr,replaseText));
                break;
            case "3":
                System.out.println("Выбрана задача 3");
                System.out.println("Удалить все теги из html документа");
//<!DOCTYPE html><html lang="en"><head><title>Document</title></head><body>TEXT</body></html>
                System.out.println("Результат: " + this.deleteTegsFromHtml(str));
                break;
            case "4":
                System.out.println("Выбрана задача 4");
                System.out.println("Удалить указанный тег из html строки");
                System.out.println("Результат: " + this.deleteOneTegFromHtml(str));
                break;
        
        }
        System.out.println("--- конец программы ---");
    }
    private String deleteString(String str, String delString){
        //находим индех вхождения строки.
        int startIndex = str.indexOf(delString);
        // находим index окончания строки
        int endIndex = startIndex + delString.length();
        StringBuilder sbStr = new StringBuilder(str);
        sbStr.delete(startIndex, endIndex);
        return sbStr.toString();
    }
    private String replaceText(String str,String searchText, String replaceText){
        //находим индех вхождения строки.
        int startIndex = str.indexOf(searchText);
        int endIndex = startIndex + searchText.length();
        if(startIndex > 0){
            System.out.printf("Искомая строка есть и  начинается на %d позиции%n", startIndex);
        }else{
            System.out.println("Искомая строка не найдена.");
            System.out.println("--- конец программы --- ");
            System.exit(0);
        }
        StringBuilder sbStr = new StringBuilder(str);
        sbStr.replace(startIndex, endIndex, replaceText);
        return sbStr.toString();
    }
    
    private String deleteTegsFromHtml(String str) {
        StringBuilder sb = new StringBuilder(str);
        while(sb.indexOf("<") >= 0){
            int indexOpenTag = sb.indexOf("<");
            int indexCloseTag = sb.indexOf(">");
            sb.replace(indexOpenTag, indexCloseTag+1, " ");
        }  
        return sb.toString();
    }
    
    private String deleteOneTegFromHtml(String str) {
        System.out.println("Укажите какой тег удалить (без угловых скобок): ");
        String tag = scanner.nextLine();
        StringBuilder sb = new StringBuilder(str);
        String tagBegin = "<"+tag;
        String tagEnd = "</"+tag;
        while(sb.indexOf(tagBegin) >= 0){
            int indexOpenTag = sb.indexOf(tagBegin);
            int indexOpenTagEnd = sb.indexOf(">",indexOpenTag);
           // int indexCloseTag = indexOpenTag + indexOpenTagClose+1;
            sb.replace(indexOpenTag, indexOpenTagEnd+1, "");
            int indexCloseTag = sb.indexOf(tagEnd);
            if(indexCloseTag >=0){
                int indexCloseTagEnd = sb.indexOf(">",indexCloseTag);
                sb.replace(indexCloseTag, indexCloseTagEnd+1, "");
            }
        }  
        return sb.toString();
    }
}

