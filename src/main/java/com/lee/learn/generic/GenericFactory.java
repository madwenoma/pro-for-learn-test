package com.lee.learn.generic;

interface NumberWrapper<T extends Number>{
	double square(T num);
}

public class GenericFactory {
	
	private static NumberWrapper<Number> numberWrapper = new NumberWrapper<Number>(){
		public double square(Number num){
			return num.doubleValue() * num.doubleValue();
		}
	};

	@SuppressWarnings("unchecked")
	public static <T extends Number> NumberWrapper<T> getWrapperInstance(){
		return (NumberWrapper<T>)numberWrapper;
	}

	public static void main(String[] args) {
		
		NumberWrapper<Integer> integerWrapper = GenericFactory.getWrapperInstance();
		System.out.println(integerWrapper.square(10));
		
		NumberWrapper<Double> doubleWrapper = GenericFactory.getWrapperInstance();
		System.out.println(doubleWrapper.square(100.00));
		
		
	}

}
