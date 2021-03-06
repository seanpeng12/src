import java.util.*;
import java.io.*;

public class Salesrecords {
	public static void main(String[] args) {
		ReadData();
	}
	public static void ReadData() {
		System.out.println("資管二甲 。"+"406401484。"+"彭麟翔");
		System.out.println("===============================");
		File infile = new File("D:\\itemData.txt");
		String itemName = new String();

		ArrayList<String> lst_item = new ArrayList<>();
		ArrayList<Integer> lst_price = new ArrayList<>();
		
		int amount;
		try {
			Scanner data = new Scanner(infile);
			while (data.hasNext()) {
				itemName = data.next();
				//read until space;and nextline read until line 
				amount = data.nextInt();
				if (lst_item.contains(itemName)) {
					int I = lst_item.indexOf(itemName);
					int total = lst_price.get(I) + amount;
					lst_price.set(I, total);
				} else {
					lst_item.add(itemName);
					lst_price.add(amount);
				}
			}
			data.close();
			
			//OUTPUT
			System.out.println("每個貨物名稱以及該貨物總銷售量：");
			for (int i = 0; i < lst_item.size(); i++) {
				System.out.print(lst_item.get(i) + " ");
				System.out.println("銷售量：" + lst_price.get(i));
				System.out.println("=============");
			}
			System.out.println("最高銷售量貨物名稱與銷售量：");
			int temp = lst_price.indexOf(MaxPrice(lst_item,lst_price));
			System.out.print(lst_item.get(temp) + " ");
			System.out.println(lst_price.get(temp));
			
			System.out.println("最低銷售量貨物名稱與銷售量：");
			int temp2 = lst_price.indexOf(MinPrice(lst_item,lst_price));
			System.out.print(lst_item.get(temp2) + " ");
			System.out.println(lst_price.get(temp2));
		} catch (IOException e) {
			System.out.println("Error");
		}
	}
	
	public static int MaxPrice(ArrayList a,ArrayList b){
		ArrayList<String> A = new ArrayList<String>(a);
		ArrayList<Integer> B = new ArrayList<Integer>(b);
		int max = B.get(0);
		for (int i = 1; i < A.size(); i++) {
			if(B.get(i) > max){
				max = B.get(i);
			}
		}
		return max;
	}
	public static int MinPrice(ArrayList a,ArrayList b){
		ArrayList<String> A = new ArrayList<String>(a);
		ArrayList<Integer> B = new ArrayList<Integer>(b);
		int min = B.get(0);
		for (int i = 1; i < A.size(); i++) {
			if(B.get(i) < min){
				min = B.get(i);
			}
		}
		return min;
	}
}
