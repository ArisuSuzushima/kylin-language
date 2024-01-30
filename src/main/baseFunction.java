package main;

import Program.KyLinRuntime;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Random;

import java.lang.Object;

public class baseFunction {
    public static ArrayList<String> getScript(String path) throws Exception {
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ArrayList<String> arrayList = new ArrayList<>();
        while (true)
        {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            arrayList.add(line);
        }
        bufferedReader.close();
        fileReader.close();
        return arrayList;
    }
    public static boolean isPublic(String expression) throws Exception {
        if (expression.toLowerCase().equals("public")) {
            return true;
        }else if(expression.toLowerCase().equals("private")) {
            return false;
        }else {
            throw new Exception("Syntax Error");
        }
    }
    public static String getTime() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(year);
        stringBuffer.append(month);
        stringBuffer.append(day);
        stringBuffer.append(hour);
        stringBuffer.append(minute);
        stringBuffer.append(second);
        return stringBuffer.toString();
    }
    public static String input(String text) {
        System.out.print(text);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public static void include(String code , KyLinRuntime kylinRuntime) throws Exception {
        String in = code.substring(code.indexOf("<")+1,code.lastIndexOf(">"));
        in = in.replace("{head}", mainApp.jarDirectory+"/../head");
        File file = new File(in);
        if (file.isFile() && file.canRead()) {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                line = line.trim();
                if (line.equals("")) {
                    continue;
                }
                String[] words = line.split(" ");
                String keyword = kylinRuntime.defined_keyword.get(words[0]);
                if (keyword == null) {
                    keyword = "";
                } else {
                    throw new Exception("Target head file syntax error: "+line);
                }
            }
        }else {
            throw new Exception("Can not find target head file.");
        }
    }
    public static String getLastName(String str) {
        try {
            return str.substring(0,str.lastIndexOf("."));
        }catch (Exception exception) {
            return str;
        }
    }
    public static Object getValueContent(String value_name , KyLinRuntime kyLinRuntime) throws Exception {
        if (kyLinRuntime.ValueMap.containsKey(value_name))
        {
            return kyLinRuntime.ValueMap.get(value_name).getContent();
        }
        else if (kyLinRuntime.PublicRuntime != null && kyLinRuntime.PublicRuntime.ValueMap.containsKey(value_name))
        {
            return kyLinRuntime.PublicRuntime.ValueMap.get(value_name).getContent();
        }
        else {
            throw new Exception("No Value: "+value_name);
        }
    }
    public static long getRandomLong() {
        Random random = new Random();

        return random.nextLong();
    }
}
