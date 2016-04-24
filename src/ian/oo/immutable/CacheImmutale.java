package ian.oo.immutable;

class CacheImmutale{

	private static int MAX_SIZE = 10;

	private static CacheImmutale[] cache = new CacheImmutale[MAX_SIZE];

	private static int pos = 0;

	// immutabel variable
	private final String name;

	private CacheImmutale(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}

	public static CacheImmutale valueOf(String name){

		for(int i = 0; i < MAX_SIZE; i++){
			if (cache[i] != null && cache[i].getName().equals(name)) {
				return cache[i];
			}
		}
		// if the cache is full
		if (pos == MAX_SIZE) {
			cache[0] = new CacheImmutale(name);
			pos = 1;
		}else{
			cache[pos++] = new CacheImmutale(name);
		}
		return cache[pos - 1];
	}

	public boolean equals(Object obj){
		if (this == obj) {
			return true;
		}
		if (obj != null && obj.getClass() == CacheImmutale.class) {
			CacheImmutale ci = (CacheImmutale)obj;
			return name.equals(ci.getName());
		}
		return false;
	}

	public int hashCode(){
		return name.hashCode();
	}

}