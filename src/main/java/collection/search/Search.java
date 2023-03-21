package collection.search;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

public abstract class Search<T>
{
	protected final T[] array;
	protected final T target;
	
	public Search(@NotNull T[] array, @NotNull T target)
	{
		this.array = array;
		this.target = target;
	}
	
	public abstract int search(@NotNull Comparator<T> comparator);
}