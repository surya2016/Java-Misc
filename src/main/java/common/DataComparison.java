package common;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class DataComparison {

	List<Map<String,Object>> actualData = null;
	List<Map<String,Object>> tempTableData = null;
	
	public static boolean compare(List<Map<String,Object>> mm, List<Map<String,Object>> sl) throws FileNotFoundException, IOException {
        
		List<Map<String,Object>> compareData = null;
		
		Map<String,Map<String,Object>> mm_Data1 = new HashMap<String, Map<String,Object>>();
		Map<String,Map<String,Object>> sl_Data1 = new HashMap<String, Map<String,Object>>();
		Map<String,Map<String,Object>> mm_BK = new HashMap<String,Map<String,Object>>();
		Map<String,Map<String,Object>> sl_BK = new HashMap<String,Map<String,Object>>();
		
		Map<String,Object> success_record = new HashMap<String,Object>();
		List<Map<String,Object>> successData = new ArrayList<Map<String,Object>>();
		
		boolean flag = false;
		
		Excel excel_Object = new Excel();
		
		String column = "gid,userId,elearningId";
	
		String[] col = column.split(",");
        String key = null;

        out: for(Map<String,Object> map : mm) {
            if(!column.contains(",")) {
                mm_Data1.put(column+"="+map.get(column).toString(), map);
            } else {
                key = "";
                for(String str : col) {
                	if(map.get(str).toString().contains(","))
                	{
                		//System.out.println("map==="+map.get(str));
                		
                		String[] elearning=map.get(str).toString().split(",");
                		for(String s : elearning) 
                		{
                			Map<String,Object> m = new HashMap<String,Object>();
                    		m.putAll(map);
                			String k=key;
                			k = k+","+str+"="+s;
                			m.put(str, s);
                			k = k.substring(1, k.length());
                			//System.out.println("k1111111>>>"+k);
                			mm_Data1.put(k, m);
                			/*for(Map.Entry<String, Object> val : mm_Data1.get(k).entrySet())
                        		System.out.println(val.getKey() +"-----"+val.getValue());
                			*/
                		}
                		continue out;
                	}
                	else
                		key = key+","+str+"="+map.get(str);
                		
                }
                key = key.substring(1, key.length());
               // System.out.println(key);
                mm_Data1.put(key, map);
            }
        }

       /* for(Map.Entry<String, Map<String,Object>> ww:mm_Data1.entrySet())
        {
        	System.out.println("Key"+ ww.getKey());
        	for(Map.Entry<String, Object> val : mm_Data1.get(ww.getKey()).entrySet())
        		System.out.println(val.getKey() +"-----"+val.getValue());
        }*/
        for(Map<String,Object> map : sl) {
            if(!column.contains(",")) {
                sl_Data1.put(column+"="+map.get(column).toString(), map);
            } else {
                key = "";
                for(String str : col) {
                    key = key+","+str+"="+map.get(str);
                }
                key = key.substring(1, key.length());
                sl_Data1.put(key, map);
            }
        }

        mm_BK.putAll(mm_Data1);
        sl_BK.putAll(sl_Data1);
        excel_Object.deleteSheet("Comparison_UserProfile");
        compareData = new ArrayList<Map<String,Object>>();

        String keyValue = null;
        outer:for(Map.Entry<String, Map<String,Object>> mapValue : mm_Data1.entrySet()) {
            keyValue = mapValue.getKey();
            //If same data, validation success
            if(mm_Data1.get(keyValue).equals(sl_Data1.get(keyValue))) {
                mm_BK.remove(keyValue);
                sl_BK.remove(keyValue);
            } else {
                flag = true;
                for(Map.Entry<String, Object> temp : mm_Data1.get(keyValue).entrySet()) {
                	
                	boolean f = false;
                	int diff = 0;
                	System.out.println(keyValue+">>"+mm_Data1.get(keyValue));
                    System.out.println(keyValue+">>"+sl_Data1.get(keyValue));
                	if(!temp.getValue().toString().equals(sl_Data1.get(keyValue).get(temp.getKey()).toString())) 
                	{
                		System.out.println("Not equal"+">>"+temp.getKey()+">>"+temp.getValue().toString()+"!="+sl_Data1.get(keyValue).get(temp.getKey()).toString());
                		if(temp.getKey().equals("placedDate"))
                		{
                			f= true;
                			diff = Math.abs(Integer.parseInt(temp.getValue().toString()) - Integer.parseInt(sl_Data1.get(keyValue).get(temp.getKey()).toString()));
                			System.out.println(diff);
                			
                		}
                		else
                			f = false;
                	}
                	if(f)
                	{
                		if(diff<1000)
            			{
            				flag = false;
            				mm_BK.remove(keyValue);
                            sl_BK.remove(keyValue);
                            continue outer;
            			}
                	}
                //	System.out.println(temp.getValue());
                //	System.out.println(sl_Data1.get(keyValue).get(temp.getKey()));
                }
                //If different data, then data from both tables are dumped into excel sheet
                //System.out.println(keyValue+">>"+mm_Data1.get(keyValue));
                //System.out.println(keyValue+">>"+sl_Data1.get(keyValue));
                compareData.clear();
                compareData.add(mm_Data1.get(keyValue));
                compareData.add(sl_Data1.get(keyValue));
                excel_Object.writeMap("Comparison_UserProfile", compareData);
                mm_BK.remove(keyValue);
                sl_BK.remove(keyValue);
            }
            if(mm_BK.size()%20==0) System.out.println("Total records : "+mm_Data1.size()+", remaining records to be processed : "+mm_BK.size());
            if(sl_BK.size()%20==0) System.out.println("Total records : "+sl_Data1.size()+", remaining records to be processed : "+sl_BK.size());
        }
        if(sl_BK.size()>0) {
            compareData.clear();
            for(Map.Entry<String, Map<String,Object>> mapValue : sl_BK.entrySet()){
                compareData.add(sl_BK.get(mapValue.getKey()));
            }
            excel_Object.writeMap("Comparison_UserProfile", "Simplilearn", compareData);
        }
       if(!flag) {
          
            success_record.put("remarks", "All users profile migrated");
            successData.add(success_record);
            excel_Object.writeMap("Success", successData);
            excel_Object.writeMap("Success", successData);
        }
        return true;
    }
	
	
	
	public static void main(String args[])
	{
		DataComparison dc = new DataComparison();
		
	}
	
}
