We've already established that Java is statically typed:

```java
int age = 20;

```

`age` is an `int`. But what happens when we want to assign that value to a variable of a different type?
For example:

```java
int age = 20;
double value = age;

```

This is perfectly legal.

**1. Widening Conversion**
Java can automatically convert a type into one that represents a broader range of values.
For example:

```java
int number = 42;
double decimal = number;

```

You can think of it like this: `int` → `double`.

The value `42` becomes `42.0`. You don't need to write an explicit cast. This is called a *widening primitive conversion*. Conceptually, the flow looks like this:

`byte` → `short` → `int` → `long` → `float` → `double`

This doesn't mean every single step is mathematically "perfect" in terms of precision (since `float` and `double` are floating-point types), but the principle holds: Java automatically allows conversions to wider compatible types.

**2. Narrowing Conversion**
Going the other way is much more delicate. Suppose we have:

```java
double price = 19.99;
int wholePrice = price;

```

This will not compile. Java refuses to automatically guess what to do with `19.99` if it needs to become an `int`, because data might be lost. To explicitly tell Java, "Yes, I know what I'm doing, I want to force this conversion," we use casting:

```java
double price = 19.99;
int wholePrice = (int) price;

```

The result will be `19`. The decimal portion is completely discarded—it is not rounded.

* `19.99` → `19`
* `19.01` → `19`
* `19.999` → `19`

**3. Casting Does Not Modify the Original Variable**
This is a crucial detail.

```java
double price = 19.99;
int wholePrice = (int) price;

```

After these instructions:

* `price` remains `19.99`
* `wholePrice` is `19`

We didn't transform `price` into an `int`. We created a brand new `int` value derived from `price`.

**4. Division and Casting**
There is an interesting trap here. Take a look:

```java
int a = 10;
int b = 3;
double result = a / b;

```

You might expect `3.333...`, but you get `3.0`.

Why? Because the division happens *before* the assignment. The compiler and runtime evaluate it in this order:

1. `a / b`
2. `int / int`
3. `3`
4. Assignment to `double`
5. `3.0`

If you want a true decimal division, you need to cast first:

```java
double result = (double) a / b;

```

Now the order is:

1. `(double) a` → `10.0`
2. `10.0 / 3` → `3.333...`

This is one of those concepts you should learn by understanding the order of operations, not just by memorizing syntax.

**5. Overflow**
Now for something even more interesting. An `int` in Java represents a finite range of values.

```java
int max = 2_147_483_647;

```

This is the maximum possible `int` value. What happens if you do this?

```java
int result = max + 1;

```

You don't get a bigger number. You get an *overflow*. The value wraps around to the lowest possible negative number. You don't need to memorize the maximum number by heart yet. It is much more important to grasp this core idea: **numeric types have a finite capacity.** This will become highly relevant later when discussing numeric bugs, performance, databases, serialization, and financial systems.

**6. Underscores in Numbers**
You just saw this: `2_147_483_647`. Underscores can be used to make large numbers much easier to read:

```java
int population = 60_000_000;
long distance = 9_460_730_472_580_800L;

```

This is purely syntactic sugar. The compiler ignores them entirely. Therefore, `1_000_000` and `1000000` represent the exact same value in memory.

**7. Number Suffixes**
Some literal values require an explicit type indicator. For example:

```java
long population = 8_000_000_000L;

```

The `L` indicates a `long` literal. For floating-point numbers:

```java
float temperature = 36.5f;

```

The `f` indicates a `float` literal. Meanwhile, this works perfectly out of the box:

```java
double temperature = 36.5;

```

Because any standard decimal literal is treated as a `double` by default.