import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] tovar = new int[3];
        int[] sums = new int[3];
        boolean[] proVerka = new boolean[3];
        String[] products = {"Сыр", "Колбаса", "Макароны"};
        int[] prices = {60, 150, 80};
        System.out.println("Список возможных товаров для покупки");
        int n = 0;
        for (int i = 0; i < products.length; i++) {
            n = 1 + n;
            System.out.println(n + ". " + products[i] + " " + prices[i] + " руб/шт");
        }
//        outer:
        while (true) {
            int productNumber;
            int productCount;
            System.out.println("Выберите товар и количество или введите `end`");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                System.out.println("Ваша корзина:");
                int ss = 0;
                for (int chs = 0; chs < products.length; chs++) {
                    if (proVerka[chs]) {
                        String nn = products[chs];
                        int k = tovar[chs];
                        int c = prices[chs];
                        int s = sums[chs];
                        System.out.println(nn + " " + k + " шт. " + c + " руб/шт " + s + " руб в сумме");
                        ss += s;
                    }
                }
                System.out.println("Итого " + ss + " руб.");
                break;
            }
            String[] vibor = input.split(" ");
            if(vibor.length !=2){
                System.out.println("Не коректный ввод данных введите снова");
                continue;
            }
            try {
                productNumber = Integer.parseInt(vibor[0]) - 1;
                productCount = Integer.parseInt(vibor[1]);
            }catch (NumberFormatException o){
                System.out.println("Не коректный ввод данных введите снова");
                continue;
            }
            if (productNumber<0 || productNumber>2){
                System.out.println("Не коректный номер товара введите снова");
                continue;
            }
            if (productCount < 0) {
                System.out.println("Не коректное колличество введите снова");
                continue;
            }
            int count = tovar[productNumber];
            int cena = prices[productNumber];
            tovar[productNumber] = productCount + count;
            sums[productNumber] = (productCount + count) * cena;
            proVerka[productNumber] = true;
        }
    }
}