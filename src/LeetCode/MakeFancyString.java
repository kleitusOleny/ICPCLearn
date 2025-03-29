package LeetCode;

public class MakeFancyString{
    public String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();
        int countTrack =0;
        String track =  "";
        for (int i = 0; i < s.length(); i++) {
            String tmp = s.charAt(i) + "";
            System.out.println(track +" ;" + countTrack);
            if (!tmp.equals(track)){
                track = tmp;
                countTrack++;
                if (countTrack < 3) result.append(track);
            }else {
                track = s.charAt(i+1) + "";
                countTrack =0;
            }
        }
        return result.toString();
    }
}
