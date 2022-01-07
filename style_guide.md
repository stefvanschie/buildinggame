This file is an addition to Google's Java Style Guide which you can view [here](https://google.github.io/styleguide/javaguide.html).
All the text underneath are only the points in which the styling of this project differs from Google's Style Guide.

### Additions
#### Variable declarations

**Var usage: only when clear**

Replacing the explicit type definition in a local variable declaration/initialisation may be replaced by the var word
for type inference, only if it is clear from the initialisation what the actual type would be, even for someone who does
not necessarily know the rest of the codebase. For example, this is a place where this is allowed:

```java
var text = "Hi"; //allowed, it's clear from the right-hand side that this is a String
```

However, this is a place where local type inference is not allowed:

```java
var data = getData(); //disallowed, it's unclear what type data would be
```

Usage of local type inference is always a may, never a must. When in doubt whether local variable type inference would
be acceptable, don't use it and resort to the explicit type name.**

#### Text blocks

Text blocks must only be used when a piece of text contains multiple lines of text. Text blocks must not be used for
text on a single line or empty text. When a text block is used, the ending three quotes must be indented by four spaces
or one tab character. The following is correct:
```java
var text = """
    Some text that
    spans across multiple
    lines.
    """
```
while the following is not:
```java
var text = """
    Some text that
    spans across multiple
    lines.
           """
```

The text in text blocks must be indented by four spaces or one tab. The text may only be aligned more to the right iff.
the entire text starts with a space or a tab character.

#### Records

Records are not used.

#### Sealed classes

Classes may only be marked as sealed if creation of additional subclasses, besides the permitted subclasses, would yield
incorrect behaviour in functionality related to this base class.

#### Pattern matching

For an evaluated expression, x instanceof Y, pattern matching must be used if code that is run when this expression
evaluates to true contains a cast form x to Y. The following is incorrect:
```java
if (x instanceof String) {
    String y = (String) x;
    //code
}
```
while this is correct:
```java
if (x instanceof String y) {
    //code
}
```

### Differences

2.3.1 ([original](https://google.github.io/styleguide/javaguide.html#s2.3.1-whitespace-characters)):  
Tab characters *may* be used for indentation.

3 ([original](https://google.github.io/styleguide/javaguide.html#s3-source-file-structure)):  
This project uses The Unlicense license, therefor no license or copyright information at the top.

3.3.3 ([original](https://google.github.io/styleguide/javaguide.html#s3.3.3-import-ordering-and-spacing)):  
The import statements do not have to be in ASCII sort order, but import statements starting with the same main package name should be grouped.

4.1.3 ([original](https://google.github.io/styleguide/javaguide.html#s4.1.3-braces-empty-blocks)):  
An empty block is immediately opened and closed on the same line as the block construct. This is correct:
```java
void doNothing() {}
```
while this isn't:
```java
void doNothingElse() {
}
```

4.2 ([original](https://google.github.io/styleguide/javaguide.html#s4.2-block-indentation)):  
Indentation uses 4 spaces or one tab.

4.4 ([original](https://google.github.io/styleguide/javaguide.html#s4.4-column-limit)):  
The column limit is 120 characters.

4.6.2 ([original](https://google.github.io/styleguide/javaguide.html#s4.6.2-horizontal-whitespace)):  
Point 8: Only the first one is correct, the second one isn't:
```java
//correct
new int[] {5, 6}

//incorrect
new int[] { 5, 6 }
```

4.8.1 ([original](https://google.github.io/styleguide/javaguide.html#s4.8.1-enum-classes)):  
Constants should always be on separate lines and should never be like an array initializer.

4.8.2.1 ([original](https://google.github.io/styleguide/javaguide.html#s4.8.2-variable-declarations)):  
Multiple variable declarations in one line are allowed.

4.8.5 ([original](https://google.github.io/styleguide/javaguide.html#s4.8.5-annotations)):  
Annotations should always be above the member class/method/field and there should always be one per line.

5.2.4 ([original](https://google.github.io/styleguide/javaguide.html#s5.2.4-constant-names)):  
Constants are either enum values or fields marked with static and final.

7.1.1 ([original](https://google.github.io/styleguide/javaguide.html#s7.1.1-javadoc-multi-line)):  
A Javadoc should never be on one line. You should always use the first example.
