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
    public void run() {
        System.out.println("--- Поиск в строке ---");
        System.out.println("Введите текст");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println("Введите строку");
        String searchStr = scanner.nextLine();
        int i = 0;
        System.out.println("Искомая строка начинается на %d позиции%n", i);
    }
}
