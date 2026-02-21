//https://leetcode.com/problems/special-binary-string/?envType=daily-question&envId=2026-02-20

class Solution {
    
    public String makeLargestSpecial(String s) {
    int sum=0;
     int st=0;
    ArrayList<String> inners =new ArrayList<>();

     for(int i=0;i<s.length();i++){
        sum+=(s.charAt(i)=='1')?1:-1;

        if(sum==0){
            String in =s.substring(st+1,i);
            inners.add("1"+makeLargestSpecial(in)+"0");
            st=i+1;
        }
     }

 Collections.sort(inners, Collections.reverseOrder());
     return String.join("",inners);
    
    }
}
