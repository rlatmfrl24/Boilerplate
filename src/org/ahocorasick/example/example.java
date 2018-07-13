package org.ahocorasick.example;

import java.util.Collection;

import org.ahocorasick.trie.Emit;
import org.ahocorasick.trie.Token;
import org.ahocorasick.trie.Trie;

public class example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1. Aho-Corasick 기본 용례
		Trie trie = Trie.builder()
				.addKeyword("hers")
				.addKeyword("his")
				.addKeyword("she")
				.addKeyword("he").build();
		Collection<Emit> emits = trie.parseText("ushers");
		System.out.println(emits);

		//2. 단어 단위 매칭
		trie = Trie.builder().onlyWholeWords().addKeyword("sugar").build();
		emits = trie.parseText("sugarcane sugarcane sugar canesugar");
		System.out.println(emits);

		//3. 대소문자 무시 검색
		trie = Trie.builder()
				.ignoreCase()
				.addKeyword("casing")
				.build();
		emits = trie.parseText("CaSiNg");
		System.out.println(emits);
		
	    trie = Trie.builder().ignoreOverlaps()
	            .addKeyword("ab")
	            .addKeyword("cba")
	            .addKeyword("ababc")
	            .build();
	    Emit firstMatch = trie.firstMatch("ababcbab");
	    System.out.println(firstMatch);
	    
	    //4. Pattern Matching 후 치환
	    String speech = "The Answer to the Great Question... Of Life, " +
	            "the Universe and Everything... Is... Forty-two,' said " +
	            "Deep Thought, with infinite majesty and calm.";
	    trie = Trie.builder().ignoreOverlaps().onlyWholeWords().ignoreCase()
	        .addKeyword("great question")
	        .addKeyword("forty-two")
	        .addKeyword("deep thought")
	        .build();
	    Collection<Token> tokens = trie.tokenize(speech);
	    StringBuffer html = new StringBuffer();
	    html.append("<html><body><p>");
	    for (Token token : tokens) {
	        if (token.isMatch()) {
	            html.append("<i>");
	        }
	        html.append(token.getFragment());
	        if (token.isMatch()) {
	            html.append("</i>");
	        }
	    }
	    html.append("</p></body></html>");
	    System.out.println(html);

	}

}
