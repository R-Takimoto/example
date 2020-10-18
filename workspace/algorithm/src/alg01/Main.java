package alg01;


public class Main {

	public static void main(String[] args) {
		int[] a = {11, 3, 28, 14, 23, 7, 4, 1, 5, 20};

		int[] b = new int[50];

		for(int i = 0; i < b.length; i ++) {
			b[i] = new java.util.Random().nextInt(100);
		}

//		int ind = minIndx(b);
//		for(int val : b) {
//			System.out.println(val);
//		}
//		System.out.println("最小値のインデックスは" + ind);
		int[] ar = sentaku(b);

		for(int val : ar) {
			System.out.println(val);
		}

	}

	public static int minIndx(int[] array) {
		int r = 0;
		int minNum= array[0];
		int minInd = 0;
		for(int i = 0; i < array.length; i ++) {
			if(minNum > array[i]) {
				minNum = array[i];
				minInd  = i;
			}
		}
		r = minInd;
//		java.util.ArrayList<Integer> ar = new java.util.ArrayList<Integer>();
//		for(int val : array) {
//			ar.add(val);
//		}

//		r = ar.indexOf(mi);

		return r;
	}

	public static int[] sentaku(int[] ar) {
		for(int i = 0; i < ar.length - 1; i ++) {
			int min_num = ar[i];
			int min_ind = i;
			for(int j = i; j < ar.length; j ++) {
				if(min_num > ar[j]) {
					min_num = ar[j];
					min_ind = j;
				}
			}
			int m = ar[i];
			ar[i] = min_num;
			ar[min_ind] = m;
		}
		return ar;
	}
}
