package collection.search;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

@SuppressWarnings("unused")
public final class FibonacciSearch<T> extends Search<T>
{
	
	public FibonacciSearch(T[] array, T target)
	{
		super(array, target);
	}
	
	@Override
	public int search(@NotNull Comparator<T> comparator)
	{
		int fibNMinus2 = 0;
		int fibNMinus1 = 1;
		int fibN = fibNMinus1 + fibNMinus2;
		while(fibN < array.length)
		{
			fibNMinus2 = fibNMinus1;
			fibNMinus1 = fibN;
			fibN = fibNMinus1 + fibNMinus2;
		}
		
		int offset = -1;
		while(fibN > 1)
		{
			int i = Math.min(offset + fibNMinus2, array.length - 1);
			int cmpResult = comparator.compare(array[i], target);
			if(cmpResult < 0)
			{
				fibN = fibNMinus1;
				fibNMinus1 = fibNMinus2;
				fibNMinus2 = fibN - fibNMinus1;
				offset = i;
			} else if(cmpResult > 0)
			{
				fibN = fibNMinus2;
				fibNMinus1 = fibNMinus1 - fibNMinus2;
			} else
			{
				return i;
			}
		}
		
		if(fibNMinus1 > 0 && comparator.compare(array[offset + 1], target) == 0)
		{
			return offset + 1;
		}
		
		return -1;
	}
}