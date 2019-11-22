package bqmig.apollo;

import java.util.Map;
import java.util.Map.Entry;

public class Comparisions {
	
	// considering dataMap1 as source of truth
	public void compareMapOfMap(Map<String,Map<String,Object>> dataMap1, Map<String,Map<String,Object>> dataMap2)
	{
		for(Entry<String, Map<String, Object>> data1: dataMap1.entrySet())
		{
			if(dataMap2.containsKey(data1.getKey()))
			{
				Map<String, Object> data2 = dataMap2.get(data1.getKey());
				
				for(Entry<String, Object> d1 : data1.getValue().entrySet())
				{
					if(data2.containsKey(d1.getKey()))
					{
						if(!data2.get(d1.getKey()).toString().equalsIgnoreCase(d1.getValue().toString()))
						{
							System.out.println("value incorrect in data2 for key"+d1.getKey());
							break;
						}
					}
					else
					{
						System.out.println("Entry missing in data2 for key"+d1.getKey());
						break;
					}
				}
			}
			else
			{
				System.out.println("Entry missing in dataMap2 for key"+data1.getKey());
			}
		}
	}
}
