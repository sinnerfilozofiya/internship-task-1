import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    // ANSI renk kodları
    public static final String RESET = "\033[0m";  // Text Reset
    public static final String GREEN = "\033[0;32m";  // GREEN
    public static final String RED = "\033[0;31m";    // RED

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> history = new ArrayList<>();

        while (true) {
            // Menü seçenekleri
            System.out.println("====================================");
            System.out.println("        Hesap Makinesi Menü         ");
            System.out.println("====================================");
            System.out.println("1. Toplama");
            System.out.println("2. Çıkarma");
            System.out.println("3. Çarpma");
            System.out.println("4. Bölme");
            System.out.println("5. Karekök Alma");
            System.out.println("6. Üslü Sayı Alma");
            System.out.println("7. Geçmiş İşlemleri Göster");
            System.out.println("8. Çıkış");
            System.out.println("====================================");
            System.out.print("Bir seçenek giriniz: ");
            
            int choice = -1;

            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("====================================");
                System.out.println(RED + "Geçersiz giriş! Lütfen bir sayı giriniz." + RESET);
                System.out.println("====================================");
                scanner.next(); // Hatalı girdiyi temizle
                continue; // Döngünün başına dön
            }

            if (choice == 8) {
                System.out.println("====================================");
                System.out.println("Çıkılıyor...");
                System.out.println("====================================");
                break;
            }

            if (choice == 7) {
                System.out.println("====================================");
                System.out.println("       Geçmiş İşlemler");
                System.out.println("====================================");
                if (history.isEmpty()) {
                    System.out.println(RED + "Geçmiş işlem bulunmamaktadır." + RESET);
                } else {
                    for (String record : history) {
                        System.out.println(GREEN + record + RESET);
                    }
                }
                System.out.println("====================================");
                continue;
            }

            double num1 = 0, num2 = 0;
            if (choice >= 1 && choice <= 4) {
                while (true) {
                    try {
                        System.out.print("Birinci sayıyı giriniz: ");
                        num1 = scanner.nextDouble();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("====================================");
                        System.out.println(RED + "Geçersiz giriş! Lütfen bir sayı giriniz." + RESET);
                        System.out.println("====================================");
                        scanner.next();
                    }
                }
                while (true) {
                    try {
                        System.out.print("İkinci sayıyı giriniz: ");
                        num2 = scanner.nextDouble();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("====================================");
                        System.out.println(RED + "Geçersiz giriş! Lütfen bir sayı giriniz." + RESET);
                        System.out.println("====================================");
                        scanner.next();
                    }
                }
            } else if (choice == 5 || choice == 6) {
                while (true) {
                    try {
                        System.out.print("Bir sayı giriniz: ");
                        num1 = scanner.nextDouble();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("====================================");
                        System.out.println(RED + "Geçersiz giriş! Lütfen bir sayı giriniz." + RESET);
                        System.out.println("====================================");
                        scanner.next();
                    }
                }
            }

            System.out.println("====================================");
            String result = "";
            switch (choice) {
                case 1:
                    result = "Toplama: " + num1 + " + " + num2 + " = " + (num1 + num2);
                    System.out.println(GREEN + "Sonuç: " + (num1 + num2) + RESET);
                    history.add(result);
                    break;
                case 2:
                    result = "Çıkarma: " + num1 + " - " + num2 + " = " + (num1 - num2);
                    System.out.println(GREEN + "Sonuç: " + (num1 - num2) + RESET);
                    history.add(result);
                    break;
                case 3:
                    result = "Çarpma: " + num1 + " * " + num2 + " = " + (num1 * num2);
                    System.out.println(GREEN + "Sonuç: " + (num1 * num2) + RESET);
                    history.add(result);
                    break;
                case 4:
                    if (num2 != 0) {
                        result = "Bölme: " + num1 + " / " + num2 + " = " + (num1 / num2);
                        System.out.println(GREEN + "Sonuç: " + (num1 / num2) + RESET);
                        history.add(result);
                    } else {
                        result = "Hata: Bir sayı sıfıra bölünemez.";
                        System.out.println(RED + result + RESET);
                    }
                    break;
                case 5:
                    if (num1 >= 0) {
                        result = "Karekök: √" + num1 + " = " + Math.sqrt(num1);
                        System.out.println(GREEN + "Sonuç: " + Math.sqrt(num1) + RESET);
                        history.add(result);
                    } else {
                        result = "Hata: Negatif sayının karekökü alınamaz.";
                        System.out.println(RED + result + RESET);
                    }
                    break;
                case 6:
                    while (true) {
                        try {
                            System.out.print("Üs değerini giriniz: ");
                            num2 = scanner.nextDouble();
                            result = "Üslü Sayı: " + num1 + "^" + num2 + " = " + Math.pow(num1, num2);
                            System.out.println(GREEN + "Sonuç: " + Math.pow(num1, num2) + RESET);
                            history.add(result);
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("====================================");
                            System.out.println(RED + "Geçersiz giriş! Lütfen bir sayı giriniz." + RESET);
                            System.out.println("====================================");
                            scanner.next();
                        }
                    }
                    break;
                default:
                    System.out.println(RED + "Geçersiz seçenek. Lütfen tekrar deneyin." + RESET);
                    break;
            }
            System.out.println("====================================");
        }
        scanner.close();
    }
}
