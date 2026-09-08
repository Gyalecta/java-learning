Let's start with a fundamental question: **What is a variable?**

You can think of it, initially, as a name associated with a value that the program can use. For example:

```java
int age = 20;

```

Here we have four elements:

* `int` → type
* `age` → variable name
* `=` → assignment operator
* `20` → value

Essentially, this statement says: *"Create a variable named `age`, capable of holding an `int` value, and assign it the value 20."*

---

## 1. Declaration and Initialization

These are two distinct concepts.

**Declaration**

```java
int age;

```

We have declared a variable named `age` of type `int`. We haven't explicitly assigned it a value yet.

**Initialization**

```java
int age = 20;

```

Here, declaration and initialization happen together. We can also split them:

```java
int age;
age = 20;

```

So:

* `int age;` → declaration
* `age = 20;` → assignment

This distinction will become very useful later on.

---

## 2. Primitive Types

Java has 8 primitive types. The ones we will use most often at the beginning are:

| Type | Example | Use |
| --- | --- | --- |
| `int` | `20` | Whole numbers (integers) |
| `long` | `100000L` | Very large integers |
| `double` | `1.75` | Decimal numbers |
| `float` | `1.75f` | Lower-precision decimal numbers |
| `boolean` | `true` | True/False values |
| `char` | `'A'` | A single character |

The other two, `byte` and `short`, exist but aren't particularly important for us right now.

**Watch out for `char**`
This is correct:

```java
char grade = 'A';

```

This is **not** correct:

```java
char grade = "A";

```

Why? Because:

* `'A'` (Single quotes) → `char`
* `"A"` (Double quotes) → `String`

---

## 3. String is NOT a Primitive Type

This is a crucial distinction.

```java
String name = "Domenico";

```

`String` is a class, which makes it a **reference type**. For now, it is enough to know that:

* `int`, `boolean`, `char`, `double` → primitive types
* `String` → reference type

Later, when we study Object-Oriented Programming (OOP) and the JVM, we will dive much deeper into this difference.

---

## 4. Typing

Java is a **statically typed** language. This means every variable has a strictly defined type.

This is fine:

```java
int age = 20;

```

This is not:

```java
int age = "Domenico";

```

The compiler will stop you before the program even runs. This highlights a fundamental distinction in how Java works:

```text
 Source Code
      ↓
   COMPILER
      ↓
   Error? ─── yes → Program does not compile
      │
      no
      ↓
   Bytecode
      ↓
      JVM

```

Trying to put a `String` into an `int` doesn't just produce "weird behavior"—it prevents the program from compiling entirely.

---

## 5. Modifying a Variable

Variables can change their values:

```java
int age = 20;
age = 21;

```

After the second statement, `age` is `21`. The variable continues to be an `int`, so this is perfectly valid.

However, this is not valid:

```java
int age = 20;
age = "Domenico"; // Compilation error

```

A variable's type does not change just because you try to assign a different type of value to it.

---

## 6. The `final` Keyword

Java allows you to declare a variable that cannot be reassigned:

```java
final int birthYear = 2006;

```

If we try to do this later:

```java
birthYear = 2007; // Compilation error

```

We will get a compilation error. For now, think of `final` as: *"This variable cannot be reassigned after initialization."*

Later, we will discover a very important subtlety: `final` does not always mean the object itself is "immutable." That distinction will be critical when we get to objects.

---

## 7. Numbers and Operators

Naturally, we can perform mathematical operations:

```java
int a = 10;
int b = 3;

int sum = a + b;
int difference = a - b;
int product = a * b;
int quotient = a / b;
int remainder = a % b;

```

**Here is our first little Java trap.**
If you do:

```java
int quotient = 10 / 3;

```

You don't get `3.333333...`. You get:
`3`

This is because you are performing integer division (dividing an `int` by an `int`). To get a decimal result, you must involve a decimal type, for example:

```java
double quotient = 10.0 / 3;

```

Which gives you approximately: `3.3333333333333335`

This seemingly trivial detail will be incredibly important later on.