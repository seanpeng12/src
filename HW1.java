import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.ArrayList;

public class HW1 {
	static ArrayList<Item> items = new ArrayList<>();
	private static Object itemNames;
	public static class Item {
		public static Object getItemName;
		private String itemName;
		private int amount;
		
		public Item(String itemName, int amount) {
			this.itemName=itemName;
			this.amount=amount;
		}
		 public String getItemName() {
			return itemName;
		}
		public void setItemName(String itemName) {
			this.itemName = itemName;
		}
		public int getAmount() {
			return amount;
		}
		public void setAmount(int Amount) {
			this.amount = Amount;
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readData();
		listData();
		
		
		
	}
	
	public static void readData() {
		 File infile = new File("D:\\itemData.txt"); 
		 String itemName =new String();			
		 int amount;
		 			try{
		             Scanner data = new Scanner(infile);       
		             while (data.hasNext()){
		                 itemName = data.next();
		                 amount = data.nextInt(); 
		                 int itemIndex=getItemIndex(itemName);
		                 if(itemIndex != -1) {
		                	 items.get(itemIndex).setAmount(items.get(itemIndex).getAmount()+amount);
		                 Item item=items.get(itemIndex);
		                 item.setAmount(item.getAmount()+amount);
		                 
		                 }
		                 else {
		                	 items.add(new Item(itemName,amount));
		                 }
		 							
		             } 
		         }
		                 catch (IOException e){   }

		
	}

	public static void listData() {
		for(int i=0;i<items.size();i++) {
			
		}
	}
	public static void printMaxsales() {
		
	}
	public static void printMinsales() {
		
	}
	public static int getItemIndex(String itemName) {
		for(int i =0;i<items.size();i++) {
			if(items.get(i).getItemName.equals(itemNames)) {
				return i;
			}
		}
		return -1;
	}

}
