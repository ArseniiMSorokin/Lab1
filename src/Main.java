import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Создание объекта sc класса Scanner для ввода данных
        Scanner sc = new Scanner(System.in);

        // Считывание целочисленных чисел Грузоподъемность, Вес человек A B C
        short lift_capacity = sc.nextShort();
        short person_a = sc.nextShort();
        short person_b = sc.nextShort();
        short person_c = sc.nextShort();

        // Проверка чтобы хотя бы одного человека лифт мог бы поднять, если не выполняется выводится
        // 0 - количество людей, которых сможет поднять лифт
        if (person_a<=lift_capacity || person_b<=lift_capacity || person_c<=lift_capacity) {
            // Если вес людей А и B меньше или равен грузоподъемности то можно попробовать добавить человека C,
            // иначе проверить сочетание веса людей А и C
            if (person_a + person_b <= lift_capacity) {
                // Если вес людей A B и C меньше или равен грузоподъемности тогда выводим 3 -
                // то есть лифт может поднять всех людей, иначе лифт может поднять только людей A и C выводим 2
                if (person_a + person_b + person_c <= lift_capacity) {
                    System.out.print(3);
                }
                else {
                    System.out.print(2);
                }
            }
            else {
                // Так как грузоподъемность лифта оказалась меньше веса людей A и B, проверяем сочетание
                // веса людей A и C, если их сумма меньше или равна грузоподъемности, выводим 2 человека
                // сможет поднять лифт, иначе проверяем оставшийся случай с весом людей B и C
                if (person_a + person_c <= lift_capacity) {
                    System.out.print(2);
                }
                else {
                    // Если вес людей A и C меньше или равен грузоподъемности сразу выводим 2 (так как с третьим
                    // человеком вес будет точно выше грузоподъемности A+B>X), иначе выводим 1 (так как изначально была
                    // проверка, что вес хотя бы одного человека меньше или равен грузоподъемности, а какой именно
                    // человек нам знать не важно)
                    if (person_b + person_c <= lift_capacity) {
                        System.out.print(2);
                    }
                    else {
                        System.out.print(1);
                    }
                }
            }
        }
        else {
            System.out.print(0);
        }
    }
}