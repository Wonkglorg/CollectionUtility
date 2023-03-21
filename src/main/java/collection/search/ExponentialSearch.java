package collection.search;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

@SuppressWarnings("unused")
public final class ExponentialSearch<T> extends Search<T>
{
	/**
	 * Worst case complexity = O(log n)
	 * Average case O(log i + log n)
	 *
	 * always performs better if the searched element is in the lower half of the list if it is at the end then it matches binary search.
	 *
	 * exponential search has a higher overhead compared to binary search
	 *
	 *
	 * for larger arrays or arrays with non-uniformly distributed data, exponential search might be more efficient than binary search.
	 *
	 * @param arr
	 * @param target
	 * @return
	 */
	@SuppressWarnings("unused")
	
	public ExponentialSearch(@NotNull T[] array, @NotNull T target)
	{
		super(array, target);
	}
	
	public int search(@NotNull Comparator<T> comparator)
	{
		int n = array.length;
		if(comparator.compare(array[0], target) == 0)
		{
			return 0;
		}
		int i = 1;
		while(i < n && comparator.compare(array[i], target) <= 0)
		{
			i *= 2;
		}
		return binarySearch(array, target, comparator, i / 2, Math.min(i, n));
	}
	
	private int binarySearch(@NotNull T[] arr, @NotNull T target, @NotNull Comparator<T> comparator, int left, int right)
	{
		while(left <= right)
		{
			int mid = left + (right - left) / 2;
			int cmp = comparator.compare(arr[mid], target);
			if(cmp == 0)
			{
				return mid;
			} else if(cmp < 0)
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