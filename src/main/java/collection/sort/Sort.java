package collection.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public abstract class Sort<T>
{
	protected final List<T> list;
	
	public Sort(@NotNull List<T> list)
	{
		this.list = list;
	}
	
	public abstract List<T> sort(@NotNull Comparator<T> comparator);
	
	protected abstract boolean isSorted();
	
}