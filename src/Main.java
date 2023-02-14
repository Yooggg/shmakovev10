import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DeflaterOutputStream;

public class Main {
    public static void main(String[] args) {

        try (InputStreamReader inputStreamReader = new InputStreamReader(System.in);
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(System.out);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
             BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter)) {

            bufferedWriter.write("Введите название 1-го файла - ");
            bufferedWriter.flush();
            String file1Name = bufferedReader.readLine();

            bufferedWriter.write("Введите название 2-го файла - ");
            bufferedWriter.flush();
            String file2Name = bufferedReader.readLine();

            File file1 = new File(file1Name + ".txt");
            File file2 = new File(file2Name + ".txt");

            List<String> str_list = new ArrayList<>();

            try (FileWriter fw1 = new FileWriter(file1, true)) {
                bufferedWriter.write("Введите строку, которая запишется в файл - ");
                bufferedWriter.flush();
                String str = bufferedReader.readLine();
                fw1.write(str);
            }

            try (FileWriter fw2 = new FileWriter(file2, true);
                 FileReader fr1 = new FileReader(file1)) {

                var bufferedReader1 = new BufferedReader(fr1);
                String get_str;

                while ((get_str = bufferedReader1.readLine()) != null) {
                    str_list.add(get_str);
                }

                for (var string : str_list) {
                    String[] splited_string = string.split("\\s+");
                    for (String spl_str : splited_string) {
                        try {
                            int num = Integer.parseInt(spl_str);
                            fw2.append(String.valueOf(num));
                            fw2.append(" ");
                        } catch (NumberFormatException e) {}
                    }
                }
            }

            URLpFinder urLpFinder = new URLpFinder();
            String textURL = "http://xn--b1afk4ade4e.xn--b1ab2a0a.xn--b1aew.xn--p1ai/info-service.htm?sid=2000";
            int ans = urLpFinder.findP(textURL);
            bufferedWriter.write(ans + "");
            bufferedWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}