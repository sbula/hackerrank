package javaPath.string;

import org.junit.Test;
import org.junit.Assert;

public class TestAnagrams {
	@Test
	public void test001() {
		Assert.assertTrue(Anagrams.isAnagram("anagram", "margana"));
	}

	@Test
	public void test002() {
		Assert.assertFalse(Anagrams.isAnagram("anagramm", "marganaa"));
	}

	@Test
	public void test003() {
		Assert.assertTrue(Anagrams.isAnagram("Hello", "hello"));
	}

	@Test
	public void test004() {
		Assert.assertTrue(Anagrams.isAnagram("Hello", "llohe"));
	}
}
