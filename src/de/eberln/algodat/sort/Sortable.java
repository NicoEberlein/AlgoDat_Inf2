package de.eberln.algodat.sort;

public abstract class Sortable<T extends Comparable<T>> {

	protected T[] array;
	
	public Sortable(T[] array) {
		this.array = array;
	}
	
	public abstract T[] sort();
	
	public String getType() {
		return getClass().getName();
	}
	
	public String toString() {
		String s = "[ ";
		for(T t : array) {
			s += t.toString() + " ";
		}
		s += "]";
		return s;
	}

	public boolean isSorted() {

		if(array.length <= 1) {
			return true;
		}

		for(int i = 1; i<array.length; i++) {
			if(array[i-1].compareTo(array[i]) > 0) return false;
		}

		return true;
	}
	
    public void dump(int lineLength)
    {
        int nrLength = (int)Math.log10(array.length)+3;
        int maxPerLine = lineLength / nrLength;
        String formatStr = "%" + nrLength + "d";
        
        for (int i=0; i<array.length; i++)
        {
            if ((i!=0) && (i%maxPerLine==0)) System.out.println();
            System.out.printf(formatStr, array[i]);
        }
        System.out.println();
    }

	protected void swapAtIndex(int i, int j) {

		T tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;

	}
}
