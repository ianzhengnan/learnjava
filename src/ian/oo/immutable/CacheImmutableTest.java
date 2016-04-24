package ian.oo.immutable;

public class CacheImmutableTest {

	public static void main(String[] args){

		CacheImmutale c1 = CacheImmutale.valueOf("ian");
		CacheImmutale c2 = CacheImmutale.valueOf("ian");

		System.out.println(c1 == c2);

	}

}