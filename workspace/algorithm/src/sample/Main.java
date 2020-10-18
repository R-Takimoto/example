package sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //生徒リスト
        List<String> student = new ArrayList<String>();
        student.addAll(Arrays.asList(
                "川﨑康史", "國森菜々穂", "城野敦司", "谷川拓馬", "坂口ルイ",
                "浜田明彦", "滝本亮", "神福幸子", "江本愛", "川嵜瞳",
                "福原好伸", "杉山奈弓", "細田希", "浦上愛里奈", "折出望",
                "横田春樹", "岡崎智子", "野瀬遼介", "板垣ゆい", "藤野永子"
                ));


        //席リスト
        List<String> chair = new ArrayList<String>();
        chair.addAll(Arrays.asList(
                "s01", "s02", "s03", "s04", "s05",
                "s06", "s07", "s08", "s09", "s10",
                "s11", "s12", "s13", "s14", "s15",
                "s16", "s17", "s18", "s19", "s20"
                ));

        Student[] s1 = new Student[20];

        for(int i = 0; i < chair.size(); i ++) {
        	s1[i] = new Student(student.get(i), chair.get(i));
        }


        int n = 20;
        Random rr = new Random();
        int r;

        for(int i = 0; i < s1.length; i ++) {
        	do {
        		r = rr.nextInt(n);
        	}while(s1[i].number.equals(chair.get(r)));
        	s1[i].setNumber(chair.get(r));
        	chair.remove(r);
        	if(n > 0) {
        		n --;
        	}

        }
//        System.out.println(s1[0].name + s1[0].number);
//        for(int i = 0; i < 20; i ++) {
//
//        }


//        final  String FORMAT = "%-30s %5s\n";
        for(int i = 0; i < 20; i ++) {
        	String s = String.format("%-30s %5s", s1[i].name, s1[i].number);
        	System.out.println(s);
//        	System.out.printf(FORMAT,s1[i].name, s1[i].number);
        }

//        Map<String, String> rslt = new LinkedHashMap<String, String>();
//
//        int r = chair.size();
//        for(int i = 0; i < chair.size(); i ++) {
//            int n = new Random().nextInt(r);
//            String s = student.get(n);
//            r --;
//            rslt.put(chair.get(i), s);
//            student.remove(n);
//        }
//
//        for(String key : rslt.keySet()) {
//            String val = rslt.get(key);
//            System.out.println("座席:" + key + "=" + val + "さん");
//        }

    }

}
