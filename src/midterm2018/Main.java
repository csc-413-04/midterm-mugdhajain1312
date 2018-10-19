package midterm2018;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.net.MalformedURLException;

import static java.lang.reflect.Array.*;
import java.util.*;



public class Main {

    public static void main(String[] args) {
        String question1and2 = "GET /add?a=3&b=4 HTTP/1.1\n"
            + "Host: localhost:1298\n"
            + "Connection: keep-alive\n"
            + "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36\n"
            + "Accept: image/webp,image/apng,image/*,*/*;q=0.8\n"
            + "Referer: http://localhost:1298/\n"
            + "Accept-Encoding: gzip, deflate, br\n"
            + "Accept-Language: en-US,en;q=0.9,es;q=0.8\n";

        String question3 = "{\n"
            + "    “task” : “inc”,\n"
            + "    “num” : 3\n"
            + "}\n";

        String question4and5 = "To opt out, you’ll need to enter the Settings menu by clicking the three vertical dots, all the way in the upper right corner of the browser. From there, you’ll need to enter the Advanced settings at the very bottom and find the “Allow Chrome sign in” toggle, then turn it to off. Doing so lets you sign into Google services like Gmail and Maps without signing into the Chrome browser itself.";


        System.out.println(question1and2);
        System.out.println(question3);
        System.out.println(question4and5);

        // print each answer at the end

        // Question 1
        // Return the Host

        //first method
//        try {
//            aURL = new java.net.URL("http://example.com:80/docs/");
//        }catch(MalformedURLException e){
//            System.out.println(e);
//        }
//
//        System.out.println("host = " + aURL.getHost());
//        aURL = new java.net.URL(question1and2);
//        return aURL.getHost();
//
//        public class GetHost{
//
//            public static void main(String []args){
//                aURL = new java.net.URL(question1and2);
//                return aURL.getHost();
//            }
//        }

        //2nd method try
//        public Map<String, List<String>> splitQuery(URL url) {
//            if (Strings.isNullOrEmpty(url.getQuery())) {
//                return Collections.emptyMap();
//            }
//            return Arrays.stream(url.getQuery().split("&"))
//                    .map(this::splitQueryParameter)
//                    .collect(Collectors.groupingBy(SimpleImmutableEntry::getKey, LinkedHashMap::new, mapping(Map.Entry::getValue, toList())));
//        }
//
//        public SimpleImmutableEntry<String, String> splitQueryParameter(String it) {
//            final int idx = it.indexOf("=");
//            final String key = idx > 0 ? it.substring(0, idx) : it;
//            final String value = idx > 0 && it.length() > idx + 1 ? it.substring(idx + 1) : null;
//            return new SimpleImmutableEntry<>(key, value);
//        }

        // Question 2
        // return sum of a and b
        question1and2 = "GET /add?a=3&b=4 HTTP/1.1\n" + "Host: localhost:1298\n" + "Connection: keep-alive\n" + "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36\n" + "Accept: image/webp,image/apng,image/,/*;q=0.8\n" + "Referer: http://localhost:1298/\n" + "Accept-Encoding: gzip, deflate, br\n" + "Accept-Language: en-US,en;q=0.9,es;q=0.8\n";

        String[] url1 = question1and2.split("//?", 2);
        StringTokenizer st = new StringTokenizer(question1and2," ");
        int a;
        a = question1and2.lastIndexOf("?");
        int b = question1and2.indexOf("HTTP");

        String param = question1and2.substring(a+1,b-1);
        String[] params = param.split("&");

        int sum = 0;
        for(String par: params){
            String[] p = par.split("=");
            sum += Integer.parseInt(p[1]);
        }
        System.out.println("sum   "+sum);

        // Question 3
        // convert to java object, increment num, convert back to json and return
//        JSONParser parser = new JSONParser();
//        JSONObject json = (JSONObject) parser.parse(stringToParse);
//        JSONObject object=new JSONObject(jsonstring);
//        int n = Integer.parseInt(object.get(“num”)) +1;
//        object.put(“num”, n);
//        System.out.println(object.toString());



        //QUESTION 4:RETURNING UNIQUE WORDS

        String s = "To opt out, you’ll need to enter the Settings menu by clicking the three vertical dots, all the way in the upper right corner of the browser. From there, you’ll need to enter the Advanced settings at the very bottom and find the “Allow Chrome sign in” toggle, then turn it to off. Doing so lets you sign into Google services like Gmail and Maps without signing into the Chrome browser itself.";
        String c[] = s.split(" ");
        Set set = new HashSet();
        //System.out.println(a.length);
        for(String s1 : c){
            set.add(s1);
        }
        Iterator iter = set.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        //QUESTION 5:RETURNING 2ND MOST COMMON WORD

        class ValueComparator implements Comparator<String>{

            HashMap<String, Integer> map = new HashMap<String, Integer>();

            public ValueComparator(HashMap<String, Integer> map){
                this.map.putAll(map);
            }

            @Override
            public int compare(String s1, String s2) {
                if(map.get(s1) >= map.get(s2)){
                    return -1;
                }else{
                    return 1;
                }
            }
        }
        class Solution {
            public void main(String []args){
                String question4and5 = "To opt out, you’ll need to enter the Settings menu by clicking the three vertical dots, all the way in the upper right corner of the browser. From there, you’ll need to enter the Advanced settings at the very bottom and find the “Allow Chrome sign in” toggle, then turn it to off. Doing so lets you sign into Google services like Gmail and Maps without signing into the Chrome browser itself.";
                String[] words = question4and5.toLowerCase().split("\\s+");
                HashMap<String, Integer> wordCounts = new HashMap<String, Integer>();

                for (String word : words) {
                    Integer count = wordCounts.get(word);
                    if (count == null) {
                        count = 0;
                    }
                    wordCounts.put(word, count + 1);
                }
                TreeMap<String, Integer> sortedMap = sortMapByValue(wordCounts);
                Iterator iterator = sortedMap.entrySet().iterator();
                int ii  = 1;
                while (iterator.hasNext()) {

                    Map.Entry mapEntry = (Map.Entry) iterator.next();
                    if(ii == 3){
                        System.out.println("The word:  " + mapEntry.getKey()
                                + " : occurs " + mapEntry.getValue() + " times");

                    }
                    ii++;
                }

            }

            public TreeMap<String, Integer> sortMapByValue(HashMap<String, Integer> map){
                Comparator<String> comparator = new ValueComparator(map);
                TreeMap<String, Integer> result = new TreeMap<String, Integer>(comparator);
                result.putAll(map);
                return result;
            }
        }





    }
}
