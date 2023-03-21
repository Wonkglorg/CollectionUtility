package collection.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

/**
 * Time complexity of O(n^2)
 *
 * Not practical do not use in large lists!
 * @param <T>
 */
@SuppressWarnings("unused")
public final class BubbleSort<T> extends Sort<T>
{
	
	public BubbleSort(@NotNull List<T> list)
	{
		super(list);
	}
	
	@Override
	public List<T> sort(@NotNull Comparator<T> comparator)
	{
		int n = list.size();
		
		for(int i = 0; i < n - 1; i++)
		{
			boolean swapped = false;
			
			for(int j = 0; j < n - i - 1; j++)
			{
				if(comparator.compare(list.get(j), list.get(j + 1)) > 0)
				{
					swap(list, j, j + 1);
					swapped = true;
				}
			}
			
			if(!swapped)
			{
				break;
			}
		}
		return list;
	}
	
	private static <T> void swap(List<T> arr, int i, int j)
	{
		T temp = arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, temp);
	}
	
	@Override
	protected boolean isSorted()
	{
		return false;
	}
}