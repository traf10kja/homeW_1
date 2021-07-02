package HWork_5;

public class Main {
    public static void main(String[] args) {
//        Employee pers1 = new Employee("Ковалев Ираклий Семенович", "Менеджер",
//                "koval1@mail.ru", "8-991-45-78-963", 40000, 34);

//        pers1.info();

        /** 4. Создать массив из 5 сотрудников.*/
        Employee[] persArray = {
                new Employee("Ковалев Ираклий Семенович", "Менеджер",
                        "koval1@mail.ru", "8-991-45-78-963", 40000, 34),
                new Employee("Клёвская Александра Алексеевна", "Маркетолог",
                        "alleksa@mail.ru", "8-991-56-98-968", 50000, 28),
                new Employee("Петров Васили Иванович", "Директор",
                        "petro21@king.ru", "8-991-45-77-777", 400000, 54),
                new Employee("Айверсов Аллен Сергеевич", "Программист",
                        "theanswer3@mail.ru", "8-913-45-78-398", 100000, 39),
                new Employee("Куприянова Василиса Алексеевна", "Бухгалтер",
                        "kupidosha99@yandex.ru", "8-991-33-78-773", 70000, 44),

        };

//        System.out.println(Arrays.toString(persArray));
        /** 5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.*/
        for (int i = 0; i < persArray.length; i++) {
            if (persArray[i].getAge() > 40) {
                System.out.println(persArray[i]);
            }

        }


    }

}
