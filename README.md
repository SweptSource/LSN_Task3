# LSN_Task3

##Założenia:
- aplikacja będzie czytać dane z pliku;
- aplikacja oczekuje zwalidowanych danych (nie waliduje pliku wejściowego);
- aplikacja oczekuje uporzdkowanych danych (jak w przykładzie). Oznacza to, że:

zawsze wystąpi pierwsza linia - z iloscią danych;

pierwsza wartość w linii danych bedzie zawsze mniejsza od drugiej;

```
3
1 2
2 3
5 6
```
- przykładowe dane wyjściowe:

```
2
```

##Uruchomienie
- projekt maven'owy, zbudować przez:

```mvn clean install```
- uruchomić zbudowanego jar'a przekazując jako parametr ścieżke do pliku, na przykład:

```java -jar target\t3-1.0-SNAPSHOT.jar C:\_WORK\LOGISFERA_NOVA\t3_test.txt```