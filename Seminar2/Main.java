/// Дана строка sql-запроса "select * from students where ".
/// Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
/// Если значение null, то параметр не должен попадать в запрос.
/// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String[] list = {"{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}"};
        System.out.println(list[0]);
        StringBuilder resultSelect = lineInList(list);
        System.out.println(resultSelect);
    }

    public static StringBuilder lineInList(String[] list) {
        String line = list[0];
        String line1 = line.replace("{", "");
        String line2 = line1.replace("}", "");
        String line3 = line2.replaceAll("\"", "");
        System.out.println(line3);
        StringBuilder result = new StringBuilder("select * from students where ");

        String[] arrayData = line3.split(", ");
        for (int i = 0; i < arrayData.length; i++) {
            String[] arrData = arrayData[i].split(":");
            if (!arrData[1].equals("null")) {
                if (i != 0) {
                    result.append(" AND ");
                }
                result.append(arrData[0]);
                result.append(" = '");
                result.append(arrData[1]);
                result.append("'");
            }
        }
        return result;
    }
}
