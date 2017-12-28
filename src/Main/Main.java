package Main;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {

        try {
            System.out.println("Введите количество строк и столбцов>>> ");
            Scanner scanner = new Scanner(System.in);
            Matrix matrix = new Matrix(scanner.nextInt(), scanner.nextInt());
            int row, column;

            for (int i = 0; ; i++) {
                try {
                    System.out.println("1 - Поиск элемента");
                    System.out.println("2 - Вставка нового элемента");
                    System.out.println("3 - Получить размер матрицы");
                    System.out.println("4 - Получить количество доступных мест");
                    System.out.println("5 - Получить количество мест где содержится null");
                    System.out.println("6 - Получить количество доступных мест в строке");
                    System.out.println("7 - Получить количество доступных мест в столбце");
                    System.out.println("8 - Получить количество недоступных мест в строке");
                    System.out.println("9 - Получить количество недоступных мест в столбце");
                    System.out.println("10 - Печать элементов с помощью Итератора");
                    System.out.println("11 - Печать матрицы");
                    System.out.println("0 - Выход");

                    switch (new Scanner(System.in).nextInt()) {
                        case 1:
                            System.out.println("Номер строки>> ");
                            row = scanner.nextInt();
                            System.out.println("Номер столбца>> ");
                            column = scanner.nextInt();
                            System.out.println(matrix.search(row, column));
                            break;

                        case 2:
                            System.out.println("Номер строки>> ");
                            row = scanner.nextInt();
                            System.out.println("Номер столбца>> ");
                            column = scanner.nextInt();
                            System.out.println("Новый элемент(Integer)>> ");
                            matrix.set(scanner.nextInt(), row, column);
                            break;

                        case 3:
                            System.out.println(matrix.getSize());
                            break;

                        case 4:
                            System.out.println(matrix.notNullPlaces());
                            break;

                        case 5:
                            System.out.println(matrix.nullPlaces());
                            break;

                        case 6:
                            System.out.println("Номер строки>> ");
                            System.out.println(matrix.notNullPlacesInRow(scanner.nextInt()));
                            break;

                        case 7:
                            System.out.println("Номер столбца>> ");
                            System.out.println(matrix.notNullPlacesInColumn(scanner.nextInt()));
                            break;

                        case 8:
                            Iterator iterator = matrix.iterator();
                            while (iterator.hasNext()) {
                                System.out.println(iterator.next());
                            }
                            break;

                        case 9:
                            matrix.show();
                            break;

                        case 10:
                            System.exit(1);

                        default:
                            System.out.println("Некорректный ввод");
                            break;
                    }
                } catch (NullPlaceException e) {
                    continue;

                } catch (NumberFormatException e) {
                    System.out.println("Error: Некорректный ввод!!!");
                    continue;
                }
            }
        }
        catch(InputMismatchException e)
        {
            System.out.println("Error: Некорректный ввод!!!");
        }
    }

}
