import java.util.*;

public class RemoveLetter {
    public static boolean equalFrequency(String word) {
        Map<Character,Integer> temp = new HashMap<>();

        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(temp.containsKey(ch)){
                temp.put(ch,temp.get(ch)+1);
            }else{
                temp.put(ch,1);
            }
        }
        List<Integer> vals = new ArrayList<>();
        for(int a : temp.values()){
            vals.add(a);
        }
        Collections.sort(vals);

        // 1 1 2
        // 2 2 - 1 1 1
        if(vals.get(0)==1 && vals.get(vals.size()-1)==1){
            return true;
        }
        int p = 0;
        /*int pom = vals.get(0);
        for(p=0; p<vals.size()-1 && vals.size()>2; p++){
            if(vals.get(p) != pom){
                break;
            }
        }
        if(p == vals.size()-1){
            return true;
        }*/


        if (vals.get(0) == 1) {
            int pom = vals.get(1);
            for (p = 1; p < vals.size() ; p++) {
                if (vals.get(p) != pom) {
                    break;
                }
            }
            if (p == vals.size()) {
                return true;
            }
        }
        for(int i=0; i<vals.size(); i++){
            int a = vals.get(i)-1;
            int j = 0;
            for(j=0; j<vals.size(); j++){
                if(j!=i && vals.get(j)!=a){
                    break;
                }
            }
            if(j == vals.size()){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(equalFrequency("cccd"));
    }
}
