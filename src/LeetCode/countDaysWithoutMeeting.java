package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class countDaysWithoutMeeting {
    public int countDays(int days,int[][]meetings){
        int[]track = new int[days];
        for(int i = 0; i < meetings.length; i++){
            Arrays.fill(track,meetings[i][0],meetings[i][1],1);
        }
        int count = 0;
        for(int i = 0; i < track.length; i++){
            if(track[i] == 0) count++;
        }
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println(new ListNode() == new ListNode());
    }
}
