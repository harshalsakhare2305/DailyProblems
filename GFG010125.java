//https://www.geeksforgeeks.org/problems/print-anagrams-together/1
//We can use another method like we will create HashMap<String,ArrayList<String>> 
    //then we go with everuy this string present in the array and sort it ans 
    //store it in Hashmap whenver we got
    //found the same string in the hashmap then we will store in the corresponding 
    //ArrayList
class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        ArrayList<ArrayList<String>> ans =new ArrayList<>();
        ArrayList<HashMap<Character,Integer>> list =new ArrayList<>();
        
        
        for(int i=0;i<arr.length;i++){
            HashMap<Character,Integer> mp =new HashMap<>();
            for(char ch:arr[i].toCharArray()){
                mp.put(ch,mp.getOrDefault(ch,0)+1);
            }
            
            if(ans.size()==0){
                ArrayList<String> temp =new ArrayList<>();
                temp.add(arr[i]);
                ans.add(temp);
                list.add(mp);
            }else{
                boolean flag=false;
                for(int j=0;j<list.size();j++){
                    if(mp.equals(list.get(j))){
                        ans.get(j).add(arr[i]);
                        flag=true;
                        break;
                    }
                }
                
                if(!flag){
                ArrayList<String> temp =new ArrayList<>();
                temp.add(arr[i]);
                ans.add(temp);
                list.add(mp);
                }
            }
            mp.clear();
            
        }
        
        return ans;
    }
    
   
}
