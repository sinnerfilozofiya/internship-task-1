# 4 işlemi yapabilen command prompta çalışan hesap makinesi 

# Java Calculator

Bu proje, komut satırında çalışacak şekilde tasarlanmış basit bir hesap makinesidir. Kullanıcıya toplama, çıkarma, çarpma, bölme, karekök alma, üslü sayı hesaplama gibi işlemleri yapma imkanı sağlar ve ayrıca geçmiş işlemleri gösterme özelliğine sahiptir.

## Kullanım

Programı çalıştırmak için aşağıdaki adımları izleyin:

1. **Kaynak kodu derleyin:**
    ```sh
    javac Calculator.java
    ```

2. **Programı çalıştırın:**
    ```sh
    java Calculator
    ```

## Özellikler

- Toplama
- Çıkarma
- Çarpma
- Bölme
- Karekök alma
- Üslü sayı hesaplama
- Geçmiş işlemleri gösterme
- Çıkış

## Teknik Detaylar

### ANSI Renk Kodları

Programda, komut satırında renkli çıktılar elde etmek için ANSI renk kodları kullanılmıştır:

- `RESET`: Metin rengini varsayılan renge döndürmek için kullanılır.
- `GREEN`: Yeşil renkli metin.
- `RED`: Kırmızı renkli metin.

### Kullanılan Yapılar

- `Scanner`: Kullanıcıdan giriş almak için kullanılır.
- `List<String>`: Geçmiş işlemleri saklamak için kullanılır.

### Program Akışı

1. **Menü Gösterimi:**
    Kullanıcıya yapılabilecek işlemleri gösterir.
    ```java
    System.out.println("1. Toplama");
    System.out.println("2. Çıkarma");
    System.out.println("3. Çarpma");
    System.out.println("4. Bölme");
    System.out.println("5. Karekök Alma");
    System.out.println("6. Üslü Sayı Alma");
    System.out.println("7. Geçmiş İşlemleri Göster");
    System.out.println("8. Çıkış");
    ```

2. **Kullanıcı Girişi:**
    Kullanıcının menüden bir seçenek girmesini sağlar.
    ```java
    int choice = scanner.nextInt();
    ```

3. **Geçmiş İşlemleri Gösterme:**
    Geçmiş işlemleri listeler veya geçmiş işlemin olmadığını belirtir.
    ```java
    if (choice == 7) {
        if (history.isEmpty()) {
            System.out.println(RED + "Geçmiş işlem bulunmamaktadır." + RESET);
        } else {
            for (String record : history) {
                System.out.println(GREEN + record + RESET);
            }
        }
        continue;
    }
    ```

4. **Matematiksel İşlemler:**
    Kullanıcının seçimine göre ilgili matematiksel işlemi yapar.
    - **Toplama:**
        ```java
        result = "Toplama: " + num1 + " + " + num2 + " = " + (num1 + num2);
        history.add(result);
        ```
    - **Çıkarma:**
        ```java
        result = "Çıkarma: " + num1 + " - " + num2 + " = " + (num1 - num2);
        history.add(result);
        ```
    - **Çarpma:**
        ```java
        result = "Çarpma: " + num1 + " * " + num2 + " = " + (num1 * num2);
        history.add(result);
        ```
    - **Bölme:**
        ```java
        result = "Bölme: " + num1 + " / " + num2 + " = " + (num1 / num2);
        history.add(result);
        ```
    - **Karekök Alma:**
        ```java
        result = "Karekök: √" + num1 + " = " + Math.sqrt(num1);
        history.add(result);
        ```
    - **Üslü Sayı Alma:**
        ```java
        result = "Üslü Sayı: " + num1 + "^" + num2 + " = " + Math.pow(num1, num2);
        history.add(result);
        ```

5. **Hata Yönetimi:**
    Kullanıcının geçersiz giriş yapması durumunda uyarı verir ve tekrar giriş yapılmasını sağlar.
    ```java
    catch (InputMismatchException e) {
        System.out.println(RED + "Geçersiz giriş! Lütfen bir sayı giriniz." + RESET);
        scanner.next(); // Hatalı girdiyi temizle
        continue; // Döngünün başına dön
    }
    ```

## Katkıda Bulunma

Katkıda bulunmak için lütfen bir pull request oluşturun. Herhangi bir sorunuz varsa, lütfen issue açmaktan çekinmeyin.
