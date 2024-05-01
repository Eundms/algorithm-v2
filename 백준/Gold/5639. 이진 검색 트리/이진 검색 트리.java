import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
	static Item tree;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		tree = new Item (null, x, null);
		while(true) {
			String line = br.readLine();
			if(line == null || line.equals(""))break;
			x = Integer.parseInt(line);
			
			tree.insert(x);
		}
		print(tree);
		
	}
	static void print(Item tree) {
		if(tree == null) {
			return;
		}
		print(tree.left);
		print(tree.right);
		System.out.println(tree.x);

	}
	static class Item {
		Item left;
		int x;
		Item right;
		Item(Item left, int x, Item right) {
			this.left = left;
			this.x = x;
			this.right = right;
		}
		void insert(int n) {
			if(n < this.x) {
				if(this.left == null) {
					this.left = new Item(null,n,null);
				}else {
					this.left.insert(n);
				}
			} else {
				if(this.right == null) {
					this.right = new Item(null,n,null);
				} else {
					this.right.insert(n);
				}
			}
		}
	}


	
}