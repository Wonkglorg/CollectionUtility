package collection.search;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

/**
 * Time complexity O(log n)
 *
 * @param <T>
 */

@SuppressWarnings("unused")
public final class BinarySearch<T> extends Search<T>
{
	
	public BinarySearch(@NotNull T[] array, @NotNull T target)
	{
		super(array, target);
	}
	
	@Override
	public int search(@NotNull Comparator<T> comparator)
	{
		int left = 0;
		int right = array.length - 1;
		
		while(left <= right)
		{
			int mid = (left + right) / 2;
			int comparison = comparator.compare(array[mid], target);
			
			if(comparison == 0)
			{
				return mid;
			} else if(comparison < 0)
			{
				left = mid + 1;
			} else
			{
				right = mid - 1;
			}
		}
		
		return -1;
	}
}