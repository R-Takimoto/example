package sortTest;

public class Main {

	public static void main(String[] args) {
		int[] numbers = createArray();

		System.out.println("配列生成");
		displayArray(numbers);

		System.out.println("並べ替えスタート");
		for(int i = 0; i < numbers.length - 1; i ++) {
			System.out.println((i + 1) + "周目");
			for(int j = i + 1; j < numbers.length ; j ++) {
				if(numbers[i] > numbers[j]) {
					int num = numbers[j];
					numbers[j] = numbers[i];
					numbers[i] = num;
				}
				displayArray(numbers);
			}
		}
		System.out.println("並べ替え後");
		displayArray(numbers);


//		for(int i  = 0; i + 1 < numbers.length; i ++) {
//			for(int j = 0; j + 1 < numbers.length - i; j ++) {
//				if(numbers[j] > numbers[j + 1]) {
//					int num = numbers[j];
//					numbers[j] = numbers[j + 1];
//					numbers[j + 1] = num;
//				}
//				displayArray(numbers);
//			}
//			System.out.println("-------------------------");
//		}
//		System.out.println("並べ替え後");
//		displayArray(numbers);


	}


	//配列生成メソッド
	public static int[] createArray() {
		int length = 10; //配列の要素数

		int[] numbers = new int[length];
		for(int i = 0; i < numbers.length; i ++) {
			numbers[i] = new java.util.Random().nextInt(100); //0-99のランダムな数を代入
		}
		return numbers;
	}

	//配列表示メソッド
	public static void displayArray(int[] array) {
		for(int val : array) {
			System.out.print(val + " ");
		}
		System.out.println(); //改行
	}





}
