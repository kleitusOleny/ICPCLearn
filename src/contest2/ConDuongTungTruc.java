import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
7 2 2
20 2
30 1
25 1
35 1
60 2
65 2
10 1

OUTPUT
35
 */
public class ConDuongTungTruc {
    private static class Pair {
        int d, k;
        
        public Pair(int d, int k) {
            this.d = d;
            this.k = k;
        }
        
        @Override
        public String toString() {
            return "Pair{" +
                    "d=" + d +
                    ", k=" + k +
                    '}';
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        StringBuilder stb = new StringBuilder();
        List<Pair> listA = new ArrayList<>();
        List<Pair> listB = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            if (k == 1) {
                listA.add(new Pair(d, k));
            } else {
                listB.add(new Pair(d, k));
            }
        }
        
        if (a >= listA.size() && b >= listB.size() && a+b <= n) {
            System.out.println(stb.append(-1));
        }
        listA.sort((o1, o2) -> o2.d - o1.d);
        listB.sort((o1, o2) -> o2.d - o1.d);
        System.out.println(listA + "\n" + listB);
        
        int sum = 0;
        while (a > 0 || b > 0) {
            if (a > 0) {
                sum += listA.get(listA.size() - a-- -1).d;
            }
            if (b > 0) {
                sum += listB.get(listB.size() - b-- -1).d;
            }
        }
        System.out.println(stb.append(sum));
    }
}
