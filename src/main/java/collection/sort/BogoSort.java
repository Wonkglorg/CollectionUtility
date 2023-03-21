package collection.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * Lul
 *
 * @param <T>
 */
@SuppressWarnings("unused")
public final class BogoSort<T> extends Sort<T>
{
	private Comparator<T> comparator;
	
	public BogoSort(@NotNull List<T> list)
	{
		super(list);
	}
	
	@Override
	public List<T> sort(@NotNull Comparator<T> comparator)
	{
		this.comparator = comparator;
		Random rand = new Random();
		
		while(!isSorted())
		{
			for(int i = 0; i < list.size(); i++)
			{
				int j = rand.nextInt(list.size());
				swap(list, i, j);
			}
		}
		return list;
	}
	
	@Override
	protected boolean isSorted()
	{
		for(int i = 1; i < list.size(); i++)
		{
			if(comparator.compare(list.get(i - 1), list.get(i)) > 0)
			{
				return false;
			}
		}
		return true;
	}
	
	private void swap(List<T> arr, int i, int j)
	{
		T temp = arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, temp);
	}
}