import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Ex2 {
    public static void jsonLine(String jString) {
        StringBuilder resultStr = new StringBuilder();
        String[] sepStr = jString.split("\"");
        Map<String, String> jsonToMap = new HashMap<>();
        int j = 0;
        boolean case1 = false;
        boolean case2 = false;
        boolean case3 = false;
        for (String i : sepStr) {
            j++;
            switch (i.toLowerCase()) {
                case "фамилия":
                    jsonToMap.put(i, sepStr[j + 1]);
                    case1 = true;
                    break;
                case "оценка":
                    jsonToMap.put(i, sepStr[j + 1]);
                    case2 = true;
                    break;
                case "предмет":
                    jsonToMap.put(i, sepStr[j + 1]);
                    case3 = true;
                    break;
            }
            if (case1 && case2 && case3) {
                resultStr.append("Студент " + jsonToMap.get("фамилия") + " получил " +
                        jsonToMap.get("оценка") + " по предмету " + jsonToMap.get("предмет"));
                System.out.println(resultStr);
                case1 = case2 = case3 = false;
                resultStr.setLength(0);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(Paths.get("c:/Users/darya/OneDrive/Рабочий стол/Java/Home_work_2/Students.json"), StandardCharsets.UTF_8.name());
        String jsonLine = scanner.useDelimiter("\\A").next();
        jsonLine(jsonLine);
        scanner.close();
    }
}