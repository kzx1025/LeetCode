package exam;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by iceke on 16/9/13.
 */
public class Kahao {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int testNum = Integer.parseInt(scanner.nextLine());
        while(testNum-- > 0){
            int num = Integer.parseInt(scanner.nextLine());
            HashSet<String> set = new HashSet<String>();

            String all = scanner.nextLine();
            String[] allPeople = all.split(" ");
           // for(int i = 0; i < num; i++){
            //    set.add(Integer.valueOf(allPeople[i]));
          //  }

            String hasCard = scanner.nextLine();
            String[] hasCardPeoples = hasCard.split(" ");
            StringBuilder stringBuilder = new StringBuilder();
            for(int i = 0;i<hasCardPeoples.length;i++){
                set.add(hasCardPeoples[i]);
            }
            for(int i = 0; i < allPeople.length; i++) {
                if (!set.contains(allPeople[i])) {
                    stringBuilder.append(allPeople[i] + " ");
                }
            }
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            System.out.println(stringBuilder.toString());

        }
    }
}
