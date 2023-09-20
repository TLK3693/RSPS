import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class SortByYearsUP implements Comparator<Book>
{
    @Override
    public int compare(Book o1, Book o2) {
       return o1.YearOfPublishing - o2.YearOfPublishing;
    }
}

class SortByYearsLOW implements Comparator<Book>
{
    @Override
    public int compare(Book o1, Book o2) {
       return o2.YearOfPublishing - o1.YearOfPublishing;
    }
}

class SortByRaitingUP implements Comparator<Author>
{
    @Override
    public int compare(Author o1, Author o2) {
       return Double.compare(o1.Rating, o2.Rating);
    }
}

class SortByRaitingLOW implements Comparator<Author>
{
    @Override
    public int compare(Author o1, Author o2) {
       return Double.compare(o2.Rating, o1.Rating);
    }
}

public class LambdaApp {
    public static void main(String[] args) {
        Author MichaelBulgakov = new Author(
            "Булгаков",
            "Михаил",
            "Афанасьевич",
            "+7(495)791-72-98",
            "MichaelBulgakov@mail.ru",
            4.9
        );

        Author NikolaiGogol = new Author(
            "Гоголь",
            "Николай",
            "Васильевич",
            "+7(495)752-54-55",
            "NikolaiGogol@gmail.ru",
            4.8
        );

        Author 	AlexandreDumas = new Author(
            "Дюма",
            "Александр",
            "",
            "+7(495)705-32-37",
            "AlexandreDumas@rambler.ru",
            3.7
        );

        Author AlexanderPushkin = new Author(
            "Пушкин",
            "Александр ",
            "Сергеевич",
            "+7(495)662-42-00",
            "AlexanderPushkin@mail.ru",
            5.0
        );
        ArrayList<Author> authors = new ArrayList<Author>();
        authors.add(0,MichaelBulgakov);
        authors.add(1, AlexanderPushkin);
        authors.add(2, AlexandreDumas);
        authors.add(3, NikolaiGogol);

        Author printAllAuthors = new Author(){
            public void Info(List<Author> authors) {
                for (int index = 0;  index < authors.size(); index++) {
                    System.out.println("---Информация об авторе---\n");
                    System.out.println("Фамлия = " + authors.get(index).getLastName() + "\n");
                    System.out.println("Имя = " + authors.get(index).getFirstName() + "\n");
                    System.out.println("Отчество = " + authors.get(index).getSurname() + "\n");
                    System.out.println("Номер телефона = " + authors.get(index).getTelephone() + "\n");
                    System.out.println("Электронная почта = " + authors.get(index).getEmail() + "\n");
                    System.out.println("Рейтинг автора = " + authors.get(index).getRating() + "\n");
                }
            }
        };
        printAllAuthors.Info(authors);

        int user_choise;
        RaitingSort sortOperationByRaiting = (List<Author> TMP_AUTHOR, int tmp_user_choise)->{
            if (tmp_user_choise == 1){
                Collections.sort(TMP_AUTHOR, new SortByRaitingUP());
            }else{
                Collections.sort(TMP_AUTHOR, new SortByRaitingLOW());
            }

            return TMP_AUTHOR;
        };

        // try(Scanner sc = new Scanner(System.in)) {
        //     System.out.println("--Сортировка по рейтингу--\n1-По возрастанию\n2-По убыванию\n");
        //     user_choise = sc.nextInt();
        //     sortOperationByRaiting.raiting_calculate(authors, user_choise);
        //     printAllAuthors.Info(authors);

        // } catch (Exception e) {
        //     // TODO: handle exception
        //     System.out.println(0);
        // }




        Book MasteraAndMargarita = new Book(
            "Мастер и Маргарита",
            "Мягкий переплёт",
            "Гуманитарный издательский центр «Владос»",
            1929,
            "Роман"
        );

        Book DeadSouls = new Book(
            "Мёртвые души",
            "Твёрдый переплёт",
            "Издательский Дом «Интеллект»",
            1842,
            "Проза"
        );

        Book LecomtedeMonteCristo = new Book(
            "Граф Монте-Кристо",
            "Твёрдый переплёт",
            "Издательство «Дрофа»",
            1844,
            "Роман"
        );

        Book EugeneOnegin = new Book(
            "Евгений Онегин",
            "Брошюровка на пружине",
            "Издательский дом «ОНИКС»",
            1825,
            "Поэзия"
        );

        Book Auditor = new Book(
            "Ревизор",
            "Переплёт 7Б и 7БЦ",
            "Издательский дом «Питер»",
            1836,
            "Пьеса"
        );

        Book BelkinStories = new Book(
            "Повести Белкина",
            "Мягкий переплёт",
            "Издательский дом «Питер»",
            1831,
            "Повесть"
        );
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(0,MasteraAndMargarita);
        books.add(1, DeadSouls);
        books.add(2, LecomtedeMonteCristo);
        books.add(3, EugeneOnegin);
        books.add(4, Auditor);
        books.add(5, BelkinStories);

        BookInterface printBooksOperation = (List<Book> tmp_books) -> {
            for (int index = 0; index < tmp_books.size(); index++) {
                System.out.println("---Информация о книге---\n");
                System.out.println("Название книги = " + tmp_books.get(index).getName() + "\n");
                System.out.println("Переплёт книги = " + tmp_books.get(index).getBinding() + "\n");
                System.out.println("Издательство = " + tmp_books.get(index).getPublishingHouse() + "\n");
                System.out.println("Год издательства = " + tmp_books.get(index).getYearOfPublishing() + "\n");
                System.out.println("Жанр = " + tmp_books.get(index).getGenre() + "\n");
            }
        };
        printBooksOperation.Info(books);

        YearsSort sortOperationByYears = (List<Book> TMP_BOOKS, int tmp_user_choise)->{
            if (tmp_user_choise == 1){
                Collections.sort(TMP_BOOKS, new SortByYearsUP());
            }else{
                Collections.sort(TMP_BOOKS, new SortByYearsLOW());
            }

            return TMP_BOOKS;
        };

        // try(Scanner sc = new Scanner(System.in)) {
        //     System.out.println("---Сортировка по году---\n1-По возрастанию\n2-По убыванию\n");
        //     user_choise = sc.nextInt();
        //     sortOperationByYears.years_calculate(books, user_choise);
        //     printBooksOperation.Info(books);

        // } catch (Exception e) {
        //     // TODO: handle exception
        //     System.out.println(0);
        // }

        GenreInterface operation = (List<Book> tmp_books, String tmp_user_genre_input) -> {
            try {
                //List<String> tmp_result = new ArrayList<String>();
                for (int index = 0; index < tmp_books.size(); index++) {
                    if (tmp_books.get(index).getGenre() == tmp_user_genre_input) {
                        //System.out.println(tmp_books.get(index).getName());
                        //tmp_result.add(index,tmp_user_genre_input);
                        System.out.println("---Информация о книге---\n");
                        System.out.println("Название книги = " + tmp_books.get(index).getName() + "\n");
                        System.out.println("Переплёт книги = " + tmp_books.get(index).getBinding() + "\n");
                        System.out.println("Издательство = " + tmp_books.get(index).getPublishingHouse() + "\n");
                        System.out.println("Год издательства = " + tmp_books.get(index).getYearOfPublishing() + "\n");
                        System.out.println("Жанр = " + tmp_books.get(index).getGenre() + "\n");
                    }
                }
                //System.out.println(tmp_result);
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("Неккоректный ввод");
                // System.out.println("Неккоректный ввод, попробуйте ещё раз");
                // operation.GenreSearch(tmp_books, tmp_user_genre_input);
            }
        };

        System.out.print("----Поиск по жанру----\n ");
        operation.GenreSearch(books, "Повесть");

        // try (Scanner sc = new Scanner(System.in)) {
        //     if(sc.hasNextLine()) {
        //         //System.out.print("Введите название жанра -");
        //         //String user_genre_input = sc.nextLine();
        //         String user_genre_input = sc.nextLine();
        //         System.out.println(user_genre_input);
        //         operation.GenreSearch(books, user_genre_input);


        //     } else  {
        //         // TODO: handle exception
        //         System.out.println(0);
        //     }
        // }

    }
}
