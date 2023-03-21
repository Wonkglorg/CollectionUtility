package collection.search;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

@SuppressWarnings("unused")
public final class LinearSearch<T> extends Search<T>
{
	
	public LinearSearch(@NotNull T[] array, @NotNull T target)
	{
		super(array, target);
	}
	
	@Override
	public int search(@NotNull Comparator<T> comparator)
	{
		int n = array.length;
		
		for(int i = 0; i < n; i++)
		{
			if(comparator.compare(array[i], target) == 0)
			{
				return i;
			}
		}
		
		return -1;
	}
}