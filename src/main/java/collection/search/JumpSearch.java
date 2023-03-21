package collection.search;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

/**
 * Needs to be sorted in ascending order
 *
 * @param <T>
 */
@SuppressWarnings("unused")
public final class JumpSearch<T> extends Search<T>
{
	public JumpSearch(@NotNull T[] array, @NotNull T target)
	{
		super(array, target);
	}
	
	@Override
	public int search(@NotNull Comparator<T> comparator)
	{
		int n = array.length;
		int blockSize = (int) Math.sqrt(n);
		
		int start = 0;
		int end = blockSize;
		
		while(end < n && comparator.compare(array[end], target) < 0)
		{
			start = end;
			end += blockSize;
		}
		
		for(int i = start; i <= end; i++)
		{
			if(comparator.compare(array[i], target) == 0)
			{
				return i;
			}
		}
		
		return -1;
	}
}
