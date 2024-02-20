# -> On the importance of a Lexer + Parser
This project rests on the challenge of writing a Mardown to HTML parser. In the future, I plan on 
	adding other features such as a fully fledged Lexer + Parser, and an intermediate 
	representation instead of directly generating HTML.
	
For now, there are some questions:
1. Can we avoid the need for a Lexer?
2. Can we write a 'dumb' Parser?
3. Does Markdown have high-level and low-level elements? 
	(example: headings and code blocks vs text modifiers)
4. How much lookahead do we need?
5. How would we structure Markdown as a language?

Maybe we can always be eager in our lexical analysis and avoid some road blocks.
	
## 1. Can we avoid the need for a Lexer?
Yes. In fact, Lexer's aren't required. The thing is: without it, the parsing task becomes 2x worse.
	
The follow-up question is:
1.1. is implementing a Lexer worth it?

### 1.1. Is implementing a Lexer worth it?
Traditional Lexers use regular expressions and state machines. Our restriction, for now, is to 
	avoid regular expressions so we would need to use some kind of state machine approach.
	
At a first glance this means we are going to create a very barebones implementation of a state 
	machine, a translator from regex to state machine and of course a way of 'executing' the state 
	machine with a given input.
	
This seems too complicated for what it is worth. Furthermore, it's like saying you can't use 
	Strings so you implement a structure using an array of characters... the workaround to a 
	restriction cannot be to implement the restriction.
	
## 2. Can we write a 'dumb' Parser?
I guess there is always a way of doing a 'dumb' **something*. This is no exception. Instead of a 
	one-shot well-designed regular expression, we can use multiple conditionals to detect patterns.
	
"Ok but then why would we even think of a Parser or a Lexer?". Because it is more complex and error
	prone. Debugging a regex is known to be non-trivial, and debugging several intricate checks and
	functions is certainly non-trivial.
	
With this said, we have to do many checks that may span the entire input, for example, if a 
	Markdown link element is never correctly closed (and therefore counts as regular text) we would
	have to (possibly) check the entire Markdown content in search of that closing bracket.
	
For a first *naive* implementation we'll close our eyes to this issue but try to optimize wherever 
	possible.
	
## 3. Does Markdown have high-level and low-level elements?
Markdown when read line by line seems to have bigger section-like elements such as headings and 
	code blocks. **But**, in fact it is actually a language that makes heavy use of the newline 
	character.
	
What makes sense to talk about are elements that can have other Markdown nested elements (or just 
	plain text). 

So, main takes from here:
- Define what Markdown elements will be supported
- Define what nesting is allowed and go from there

## 4. How much lookahead do we need?
Well, this question only makes sense if we went with a Lexer/Parser. At this point, after 
	abandoning such options, it really depends in the implementation details. 
	
Best case scenario its the same as when using a Lexer/Parser, but because we'll be dealing with raw
	text, we might need to lookahead the entire file (hopefully not).
	
## 5. How would we structure Markdown as a language?
I wrote this question so badly I have to concentrate on what it means now. But I think it's "How do
	you define Markdown from a Lexer/Parser's point of view". In short: tokens, rules, delimeters, 
	etc.
	
This seems like a to broad of a question to answer at this time, we can only answer this after 
	defining clear objectives for which features we want to support.

# -> Proposed features

V1
- Headings
- Paragraphs
- Fenced code block
- Blockquotes

V2
- Bold, italic, emphasized, strikethrough and code text
- Emojis

V3
- Unordered/Ordered lists

V4
- Links
- Images